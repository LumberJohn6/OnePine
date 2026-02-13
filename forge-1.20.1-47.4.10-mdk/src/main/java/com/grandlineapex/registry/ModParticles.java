package com.grandlineapex.registry;

import com.grandlineapex.GrandLineApex;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GrandLineApex.MODID);

    public static void register(IEventBus bus) {
        PARTICLES.register(bus);
    }
}
