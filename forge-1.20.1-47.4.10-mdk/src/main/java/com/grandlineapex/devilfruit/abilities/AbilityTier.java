/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\AbilityTier.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities;

public enum AbilityTier {
    PASSIVE(0),
    T1(1),
    T2(2),
    T3(3),
    AWAKENING(99);

    public final int order;
    AbilityTier(int order) { this.order = order; }
}
