/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\bounty\BountyManager.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.bounty;

import com.grandlineapex.capability.player.BountyCapability;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;

public class BountyManager {
    private BountyManager() {}

    public static long rewardForEntity(LivingEntity entity) {
        // Lightweight baseline reward model; tune by biome/raid/elite flags later.
        if (entity.getType().getCategory() == MobCategory.MONSTER) return 35;
        if (entity.getType().getCategory() == MobCategory.CREATURE) return 10;
        return 20;
    }

    public static void onEntityDefeated(ServerPlayer killer, LivingEntity defeated) {
        long reward = rewardForEntity(defeated);
        killer.getCapability(BountyCapability.BOUNTY).ifPresent(bounty -> {
            BountyTier before = bounty.getTier();
            BountyTier after = bounty.addBounty(reward);
            // Tier transition is where cross-system unlocks/rewards are applied.
            if (after != before) {
                BountyRewardHandler.onTierReached(killer, after);
            }
        });
    }
}

