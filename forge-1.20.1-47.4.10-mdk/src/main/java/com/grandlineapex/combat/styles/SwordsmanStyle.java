package com.grandlineapex.combat.styles;

import com.grandlineapex.bounty.BountyTier;
import com.grandlineapex.combat.FightingStyle;

public class SwordsmanStyle extends FightingStyle {
    @Override
    public String id() {
        return "grandlineapex:swordsman";
    }

    @Override
    public float damageMultiplier(int mastery) {
        return 1.0f + Math.min(0.24f, mastery * 0.0015f);
    }

    @Override
    public float staminaCostMultiplier(int mastery) {
        return Math.max(0.65f, 1.0f - mastery * 0.0010f);
    }

    @Override
    public BountyTier unlockTier() {
        return BountyTier.OUTLAW;
    }
}
