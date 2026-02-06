package com.grandlineapex.capability.devilfruit;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.nbt.CompoundTag;

public class PlayerDevilFruitProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

    private final PlayerDevilFruitData data = new PlayerDevilFruitData();
    private final LazyOptional<PlayerDevilFruitData> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == DevilFruitCapability.DEVIL_FRUIT ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("fruitId", data.getFruitId());
        tag.putInt("mastery", data.getMastery());
        tag.putBoolean("awakened", data.isAwakened());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        data.setFruitId(tag.getString("fruitId"));
        data.addMastery(tag.getInt("mastery"));
        data.setAwakened(tag.getBoolean("awakened"));
    }
}