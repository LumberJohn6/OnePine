/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\mera\FlameStep.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.mera;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.BuffEffect;
import com.grandlineapex.devilfruit.abilities.effects.TeleportEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;

public class FlameStep extends BaseAbility {
    public FlameStep() {
        super("grandlineapex:flame_step", AbilityTier.T3, 80, 15.0f, 90);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        boolean moved = TeleportEffect.blinkForward(level, player, 8.0);
        if (moved) {
            BuffEffect.apply(player, MobEffects.FIRE_RESISTANCE, 20 * 10, 0);
            level.sendParticles(net.minecraft.core.particles.ParticleTypes.FLAME,
                    player.getX(), player.getY() + 0.6, player.getZ(), 20, 0.3, 0.4, 0.3, 0.02);
        }
        return moved;
    }
}


