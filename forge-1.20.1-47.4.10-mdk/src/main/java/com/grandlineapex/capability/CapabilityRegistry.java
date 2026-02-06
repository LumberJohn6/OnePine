package com.grandlineapex.capability;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry {

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(PlayerDevilFruitData.class);
    }
}