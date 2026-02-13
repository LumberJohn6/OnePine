/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuBazooka.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.gomu;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class GomuBazooka extends BaseAbility {
    public GomuBazooka() {
        super("grandlineapex:gomu_bazooka", AbilityTier.T2, 90, 16.0f, 35);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        AOEEffect.blast(level, player, player.position().add(player.getLookAngle().scale(3.0)),
                14.0f, 2.2, 2.0, ParticleTypes.CLOUD, SoundEvents.GENERIC_EXPLODE);
        return true;
    }
}


