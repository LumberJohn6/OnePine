package com.grandlineapex.systems.stamina;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class StaminaCapability {
    public static final Capability<PlayerStaminaData> STAMINA =
            CapabilityManager.get(new CapabilityToken<>() {});
}