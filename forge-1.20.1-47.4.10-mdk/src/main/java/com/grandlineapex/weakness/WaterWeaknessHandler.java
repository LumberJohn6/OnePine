/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\weakness\WaterWeaknessHandler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.weakness;

import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.capability.player.PlayerAbilityRuntimeData;
import com.grandlineapex.devilfruit.DevilFruit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class WaterWeaknessHandler {
    private WaterWeaknessHandler() {
    }

    public static boolean isWeakened(ServerPlayer player, DevilFruit fruit) {
        return fruit.hasWaterWeakness() && (player.isInWater() || player.isInWaterRainOrBubble() || player.isUnderWater());
    }

    public static void apply(ServerLevel level, ServerPlayer player) {
        player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME)
                .ifPresent(runtime -> runtime.interruptAll(level, player, "water"));
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1, false, false, true));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2, false, false, true));
        if (player.getAirSupply() > 0) {
            player.setAirSupply(player.getAirSupply() - 1);
        }
    }
}

