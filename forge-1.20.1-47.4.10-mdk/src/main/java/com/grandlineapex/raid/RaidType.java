/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\raid\RaidType.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.raid;

public enum RaidType {
    EAST_BLUE(1.0f),
    GRAND_LINE(1.35f),
    NEW_WORLD(1.8f);

    private final float baseMultiplier;

    RaidType(float baseMultiplier) {
        this.baseMultiplier = baseMultiplier;
    }

    public float baseMultiplier() {
        return baseMultiplier;
    }
}

