/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\CapabilityRegistry.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability;

import com.grandlineapex.capability.devilfruit.PlayerDevilFruitData;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.PlayerAbilityRuntimeData;
import com.grandlineapex.capability.player.PlayerBountyData;
import com.grandlineapex.capability.player.PlayerCombatData;
import com.grandlineapex.capability.player.PlayerHakiData;
import com.grandlineapex.capability.player.PlayerStatsData;
import com.grandlineapex.world.fruit.DevilFruitWorldRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry {

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        // Central capability type registration so Forge can serialize/attach these stores.
        event.register(com.grandlineapex.systems.stamina.PlayerStaminaData.class);
        event.register(com.grandlineapex.capability.PlayerData.class);
        event.register(com.grandlineapex.capability.devilfruit.DevilFruitData.class);
        event.register(PlayerDevilFruitData.class);
        event.register(PlayerBountyData.class);
        event.register(PlayerHakiData.class);
        event.register(PlayerCombatData.class);
        event.register(PlayerStatsData.class);
        event.register(PlayerAbilityRuntimeData.class);
        event.register(DevilFruitWorldRegistry.class);
    }
}

