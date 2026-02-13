/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\BuffEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

public class BuffEffect {
    private BuffEffect() {}

    public static void apply(ServerPlayer player, MobEffect effect, int durationTicks, int amplifier) {
        player.addEffect(new MobEffectInstance(effect, Math.max(1, durationTicks), Math.max(0, amplifier), false, true, true));
    }
}

