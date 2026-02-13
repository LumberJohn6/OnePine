/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\combat\FightingStyle.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.combat;

import com.grandlineapex.bounty.BountyTier;
import com.grandlineapex.combat.styles.BrawlerStyle;
import com.grandlineapex.combat.styles.SwordsmanStyle;

import java.util.Map;

public abstract class FightingStyle {
    private static final Map<String, FightingStyle> STYLES = Map.of(
            "grandlineapex:brawler", new BrawlerStyle(),
            "grandlineapex:swordsman", new SwordsmanStyle()
    );

    public abstract String id();
    public abstract float damageMultiplier(int mastery);
    public abstract float staminaCostMultiplier(int mastery);
    public abstract BountyTier unlockTier();

    public static FightingStyle byId(String id) {
        return STYLES.getOrDefault(id, STYLES.get("grandlineapex:brawler"));
    }
}

