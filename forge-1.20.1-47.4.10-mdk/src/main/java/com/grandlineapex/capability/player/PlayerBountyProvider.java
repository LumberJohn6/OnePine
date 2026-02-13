package com.grandlineapex.capability.player;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerBountyProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    private final PlayerBountyData data = new PlayerBountyData();
    private final LazyOptional<PlayerBountyData> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == BountyCapability.BOUNTY ? optional.cast() : LazyOptional.empty();
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
