package com.grandlineapex.capability.player;

import com.grandlineapex.haki.HakiType;
import net.minecraft.nbt.CompoundTag;

import java.util.EnumMap;
import java.util.Map;

public class PlayerHakiData {
    private final Map<HakiType, Integer> mastery = new EnumMap<>(HakiType.class);
    private final Map<HakiType, Boolean> unlocked = new EnumMap<>(HakiType.class);
    private HakiType activeType = HakiType.NONE;
    private boolean active;

    public PlayerHakiData() {
        for (HakiType type : HakiType.values()) {
            mastery.put(type, 0);
            unlocked.put(type, type == HakiType.NONE);
        }
    }

    public int getMastery(HakiType type) {
        return mastery.getOrDefault(type, 0);
    }

    public void setMastery(HakiType type, int value) {
        mastery.put(type, Math.max(0, value));
    }

    public void addMastery(HakiType type, int value) {
        setMastery(type, getMastery(type) + value);
    }

    public boolean isUnlocked(HakiType type) {
        return unlocked.getOrDefault(type, false);
    }

    public void setUnlocked(HakiType type, boolean value) {
        unlocked.put(type, value);
        if (!value && activeType == type) {
            activeType = HakiType.NONE;
            active = false;
        }
    }

    public HakiType getActiveType() {
        return activeType;
    }

    public void setActiveType(HakiType activeType) {
        this.activeType = activeType == null ? HakiType.NONE : activeType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putString("activeType", activeType.name());
        tag.putBoolean("active", active);
        for (HakiType type : HakiType.values()) {
            String key = type.name().toLowerCase();
            tag.putInt(key + "_mastery", getMastery(type));
            tag.putBoolean(key + "_unlocked", isUnlocked(type));
        }
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        try {
            activeType = HakiType.valueOf(tag.getString("activeType"));
        } catch (Exception ignored) {
            activeType = HakiType.NONE;
        }
        active = tag.getBoolean("active");
        for (HakiType type : HakiType.values()) {
            String key = type.name().toLowerCase();
            setMastery(type, tag.getInt(key + "_mastery"));
            if (tag.contains(key + "_unlocked")) {
                setUnlocked(type, tag.getBoolean(key + "_unlocked"));
            }
        }
    }

    public void copyFrom(PlayerHakiData other) {
        for (HakiType type : HakiType.values()) {
            setMastery(type, other.getMastery(type));
            setUnlocked(type, other.isUnlocked(type));
        }
        setActiveType(other.getActiveType());
        setActive(other.isActive());
    }
}
