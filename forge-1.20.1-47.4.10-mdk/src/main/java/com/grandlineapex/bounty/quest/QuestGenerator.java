/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\bounty\quest\QuestGenerator.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.bounty.quest;

import com.grandlineapex.bounty.BountyTier;
import net.minecraft.resources.ResourceLocation;

public class QuestGenerator {
    private QuestGenerator() {}

    public static BountyQuest generate(BountyTier tier, boolean raidActive) {
        int baseTargets = switch (tier) {
            case ROOKIE -> 5;
            case OUTLAW -> 8;
            case SUPER_ROOKIE -> 12;
            case WARLORD_CANDIDATE -> 16;
            case EMPEROR_CANDIDATE -> 20;
        };
        long reward = baseTargets * 25L + (raidActive ? 200L : 0L);
        String scope = raidActive ? "during the current raid" : "in nearby regions";
        return new BountyQuest(
                ResourceLocation.parse("grandlineapex:generated_" + tier.name().toLowerCase()),
                "Wanted Suppression: " + tier.name(),
                "Defeat " + baseTargets + " hostile targets " + scope + ".",
                baseTargets,
                reward
        );
    }
}

