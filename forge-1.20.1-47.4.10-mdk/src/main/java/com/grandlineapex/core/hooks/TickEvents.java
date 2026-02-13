/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\core\hooks\TickEvents.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.core.hooks;

import com.grandlineapex.combat.energy.CooldownHandler;
import com.grandlineapex.client.ClientKeybinds;
import com.grandlineapex.client.input.ClientInputHandler;
import com.grandlineapex.client.hud.AbilityWheelScreen;
import com.grandlineapex.client.hud.HakiScreen;
import com.grandlineapex.client.hud.MasteryScreen;
import com.grandlineapex.haki.HakiType;
import com.grandlineapex.network.NetworkHandler;
import com.grandlineapex.network.packets.ToggleHakiC2S;
import net.minecraft.client.Minecraft;
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

        ClientInputHandler.onClientTick();

        if (mc.screen == null && ClientKeybinds.OPEN_HAKI != null && ClientKeybinds.OPEN_HAKI.consumeClick()) {
            mc.setScreen(new HakiScreen());
        }

        if (mc.screen == null && ClientKeybinds.OPEN_MASTERY != null && ClientKeybinds.OPEN_MASTERY.consumeClick()) {
            mc.setScreen(new MasteryScreen());
        }

        if (ClientKeybinds.TOGGLE_ARMAMENT != null && ClientKeybinds.TOGGLE_ARMAMENT.consumeClick()) {
            NetworkHandler.CHANNEL.sendToServer(new ToggleHakiC2S(HakiType.ARMAMENT));
        }
        if (ClientKeybinds.TOGGLE_OBSERVATION != null && ClientKeybinds.TOGGLE_OBSERVATION.consumeClick()) {
            NetworkHandler.CHANNEL.sendToServer(new ToggleHakiC2S(HakiType.OBSERVATION));
        }
        if (ClientKeybinds.TOGGLE_CONQUEROR != null && ClientKeybinds.TOGGLE_CONQUEROR.consumeClick()) {
            NetworkHandler.CHANNEL.sendToServer(new ToggleHakiC2S(HakiType.CONQUEROR));
        }
    }
}

