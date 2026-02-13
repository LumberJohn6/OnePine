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

    public static final RegistryObject<Item> AWAKENING_CATALYST =
            ITEMS.register("awakening_catalyst", () -> new AwakeningCatalystItem(new Item.Properties()));

    private static RegistryObject<Item> registerDevilFruitItem(String itemId, ResourceLocation fruitId) {
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
