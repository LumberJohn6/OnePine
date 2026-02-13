/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\fruit\LegacyFruitAdapter.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.fruit;

import com.grandlineapex.devilfruit.abilities.Ability;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class LegacyFruitAdapter extends DevilFruit {
    private final com.grandlineapex.devilfruit.DevilFruit legacy;

    public LegacyFruitAdapter(com.grandlineapex.devilfruit.DevilFruit legacy) {
        this.legacy = legacy;
    }

    @Override
    public ResourceLocation id() {
        return legacy.id();
    }

    @Override
    public Component displayName() {
        return legacy.displayName();
    }

    @Override
    public FruitType type() {
        return switch (legacy.type()) {
            case PARAMECIA -> FruitType.PARAMECIA;
            case ZOAN, MYTHICAL_ZOAN -> FruitType.ZOAN;
            case LOGIA -> FruitType.LOGIA;
        };
    }

    @Override
    public List<Ability> abilities() {
        return legacy.abilities();
    }

    @Override
    public boolean hasWaterWeakness() {
        return legacy.hasWaterWeakness();
    }

    @Override
    public boolean hasSeastoneWeakness() {
        return legacy.hasSeastoneWeakness();
    }

    @Override
    public void onEat(ServerPlayer player) {
        legacy.onEat(player);
    }

    @Override
    public void onRemove(ServerPlayer player) {
        legacy.onRemove(player);
    }

    @Override
    public void onPlayerTick(ServerPlayer player) {
        legacy.onPlayerTick(player);
    }

    @Override
    public float onDamageTaken(ServerPlayer player, net.minecraft.world.damagesource.DamageSource source, float amount) {
        return legacy.onDamageTaken(player, source, amount);
    }
}

