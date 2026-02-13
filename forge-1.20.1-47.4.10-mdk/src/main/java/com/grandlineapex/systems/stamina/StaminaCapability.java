/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\systems\stamina\StaminaCapability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.systems.stamina;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class StaminaCapability {
    public static final Capability<PlayerStaminaData> STAMINA =
            CapabilityManager.get(new CapabilityToken<>() {});
}
