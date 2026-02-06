package com.grandlineapex;

import com.grandlineapex.network.NetworkHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;

@Mod(GrandLineApex.MODID)
public class GrandLineApex {
    public static final String MODID = "grandlineapex";

    public GrandLineApex() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        NetworkHandler.register();

        // Example: if/when you add deferred registers:
        // ModItems.register(modBus);
        // ModEntities.register(modBus);
        // Capability registration is handled by your @EventBusSubscriber(CapabilityRegistry)

        // If you keep only static subscribers with Bus.FORGE, you do NOT register them here.
        // Use this for instance-based listeners if you create any:
        // MinecraftForge.EVENT_BUS.register(new SomeInstanceListener());
        MinecraftForge.EVENT_BUS.register(this);
    }
}