/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\network\packets\c2s\ServerAbilityPacket.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.network.packets.c2s;

import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.network.packets.ActivateAbilityC2S;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ServerAbilityPacket {
    private final ResourceLocation fruitId;
    private final AbilityTier tier;

    public ServerAbilityPacket(ResourceLocation fruitId, AbilityTier tier) {
        this.fruitId = fruitId;
        this.tier = tier;
    }

    public static void encode(ServerAbilityPacket msg, FriendlyByteBuf buf) {
        buf.writeResourceLocation(msg.fruitId);
        buf.writeEnum(msg.tier);
    }

    public static ServerAbilityPacket decode(FriendlyByteBuf buf) {
        return new ServerAbilityPacket(buf.readResourceLocation(), buf.readEnum(AbilityTier.class));
    }

    public static void handle(ServerAbilityPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ActivateAbilityC2S.handle(new ActivateAbilityC2S(msg.fruitId, msg.tier), ctx);
    }
}

