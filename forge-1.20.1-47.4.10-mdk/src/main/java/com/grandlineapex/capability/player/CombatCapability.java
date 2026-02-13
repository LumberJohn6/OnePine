/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\player\CombatCapability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.player;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class CombatCapability {
    public static final Capability<PlayerCombatData> COMBAT =
            CapabilityManager.get(new CapabilityToken<>() {});
}

