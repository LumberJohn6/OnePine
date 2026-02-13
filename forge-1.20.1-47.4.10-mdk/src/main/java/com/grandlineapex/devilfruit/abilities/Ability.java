package com.grandlineapex.devilfruit.abilities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public interface Ability {
    ResourceLocation id();
    AbilityTier tier();

    int baseCooldownTicks();      // e.g., 60 = 3s
    float staminaCost();          // e.g., 10f
    int masteryRequirement();     // gate per-ability

    /**
     * Return true if execution succeeded (and costs should be applied).
     */
    boolean execute(ServerLevel level, ServerPlayer player);

    default int chargeDurationTicks(int mastery) { return 0; }
    default int channelDurationTicks(int mastery) { return 0; }
    default int activeDurationTicks(int mastery) { return 1; }

    default boolean canInterruptOnDamage() { return true; }
    default boolean canInterruptInWater() { return true; }

    default boolean onActivate(ServerLevel level, ServerPlayer player, int mastery) {
        return execute(level, player);
    }

    default void onActiveTick(ServerLevel level, ServerPlayer player, int mastery, int ticksRemaining) {
    }

    default void onInterrupted(ServerLevel level, ServerPlayer player, int mastery, String reason) {
    }

    // Optional: simple mastery scaling helpers you can tune later
    default int cooldownWithMastery(int mastery) {
        // example: -1% per 20 mastery
        double scale = 1.0 - Math.floorDiv(mastery, 20) * 0.01;
        return Math.max(5, (int)Math.round(baseCooldownTicks() * scale));
    }

    default float staminaWithMastery(int mastery) {
        // example: -0.5% per 25 mastery
        double scale = 1.0 - Math.floorDiv(mastery, 25) * 0.005;
        return (float)Math.max(1.0, staminaCost() * scale);
    }
}
