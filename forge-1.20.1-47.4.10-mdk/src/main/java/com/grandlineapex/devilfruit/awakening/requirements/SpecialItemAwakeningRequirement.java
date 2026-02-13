package com.grandlineapex.devilfruit.awakening.requirements;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.devilfruit.awakening.AwakeningRequirement;
import net.minecraft.server.level.ServerPlayer;

public class SpecialItemAwakeningRequirement implements AwakeningRequirement {
    @Override
    public String id() {
        return "special_item";
    }

    @Override
    public boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData) {
        return devilFruitData.isAwakeningSpecialItemUsed();
    }
}
