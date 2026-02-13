/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\api\IDevilFruit.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.api;

import com.grandlineapex.devilfruit.FruitType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public interface IDevilFruit {
    ResourceLocation getId();

    FruitType getType();

    void onEat(ServerPlayer player);

    void onRemove(ServerPlayer player);

    List<IFruitAbility> getAbilities();
}

