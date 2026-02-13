/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\fruits\logia\MeraMeraNoMi.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.fruits.logia;

import com.grandlineapex.devilfruit.DevilFruit;
import com.grandlineapex.devilfruit.FruitType;
import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MeraMeraNoMi implements DevilFruit {
    private static final ResourceLocation ID = ResourceLocation.parse("grandlineapex:mera_mera");

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public FruitType type() {
        return FruitType.LOGIA;
    }

    @Override
    public void tickPassive(Player player) {
        if (!player.level().isClientSide) {
            player.clearFire();
        }
    }

    @Override
    public List<Ability> abilities() {
        return Stream.of(
                        ResourceLocation.parse("grandlineapex:fire_fist"),
                        ResourceLocation.parse("grandlineapex:flame_burst"),
                        ResourceLocation.parse("grandlineapex:flame_step"),
                        ResourceLocation.parse("grandlineapex:dai_enkai")
                )
                .map(AbilityRegistry::get)
                .flatMap(Optional::stream)
                .toList();
    }
}

