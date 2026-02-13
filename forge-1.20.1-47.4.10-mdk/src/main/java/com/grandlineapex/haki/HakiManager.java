package com.grandlineapex.haki;

import com.grandlineapex.bounty.BountyTier;
import com.grandlineapex.capability.player.HakiCapability;
import net.minecraft.world.entity.player.Player;

public class HakiManager {
    private HakiManager() {}

    public static BountyTier unlockTier(HakiType type) {
        return switch (type) {
            case ARMAMENT -> BountyTier.OUTLAW;
            case OBSERVATION -> BountyTier.SUPER_ROOKIE;
            case CONQUEROR -> BountyTier.WARLORD_CANDIDATE;
            case NONE -> BountyTier.ROOKIE;
        };
    }

    public static boolean canUnlock(BountyTier tier, HakiType type) {
        return tier.isAtLeast(unlockTier(type));
    }

    public static int getActiveMastery(Player player) {
        return player.getCapability(HakiCapability.HAKI)
                .map(data -> data.getMastery(data.getActiveType()))
                .orElse(0);
    }
}
