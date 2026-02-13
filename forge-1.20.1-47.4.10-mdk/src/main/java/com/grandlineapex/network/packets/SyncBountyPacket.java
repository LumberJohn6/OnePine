/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\network\packets\SyncBountyPacket.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.network.packets;

import com.grandlineapex.client.ClientBountyData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncBountyPacket {
    private final long bounty;

    public SyncBountyPacket(long bounty) {
        this.bounty = Math.max(0L, bounty);
    }

    public static void encode(SyncBountyPacket msg, FriendlyByteBuf buf) {
        buf.writeLong(msg.bounty);
    }

    public static SyncBountyPacket decode(FriendlyByteBuf buf) {
        return new SyncBountyPacket(buf.readLong());
    }

    public static void handle(SyncBountyPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () ->
                () -> ClientBountyData.set(msg.bounty)));
        ctx.get().setPacketHandled(true);
    }
}

