/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGigant.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.gomu;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import com.grandlineapex.devilfruit.abilities.effects.TransformEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class GomuGigant extends BaseAbility {
    public GomuGigant() {
        super("grandlineapex:gomu_gigant", AbilityTier.AWAKENING, 220, 38.0f, 200);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        TransformEffect.zoanForm(player, 20 * 20, 2);
        AOEEffect.blast(level, player, player.position(), 16.0f, 4.0, 1.4, ParticleTypes.CLOUD, SoundEvents.GENERIC_EXPLODE);
        return true;
    }
}


