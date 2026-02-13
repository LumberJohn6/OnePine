/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\network\packets\ToggleHakiC2S.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.network.packets;

import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.haki.HakiType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ToggleHakiC2S {
    private final HakiType type;

    public ToggleHakiC2S(HakiType type) {
        this.type = type == null ? HakiType.NONE : type;
    }

    public static void encode(ToggleHakiC2S msg, FriendlyByteBuf buf) {
        buf.writeEnum(msg.type);
    }

    public static ToggleHakiC2S decode(FriendlyByteBuf buf) {
        return new ToggleHakiC2S(buf.readEnum(HakiType.class));
    }

    public static void handle(ToggleHakiC2S msg, Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        context.enqueueWork(() -> {
            var player = context.getSender();
            if (player == null) return;

            player.getCapability(HakiCapability.HAKI).ifPresent(data -> {
                HakiType requested = msg.type;
                if (requested == HakiType.NONE) {
                    data.setActive(false);
                    data.setActiveType(HakiType.NONE);
                    return;
                }
                if (!data.isUnlocked(requested)) return;

                boolean disable = data.isActive() && data.getActiveType() == requested;
                if (disable) {
                    data.setActive(false);
                    data.setActiveType(HakiType.NONE);
                } else {
                    data.setActiveType(requested);
                    data.setActive(true);
                }
            });
        });
        context.setPacketHandled(true);
    }
}

