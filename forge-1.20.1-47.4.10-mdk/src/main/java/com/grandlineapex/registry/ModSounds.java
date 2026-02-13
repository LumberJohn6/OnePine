package com.grandlineapex.registry;

import com.grandlineapex.GrandLineApex;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GrandLineApex.MODID);

    public static final RegistryObject<SoundEvent> ABILITY_JAB =
            SOUNDS.register("ability_jab", () -> SoundEvent.createVariableRangeEvent(
                    ResourceLocation.parse("grandlineapex:ability_jab")));

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
