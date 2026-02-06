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
    public static KeyMapping CAST_T1;  // <-- NEW

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent e) {
        OPEN_WHEEL = new KeyMapping("key.grandlineapex.ability_wheel",
                GLFW.GLFW_KEY_R, "key.categories.gameplay");
        e.register(OPEN_WHEEL);

        // TEMP: quick test key to cast Tier-1
        CAST_T1 = new KeyMapping("key.grandlineapex.cast_t1",
                GLFW.GLFW_KEY_Z, "key.categories.gameplay");
        e.register(CAST_T1);
    }
}