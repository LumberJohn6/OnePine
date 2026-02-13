/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGatling.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.gomu;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.MeleeEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class GomuGatling extends BaseAbility {
    public GomuGatling() {
        super("grandlineapex:gomu_gatling", AbilityTier.T3, 120, 24.0f, 85);
    }

    @Override
    public int activeDurationTicks(int mastery) {
        return 14;
    }

    @Override
    public boolean onActivate(ServerLevel level, ServerPlayer player, int mastery) {
        return true;
    }

    @Override
    public void onActiveTick(ServerLevel level, ServerPlayer player, int mastery, int ticksRemaining) {
        if (ticksRemaining % 3 != 0) return;
        MeleeEffect.strikeInFront(level, player, 4.0f, 4.0, 1.0, 0.35, ParticleTypes.CLOUD, SoundEvents.PLAYER_ATTACK_SWEEP);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        return true;
    }
}


