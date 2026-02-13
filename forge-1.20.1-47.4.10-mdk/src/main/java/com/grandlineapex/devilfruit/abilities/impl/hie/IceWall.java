/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\hie\IceWall.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.hie;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.BuffEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;

public class IceWall extends BaseAbility {
    public IceWall() {
        super("grandlineapex:ice_wall", AbilityTier.T3, 90, 14.0f, 80);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        BuffEffect.apply(player, MobEffects.DAMAGE_RESISTANCE, 20 * 10, 1);
        BuffEffect.apply(player, MobEffects.FIRE_RESISTANCE, 20 * 10, 0);
        level.sendParticles(net.minecraft.core.particles.ParticleTypes.SNOWFLAKE,
                player.getX(), player.getY() + 1.0, player.getZ(), 25, 1.0, 1.0, 1.0, 0.01);
        return true;
    }
}


