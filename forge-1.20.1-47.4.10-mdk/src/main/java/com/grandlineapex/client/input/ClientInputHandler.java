/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\client\input\ClientInputHandler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.client.input;

import com.grandlineapex.client.ClientFruitData;
import com.grandlineapex.client.ClientKeybinds;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.network.NetworkHandler;
import com.grandlineapex.network.packets.c2s.ServerAbilityPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class ClientInputHandler {
    private ClientInputHandler() {
    }

    public static void onClientTick() {
        var mc = Minecraft.getInstance();
        if (mc.player == null) return;

        if (ClientKeybinds.CAST_T1 != null && ClientKeybinds.CAST_T1.consumeClick()) {
            String fruitId = ClientFruitData.getFruitId();
            if (!fruitId.isEmpty()) {
                NetworkHandler.CHANNEL.sendToServer(new ServerAbilityPacket(ResourceLocation.parse(fruitId), AbilityTier.T1));
            }
        }
    }
}

