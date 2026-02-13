package com.grandlineapex.network.packets;

import com.grandlineapex.client.ClientFruitData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncFruitPacket {
    private final String fruitId;
    private final int mastery;
    private final boolean awakened;

    public SyncFruitPacket(String fruitId, int mastery, boolean awakened) {
        this.fruitId = fruitId == null ? "" : fruitId;
        this.mastery = Math.max(0, mastery);
        this.awakened = awakened;
    }

    public static void encode(SyncFruitPacket msg, FriendlyByteBuf buf) {
        buf.writeUtf(msg.fruitId);
        buf.writeInt(msg.mastery);
        buf.writeBoolean(msg.awakened);
    }

    public static SyncFruitPacket decode(FriendlyByteBuf buf) {
        return new SyncFruitPacket(buf.readUtf(256), buf.readInt(), buf.readBoolean());
    }

    public static void handle(SyncFruitPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () ->
                () -> ClientFruitData.set(msg.fruitId, msg.mastery, msg.awakened)));
        ctx.get().setPacketHandled(true);
    }
}
