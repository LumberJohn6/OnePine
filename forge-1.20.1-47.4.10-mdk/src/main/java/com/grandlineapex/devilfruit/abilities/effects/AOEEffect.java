/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\AOEEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;

public class AOEEffect {
    private AOEEffect() {}

    public static int blast(ServerLevel level,
                            ServerPlayer player,
                            Vec3 center,
                            float damage,
                            double radius,
                            double knockback,
                            ParticleOptions particle,
                            SoundEvent sound) {
        int hits = MeleeEffect.strikeSphere(level, player, center, damage, radius, knockback);

        if (particle != null) {
            level.sendParticles(particle, center.x, center.y, center.z,
                    (int) Math.max(8, radius * 12), radius * 0.3, radius * 0.25, radius * 0.3, 0.02);
        }
        if (sound != null) {
            level.playSound(null, player.blockPosition(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
        return hits;
    }
}

