/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\ability\CooldownAbility.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.ability;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class CooldownAbility extends ActiveAbility {
    protected CooldownAbility(ResourceLocation id, Component name, int cooldown, float stamina, int mastery) {
        super(id, name, cooldown, stamina, mastery);
    }

    protected int scaleCooldownByMastery(int masteryValue) {
        float scale = 1.0f - Math.min(0.30f, masteryValue / 400.0f);
        return Math.max(5, Math.round(cooldownTicks() * scale));
    }
}

