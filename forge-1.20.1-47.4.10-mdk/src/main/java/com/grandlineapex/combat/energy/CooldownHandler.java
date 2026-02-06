package com.grandlineapex.combat.energy;

import java.util.HashMap;
import java.util.UUID;

public class CooldownHandler {
    private static final HashMap<UUID, Integer> COOLDOWNS = new HashMap<>();

    public static void tick() {
        COOLDOWNS.entrySet().removeIf(entry -> {
            int newValue = entry.getValue() - 1;
            if (newValue <= 0) return true;
            entry.setValue(newValue);
            return false;
        });
    }

    public static void set(UUID key, int ticks) {
        COOLDOWNS.put(key, ticks);
    }

    public static boolean isActive(UUID key) {
        return COOLDOWNS.containsKey(key);
    }
}