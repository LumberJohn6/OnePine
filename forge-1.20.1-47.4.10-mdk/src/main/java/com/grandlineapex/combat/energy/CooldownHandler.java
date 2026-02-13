/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\combat\energy\CooldownHandler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.combat.energy;

import java.util.HashMap;
import java.util.UUID;
import java.nio.charset.StandardCharsets;
import net.minecraft.resources.ResourceLocation;

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

    public static void tickCooldowns() {
        tick();
    }

    public static UUID key(UUID playerId, ResourceLocation abilityId) {
        return UUID.nameUUIDFromBytes((playerId + "|" + abilityId).getBytes(StandardCharsets.UTF_8));
    }

    public static void set(UUID key, int ticks) {
        COOLDOWNS.put(key, Math.max(1, ticks));
    }

    public static void setCooldown(UUID key, int ticks) {
        set(key, ticks);
    }

    public static boolean isActive(UUID key) {
        return isOnCooldown(key);
    }

    public static boolean isOnCooldown(UUID key) {
        return COOLDOWNS.containsKey(key);
    }
}

