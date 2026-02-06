package com.grandlineapex.events;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.devilfruit.PlayerDevilFruitProvider;
import com.grandlineapex.systems.stamina.PlayerStaminaProvider;
import com.grandlineapex.systems.stamina.StaminaCapability;
import com.grandlineapex.network.NetworkHandler;
import com.grandlineapex.network.packets.SyncStaminaS2C;

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
            event.addCapability(new ResourceLocation("grandlineapex", "devil_fruit"),
                    new PlayerDevilFruitProvider());
            event.addCapability(new ResourceLocation("grandlineapex", "stamina"),
                    new PlayerStaminaProvider());
        }
    }

    @SubscribeEvent
    public static void clone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(oldStore -> {
            event.getEntity().getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(newStore -> {
                newStore.setFruitId(oldStore.getFruitId());
                newStore.addMastery(oldStore.getMastery());
                newStore.setAwakened(oldStore.isAwakened());
            });
        });

        event.getOriginal().getCapability(StaminaCapability.STAMINA).ifPresent(oldData -> {
            event.getEntity().getCapability(StaminaCapability.STAMINA).ifPresent(newData -> {
                newData.setMax(oldData.getMax());
                newData.set(oldData.getCurrent());
            });
        });
    }

    @SubscribeEvent
    public static void tick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide) {
            event.player.getCapability(StaminaCapability.STAMINA).ifPresent(data -> {
                data.regen(1f / 20f); // 20 ticks/sec

                // Throttle sync to client (every 10 ticks)
                if (event.player.tickCount % 10 == 0 && event.player instanceof ServerPlayer sp) {
                    NetworkHandler.CHANNEL.send(
                            PacketDistributor.PLAYER.with(() -> sp),
                            new SyncStaminaS2C(data.getCurrent(), data.getMax())
                    );
                }
            });
        }
        // TEMP: give the player a test fruit the first time they tick in
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide) {

            // TEMP: give the player a test fruit the first time
            event.player.getCapability(com.grandlineapex.capability.devilfruit.DevilFruitCapability.DEVIL_FRUIT)
                    .ifPresent(df -> {
                        if (df.getFruitId() == null || df.getFruitId().isEmpty()) {
                            df.setFruitId("grandlineapex:testfruit");
                        }
                    });

            // stamina regen + sync (you already have this)
            event.player.getCapability(com.grandlineapex.systems.stamina.StaminaCapability.STAMINA).ifPresent(data -> {
                data.regen(1f / 20f);
                if (event.player.tickCount % 10 == 0 && event.player instanceof net.minecraft.server.level.ServerPlayer sp) {
                    com.grandlineapex.network.NetworkHandler.CHANNEL.send(
                            net.minecraftforge.network.PacketDistributor.PLAYER.with(() -> sp),
                            new com.grandlineapex.network.packets.SyncStaminaS2C(data.getCurrent(), data.getMax())
                    );
                }
            });
        }

    }
}