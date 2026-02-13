/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuPistol.java
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

public class GomuPistol extends BaseAbility {
    public GomuPistol() {
        super("grandlineapex:gomu_pistol", AbilityTier.T1, 50, 8.0f, 0);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        MeleeEffect.strikeInFront(level, player, 10.0f, 5.0, 1.2, 1.5, ParticleTypes.CLOUD, SoundEvents.PLAYER_ATTACK_STRONG);
        return true;
    }
}


