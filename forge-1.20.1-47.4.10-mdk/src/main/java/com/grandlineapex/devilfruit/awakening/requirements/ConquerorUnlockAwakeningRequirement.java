package com.grandlineapex.devilfruit.awakening.requirements;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.devilfruit.awakening.AwakeningRequirement;
import com.grandlineapex.haki.HakiType;
import net.minecraft.server.level.ServerPlayer;

public class ConquerorUnlockAwakeningRequirement implements AwakeningRequirement {
    @Override
    public String id() {
        return "conqueror_unlock";
    }

    @Override
    public boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData) {
        return player.getCapability(HakiCapability.HAKI)
                .map(haki -> haki.isUnlocked(HakiType.CONQUEROR))
                .orElse(false);
    }
}
