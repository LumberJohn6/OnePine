/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\PlayerData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;

import java.util.HashSet;
import java.util.Set;

public class PlayerData implements IPlayerData {
    private boolean hasFruit;
    private String fruitId = "";
    private int masteryLevel;
    private boolean armamentUnlocked;
    private boolean observationUnlocked;
    private boolean conquerorUnlocked;
    private int bounty;
    private float stamina;
    private final Set<String> activeTransformations = new HashSet<>();

    @Override
    public boolean hasFruit() {
        return hasFruit;
    }

    public void setFruit(String id, int mastery) {
        this.hasFruit = id != null && !id.isBlank();
        this.fruitId = id == null ? "" : id;
        this.masteryLevel = Math.max(0, mastery);
    }

    @Override
    public String fruitId() {
        return fruitId;
    }

    @Override
    public int masteryLevel() {
        return masteryLevel;
    }

    public void setHakiUnlocked(boolean armament, boolean observation, boolean conqueror) {
        this.armamentUnlocked = armament;
        this.observationUnlocked = observation;
        this.conquerorUnlocked = conqueror;
    }

    @Override
    public boolean armamentUnlocked() {
        return armamentUnlocked;
    }

    @Override
    public boolean observationUnlocked() {
        return observationUnlocked;
    }

    @Override
    public boolean conquerorUnlocked() {
        return conquerorUnlocked;
    }

    @Override
    public int bounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = Math.max(0, bounty);
    }

    @Override
    public float stamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = Math.max(0.0f, stamina);
    }

    @Override
    public boolean transformationActive(String id) {
        return activeTransformations.contains(id);
    }

    public void setTransformationActive(String id, boolean active) {
        if (id == null || id.isBlank()) return;
        if (active) activeTransformations.add(id);
        else activeTransformations.remove(id);
    }

    @Override
    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("hasFruit", hasFruit);
        tag.putString("fruitId", fruitId);
        tag.putInt("masteryLevel", masteryLevel);
        tag.putBoolean("armamentUnlocked", armamentUnlocked);
        tag.putBoolean("observationUnlocked", observationUnlocked);
        tag.putBoolean("conquerorUnlocked", conquerorUnlocked);
        tag.putInt("bounty", bounty);
        tag.putFloat("stamina", stamina);
        ListTag list = new ListTag();
        for (String value : activeTransformations) {
            list.add(StringTag.valueOf(value));
        }
        tag.put("activeTransformations", list);
        return tag;
    }

    @Override
    public void fromTag(CompoundTag tag) {
        hasFruit = tag.getBoolean("hasFruit");
        fruitId = tag.getString("fruitId");
        masteryLevel = Math.max(0, tag.getInt("masteryLevel"));
        armamentUnlocked = tag.getBoolean("armamentUnlocked");
        observationUnlocked = tag.getBoolean("observationUnlocked");
        conquerorUnlocked = tag.getBoolean("conquerorUnlocked");
        bounty = Math.max(0, tag.getInt("bounty"));
        stamina = Math.max(0.0f, tag.getFloat("stamina"));
        activeTransformations.clear();
        ListTag list = tag.getList("activeTransformations", Tag.TAG_STRING);
        for (Tag value : list) {
            activeTransformations.add(value.getAsString());
        }
    }

    public void copyFrom(PlayerData other) {
        fromTag(other.toTag());
    }
}

