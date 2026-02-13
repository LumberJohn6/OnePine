/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\mera\DaiEnkai.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.mera;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import com.grandlineapex.devilfruit.abilities.effects.BuffEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;

public class DaiEnkai extends BaseAbility {
    public DaiEnkai() {
        super("grandlineapex:dai_enkai", AbilityTier.AWAKENING, 240, 40.0f, 200);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        BuffEffect.apply(player, MobEffects.DAMAGE_BOOST, 20 * 15, 2);
        BuffEffect.apply(player, MobEffects.FIRE_RESISTANCE, 20 * 30, 0);
        AOEEffect.blast(level, player, player.position(), 18.0f, 5.0, 1.8, ParticleTypes.FLAME, SoundEvents.GENERIC_EXPLODE);
        return true;
    }
}


