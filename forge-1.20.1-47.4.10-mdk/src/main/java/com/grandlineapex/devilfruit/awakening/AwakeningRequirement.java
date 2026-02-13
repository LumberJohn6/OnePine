/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\awakening\AwakeningRequirement.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.awakening;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import net.minecraft.server.level.ServerPlayer;

public interface AwakeningRequirement {
    // Stable identifier used for debugging/UI progress display.
    String id();

    // Requirement checks are server-authoritative and evaluate current player capability state.
    boolean isMet(ServerPlayer player, PlayerDevilFruitData devilFruitData);
}

