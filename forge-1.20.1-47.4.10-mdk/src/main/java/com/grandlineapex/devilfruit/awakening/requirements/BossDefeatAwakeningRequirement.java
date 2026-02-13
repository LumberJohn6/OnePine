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
