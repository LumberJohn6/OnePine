package com.grandlineapex.network;

import com.grandlineapex.GrandLineApex;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {
    private static final String PROTOCOL = "1";
    // Single channel for all gameplay packets; protocol version is the compatibility gate.
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            ResourceLocation.parse(GrandLineApex.MODID + ":main"),
            () -> PROTOCOL, PROTOCOL::equals, PROTOCOL::equals
    );

    private static int index = 0;

    public static void register() {
        // Server -> Client state replication packets.
        CHANNEL.registerMessage(index++,
                com.grandlineapex.network.packets.SyncStaminaS2C.class,
                com.grandlineapex.network.packets.SyncStaminaS2C::encode,
                com.grandlineapex.network.packets.SyncStaminaS2C::decode,
                com.grandlineapex.network.packets.SyncStaminaS2C::handle);

        // Client -> Server action request packet (server validates before execution).
        CHANNEL.registerMessage(index++,
                com.grandlineapex.network.packets.ActivateAbilityC2S.class,
                com.grandlineapex.network.packets.ActivateAbilityC2S::encode,
                com.grandlineapex.network.packets.ActivateAbilityC2S::decode,
                com.grandlineapex.network.packets.ActivateAbilityC2S::handle);

        CHANNEL.registerMessage(index++,
                com.grandlineapex.network.packets.SyncFruitPacket.class,
                com.grandlineapex.network.packets.SyncFruitPacket::encode,
                com.grandlineapex.network.packets.SyncFruitPacket::decode,
                com.grandlineapex.network.packets.SyncFruitPacket::handle);

        CHANNEL.registerMessage(index++,
                com.grandlineapex.network.packets.SyncHakiPacket.class,
                com.grandlineapex.network.packets.SyncHakiPacket::encode,
                com.grandlineapex.network.packets.SyncHakiPacket::decode,
                com.grandlineapex.network.packets.SyncHakiPacket::handle);

        // Register abilities here (or call from mod constructor)
        com.grandlineapex.devilfruit.abilities.AbilityBootstrap.init();
        com.grandlineapex.devilfruit.TestFruit.register();
    }
}
