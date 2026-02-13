/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\combat\styles\BrawlerStyle.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.combat.styles;

import com.grandlineapex.bounty.BountyTier;
import com.grandlineapex.combat.FightingStyle;

public class BrawlerStyle extends FightingStyle {
    @Override
    public String id() {
        return "grandlineapex:brawler";
    }

    @Override
    public float damageMultiplier(int mastery) {
        return 1.0f + Math.min(0.18f, mastery * 0.0012f);
    }

    @Override
    public float staminaCostMultiplier(int mastery) {
        return Math.max(0.75f, 1.0f - mastery * 0.0008f);
    }

    @Override
    public BountyTier unlockTier() {
        return BountyTier.ROOKIE;
    }
}

