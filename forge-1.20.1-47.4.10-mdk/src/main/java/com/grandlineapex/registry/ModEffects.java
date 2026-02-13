package com.grandlineapex.registry;

import com.grandlineapex.GrandLineApex;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GrandLineApex.MODID);

    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }
}
