/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\ability\Ability.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.ability;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public interface Ability {
    ResourceLocation id();
    Component name();
    int cooldownTicks();
    float staminaCost();
    int masteryRequirement();

    boolean execute(AbilityContext context);
    default boolean execute(net.minecraft.server.level.ServerPlayer player) {
        return execute(new AbilityContext((net.minecraft.server.level.ServerLevel) player.level(), player, null, 0));
    }

    default boolean canUse(AbilityContext context) {
        return context.mastery() >= masteryRequirement();
    }
}

