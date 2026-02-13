/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\devilfruit\PlayerDevilFruitData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */

package com.grandlineapex.capability.devilfruit;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class PlayerDevilFruitData implements IDevilFruitData {
    // Per-player single-fruit ownership and progression state.
    private String fruitId = "";
    private int mastery = 0;
    private boolean awakened = false;
    private boolean submergedWeakness = false;
    private boolean transformed = false;
    private final Map<String, Integer> cooldownMap = new HashMap<>();
    // Requirement progress flags used by AwakeningHandler.
    private boolean awakeningBossDefeated = false;
    private boolean awakeningSpecialItemUsed = false;

    public String getFruitId() { return fruitId; }
    @Override
    public net.minecraft.resources.ResourceLocation getFruitIdValue() {
        if (fruitId == null || fruitId.isBlank()) return null;
        try {
            return net.minecraft.resources.ResourceLocation.parse(fruitId);
        } catch (Exception ignored) {
            return null;
        }
    }
    public void setFruitId(String id) {
        String value = id == null ? "" : id;
        if (!this.fruitId.isEmpty() && !this.fruitId.equals(value) && !value.isEmpty()) {
            return;
        }
        this.fruitId = value;
    }

    public int getMastery() { return mastery; }
    public void setMastery(int mastery) {
        this.mastery = Math.max(0, mastery);
    }
    public void addMastery(int amount) { setMastery(this.mastery + amount); }

    public boolean isAwakened() { return awakened; }
    public void setAwakened(boolean val) { this.awakened = val; }

    public boolean isSubmergedWeakness() {
        return submergedWeakness;
    }

    public void setSubmergedWeakness(boolean submergedWeakness) {
        this.submergedWeakness = submergedWeakness;
    }

    public boolean isTransformed() {
        return transformed;
    }

    public void setTransformed(boolean transformed) {
        this.transformed = transformed;
    }

    public Map<String, Integer> getCooldownMap() {
        return cooldownMap;
    }

    public void clearCooldowns() {
        cooldownMap.clear();
    }

    public void setCooldown(ResourceLocation abilityId, int ticks) {
        if (abilityId == null) return;
        int value = Math.max(0, ticks);
        if (value <= 0) {
            cooldownMap.remove(abilityId.toString());
        } else {
            cooldownMap.put(abilityId.toString(), value);
        }
    }

    public int getCooldown(ResourceLocation abilityId) {
        if (abilityId == null) return 0;
        return cooldownMap.getOrDefault(abilityId.toString(), 0);
    }

    public boolean isAwakeningBossDefeated() {
        return awakeningBossDefeated;
    }

    public void markAwakeningBossDefeated() {
        this.awakeningBossDefeated = true;
    }

    public boolean isAwakeningSpecialItemUsed() {
        return awakeningSpecialItemUsed;
    }

    public void markAwakeningSpecialItemUsed() {
        this.awakeningSpecialItemUsed = true;
    }

    public void clearFruitProgress() {
        // Used when consuming a new fruit or on death/reincarnation to avoid stale unlock state.
        this.fruitId = "";
        this.mastery = 0;
        this.awakened = false;
        this.submergedWeakness = false;
        this.transformed = false;
        this.cooldownMap.clear();
        this.awakeningBossDefeated = false;
        this.awakeningSpecialItemUsed = false;
    }

    public void copyFrom(PlayerDevilFruitData other) {
        setFruitId(other.getFruitId());
        setMastery(other.getMastery());
        setAwakened(other.isAwakened());
        setSubmergedWeakness(other.isSubmergedWeakness());
        setTransformed(other.isTransformed());
        this.cooldownMap.clear();
        this.cooldownMap.putAll(other.cooldownMap);
        this.awakeningBossDefeated = other.awakeningBossDefeated;
        this.awakeningSpecialItemUsed = other.awakeningSpecialItemUsed;
    }
}

