/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\ope\Room.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.ope;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.BuffEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;

public class Room extends BaseAbility {
    public Room() {
        super("grandlineapex:room", AbilityTier.T1, 70, 11.0f, 0);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        BuffEffect.apply(player, MobEffects.DAMAGE_RESISTANCE, 20 * 12, 0);
        BuffEffect.apply(player, MobEffects.DIG_SPEED, 20 * 12, 0);
        level.sendParticles(net.minecraft.core.particles.ParticleTypes.ENCHANT,
                player.getX(), player.getY() + 1.0, player.getZ(), 30, 2.5, 1.2, 2.5, 0.0);
        return true;
    }
}


