/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\DebuffEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DebuffEffect {
    private DebuffEffect() {}

    public static int applyInRadius(ServerLevel level,
                                    ServerPlayer player,
                                    Vec3 center,
                                    double radius,
                                    MobEffect effect,
                                    int durationTicks,
                                    int amplifier) {
        AABB box = AABB.ofSize(center, radius * 2.0, radius * 2.0, radius * 2.0);
        int hits = 0;
        for (LivingEntity target : level.getEntitiesOfClass(LivingEntity.class, box)) {
            if (target == player || target.isAlliedTo(player)) continue;
            if (target.position().distanceToSqr(center) > radius * radius) continue;
            target.addEffect(new MobEffectInstance(effect, Math.max(1, durationTicks), Math.max(0, amplifier), false, true, true));
            hits++;
        }
        return hits;
    }
}

