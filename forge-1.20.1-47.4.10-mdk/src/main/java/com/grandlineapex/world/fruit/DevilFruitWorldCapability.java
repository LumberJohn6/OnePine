/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\world\fruit\DevilFruitWorldCapability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.world.fruit;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class DevilFruitWorldCapability {
    public static final Capability<DevilFruitWorldRegistry> DEVIL_FRUIT_WORLD =
            CapabilityManager.get(new CapabilityToken<>() {});
}

