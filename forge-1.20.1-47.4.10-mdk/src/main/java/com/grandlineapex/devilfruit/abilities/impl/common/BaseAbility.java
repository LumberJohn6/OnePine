/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\impl\common\BaseAbility.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities.impl.common;

import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.resources.ResourceLocation;

public abstract class BaseAbility implements Ability {
    private final ResourceLocation id;
    private final AbilityTier tier;
    private final int cooldown;
    private final float stamina;
    private final int mastery;

    protected BaseAbility(String id, AbilityTier tier, int cooldown, float stamina, int mastery) {
        this.id = ResourceLocation.parse(id);
        this.tier = tier;
        this.cooldown = cooldown;
        this.stamina = stamina;
        this.mastery = mastery;
    }

    @Override
    public ResourceLocation id() {
        return id;
    }

    @Override
    public AbilityTier tier() {
        return tier;
    }

    @Override
    public int baseCooldownTicks() {
        return cooldown;
    }

    @Override
    public float staminaCost() {
        return stamina;
    }

    @Override
    public int masteryRequirement() {
        return mastery;
    }
}

