/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\giraffe\NeckWhip.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.giraffe;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.MeleeEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class NeckWhip extends BaseAbility {
    public NeckWhip() {
        super("grandlineapex:neck_whip", AbilityTier.T1, 45, 7.0f, 0);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        MeleeEffect.strikeInFront(level, player, 8.0f, 6.0, 1.0, 1.1, ParticleTypes.CRIT, SoundEvents.PLAYER_ATTACK_SWEEP);
        return true;
    }
}


