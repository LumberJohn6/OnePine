/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\world\fruit\DevilFruitWorldProvider.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.world.fruit;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class DevilFruitWorldProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    private final DevilFruitWorldRegistry data = new DevilFruitWorldRegistry();
    private final LazyOptional<DevilFruitWorldRegistry> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == DevilFruitWorldCapability.DEVIL_FRUIT_WORLD ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return data.toTag();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        data.fromTag(nbt);
    }
}

