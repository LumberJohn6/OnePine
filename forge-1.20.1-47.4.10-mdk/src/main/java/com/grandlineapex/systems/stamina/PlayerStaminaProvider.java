package com.grandlineapex.systems.stamina;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerStaminaProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    private final PlayerStaminaData data = new PlayerStaminaData();
    private final LazyOptional<PlayerStaminaData> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == StaminaCapability.STAMINA ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("current", data.getCurrent());
        tag.putFloat("max", data.getMax());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        data.setMax(tag.getFloat("max"));
        data.set(tag.getFloat("current"));
    }
}