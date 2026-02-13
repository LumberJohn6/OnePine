/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\SummonEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;

public class SummonEffect {
    private SummonEffect() {}

    public static int summonAround(ServerLevel level,
                                   ServerPlayer player,
                                   EntityType<? extends Mob> type,
                                   int count,
                                   double radius) {
        int spawned = 0;
        for (int i = 0; i < count; i++) {
            Mob mob = type.create(level);
            if (mob == null) continue;
            double angle = (Math.PI * 2.0 * i) / Math.max(1, count);
            double x = player.getX() + Math.cos(angle) * radius;
            double z = player.getZ() + Math.sin(angle) * radius;
            mob.moveTo(x, player.getY(), z, player.getYRot(), 0.0f);
            mob.setTarget(null);
            level.addFreshEntity(mob);
            spawned++;
        }
        return spawned;
    }
}

