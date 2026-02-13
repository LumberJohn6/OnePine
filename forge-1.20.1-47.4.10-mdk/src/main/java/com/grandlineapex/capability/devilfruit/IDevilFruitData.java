/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\devilfruit\IDevilFruitData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.devilfruit;

import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public interface IDevilFruitData {
    ResourceLocation getFruitIdValue();

    int getMastery();

    Map<String, Integer> getCooldownMap();

    boolean isSubmergedWeakness();

    boolean isTransformed();
}

