/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\adapters\FruitAbilityAdapter.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.adapters;

import com.grandlineapex.devilfruit.api.IFruitAbility;
import com.grandlineapex.devilfruit.abilities.Ability;

public record FruitAbilityAdapter(Ability delegate) implements IFruitAbility {
    @Override
    public void onUse(net.minecraft.server.level.ServerPlayer player) {
        if (!(player.level() instanceof net.minecraft.server.level.ServerLevel level)) return;
        delegate.execute(level, player);
    }

    @Override
    public int getCooldown() {
        return delegate.baseCooldownTicks();
    }

    @Override
    public net.minecraft.resources.ResourceLocation getId() {
        return delegate.id();
    }
}

