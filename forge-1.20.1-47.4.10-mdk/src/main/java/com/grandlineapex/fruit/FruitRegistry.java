/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\fruit\FruitRegistry.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.fruit;

import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FruitRegistry {
    private static final Map<ResourceLocation, DevilFruit> FRUITS = new HashMap<>();

    private FruitRegistry() {
    }

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

