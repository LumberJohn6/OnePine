/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\awakening\requirements\MasteryAwakeningRequirement.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.awakening.requirements;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.devilfruit.awakening.AwakeningRequirement;
import net.minecraft.server.level.ServerPlayer;

public class MasteryAwakeningRequirement implements AwakeningRequirement {
    private final int threshold;

    public MasteryAwakeningRequirement(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public String id() {
        return "mastery_threshold";
    }

    @Override
    public boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData) {
        return devilFruitData.getMastery() >= threshold;
    }
}

