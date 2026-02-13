package com.grandlineapex.bounty;

import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.capability.player.StatsCapability;
import com.grandlineapex.haki.HakiType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class BountyRewardHandler {
    private BountyRewardHandler() {}

    public static void onTierReached(ServerPlayer player, BountyTier newTier) {
        player.getCapability(HakiCapability.HAKI).ifPresent(haki -> {
            if (newTier.isAtLeast(BountyTier.OUTLAW)) {
                haki.setUnlocked(HakiType.ARMAMENT, true);
            }
            if (newTier.isAtLeast(BountyTier.SUPER_ROOKIE)) {
                haki.setUnlocked(HakiType.OBSERVATION, true);
            }
            if (newTier.isAtLeast(BountyTier.WARLORD_CANDIDATE)) {
                haki.setUnlocked(HakiType.CONQUEROR, true);
            }
        });

        player.getCapability(StatsCapability.STATS).ifPresent(stats -> {
            if (newTier == BountyTier.OUTLAW) stats.addStrength(1);
            if (newTier == BountyTier.SUPER_ROOKIE) stats.addDefense(1);
            if (newTier == BountyTier.WARLORD_CANDIDATE) stats.addAgility(1);
            if (newTier == BountyTier.EMPEROR_CANDIDATE) {
                stats.addStrength(2);
                stats.addDefense(2);
                stats.addAgility(2);
            }
        });

        player.displayClientMessage(Component.literal("Bounty tier reached: " + newTier.name()), true);
    }
}
