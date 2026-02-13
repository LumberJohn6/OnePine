/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\events\CombatHookEvent.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;

public class CombatHookEvent extends Event {
    private final Player attacker;
    private final Player defender;
    private float amount;

    public CombatHookEvent(Player attacker, Player defender, float amount) {
        this.attacker = attacker;
        this.defender = defender;
        this.amount = amount;
    }

    public Player attacker() {
        return attacker;
    }

    public Player defender() {
        return defender;
    }

    public float amount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}

