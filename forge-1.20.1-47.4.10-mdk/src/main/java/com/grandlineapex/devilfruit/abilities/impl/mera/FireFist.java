/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\mera\FireFist.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.mera;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.MeleeEffect;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

public class FireFist extends BaseAbility {
    public FireFist() {
        super("grandlineapex:fire_fist", AbilityTier.T1, 55, 9.0f, 0);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        int hits = MeleeEffect.strikeInFront(level, player, 9.0f, 4.5, 1.2, 0.9, ParticleTypes.FLAME, SoundEvents.BLAZE_SHOOT);
        if (hits > 0) {
            level.getEntities(player, player.getBoundingBox().inflate(5.0), e -> e instanceof net.minecraft.world.entity.LivingEntity)
                    .forEach(e -> {
                        if (e instanceof net.minecraft.world.entity.LivingEntity le && le != player && !le.isAlliedTo(player)) {
                            if (le.distanceToSqr(player) <= 25.0) le.setSecondsOnFire(4);
                        }
                    });
        }
        return true;
    }
}


