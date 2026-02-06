package com.grandlineapex.client;

import com.grandlineapex.GrandLineApex;
import com.grandlineapex.client.hud.StaminaHudOverlay;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GrandLineApex.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void onRegisterOverlays(RegisterGuiOverlaysEvent event) {
        // Show above all default HUD elements
        event.registerAboveAll("stamina", StaminaHudOverlay.HUD_STAMINA);
    }
}