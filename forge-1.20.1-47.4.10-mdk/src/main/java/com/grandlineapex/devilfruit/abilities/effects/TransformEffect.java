/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\TransformEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;

public class TransformEffect {
    private TransformEffect() {}

    public static void zoanForm(ServerPlayer player, int durationTicks, int power) {
        BuffEffect.apply(player, MobEffects.DAMAGE_BOOST, durationTicks, power);
        BuffEffect.apply(player, MobEffects.MOVEMENT_SPEED, durationTicks, Math.max(0, power - 1));
        BuffEffect.apply(player, MobEffects.DAMAGE_RESISTANCE, durationTicks, Math.max(0, power - 1));
    }
}

