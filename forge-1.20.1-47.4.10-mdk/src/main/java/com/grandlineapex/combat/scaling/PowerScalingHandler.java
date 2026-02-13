/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\combat\scaling\PowerScalingHandler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.combat.scaling;

import com.grandlineapex.attribute.ModAttributes;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import net.minecraft.server.level.ServerPlayer;

public class PowerScalingHandler {
    private PowerScalingHandler() {
    }

    public static void apply(ServerPlayer player) {
        player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df -> {
            int mastery = df.getMastery();
            var fruitMastery = player.getAttribute(ModAttributes.FRUIT_MASTERY.get());
            if (fruitMastery != null) fruitMastery.setBaseValue(mastery);

            var abilityPower = player.getAttribute(ModAttributes.ABILITY_POWER.get());
            if (abilityPower != null) abilityPower.setBaseValue(Math.max(0.0, mastery * 0.25));
        });
    }
}

