package com.grandlineapex.capability.player;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class AbilityRuntimeCapability {
    public static final Capability<PlayerAbilityRuntimeData> ABILITY_RUNTIME =
            CapabilityManager.get(new CapabilityToken<>() {});
}
