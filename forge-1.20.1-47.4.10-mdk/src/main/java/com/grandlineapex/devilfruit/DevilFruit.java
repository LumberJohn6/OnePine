/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\DevilFruit.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit;

import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import com.grandlineapex.devilfruit.adapters.FruitAbilityAdapter;
import com.grandlineapex.devilfruit.api.IDevilFruit;
import com.grandlineapex.devilfruit.api.IFruitAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public interface DevilFruit extends IDevilFruit {
    ResourceLocation id();
    FruitType type();
    default Component displayName() { return Component.literal(id().toString()); }

    // Passive should run every tick (server-side) unless disabled (water/seastone).
    void tickPassive(Player player);

    // Ordered by tier: PASSIVE, T1, T2, T3, AWAKENING
    List<Ability> abilities();

    default boolean hasWaterWeakness() { return true; }
    default boolean hasSeastoneWeakness() { return true; }
    default void onEat(ServerPlayer player) {}
    default void onRemove(ServerPlayer player) {}
    default void onPlayerTick(ServerPlayer player) { tickPassive(player); }
    default float onDamageTaken(ServerPlayer player, DamageSource source, float amount) { return amount; }
    default void onTransformationStart(ServerPlayer player) {}
    default void onTransformationEnd(ServerPlayer player) {}

    default boolean isAwakenedAvailable(int mastery) {
        return mastery >= 200; // tune later
    }

    default Ability getTier(AbilityTier tier) {
        return abilities().stream().filter(a -> a.tier() == tier).findFirst().orElse(null);
    }

    @Override
    default ResourceLocation getId() {
        return id();
    }

    @Override
    default FruitType getType() {
        return type();
    }

    @Override
    default List<IFruitAbility> getAbilities() {
        return abilities().stream().map(FruitAbilityAdapter::new).map(a -> (IFruitAbility) a).toList();
    }
}

