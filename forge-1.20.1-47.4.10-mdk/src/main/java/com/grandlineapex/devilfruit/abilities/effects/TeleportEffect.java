/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\effects\TeleportEffect.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;

public class TeleportEffect {
    private TeleportEffect() {}

    public static boolean blinkForward(ServerLevel level, ServerPlayer player, double distance) {
        Vec3 start = player.getEyePosition();
        Vec3 end = start.add(player.getLookAngle().scale(Math.max(1.0, distance)));
        var hit = level.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        Vec3 destination = hit.getType() == net.minecraft.world.phys.HitResult.Type.MISS
                ? end
                : hit.getLocation().add(player.getLookAngle().scale(-0.8));
        player.teleportTo(destination.x, destination.y, destination.z);
        return true;
    }
}

