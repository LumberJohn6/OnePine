/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\progression\IFruitProgression.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.progression;

public interface IFruitProgression {
    int mastery();

    int xp();

    void addXp(int amount);

    int xpToNextLevel();
}

