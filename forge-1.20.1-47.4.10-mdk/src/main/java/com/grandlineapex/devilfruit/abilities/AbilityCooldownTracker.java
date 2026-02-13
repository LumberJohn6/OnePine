/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\AbilityCooldownTracker.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class AbilityCooldownTracker {
    private AbilityCooldownTracker() {
    }

    public static boolean isOnCooldown(ServerPlayer player, ResourceLocation abilityId) {
        return player.getCapability(DevilFruitCapability.DEVIL_FRUIT)
                .map(df -> df.getCooldown(abilityId) > 0)
                .orElse(false);
    }

    public static void setCooldown(ServerPlayer player, ResourceLocation abilityId, int ticks) {
        player.getCapability(DevilFruitCapability.DEVIL_FRUIT)
                .ifPresent(df -> df.setCooldown(abilityId, ticks));
    }
}

