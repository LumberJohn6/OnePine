package com.grandlineapex.devilfruit.awakening;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import net.minecraft.server.level.ServerPlayer;

public interface AwakeningRequirement {
    // Stable identifier used for debugging/UI progress display.
    String id();

    // Requirement checks are server-authoritative and evaluate current player capability state.
    boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData);
}
