/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\bounty\BountyTier.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.bounty;

public enum BountyTier {
    ROOKIE(0),
    OUTLAW(1_000),
    SUPER_ROOKIE(5_000),
    WARLORD_CANDIDATE(20_000),
    EMPEROR_CANDIDATE(100_000);

    private final long minBounty;

    BountyTier(long minBounty) {
        this.minBounty = minBounty;
    }

    public long minBounty() {
        return minBounty;
    }

    public boolean isAtLeast(BountyTier other) {
        return this.ordinal() >= other.ordinal();
    }

    public static BountyTier fromBounty(long bounty) {
        BountyTier current = ROOKIE;
        for (BountyTier tier : values()) {
            if (bounty >= tier.minBounty) {
                current = tier;
            }
        }
        return current;
    }
}

