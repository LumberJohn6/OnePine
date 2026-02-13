/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\IPlayerData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability;

import net.minecraft.nbt.CompoundTag;

public interface IPlayerData {
    boolean hasFruit();
    String fruitId();
    int masteryLevel();
    boolean armamentUnlocked();
    boolean observationUnlocked();
    boolean conquerorUnlocked();
    int bounty();
    float stamina();
    boolean transformationActive(String id);

    CompoundTag toTag();
    void fromTag(CompoundTag tag);
}

