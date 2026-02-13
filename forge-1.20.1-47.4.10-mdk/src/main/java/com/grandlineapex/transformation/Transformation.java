/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\transformation\Transformation.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.transformation;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public interface Transformation {
    ResourceLocation id();

    void onStart(ServerPlayer player);

    void onEnd(ServerPlayer player);

    default void onTick(ServerPlayer player) {
    }

    default boolean canStart(ServerPlayer player) {
        return true;
    }
}

