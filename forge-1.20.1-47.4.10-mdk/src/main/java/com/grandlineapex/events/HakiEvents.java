package com.grandlineapex.events;

import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.haki.HakiType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HakiEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) return;
        if (event.player.tickCount % 40 != 0) return;
        event.player.getCapability(HakiCapability.HAKI).ifPresent(data -> {
            if (data.isActive() && data.getActiveType() != HakiType.NONE) {
                data.addMastery(data.getActiveType(), 1);
            }
        });
    }
}
