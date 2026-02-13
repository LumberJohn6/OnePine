/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\fruits\paramecia\GomuGomuNoMi.java
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

public class GomuGomuNoMi implements DevilFruit {
    private static final ResourceLocation ID = ResourceLocation.parse("grandlineapex:gomu_gomu");

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
        if (!player.level().isClientSide) {
            player.fallDistance = 0.0f;
        }
    }

    @Override
    public List<Ability> abilities() {
        return Stream.of(
                        ResourceLocation.parse("grandlineapex:gomu_pistol"),
                        ResourceLocation.parse("grandlineapex:gomu_bazooka"),
                        ResourceLocation.parse("grandlineapex:gomu_gatling"),
                        ResourceLocation.parse("grandlineapex:gomu_gigant")
                )
                .map(AbilityRegistry::get)
                .flatMap(Optional::stream)
                .toList();
    }
}

