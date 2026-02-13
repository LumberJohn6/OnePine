/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\hie\IceSpear.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.hie;

import com.grandlineapex.devilfruit.abilities.impl.common.BaseAbility;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.abilities.effects.ProjectileEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class IceSpear extends BaseAbility {
    public IceSpear() {
        super("grandlineapex:ice_spear", AbilityTier.T1, 45, 7.0f, 0);
    }

    @Override
    public boolean execute(ServerLevel level, ServerPlayer player) {
        ProjectileEffect.shootSnowball(level, player, 2.2f);
        return true;
    }
}


