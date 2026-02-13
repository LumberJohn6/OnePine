/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\player\BountyCapability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.player;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class BountyCapability {
    public static final Capability<PlayerBountyData> BOUNTY =
            CapabilityManager.get(new CapabilityToken<>() {});
}

