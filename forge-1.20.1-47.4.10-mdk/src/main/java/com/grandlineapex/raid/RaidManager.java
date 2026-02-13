/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\raid\RaidManager.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.raid;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;

public class RaidManager {
    // Default cadence: one in-game day between automatic raid triggers.
    private static final int DEFAULT_INTERVAL_TICKS = 24_000;
    private static int ticker = DEFAULT_INTERVAL_TICKS;

    private RaidManager() {}

    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        ticker--;
        if (ticker > 0) return;
        ticker = DEFAULT_INTERVAL_TICKS;

        // Global periodic raid orchestration entrypoint.
        var server = net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer();
        if (server == null) return;
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            triggerRaidForPlayer(player);
        }
    }

    public static void triggerRaidForPlayer(ServerPlayer player) {
        // Simple placeholder region selection; can be replaced by true world-region logic.
        RaidType type = player.experienceLevel > 30 ? RaidType.NEW_WORLD :
                (player.experienceLevel > 10 ? RaidType.GRAND_LINE : RaidType.EAST_BLUE);
        float difficulty = RaidDifficultyScaler.difficultyFor(player, type);
        // Spawner currently returns planned wave size; spawn implementation is scaffolded.
        RaidSpawner.spawnWave((net.minecraft.server.level.ServerLevel) player.level(), player.blockPosition(), 1, difficulty);
    }
}

