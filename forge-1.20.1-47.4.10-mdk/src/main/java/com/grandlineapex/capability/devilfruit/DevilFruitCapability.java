/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\devilfruit\DevilFruitCapability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */

package com.grandlineapex.capability.devilfruit;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class DevilFruitCapability {
    public static final Capability<PlayerDevilFruitData> DEVIL_FRUIT =
            CapabilityManager.get(new CapabilityToken<>() {});
}

