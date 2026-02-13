/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\attribute\ModAttributes.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.attribute;

import com.grandlineapex.GrandLineApex;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(ForgeRegistries.Keys.ATTRIBUTES, GrandLineApex.MODID);

    public static final RegistryObject<Attribute> HAKI_DAMAGE = ATTRIBUTES.register(
            "haki_damage",
            () -> new RangedAttribute("attribute.grandlineapex.haki_damage", 0.0, 0.0, 1024.0).setSyncable(true)
    );

    public static final RegistryObject<Attribute> ABILITY_POWER = ATTRIBUTES.register(
            "ability_power",
            () -> new RangedAttribute("attribute.grandlineapex.ability_power", 0.0, 0.0, 1024.0).setSyncable(true)
    );

    public static final RegistryObject<Attribute> FRUIT_MASTERY = ATTRIBUTES.register(
            "fruit_mastery",
            () -> new RangedAttribute("attribute.grandlineapex.fruit_mastery", 0.0, 0.0, 2048.0).setSyncable(true)
    );

    public static final RegistryObject<Attribute> STAMINA = ATTRIBUTES.register(
            "stamina",
            () -> new RangedAttribute("attribute.grandlineapex.stamina", 100.0, 0.0, 4096.0).setSyncable(true)
    );

    private ModAttributes() {
    }

    public static void register(IEventBus bus) {
        ATTRIBUTES.register(bus);
    }
}

