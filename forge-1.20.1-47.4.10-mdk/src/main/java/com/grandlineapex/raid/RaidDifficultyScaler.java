/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\raid\RaidDifficultyScaler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.raid;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.BountyCapability;
import net.minecraft.server.level.ServerPlayer;

public class RaidDifficultyScaler {
    private RaidDifficultyScaler() {}

    public static float difficultyFor(ServerPlayer player, RaidType type) {
        long bounty = player.getCapability(BountyCapability.BOUNTY).map(b -> b.getBounty()).orElse(0L);
        int mastery = player.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df -> df.getMastery()).orElse(0);
        float bountyScale = Math.min(1.5f, bounty / 50_000.0f);
        float masteryScale = Math.min(1.0f, mastery / 300.0f);
        return type.baseMultiplier() + bountyScale + masteryScale;
    }
}

