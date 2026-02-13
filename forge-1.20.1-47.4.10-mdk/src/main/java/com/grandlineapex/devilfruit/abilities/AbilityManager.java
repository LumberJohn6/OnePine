/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\AbilityManager.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.devilfruit.awakening.AwakeningHandler;
import com.grandlineapex.systems.stamina.StaminaCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class AbilityManager {
    private AbilityManager() {
    }

    public static boolean executeValidated(ServerLevel level,
                                           ServerPlayer player,
                                           ResourceLocation fruitId,
                                           AbilityTier tier) {
        var fruitOpt = FruitRegistry.get(fruitId);
        if (fruitOpt.isEmpty()) return false;
        var ability = fruitOpt.get().getTier(tier);
        if (ability == null) return false;

        return player.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df ->
                player.getCapability(StaminaCapability.STAMINA).map(sta -> {
                    if (!fruitId.toString().equals(df.getFruitId())) return false;

                    int mastery = df.getMastery();
                    if (mastery < ability.masteryRequirement()) return false;
                    if (tier == AbilityTier.AWAKENING && !df.isAwakened()) return false;
                    if (AbilityCooldownTracker.isOnCooldown(player, ability.id())) return false;

                    int cooldown = Math.max(1, Math.round(
                            ability.cooldownWithMastery(mastery) * AwakeningHandler.cooldownMultiplier(df)
                    ));
                    float cost = Math.max(1f, ability.staminaWithMastery(mastery) * AwakeningHandler.staminaMultiplier(df));

                    return player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).map(runtime -> {
                        if (!runtime.canStart(ability.id())) return false;
                        if (!sta.trySpend(cost)) return false;
                        runtime.start(com.grandlineapex.ability.runtime.AbilityInstance.start(fruitId, ability, mastery, cooldown));
                        AbilityCooldownTracker.setCooldown(player, ability.id(), cooldown);
                        return true;
                    }).orElse(false);
                }).orElse(false)
        ).orElse(false);
    }
}

