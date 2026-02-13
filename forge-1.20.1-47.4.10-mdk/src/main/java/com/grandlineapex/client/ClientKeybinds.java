/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\client\ClientKeybinds.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.client;

import com.grandlineapex.GrandLineApex;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = GrandLineApex.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientKeybinds {
    public static KeyMapping OPEN_WHEEL;
    public static KeyMapping CAST_T1;
    public static KeyMapping OPEN_HAKI;
    public static KeyMapping OPEN_MASTERY;
    public static KeyMapping TOGGLE_ARMAMENT;
    public static KeyMapping TOGGLE_OBSERVATION;
    public static KeyMapping TOGGLE_CONQUEROR;

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent e) {
        OPEN_WHEEL = new KeyMapping("key.grandlineapex.ability_wheel",
                GLFW.GLFW_KEY_R, "key.categories.gameplay");
        e.register(OPEN_WHEEL);

        // TEMP: quick test key to cast Tier-1
        CAST_T1 = new KeyMapping("key.grandlineapex.cast_t1",
                GLFW.GLFW_KEY_Z, "key.categories.gameplay");
        e.register(CAST_T1);

        OPEN_HAKI = new KeyMapping("key.grandlineapex.open_haki",
                GLFW.GLFW_KEY_H, "key.categories.gameplay");
        e.register(OPEN_HAKI);

        OPEN_MASTERY = new KeyMapping("key.grandlineapex.open_mastery",
                GLFW.GLFW_KEY_J, "key.categories.gameplay");
        e.register(OPEN_MASTERY);

        TOGGLE_ARMAMENT = new KeyMapping("key.grandlineapex.toggle_armament",
                GLFW.GLFW_KEY_V, "key.categories.gameplay");
        e.register(TOGGLE_ARMAMENT);

        TOGGLE_OBSERVATION = new KeyMapping("key.grandlineapex.toggle_observation",
                GLFW.GLFW_KEY_B, "key.categories.gameplay");
        e.register(TOGGLE_OBSERVATION);

        TOGGLE_CONQUEROR = new KeyMapping("key.grandlineapex.toggle_conqueror",
                GLFW.GLFW_KEY_N, "key.categories.gameplay");
        e.register(TOGGLE_CONQUEROR);
    }
}

