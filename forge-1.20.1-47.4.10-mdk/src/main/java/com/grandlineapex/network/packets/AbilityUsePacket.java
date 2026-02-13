package com.grandlineapex.network.packets;

import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class AbilityUsePacket {
    private final ResourceLocation fruitId;
    private final AbilityTier tier;

    public AbilityUsePacket(ResourceLocation fruitId, AbilityTier tier) {
        this.fruitId = fruitId;
        this.tier = tier;
    }

    public static void encode(AbilityUsePacket msg, FriendlyByteBuf buf) {
        buf.writeResourceLocation(msg.fruitId);
        buf.writeEnum(msg.tier);
    }

    public static AbilityUsePacket decode(FriendlyByteBuf buf) {
        return new AbilityUsePacket(buf.readResourceLocation(), buf.readEnum(AbilityTier.class));
    }

    public static void handle(AbilityUsePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ActivateAbilityC2S.handle(new ActivateAbilityC2S(msg.fruitId, msg.tier), ctx);
    }
}
