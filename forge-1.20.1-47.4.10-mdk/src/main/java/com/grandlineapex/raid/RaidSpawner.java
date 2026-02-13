/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\raid\RaidSpawner.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.raid;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class RaidSpawner {
    private RaidSpawner() {}

    public static int spawnWave(ServerLevel level, BlockPos center, int wave, float difficulty) {
        // Base scaffold: wave planning is in place; actual custom NPC spawn wiring comes next.
        return Math.max(1, Math.round((2 + wave) * difficulty));
    }
}

