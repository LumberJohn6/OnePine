/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\combat\energy\EnergyHandler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.combat.energy;

import com.grandlineapex.systems.stamina.StaminaCapability;
import net.minecraft.world.entity.player.Player;

public class EnergyHandler {
    public static final int MAX_ENERGY = 100;

    public static int getEnergy(Player player) {
        return Math.round(player.getCapability(StaminaCapability.STAMINA)
                .map(data -> data.getCurrent())
                .orElse((float) MAX_ENERGY));
    }

    public static void spendEnergy(Player player, int amount) {
        if (amount <= 0) return;
        player.getCapability(StaminaCapability.STAMINA).ifPresent(data -> data.trySpend(amount));
    }

    public static void regenEnergy(Player player) {
        player.getCapability(StaminaCapability.STAMINA).ifPresent(data -> data.regen(1f / 20f));
    }
}

