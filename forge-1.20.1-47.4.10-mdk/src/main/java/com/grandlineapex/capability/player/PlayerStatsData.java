/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\player\PlayerStatsData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.player;

import net.minecraft.nbt.CompoundTag;

public class PlayerStatsData {
    private int strength;
    private int defense;
    private int agility;

    public int getStrength() {
        return strength;
    }

    public void addStrength(int amount) {
        strength = Math.max(0, strength + amount);
    }

    public int getDefense() {
        return defense;
    }

    public void addDefense(int amount) {
        defense = Math.max(0, defense + amount);
    }

    public int getAgility() {
        return agility;
    }

    public void addAgility(int amount) {
        agility = Math.max(0, agility + amount);
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("strength", strength);
        tag.putInt("defense", defense);
        tag.putInt("agility", agility);
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        strength = Math.max(0, tag.getInt("strength"));
        defense = Math.max(0, tag.getInt("defense"));
        agility = Math.max(0, tag.getInt("agility"));
    }

    public void copyFrom(PlayerStatsData other) {
        this.strength = other.strength;
        this.defense = other.defense;
        this.agility = other.agility;
    }
}

