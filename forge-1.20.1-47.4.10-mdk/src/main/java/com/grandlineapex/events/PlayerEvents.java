package com.grandlineapex.events;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.devilfruit.PlayerDevilFruitProvider;
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
import com.grandlineapex.systems.stamina.PlayerStaminaProvider;
import com.grandlineapex.systems.stamina.StaminaCapability;
import com.grandlineapex.network.NetworkHandler;
import com.grandlineapex.network.packets.SyncFruitPacket;
import com.grandlineapex.network.packets.SyncHakiPacket;
import com.grandlineapex.network.packets.SyncStaminaS2C;
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
                    new PlayerDevilFruitProvider());
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

        // Evaluate awakening progression and apply awakened passive traits.
        AwakeningHandler.tick(sp);

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
    }
}
