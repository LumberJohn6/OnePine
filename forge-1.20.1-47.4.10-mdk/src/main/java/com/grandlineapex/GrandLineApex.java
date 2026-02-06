package com.grandlineapex;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import com.grandlineapex.capability.CapabilityRegistry;
import com.grandlineapex.capability.CapabilityAttacher;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = GrandLineApex.MODID, name = GrandLineApex.NAME, version = GrandLineApex.VERSION)
public class GrandLineApex {

    public GrandLineApex() {
        MinecraftForge.EVENT_BUS.register(new CapabilityAttacher());
        MinecraftForge.EVENT_BUS.register(PlayerTickEvents.class);
        MinecraftForge.EVENT_BUS.register(CombatEvents.class);

        CapabilityRegistry.register();
    }


    public static final String MODID = "grandlineapex";
    public static final String NAME = "Grand Line Apex";
    public static final String VERSION = "0.1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(NAME + " loaded!");
    }
}
