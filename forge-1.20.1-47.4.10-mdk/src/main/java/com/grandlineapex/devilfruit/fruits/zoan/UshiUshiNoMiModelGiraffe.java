/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\fruits\zoan\UshiUshiNoMiModelGiraffe.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.fruits.zoan;

import com.grandlineapex.devilfruit.DevilFruit;
import com.grandlineapex.devilfruit.FruitType;
import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class UshiUshiNoMiModelGiraffe implements DevilFruit {
    private static final ResourceLocation ID = ResourceLocation.parse("grandlineapex:ushi_ushi_model_giraffe");

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public FruitType type() {
        return FruitType.ZOAN;
    }

    @Override
    public void tickPassive(Player player) {
        // small zoan mobility passive
        if (!player.level().isClientSide && player.tickCount % 40 == 0) {
            player.heal(0.5f);
        }
    }

    @Override
    public List<Ability> abilities() {
        return Stream.of(
                        ResourceLocation.parse("grandlineapex:neck_whip"),
                        ResourceLocation.parse("grandlineapex:giraffe_charge"),
                        ResourceLocation.parse("grandlineapex:pasta_machine"),
                        ResourceLocation.parse("grandlineapex:giraffe_awakening")
                )
                .map(AbilityRegistry::get)
                .flatMap(Optional::stream)
                .toList();
    }
}

