package com.grandlineapex.devilfruit;

import com.grandlineapex.devilfruit.DevilFruit;
import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.devilfruit.FruitType;
import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityRegistry;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import java.util.List;

public class TestFruit implements DevilFruit {
    private static final ResourceLocation ID = new ResourceLocation("grandlineapex","testfruit");

    @Override public ResourceLocation id() { return ID; }
    @Override public FruitType type() { return FruitType.PARAMECIA; }
    @Override public void tickPassive(Player player) { /* none for test */ }

    @Override
    public List<Ability> abilities() {
        return List.of(
                AbilityRegistry.get(new ResourceLocation("grandlineapex","t1_jab")).orElse(null)
        );
    }

    public static void register() {
        FruitRegistry.register(new TestFruit());
    }
}