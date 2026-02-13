/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\events\DevilFruitEvents.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.events;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.devilfruit.FruitRegistry;
import net.minecraft.server.level.ServerPlayer;
import com.grandlineapex.weakness.SeastoneHandler;
import com.grandlineapex.weakness.WaterWeaknessHandler;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DevilFruitEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) return;
        if (!(event.player instanceof ServerPlayer player)) return;

        var level = (net.minecraft.server.level.ServerLevel) player.level();

        // Runtime passive loop for equipped fruit and weakness handling.
        player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(data -> {
            if (data.getFruitId().isEmpty()) return;
            net.minecraft.resources.ResourceLocation fruitId;
            try {
                fruitId = net.minecraft.resources.ResourceLocation.parse(data.getFruitId());
            } catch (Exception ignored) {
                return;
            }
            var fruitOpt = FruitRegistry.get(fruitId);
            if (fruitOpt.isEmpty()) return;

            var fruit = fruitOpt.get();
            boolean waterWeak = WaterWeaknessHandler.isWeakened(player, fruit);
            boolean seastoneWeak = SeastoneHandler.isWeakened(player, fruit);
            data.setSubmergedWeakness(waterWeak || seastoneWeak);

            if (!waterWeak && !seastoneWeak) {
                fruit.onPlayerTick(player);
                return;
            }

            if (waterWeak) WaterWeaknessHandler.apply(level, player);
            if (seastoneWeak) SeastoneHandler.apply(level, player);
        });
    }
}

