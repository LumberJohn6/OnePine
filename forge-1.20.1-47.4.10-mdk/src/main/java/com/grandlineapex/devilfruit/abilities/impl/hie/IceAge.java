/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\hie\IceAge.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.hie;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import com.grandlineapex.devilfruit.abilities.effects.DebuffEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;

public class IceAge extends BaseAbility {
    public IceAge() {
        super("grandlineapex:ice_age", AbilityTier.T2, 110, 17.0f, 35);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        AOEEffect.blast(level, player, player.position(), 8.0f, 4.0, 0.5, ParticleTypes.SNOWFLAKE, SoundEvents.GLASS_BREAK);
        DebuffEffect.applyInRadius(level, player, player.position(), 4.5, MobEffects.MOVEMENT_SLOWDOWN, 100, 2);
        return true;
    }
}


