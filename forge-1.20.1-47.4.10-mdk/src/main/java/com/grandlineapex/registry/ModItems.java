/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\registry\ModItems.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.registry;

import com.grandlineapex.GrandLineApex;
import com.grandlineapex.item.AwakeningCatalystItem;
import com.grandlineapex.item.DevilFruitItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GrandLineApex.MODID);

    private static final Map<String, RegistryObject<Item>> DEVIL_FRUIT_ITEMS = new HashMap<>();

    public static final RegistryObject<Item> TEST_FRUIT_ITEM = registerDevilFruitItem(
            "test_fruit_item",
            ResourceLocation.parse("grandlineapex:testfruit")
    );
    public static final RegistryObject<Item> GOMU_GOMU_FRUIT = registerDevilFruitItem(
            "gomu_gomu_fruit",
            ResourceLocation.parse("grandlineapex:gomu_gomu")
    );
    public static final RegistryObject<Item> MERA_MERA_FRUIT = registerDevilFruitItem(
            "mera_mera_fruit",
            ResourceLocation.parse("grandlineapex:mera_mera")
    );
    public static final RegistryObject<Item> OPE_OPE_FRUIT = registerDevilFruitItem(
            "ope_ope_fruit",
            ResourceLocation.parse("grandlineapex:ope_ope")
    );
    public static final RegistryObject<Item> HIE_HIE_FRUIT = registerDevilFruitItem(
            "hie_hie_fruit",
            ResourceLocation.parse("grandlineapex:hie_hie")
    );
    public static final RegistryObject<Item> USHI_USHI_GIRAFFE_FRUIT = registerDevilFruitItem(
            "ushi_ushi_model_giraffe_fruit",
            ResourceLocation.parse("grandlineapex:ushi_ushi_model_giraffe")
    );

    public static final RegistryObject<Item> AWAKENING_CATALYST =
            ITEMS.register("awakening_catalyst", () -> new AwakeningCatalystItem(new Item.Properties()));

    public static RegistryObject<Item> registerDevilFruitItem(String itemId, ResourceLocation fruitId) {
        RegistryObject<Item> obj = ITEMS.register(itemId, () -> new DevilFruitItem(fruitId, new Item.Properties()));
        DEVIL_FRUIT_ITEMS.put(fruitId.toString(), obj);
        return obj;
    }

    public static Optional<ItemStack> stackForFruit(ResourceLocation fruitId) {
        RegistryObject<Item> obj = DEVIL_FRUIT_ITEMS.get(fruitId.toString());
        if (obj == null) return Optional.empty();
        return Optional.of(new ItemStack(obj.get()));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}

