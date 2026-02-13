/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\MeleeEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MeleeEffect {
    private MeleeEffect() {}

    public static int strikeInFront(ServerLevel level,
                                    ServerPlayer player,
                                    float damage,
                                    double range,
                                    double radius,
                                    double knockback,
                                    ParticleOptions particle,
                                    SoundEvent sound) {
        Vec3 look = player.getLookAngle();
        Vec3 center = player.getEyePosition().add(look.scale(range));
        AABB box = AABB.ofSize(center, radius * 2.0, radius * 2.0, radius * 2.0);

        int hits = 0;
        for (LivingEntity target : level.getEntitiesOfClass(LivingEntity.class, box)) {
            if (target == player || target.isAlliedTo(player)) continue;
            Vec3 toTarget = target.position().subtract(player.position());
            if (toTarget.lengthSqr() < 0.0001) continue;
            if (toTarget.normalize().dot(look) < 0.2) continue;

            if (target.hurt(level.damageSources().playerAttack(player), damage)) {
                target.setDeltaMovement(target.getDeltaMovement().add(look.scale(knockback)));
                hits++;
            }
        }

        if (particle != null) {
            for (int i = 0; i < 10; i++) {
                Vec3 p = player.getEyePosition().add(look.scale(i * (range / 10.0)));
                level.sendParticles(particle, p.x, p.y, p.z, 2, 0.07, 0.07, 0.07, 0.01);
            }
        }

        if (sound != null) {
            level.playSound(null, player.blockPosition(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
        return hits;
    }

    public static int strikeSphere(ServerLevel level,
                                   ServerPlayer player,
                                   Vec3 center,
                                   float damage,
                                   double radius,
                                   double knockback) {
        AABB box = AABB.ofSize(center, radius * 2.0, radius * 2.0, radius * 2.0);
        int hits = 0;
        for (Entity entity : level.getEntities(player, box, e -> e instanceof LivingEntity && e != player)) {
            LivingEntity target = (LivingEntity) entity;
            if (target.isAlliedTo(player)) continue;
            Vec3 delta = target.position().subtract(center);
            if (delta.lengthSqr() > radius * radius) continue;
            if (target.hurt(level.damageSources().playerAttack(player), damage)) {
                Vec3 push = delta.lengthSqr() < 0.0001 ? player.getLookAngle() : delta.normalize();
                target.setDeltaMovement(target.getDeltaMovement().add(push.scale(knockback)));
                hits++;
            }
        }
        return hits;
    }
}

