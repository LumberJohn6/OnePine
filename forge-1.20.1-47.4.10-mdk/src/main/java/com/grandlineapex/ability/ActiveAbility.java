/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\ability\ActiveAbility.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.ability;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class ActiveAbility implements Ability {
    private final ResourceLocation id;
    private final Component name;
    private final int cooldown;
    private final float stamina;
    private final int mastery;

    protected ActiveAbility(ResourceLocation id, Component name, int cooldown, float stamina, int mastery) {
        this.id = id;
        this.name = name;
        this.cooldown = cooldown;
        this.stamina = stamina;
        this.mastery = mastery;
    }

    @Override
    public ResourceLocation id() {
        return id;
    }

    @Override
    public Component name() {
        return name;
    }

    @Override
    public int cooldownTicks() {
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

