/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\network\packets\SyncHakiPacket.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.network.packets;

import com.grandlineapex.client.ClientHakiData;
import com.grandlineapex.haki.HakiType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncHakiPacket {
    private final HakiType type;
    private final int mastery;
    private final boolean active;

    public SyncHakiPacket(HakiType type, int mastery, boolean active) {
        this.type = type == null ? HakiType.NONE : type;
        this.mastery = Math.max(0, mastery);
        this.active = active;
    }

    public static void encode(SyncHakiPacket msg, FriendlyByteBuf buf) {
        buf.writeEnum(msg.type);
        buf.writeInt(msg.mastery);
        buf.writeBoolean(msg.active);
    }

    public static SyncHakiPacket decode(FriendlyByteBuf buf) {
        HakiType type;
        try {
            type = buf.readEnum(HakiType.class);
        } catch (Exception ignored) {
            type = HakiType.NONE;
        }
        return new SyncHakiPacket(type, buf.readInt(), buf.readBoolean());
    }

    public static void handle(SyncHakiPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () ->
                () -> ClientHakiData.set(msg.type, msg.mastery, msg.active)));
        ctx.get().setPacketHandled(true);
    }
}

