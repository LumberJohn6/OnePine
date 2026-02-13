package com.grandlineapex.core.hooks;

import com.grandlineapex.combat.energy.CooldownHandler;
import com.grandlineapex.client.ClientKeybinds;
import com.grandlineapex.client.hud.AbilityWheelScreen;
import com.grandlineapex.client.hud.HakiScreen;
import com.grandlineapex.client.hud.MasteryScreen;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.network.NetworkHandler;
import com.grandlineapex.network.packets.ActivateAbilityC2S;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TickEvents {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            CooldownHandler.tickCooldowns();
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        var mc = Minecraft.getInstance();
        if (mc.player == null) return;

        // Hold R to open the wheel (client-only)
        if (mc.screen == null
                && ClientKeybinds.OPEN_WHEEL != null
                && ClientKeybinds.OPEN_WHEEL.isDown()) {
            mc.setScreen(new AbilityWheelScreen());
        }

        // TEMP: Press Z to cast Tier 1 of the "testfruit"
        if (ClientKeybinds.CAST_T1 != null && ClientKeybinds.CAST_T1.consumeClick()) {
            NetworkHandler.CHANNEL.sendToServer(
                    new ActivateAbilityC2S(
                            ResourceLocation.parse("grandlineapex:testfruit"),
                            AbilityTier.T1
                    )
            );
        }

        if (mc.screen == null && ClientKeybinds.OPEN_HAKI != null && ClientKeybinds.OPEN_HAKI.consumeClick()) {
            mc.setScreen(new HakiScreen());
        }

        if (mc.screen == null && ClientKeybinds.OPEN_MASTERY != null && ClientKeybinds.OPEN_MASTERY.consumeClick()) {
            mc.setScreen(new MasteryScreen());
        }
    }
}
