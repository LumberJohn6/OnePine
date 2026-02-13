/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\mera\FlameBurst.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.mera;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class FlameBurst extends BaseAbility {
    public FlameBurst() {
        super("grandlineapex:flame_burst", AbilityTier.T2, 100, 18.0f, 40);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        AOEEffect.blast(level, player, player.position(), 10.0f, 3.5, 1.2, ParticleTypes.FLAME, SoundEvents.FIRECHARGE_USE);
        return true;
    }
}


