package com.grandlineapex.world.fruit;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class DevilFruitWorldRegistry {
    // Global world ownership table: fruitId -> player UUID currently holding that fruit.
    private final Map<String, UUID> consumedByFruitId = new HashMap<>();
    // Reincarnation cooldown table: fruitId -> ticks remaining before this fruit is available again.
    private final Map<String, Integer> respawnCooldownByFruitId = new HashMap<>();

    public boolean isConsumed(ResourceLocation fruitId) {
        return consumedByFruitId.containsKey(fruitId.toString());
    }

    public boolean isOnCooldown(ResourceLocation fruitId) {
        return respawnCooldownByFruitId.getOrDefault(fruitId.toString(), 0) > 0;
    }

    public boolean isAvailable(ResourceLocation fruitId) {
        String id = fruitId.toString();
        return !consumedByFruitId.containsKey(id) && respawnCooldownByFruitId.getOrDefault(id, 0) <= 0;
    }

    public boolean tryConsume(ResourceLocation fruitId, UUID playerId) {
        // Single source of truth for exclusivity: only one owner per fruit id at a time.
        String id = fruitId.toString();
        if (!isAvailable(fruitId)) return false;
        consumedByFruitId.put(id, playerId);
        respawnCooldownByFruitId.remove(id);
        return true;
    }

    public void releaseFruit(ResourceLocation fruitId, int cooldownTicks) {
        // Called on death/reincarnation to hand fruit back to the world pool.
        String id = fruitId.toString();
        consumedByFruitId.remove(id);
        respawnCooldownByFruitId.put(id, Math.max(0, cooldownTicks));
    }

    public void releaseAllOwnedBy(UUID playerId, int cooldownTicks) {
        Iterator<Map.Entry<String, UUID>> iterator = consumedByFruitId.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, UUID> entry = iterator.next();
            if (!entry.getValue().equals(playerId)) continue;
            respawnCooldownByFruitId.put(entry.getKey(), Math.max(0, cooldownTicks));
            iterator.remove();
        }
    }

    public Optional<UUID> ownerOf(ResourceLocation fruitId) {
        return Optional.ofNullable(consumedByFruitId.get(fruitId.toString()));
    }

    public void tickCooldowns() {
        // Advanced by WorldEvents server tick; keeps registry time-based behavior deterministic.
        Iterator<Map.Entry<String, Integer>> iterator = respawnCooldownByFruitId.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int next = entry.getValue() - 1;
            if (next <= 0) {
                iterator.remove();
            } else {
                entry.setValue(next);
            }
        }
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();

        ListTag consumed = new ListTag();
        for (Map.Entry<String, UUID> entry : consumedByFruitId.entrySet()) {
            CompoundTag e = new CompoundTag();
            e.putString("fruitId", entry.getKey());
            e.putUUID("owner", entry.getValue());
            consumed.add(e);
        }
        tag.put("consumed", consumed);

        ListTag cooldowns = new ListTag();
        for (Map.Entry<String, Integer> entry : respawnCooldownByFruitId.entrySet()) {
            CompoundTag e = new CompoundTag();
            e.putString("fruitId", entry.getKey());
            e.putInt("ticks", entry.getValue());
            cooldowns.add(e);
        }
        tag.put("cooldowns", cooldowns);
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        consumedByFruitId.clear();
        respawnCooldownByFruitId.clear();

        ListTag consumed = tag.getList("consumed", Tag.TAG_COMPOUND);
        for (Tag t : consumed) {
            if (!(t instanceof CompoundTag ct)) continue;
            if (!ct.hasUUID("owner")) continue;
            consumedByFruitId.put(ct.getString("fruitId"), ct.getUUID("owner"));
        }

        ListTag cooldowns = tag.getList("cooldowns", Tag.TAG_COMPOUND);
        for (Tag t : cooldowns) {
            if (!(t instanceof CompoundTag ct)) continue;
            respawnCooldownByFruitId.put(ct.getString("fruitId"), Math.max(0, ct.getInt("ticks")));
        }
    }
}
