package com.grandlineapex.network.packets;

import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.systems.stamina.StaminaCapability;
import com.grandlineapex.combat.energy.CooldownHandler;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


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
        return new ActivateAbilityC2S(buf.readResourceLocation(),
                AbilityTier.values()[buf.readInt()]);
    }

    public static void handle(ActivateAbilityC2S msg, Supplier<NetworkEvent.Context> ctx) {
        var c = ctx.get();
        c.enqueueWork(() -> {
            var player = c.getSender();
            if (player == null || !(player.level() instanceof net.minecraft.server.level.ServerLevel level)) return;

            // Resolve fruit + ability
            var fruitOpt = FruitRegistry.get(msg.fruitId);
            if (fruitOpt.isEmpty()) return;
            var ability = fruitOpt.get().getTier(msg.tier);
            if (ability == null) return;

            // Check mastery and stamina and cooldown
            player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df -> {
                player.getCapability(StaminaCapability.STAMINA).ifPresent(sta -> {
                    int mastery = df.getMastery();
                    int cooldown = ability.cooldownWithMastery(mastery);
                    float cost = ability.staminaWithMastery(mastery);

                    UUID key = UUID.nameUUIDFromBytes(
                            (ability.id().toString() + "|" + player.getUUID()).getBytes(StandardCharsets.UTF_8)
                    );
                            // just to build a per-player per-ability key
                            // (you could also store a Map<AbilityId, ticks> inside a player capability)
                            ;

                    if (CooldownHandler.isActive(key)) return;
                    if (!sta.trySpend(cost)) return;

                    boolean ok = ability.execute(level, player);
                    if (ok) {
                        CooldownHandler.set(key, cooldown);
                    }
                });
            });
        });
        c.setPacketHandled(true);
    }
}