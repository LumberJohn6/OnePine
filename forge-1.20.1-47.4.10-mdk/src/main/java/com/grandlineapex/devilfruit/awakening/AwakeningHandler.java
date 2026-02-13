package com.grandlineapex.devilfruit.awakening;

import com.grandlineapex.bounty.BountyTier;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.devilfruit.awakening.requirements.BossDefeatAwakeningRequirement;
import com.grandlineapex.devilfruit.awakening.requirements.BountyAwakeningRequirement;
import com.grandlineapex.devilfruit.awakening.requirements.ConquerorUnlockAwakeningRequirement;
import com.grandlineapex.devilfruit.awakening.requirements.MasteryAwakeningRequirement;
import com.grandlineapex.devilfruit.awakening.requirements.SpecialItemAwakeningRequirement;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class AwakeningHandler {
    // Central awakening contract: all entries here must pass before awakening is granted.
    private static final List<AwakeningRequirement> REQUIREMENTS = List.of(
            new MasteryAwakeningRequirement(250),
            new BountyAwakeningRequirement(BountyTier.WARLORD_CANDIDATE),
            new BossDefeatAwakeningRequirement(),
            new ConquerorUnlockAwakeningRequirement(),
            new SpecialItemAwakeningRequirement()
    );

    private AwakeningHandler() {}

    public static boolean meetsAllRequirements(ServerPlayer player, PlayerDevilFruitData data) {
        if (data.getFruitId().isEmpty()) return false;
        for (AwakeningRequirement requirement : REQUIREMENTS) {
            if (!requirement.isMet(player, data)) return false;
        }
        return true;
    }

    public static boolean tryAwaken(ServerPlayer player, PlayerDevilFruitData data) {
        if (data.isAwakened()) return true;
        if (!meetsAllRequirements(player, data)) return false;
        data.setAwakened(true);
        // Player feedback stays local here; visuals/animations can hook into this transition later.
        player.displayClientMessage(Component.literal("Your Devil Fruit has awakened!"), true);
        return true;
    }

    public static void tick(ServerPlayer player) {
        // Called by PlayerEvents each server tick to keep awakening state and awakened passives in sync.
        player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(data -> {
            if (tryAwaken(player, data)) {
                // Passive trait while awakened.
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, false, false, true));
            }
        });
    }

    // Scaling hooks consumed by ability activation/combat layers.
    public static float staminaMultiplier(PlayerDevilFruitData data) {
        return data.isAwakened() ? 0.80f : 1.0f;
    }

    public static float cooldownMultiplier(PlayerDevilFruitData data) {
        return data.isAwakened() ? 0.75f : 1.0f;
    }

    public static float damageMultiplier(PlayerDevilFruitData data) {
        return data.isAwakened() ? 1.15f : 1.0f;
    }
}
