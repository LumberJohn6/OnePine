package com.grandlineapex.network.packets;

import com.grandlineapex.ability.runtime.AbilityInstance;
import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.devilfruit.awakening.AwakeningHandler;
import com.grandlineapex.systems.stamina.StaminaCapability;

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

            // Resolve fruit + ability
            var fruitOpt = FruitRegistry.get(msg.fruitId);
            if (fruitOpt.isEmpty()) return;
            var ability = fruitOpt.get().getTier(msg.tier);
            if (ability == null) return;

            // Validation chain: equipped fruit -> mastery/awakening -> cooldown -> stamina -> execute.
            // This keeps all authoritative gameplay checks on the server.
            player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df -> {
                player.getCapability(StaminaCapability.STAMINA).ifPresent(sta -> {
                    if (!msg.fruitId.toString().equals(df.getFruitId())) return;

                    int mastery = df.getMastery();
                    if (mastery < ability.masteryRequirement()) return;
                    if (msg.tier == AbilityTier.AWAKENING && !df.isAwakened()) return;

                    // Awakening multipliers are injected at activation time so runtime inherits scaled values.
                    int cooldown = Math.max(1, Math.round(
                            ability.cooldownWithMastery(mastery) * AwakeningHandler.cooldownMultiplier(df)
                    ));
                    float cost = Math.max(1f,
                            ability.staminaWithMastery(mastery) * AwakeningHandler.staminaMultiplier(df));
                    player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(runtime -> {
                        if (!runtime.canStart(ability.id())) return;
                        if (!sta.trySpend(cost)) return;

                        // Enter the runtime engine instead of executing ad-hoc logic directly.
                        AbilityInstance instance = AbilityInstance.start(msg.fruitId, ability, mastery, cooldown);
                        runtime.start(instance);
                    });
                });
            });
        });
        c.setPacketHandled(true);
    }
}
