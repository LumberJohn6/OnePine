/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\giraffe\PastaMachine.java
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

public class PastaMachine extends BaseAbility {
    public PastaMachine() {
        super("grandlineapex:pasta_machine", AbilityTier.T3, 110, 19.0f, 75);
    }

    @Override
    public int activeDurationTicks(int mastery) {
        return 12;
    }

    @Override
    public boolean onActivate(ServerLevel level, ServerPlayer player, int mastery) {
        return true;
    }

    @Override
    public void onActiveTick(ServerLevel level, ServerPlayer player, int mastery, int ticksRemaining) {
        if (ticksRemaining % 2 != 0) return;
        MeleeEffect.strikeInFront(level, player, 3.5f, 5.5, 1.0, 0.3, ParticleTypes.CRIT, SoundEvents.PLAYER_ATTACK_SWEEP);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        return true;
    }
}


