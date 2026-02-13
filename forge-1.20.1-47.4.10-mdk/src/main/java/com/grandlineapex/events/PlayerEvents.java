/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\events\PlayerEvents.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.events;

import com.grandlineapex.capability.PlayerDataProvider;
import com.grandlineapex.capability.PlayerDataStorage;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.devilfruit.DevilFruitProvider;
import com.grandlineapex.capability.player.BountyCapability;
import com.grandlineapex.capability.player.CombatCapability;
import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.capability.player.PlayerBountyProvider;
import com.grandlineapex.capability.player.PlayerCombatProvider;
import com.grandlineapex.capability.player.PlayerHakiProvider;
import com.grandlineapex.capability.player.PlayerAbilityRuntimeProvider;
import com.grandlineapex.capability.player.PlayerStatsProvider;
import com.grandlineapex.capability.player.StatsCapability;
import com.grandlineapex.combat.scaling.PowerScalingHandler;
import com.grandlineapex.systems.stamina.PlayerStaminaProvider;
import com.grandlineapex.systems.stamina.StaminaCapability;
import com.grandlineapex.network.NetworkHandler;
import com.grandlineapex.network.packets.SyncFruitPacket;
import com.grandlineapex.network.packets.SyncHakiPacket;
import com.grandlineapex.network.packets.SyncStaminaS2C;
import com.grandlineapex.network.packets.SyncBountyPacket;
import com.grandlineapex.devilfruit.awakening.AwakeningHandler;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            // Attach all persistent player-domain stores in one place so subsystems share a unified model.
            event.addCapability(ResourceLocation.parse("grandlineapex:devil_fruit"),
                    new DevilFruitProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:stamina"),
                    new PlayerStaminaProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:bounty"),
                    new PlayerBountyProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:haki"),
                    new PlayerHakiProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:combat"),
                    new PlayerCombatProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:stats"),
                    new PlayerStatsProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:ability_runtime"),
                    new PlayerAbilityRuntimeProvider());
            event.addCapability(ResourceLocation.parse("grandlineapex:player_data"),
                    new PlayerDataProvider());
        }
    }

    @SubscribeEvent
    public static void clone(PlayerEvent.Clone event) {
        // Copy capability data on respawn/death clone so progression persists through player lifecycle events.
        event.getOriginal().getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(oldStore -> {
            event.getEntity().getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(newStore -> {
                newStore.copyFrom(oldStore);
            });
        });

        event.getOriginal().getCapability(StaminaCapability.STAMINA).ifPresent(oldData -> {
            event.getEntity().getCapability(StaminaCapability.STAMINA).ifPresent(newData -> {
                newData.setMax(oldData.getMax());
                newData.set(oldData.getCurrent());
            });
        });

        event.getOriginal().getCapability(BountyCapability.BOUNTY).ifPresent(oldData -> {
            event.getEntity().getCapability(BountyCapability.BOUNTY).ifPresent(newData -> {
                newData.copyFrom(oldData);
            });
        });

        event.getOriginal().getCapability(HakiCapability.HAKI).ifPresent(oldData -> {
            event.getEntity().getCapability(HakiCapability.HAKI).ifPresent(newData -> {
                newData.copyFrom(oldData);
            });
        });

        event.getOriginal().getCapability(CombatCapability.COMBAT).ifPresent(oldData -> {
            event.getEntity().getCapability(CombatCapability.COMBAT).ifPresent(newData -> {
                newData.copyFrom(oldData);
            });
        });

        event.getOriginal().getCapability(StatsCapability.STATS).ifPresent(oldData -> {
            event.getEntity().getCapability(StatsCapability.STATS).ifPresent(newData -> {
                newData.copyFrom(oldData);
            });
        });

        event.getOriginal().getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(oldData -> {
            event.getEntity().getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(newData -> {
                newData.copyFrom(oldData);
            });
        });

        event.getOriginal().getCapability(PlayerDataStorage.PLAYER_DATA).ifPresent(oldData -> {
            event.getEntity().getCapability(PlayerDataStorage.PLAYER_DATA).ifPresent(newData -> {
                newData.copyFrom(oldData);
            });
        });
    }

    @SubscribeEvent
    public static void tick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) return;
        if (!(event.player instanceof ServerPlayer sp)) return;

        // Server-authoritative stamina regeneration.
        event.player.getCapability(StaminaCapability.STAMINA).ifPresent(data -> data.regen(1f / 20f));

        // Tick all active ability instances (charge/channel/active/cooldown state transitions).
        event.player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(runtime ->
                runtime.tickAll((net.minecraft.server.level.ServerLevel) event.player.level(), sp));

        event.player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df ->
                event.player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(runtime -> {
                    df.clearCooldowns();
                    runtime.snapshotCooldowns().forEach(df::setCooldown);
                }));

        // Evaluate awakening progression and apply awakened passive traits.
        AwakeningHandler.tick(sp);
        PowerScalingHandler.apply(sp);

        // Mirror fragmented subsystem state into unified player-data capability.
        event.player.getCapability(PlayerDataStorage.PLAYER_DATA).ifPresent(playerData -> {
            event.player.getCapability(DevilFruitCapability.DEVIL_FRUIT)
                    .ifPresent(df -> playerData.setFruit(df.getFruitId(), df.getMastery()));
            event.player.getCapability(HakiCapability.HAKI)
                    .ifPresent(haki -> playerData.setHakiUnlocked(
                            haki.isUnlocked(com.grandlineapex.haki.HakiType.ARMAMENT),
                            haki.isUnlocked(com.grandlineapex.haki.HakiType.OBSERVATION),
                            haki.isUnlocked(com.grandlineapex.haki.HakiType.CONQUEROR)
                    ));
            event.player.getCapability(BountyCapability.BOUNTY)
                    .ifPresent(bounty -> playerData.setBounty((int) Math.min(Integer.MAX_VALUE, bounty.getBounty())));
            event.player.getCapability(StaminaCapability.STAMINA)
                    .ifPresent(stamina -> playerData.setStamina(stamina.getCurrent()));
        });

        // Throttle sync to reduce packet volume (10 ticks = 0.5s).
        if (event.player.tickCount % 10 != 0) return;

        // Push current server state to client caches that drive HUD/screens.
        event.player.getCapability(StaminaCapability.STAMINA).ifPresent(data ->
                NetworkHandler.CHANNEL.send(
                        PacketDistributor.PLAYER.with(() -> sp),
                        new SyncStaminaS2C(data.getCurrent(), data.getMax())));

        event.player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(data ->
                NetworkHandler.CHANNEL.send(
                        PacketDistributor.PLAYER.with(() -> sp),
                        new SyncFruitPacket(data.getFruitId(), data.getMastery(), data.isAwakened())));

        event.player.getCapability(HakiCapability.HAKI).ifPresent(data ->
                NetworkHandler.CHANNEL.send(
                        PacketDistributor.PLAYER.with(() -> sp),
                        new SyncHakiPacket(data.getActiveType(), data.getMastery(data.getActiveType()), data.isActive())));

        event.player.getCapability(BountyCapability.BOUNTY).ifPresent(data ->
                NetworkHandler.CHANNEL.send(
                        PacketDistributor.PLAYER.with(() -> sp),
                        new SyncBountyPacket(data.getBounty())));
    }
}

