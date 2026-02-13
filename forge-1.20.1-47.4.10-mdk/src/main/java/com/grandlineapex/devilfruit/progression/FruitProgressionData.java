/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\progression\FruitProgressionData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.progression;

public class FruitProgressionData implements IFruitProgression {
    private int mastery;
    private int xp;

    @Override
    public int mastery() {
        return mastery;
    }

    @Override
    public int xp() {
        return xp;
    }

    @Override
    public void addXp(int amount) {
        if (amount <= 0) return;
        xp += amount;
        while (xp >= xpToNextLevel()) {
            xp -= xpToNextLevel();
            mastery++;
        }
    }

    @Override
    public int xpToNextLevel() {
        return 50 + (mastery * 10);
    }
}

