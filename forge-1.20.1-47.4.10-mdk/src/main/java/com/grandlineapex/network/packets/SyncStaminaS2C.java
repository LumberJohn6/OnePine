package com.grandlineapex.network.packets;

import com.grandlineapex.client.ClientStaminaData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.DistExecutor;

import java.util.function.Supplier;

public class SyncStaminaS2C {
    private final float current;
    private final float max;

    public SyncStaminaS2C(float current, float max) {
        this.current = current;
        this.max = max;
    }

    public static void encode(SyncStaminaS2C msg, FriendlyByteBuf buf) {
        buf.writeFloat(msg.current);
        buf.writeFloat(msg.max);
    }

    public static SyncStaminaS2C decode(FriendlyByteBuf buf) {
        return new SyncStaminaS2C(buf.readFloat(), buf.readFloat());
    }

    public static void handle(SyncStaminaS2C msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () ->
                () -> ClientStaminaData.set(msg.current, msg.max)
        ));
        ctx.get().setPacketHandled(true);
    }
}