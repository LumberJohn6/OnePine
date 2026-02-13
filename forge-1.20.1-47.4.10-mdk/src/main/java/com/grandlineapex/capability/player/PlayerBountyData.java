package com.grandlineapex.capability.player;

import com.grandlineapex.bounty.BountyTier;
import net.minecraft.nbt.CompoundTag;

public class PlayerBountyData {
    private long bounty;
    private BountyTier tier = BountyTier.ROOKIE;

    public long getBounty() {
        return bounty;
    }

    public BountyTier getTier() {
        return tier;
    }

    public BountyTier addBounty(long amount) {
        if (amount <= 0) {
            return tier;
        }
        bounty += amount;
        tier = BountyTier.fromBounty(bounty);
        return tier;
    }

    public void setBounty(long bounty) {
        this.bounty = Math.max(0L, bounty);
        this.tier = BountyTier.fromBounty(this.bounty);
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putLong("bounty", bounty);
        tag.putString("tier", tier.name());
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        setBounty(tag.getLong("bounty"));
        if (tag.contains("tier")) {
            try {
                tier = BountyTier.valueOf(tag.getString("tier"));
            } catch (IllegalArgumentException ignored) {
                tier = BountyTier.fromBounty(bounty);
            }
        }
    }

    public void copyFrom(PlayerBountyData other) {
        setBounty(other.getBounty());
    }
}
