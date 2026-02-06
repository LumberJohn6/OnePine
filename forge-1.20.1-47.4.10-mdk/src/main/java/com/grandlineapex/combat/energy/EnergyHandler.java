package com.grandlineapex.combat.energy;

import net.minecraft.entity.player.PlayerEntity;

public class EnergyHandler {
    public static final int MAX_ENERGY = 100;

    public static int getEnergy(PlayerEntity player) {
        // get from capability or default
        return 0; // implement
    }

    public static void spendEnergy(PlayerEntity player, int amount) {
        // subtract energy
    }

    public static void regenEnergy(PlayerEntity player) {
        // add energy each tick
    }
}
