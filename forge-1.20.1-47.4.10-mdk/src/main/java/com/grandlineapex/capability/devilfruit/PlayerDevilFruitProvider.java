/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\devilfruit\PlayerDevilFruitProvider.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.devilfruit;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;

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
        tag.putBoolean("submergedWeakness", data.isSubmergedWeakness());
        tag.putBoolean("transformed", data.isTransformed());
        ListTag cooldowns = new ListTag();
        data.getCooldownMap().forEach((id, ticks) -> {
            CompoundTag cd = new CompoundTag();
            cd.putString("id", id);
            cd.putInt("ticks", Math.max(0, ticks));
            cooldowns.add(cd);
        });
        tag.put("cooldowns", cooldowns);
        tag.putBoolean("awakeningBossDefeated", data.isAwakeningBossDefeated());
        tag.putBoolean("awakeningSpecialItemUsed", data.isAwakeningSpecialItemUsed());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        data.setFruitId(tag.getString("fruitId"));
        data.setMastery(tag.getInt("mastery"));
        data.setAwakened(tag.getBoolean("awakened"));
        data.setSubmergedWeakness(tag.getBoolean("submergedWeakness"));
        data.setTransformed(tag.getBoolean("transformed"));
        data.clearCooldowns();
        ListTag cooldowns = tag.getList("cooldowns", Tag.TAG_COMPOUND);
        for (Tag t : cooldowns) {
            if (!(t instanceof CompoundTag ct)) continue;
            if (!ct.contains("id")) continue;
            try {
                data.setCooldown(ResourceLocation.parse(ct.getString("id")), ct.getInt("ticks"));
            } catch (Exception ignored) {
            }
        }
        if (tag.getBoolean("awakeningBossDefeated")) {
            data.markAwakeningBossDefeated();
        }
        if (tag.getBoolean("awakeningSpecialItemUsed")) {
            data.markAwakeningSpecialItemUsed();
        }
    }
}

