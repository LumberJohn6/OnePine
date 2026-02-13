/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeCharge.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.giraffe;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.AOEEffect;
import com.grandlineapex.devilfruit.abilities.effects.TeleportEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class GiraffeCharge extends BaseAbility {
    public GiraffeCharge() {
        super("grandlineapex:giraffe_charge", AbilityTier.T2, 80, 13.0f, 30);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        TeleportEffect.blinkForward(level, player, 7.0);
        AOEEffect.blast(level, player, player.position(), 10.0f, 2.2, 1.5, ParticleTypes.CLOUD, SoundEvents.GOAT_RAM_IMPACT);
        return true;
    }
}


