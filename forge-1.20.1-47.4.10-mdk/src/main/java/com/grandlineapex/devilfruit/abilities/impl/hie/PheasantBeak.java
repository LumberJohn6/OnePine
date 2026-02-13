/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\hie\PheasantBeak.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.hie;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import com.grandlineapex.devilfruit.abilities.effects.ProjectileEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class PheasantBeak extends BaseAbility {
    public PheasantBeak() {
        super("grandlineapex:pheasant_beak", AbilityTier.AWAKENING, 170, 30.0f, 200);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        ProjectileEffect.shootSnowball(level, player, 3.2f);
        AOEEffect.blast(level, player, player.position().add(player.getLookAngle().scale(2.5)),
                12.0f, 3.5, 0.8, ParticleTypes.SNOWFLAKE, SoundEvents.GLASS_BREAK);
        return true;
    }
}


