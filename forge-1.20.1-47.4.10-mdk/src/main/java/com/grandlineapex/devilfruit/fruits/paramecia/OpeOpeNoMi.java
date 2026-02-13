/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\fruits\paramecia\OpeOpeNoMi.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.fruits.paramecia;

import com.grandlineapex.devilfruit.DevilFruit;
import com.grandlineapex.devilfruit.FruitType;
import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OpeOpeNoMi implements DevilFruit {
    private static final ResourceLocation ID = ResourceLocation.parse("grandlineapex:ope_ope");

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public FruitType type() {
        return FruitType.PARAMECIA;
    }

    @Override
    public void tickPassive(Player player) {
        // no passive
    }

    @Override
    public List<Ability> abilities() {
        return Stream.of(
                        ResourceLocation.parse("grandlineapex:room"),
                        ResourceLocation.parse("grandlineapex:shambles"),
                        ResourceLocation.parse("grandlineapex:tact"),
                        ResourceLocation.parse("grandlineapex:gamma_knife")
                )
                .map(AbilityRegistry::get)
                .flatMap(Optional::stream)
                .toList();
    }
}

