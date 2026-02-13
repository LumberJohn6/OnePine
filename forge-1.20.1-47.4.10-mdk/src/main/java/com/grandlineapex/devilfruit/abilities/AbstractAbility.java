/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\AbstractAbility.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities;

import net.minecraft.resources.ResourceLocation;

public abstract class AbstractAbility implements Ability {
    private final ResourceLocation id;
    private final AbilityTier tier;
    private final AbilityType type;
    private final int cooldown;
    private final float stamina;
    private final int mastery;

    protected AbstractAbility(ResourceLocation id,
                              AbilityTier tier,
                              AbilityType type,
                              int cooldown,
                              float stamina,
                              int mastery) {
        this.id = id;
        this.tier = tier;
        this.type = type;
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

    public AbilityType type() {
        return type;
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

