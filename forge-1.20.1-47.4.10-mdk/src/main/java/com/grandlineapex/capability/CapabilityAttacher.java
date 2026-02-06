package com.grandlineapex.capability;

import com.grandlineapex.capability.player.PlayerDevilFruitData;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraft.resources.ResourceLocation;

public class CapabilityAttacher {
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity player) {
            event.addCapability(new ResourceLocation("grandlineapex", "devil_fruit_data"),
                    new PlayerDevilFruitProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // copy capability from original to clone (important on death)
    }
}
