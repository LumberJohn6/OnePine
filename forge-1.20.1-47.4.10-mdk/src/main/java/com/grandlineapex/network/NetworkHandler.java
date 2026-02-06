package com.grandlineapex.network;

import com.grandlineapex.GrandLineApex;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.SimpleChannel;

public class NetworkHandler {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GrandLineApex.MODID, "main"),
            () -> PROTOCOL, PROTOCOL::equals, PROTOCOL::equals
    );

    private static int index = 0;

    public static void register() {
        CHANNEL.registerMessage(index++,
                com.grandlineapex.network.packets.SyncStaminaS2C.class,
                com.grandlineapex.network.packets.SyncStaminaS2C::encode,
                com.grandlineapex.network.packets.SyncStaminaS2C::decode,
                com.grandlineapex.network.packets.SyncStaminaS2C::handle);

        CHANNEL.registerMessage(index++,
                com.grandlineapex.network.packets.ActivateAbilityC2S.class,
                com.grandlineapex.network.packets.ActivateAbilityC2S::encode,
                com.grandlineapex.network.packets.ActivateAbilityC2S::decode,
                com.grandlineapex.network.packets.ActivateAbilityC2S::handle);

        // Register abilities here (or call from mod constructor)
        com.grandlineapex.devilfruit.abilities.AbilityBootstrap.init();
        com.grandlineapex.devilfruit.TestFruit.register();
    }
}