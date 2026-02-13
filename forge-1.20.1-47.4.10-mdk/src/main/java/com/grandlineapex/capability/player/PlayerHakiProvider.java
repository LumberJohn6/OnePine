package com.grandlineapex.capability.player;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerHakiProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    private final PlayerHakiData data = new PlayerHakiData();
    private final LazyOptional<PlayerHakiData> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == HakiCapability.HAKI ? optional.cast() : LazyOptional.empty();
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
