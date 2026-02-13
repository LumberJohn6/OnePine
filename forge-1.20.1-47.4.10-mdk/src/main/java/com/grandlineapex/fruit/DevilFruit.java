/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\fruit\DevilFruit.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.fruit;

import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public abstract class DevilFruit {
    public abstract ResourceLocation id();
    public abstract Component displayName();
    public abstract FruitType type();
    public abstract List<Ability> abilities();

    public boolean hasWaterWeakness() {
        return true;
    }

    public boolean hasSeastoneWeakness() {
        return true;
    }

    public void onEat(ServerPlayer player) {
    }

    public void onRemove(ServerPlayer player) {
    }

    public void onPlayerTick(ServerPlayer player) {
    }

    public float onDamageTaken(ServerPlayer player, net.minecraft.world.damagesource.DamageSource source, float amount) {
        return amount;
    }

    public void onTransformationStart(ServerPlayer player) {
    }

    public void onTransformationEnd(ServerPlayer player) {
    }

    public boolean isAwakenedAvailable(int mastery) {
        return mastery >= 200;
    }

    public Ability getTier(AbilityTier tier) {
        return abilities().stream().filter(a -> a.tier() == tier).findFirst().orElse(null);
    }
}

