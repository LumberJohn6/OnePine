package com.grandlineapex.devilfruit;

import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public interface DevilFruit {
    ResourceLocation id();
    FruitType type();

    // Passive should run every tick (server-side) unless disabled (water/seastone).
    void tickPassive(Player player);

    // Ordered by tier: PASSIVE, T1, T2, T3, AWAKENING
    List<Ability> abilities();

    default boolean hasWaterWeakness() { return true; }
    default boolean hasSeastoneWeakness() { return true; }

    default boolean isAwakenedAvailable(int mastery) {
        return mastery >= 200; // tune later
    }

    default Ability getTier(AbilityTier tier) {
        return abilities().stream().filter(a -> a.tier() == tier).findFirst().orElse(null);
    }
}