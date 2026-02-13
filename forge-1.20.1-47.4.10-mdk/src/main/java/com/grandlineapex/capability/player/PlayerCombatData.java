package com.grandlineapex.capability.player;

import net.minecraft.nbt.CompoundTag;

public class PlayerCombatData {
    private String fightingStyleId = "grandlineapex:brawler";
    private int styleMastery;
    private int comboCounter;

    public String getFightingStyleId() {
        return fightingStyleId;
    }

    public void setFightingStyleId(String fightingStyleId) {
        this.fightingStyleId = fightingStyleId == null ? "grandlineapex:brawler" : fightingStyleId;
    }

    public int getStyleMastery() {
        return styleMastery;
    }

    public void setStyleMastery(int styleMastery) {
        this.styleMastery = Math.max(0, styleMastery);
    }

    public void addStyleMastery(int amount) {
        setStyleMastery(styleMastery + amount);
    }

    public int getComboCounter() {
        return comboCounter;
    }

    public void setComboCounter(int comboCounter) {
        this.comboCounter = Math.max(0, comboCounter);
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putString("fightingStyleId", fightingStyleId);
        tag.putInt("styleMastery", styleMastery);
        tag.putInt("comboCounter", comboCounter);
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        setFightingStyleId(tag.getString("fightingStyleId"));
        setStyleMastery(tag.getInt("styleMastery"));
        setComboCounter(tag.getInt("comboCounter"));
    }

    public void copyFrom(PlayerCombatData other) {
        setFightingStyleId(other.getFightingStyleId());
        setStyleMastery(other.getStyleMastery());
        setComboCounter(other.getComboCounter());
    }
}
