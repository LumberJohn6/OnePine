/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\ProjectileEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Snowball;

public class ProjectileEffect {
    private ProjectileEffect() {}

    public static void shootFireball(ServerLevel level, ServerPlayer player, float velocity) {
        var look = player.getLookAngle();
        SmallFireball fireball = new SmallFireball(level, player, look.x, look.y, look.z);
        fireball.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        fireball.shoot(look.x, look.y, look.z, velocity, 0.5f);
        level.addFreshEntity(fireball);
    }

    public static void shootSnowball(ServerLevel level, ServerPlayer player, float velocity) {
        Snowball snowball = new Snowball(EntityType.SNOWBALL, level);
        snowball.setOwner(player);
        snowball.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, velocity, 0.2f);
        level.addFreshEntity(snowball);
    }
}

