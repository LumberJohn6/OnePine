/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\ope\GammaKnife.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.ope;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.MeleeEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;

public class GammaKnife extends BaseAbility {
    public GammaKnife() {
        super("grandlineapex:gamma_knife", AbilityTier.AWAKENING, 180, 34.0f, 200);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        int hits = MeleeEffect.strikeInFront(level, player, 18.0f, 4.0, 0.9, 0.2, ParticleTypes.WITCH, null);
        if (hits <= 0) return true;

        level.getEntities(player, player.getBoundingBox().inflate(4.0), e -> e instanceof net.minecraft.world.entity.LivingEntity)
                .forEach(e -> {
                    if (e instanceof net.minecraft.world.entity.LivingEntity le && le != player && !le.isAlliedTo(player)) {
                        if (le.distanceToSqr(player) <= 16.0) {
                            le.addEffect(new net.minecraft.world.effect.MobEffectInstance(MobEffects.WITHER, 100, 1));
                        }
                    }
                });
        return true;
    }
}


