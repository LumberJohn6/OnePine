/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\bounty\quest\BountyQuest.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.bounty.quest;

import net.minecraft.resources.ResourceLocation;

public class BountyQuest {
    private final ResourceLocation id;
    private final String title;
    private final String description;
    private final int targetCount;
    private final long bountyReward;

    public BountyQuest(ResourceLocation id, String title, String description, int targetCount, long bountyReward) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.targetCount = targetCount;
        this.bountyReward = bountyReward;
    }

    public ResourceLocation id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public int targetCount() {
        return targetCount;
    }

    public long bountyReward() {
        return bountyReward;
    }
}

