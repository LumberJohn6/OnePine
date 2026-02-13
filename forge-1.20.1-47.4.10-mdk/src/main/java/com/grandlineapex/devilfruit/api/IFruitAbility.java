/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\api\IFruitAbility.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public interface IFruitAbility {
    void onUse(ServerPlayer player);

    int getCooldown();

    ResourceLocation getId();
}

