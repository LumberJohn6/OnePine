package com.grandlineapex.combat.energy;

import net.minecraft.world.entity.player.Player;
public class EnergyHandler {
    public static final int MAX_ENERGY = 100;

    public static int getEnergy(Player player) {
        // get from capability or default
        return 0; // implement
    }

    public static void spendEnergy(Player player, int amount) {
        // subtract energy
    }

    public static void regenEnergy(Player player) {
        // add energy each tick
    }
}
