/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\ope\Tact.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.ope;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import com.grandlineapex.devilfruit.abilities.effects.DebuffEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;

public class Tact extends BaseAbility {
    public Tact() {
        super("grandlineapex:tact", AbilityTier.T3, 120, 20.0f, 100);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        AOEEffect.blast(level, player, player.position().add(player.getLookAngle().scale(2.0)),
                7.0f, 3.0, 0.8, ParticleTypes.CRIT, SoundEvents.ENDER_DRAGON_FLAP);
        DebuffEffect.applyInRadius(level, player, player.position(), 4.0, MobEffects.LEVITATION, 40, 0);
        return true;
    }
}


