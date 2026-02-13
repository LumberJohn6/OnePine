/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\awakening\requirements\BountyAwakeningRequirement.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.awakening.requirements;

import com.grandlineapex.bounty.BountyTier;
import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.capability.player.BountyCapability;
import com.grandlineapex.devilfruit.awakening.AwakeningRequirement;
import net.minecraft.server.level.ServerPlayer;

public class BountyAwakeningRequirement implements AwakeningRequirement {
    private final BountyTier minimumTier;

    public BountyAwakeningRequirement(BountyTier minimumTier) {
        this.minimumTier = minimumTier;
    }

    @Override
    public String id() {
        return "bounty_threshold";
    }

    @Override
    public boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData) {
        return player.getCapability(BountyCapability.BOUNTY)
                .map(bounty -> bounty.getTier().isAtLeast(minimumTier))
                .orElse(false);
    }
}

