/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\ope\Shambles.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.ope;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.TeleportEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class Shambles extends BaseAbility {
    public Shambles() {
        super("grandlineapex:shambles", AbilityTier.T2, 65, 10.0f, 45);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        return TeleportEffect.blinkForward(level, player, 12.0);
    }
}


