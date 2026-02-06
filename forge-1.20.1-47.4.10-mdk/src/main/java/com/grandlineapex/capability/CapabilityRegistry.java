package com.grandlineapex.capability;

import com.grandlineapex.capability.player.PlayerDevilFruitData;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityRegistry {
    public static void register() {
        CapabilityManager.INSTANCE.register(
                PlayerDevilFruitData.class,
                new DevilFruitStorage(),
                PlayerDevilFruitData::new
        );
    }
}
