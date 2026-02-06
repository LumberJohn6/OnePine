
package com.grandlineapex.devilfruit.abilities;

import net.minecraft.resources.ResourceLocation;

import java.util.*;

public class AbilityRegistry {
    private static final Map<ResourceLocation, Ability> ABILITIES = new HashMap<>();

    public static Ability register(Ability a) {
        if (ABILITIES.putIfAbsent(a.id(), a) != null) {
            throw new IllegalStateException("Duplicate ability id: " + a.id());
        }
        return a;
    }

    public static Optional<Ability> get(ResourceLocation id) {
        return Optional.ofNullable(ABILITIES.get(id));
    }

    public static Collection<Ability> all() {
        return Collections.unmodifiableCollection(ABILITIES.values());
    }
}
