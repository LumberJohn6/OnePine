/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\GrandLineApex.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex;

import com.grandlineapex.attribute.ModAttributes;
import com.grandlineapex.network.ModNetwork;
import com.grandlineapex.registry.ModEffects;
import com.grandlineapex.registry.ModEntities;
import com.grandlineapex.registry.ModItems;
import com.grandlineapex.registry.ModParticles;
import com.grandlineapex.registry.ModSounds;
import com.grandlineapex.registry.ModStructures;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;

@Mod(GrandLineApex.MODID)
public class GrandLineApex {
    public static final String MODID = "grandlineapex";

    public GrandLineApex() {
        // Mod bus is for registry/lifecycle wiring; Forge bus is for runtime gameplay events.
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Network must be ready before gameplay systems send/receive packets.
        ModNetwork.register();

        // Deferred registers populate Forge registries during the mod loading phase.
        ModItems.register(modBus);
        ModEntities.register(modBus);
        ModEffects.register(modBus);
        ModParticles.register(modBus);
        ModSounds.register(modBus);
        ModStructures.register(modBus);
        ModAttributes.register(modBus);

        // Static @EventBusSubscriber handlers are auto-registered; this is for instance listeners if added.
        MinecraftForge.EVENT_BUS.register(this);
    }
}

