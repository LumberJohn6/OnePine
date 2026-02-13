/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeAwakening.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.giraffe;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.TransformEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class GiraffeAwakening extends BaseAbility {
    public GiraffeAwakening() {
        super("grandlineapex:giraffe_awakening", AbilityTier.AWAKENING, 200, 30.0f, 200);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        TransformEffect.zoanForm(player, 20 * 25, 2);
        level.sendParticles(net.minecraft.core.particles.ParticleTypes.CLOUD,
                player.getX(), player.getY() + 1.2, player.getZ(), 35, 0.8, 1.0, 0.8, 0.01);
        return true;
    }
}


