/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\ability\AbilityContext.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.ability;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public record AbilityContext(ServerLevel level,
                             ServerPlayer player,
                             ResourceLocation fruitId,
                             int mastery) {
}

