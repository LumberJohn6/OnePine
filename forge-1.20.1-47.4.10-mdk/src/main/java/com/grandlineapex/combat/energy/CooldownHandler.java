package com.grandlineapex.combat.energy;

import java.util.HashMap;
import java.util.UUID;

public class CooldownHandler {
    private static HashMap<UUID, Integer> cooldowns = new HashMap<>();

    public static void tickCooldowns() {
        // reduce all stored cooldowns tick by tick
    }

    public static boolean isOnCooldown(UUID id) {
        return cooldowns.containsKey(id);
    }

    public static void setCooldown(UUID id, int ticks) {
        cooldowns.put(id, ticks);
    }
}
