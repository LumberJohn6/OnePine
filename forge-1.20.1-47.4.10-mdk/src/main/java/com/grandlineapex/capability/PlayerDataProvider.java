/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\PlayerDataProvider.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerDataProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    private final PlayerData data = new PlayerData();
    private final LazyOptional<PlayerData> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == PlayerDataStorage.PLAYER_DATA ? optional.cast() : LazyOptional.empty();
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

