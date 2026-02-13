/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\awakening\requirements\BossDefeatAwakeningRequirement.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.awakening.requirements;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.devilfruit.awakening.AwakeningRequirement;
import net.minecraft.server.level.ServerPlayer;

public class BossDefeatAwakeningRequirement implements AwakeningRequirement {
    @Override
    public String id() {
        return "boss_defeat";
    }

    @Override
    public boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData) {
        return devilFruitData.isAwakeningBossDefeated();
    }
}

