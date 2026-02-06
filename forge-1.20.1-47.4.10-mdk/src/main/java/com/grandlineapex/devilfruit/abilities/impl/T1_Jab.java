package com.grandlineapex.devilfruit.abilities.impl;

import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.Vec3;

public class T1_Jab implements Ability {
    private static final ResourceLocation ID = new ResourceLocation("grandlineapex", "t1_jab");

    @Override public ResourceLocation id() { return ID; }
    @Override public AbilityTier tier() { return AbilityTier.T1; }
    @Override public int baseCooldownTicks() { return 40; } // 2s
    @Override public float staminaCost() { return 8f; }
    @Override public int masteryRequirement() { return 0; }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        var look = player.getLookAngle();
        var start = player.getEyePosition();
        var end = start.add(look.scale(3.0)); // 3 block jab

        var hit = net.minecraft.world.level.ClipContext.Block.COLLIDER;
        var fluid = net.minecraft.world.level.ClipContext.Fluid.NONE;
        var clip = level.clip(new net.minecraft.world.level.ClipContext(start, end, hit, fluid, player));

        // simple AoE around hit point
        Vec3 p = clip != null ? clip.getLocation() : end;
        var aabb = new net.minecraft.world.phys.AABB(p.x-0.75, p.y-0.75, p.z-0.75, p.x+0.75, p.y+0.75, p.z+0.75);
        var victims = level.getEntities(player, aabb, e -> e.isAttackable() && e != player);

        for (var e : victims) {
            e.hurt(level.damageSources().playerAttack(player), 4.0f);
        }
        // later: swing SFX, particles, camera shake
        return true;
    }
}