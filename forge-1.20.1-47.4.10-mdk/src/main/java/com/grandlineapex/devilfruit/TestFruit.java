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
    private static final ResourceLocation ID = ResourceLocation.parse("grandlineapex:testfruit");
    private static boolean registered;

    @Override public ResourceLocation id() { return ID; }
    @Override public FruitType type() { return FruitType.PARAMECIA; }
    @Override public void tickPassive(Player player) { /* none for test */ }

    @Override
    public List<Ability> abilities() {
        return AbilityRegistry.get(ResourceLocation.parse("grandlineapex:t1_jab"))
                .map(List::of)
                .orElse(List.of());
    }

    public static void register() {
        if (registered) return;
        registered = true;
        FruitRegistry.register(new TestFruit());
    }
}
