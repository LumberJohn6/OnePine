package com.grandlineapex.devilfruit;

import net.minecraft.resources.ResourceLocation;

import java.util.*;

public class FruitRegistry {
    private static final Map<ResourceLocation, DevilFruit> FRUITS = new HashMap<>();

    public static DevilFruit register(DevilFruit fruit) {
        if (FRUITS.putIfAbsent(fruit.id(), fruit) != null) {
            throw new IllegalStateException("Duplicate fruit id: " + fruit.id());
        }
        return fruit;
    }

    public static Optional<DevilFruit> get(ResourceLocation id) {
        return Optional.ofNullable(FRUITS.get(id));
    }

    public static Collection<DevilFruit> all() {
        return Collections.unmodifiableCollection(FRUITS.values());
    }
}