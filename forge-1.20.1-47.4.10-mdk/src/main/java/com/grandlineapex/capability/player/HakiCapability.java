package com.grandlineapex.capability.player;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class HakiCapability {
    public static final Capability<PlayerHakiData> HAKI =
            CapabilityManager.get(new CapabilityToken<>() {});
}
