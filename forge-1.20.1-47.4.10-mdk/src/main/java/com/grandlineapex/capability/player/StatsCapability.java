/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\player\StatsCapability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.player;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class StatsCapability {
    public static final Capability<PlayerStatsData> STATS =
            CapabilityManager.get(new CapabilityToken<>() {});
}

