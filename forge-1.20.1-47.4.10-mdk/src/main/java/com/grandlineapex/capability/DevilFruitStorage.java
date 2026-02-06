package com.grandlineapex.capability;

import com.grandlineapex.capability.player.PlayerDevilFruitData;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;

public class DevilFruitStorage implements Capability.IStorage<PlayerDevilFruitData> {
    @Override
    public CompoundTag writeNBT(Capability<PlayerDevilFruitData> capability, PlayerDevilFruitData instance, Direction side) {
        CompoundTag tag = new CompoundTag();
        tag.putString("fruitId", instance.getFruitId());
        tag.putInt("mastery", instance.getMastery());
        tag.putBoolean("awakened", instance.isAwakened());
        return tag;
    }

    @Override
    public void readNBT(Capability<PlayerDevilFruitData> capability, PlayerDevilFruitData instance, Direction side, net.minecraft.nbt.Tag nbt) {
        CompoundTag tag = (CompoundTag) nbt;
        instance.setFruitId(tag.getString("fruitId"));
        instance.addMastery(tag.getInt("mastery"));
        instance.setAwakened(tag.getBoolean("awakened"));
    }
}
