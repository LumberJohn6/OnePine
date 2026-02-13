/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\registry\ModStructures.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.registry;

import com.grandlineapex.GrandLineApex;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, GrandLineApex.MODID);

    public static void register(IEventBus bus) {
        STRUCTURES.register(bus);
    }
}

