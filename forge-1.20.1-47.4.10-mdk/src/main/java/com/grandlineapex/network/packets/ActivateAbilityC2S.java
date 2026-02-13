/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\network\packets\ActivateAbilityC2S.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.network.packets;

import com.grandlineapex.devilfruit.abilities.AbilityManager;
import com.grandlineapex.devilfruit.abilities.AbilityTier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;


public class ActivateAbilityC2S {
    private final ResourceLocation fruitId;
    private final AbilityTier tier;

    public ActivateAbilityC2S(ResourceLocation fruitId, AbilityTier tier) {
        this.fruitId = fruitId; this.tier = tier;
    }

    public static void encode(ActivateAbilityC2S p, FriendlyByteBuf buf) {
        buf.writeResourceLocation(p.fruitId);
        buf.writeInt(p.tier.ordinal());
    }

    public static ActivateAbilityC2S decode(FriendlyByteBuf buf) {
        ResourceLocation fruitId = buf.readResourceLocation();
        AbilityTier tier;
        int ordinal = buf.readInt();
        if (ordinal < 0 || ordinal >= AbilityTier.values().length) {
            tier = AbilityTier.T1;
        } else {
            tier = AbilityTier.values()[ordinal];
        }
        return new ActivateAbilityC2S(fruitId, tier);
    }

    public static void handle(ActivateAbilityC2S msg, Supplier<NetworkEvent.Context> ctx) {
        var c = ctx.get();
        c.enqueueWork(() -> {
            var player = c.getSender();
            if (player == null || !(player.level() instanceof net.minecraft.server.level.ServerLevel level)) return;
            AbilityManager.executeValidated(level, player, msg.fruitId, msg.tier);
        });
        c.setPacketHandled(true);
    }
}

