/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\player\PlayerAbilityRuntimeData.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability.player;

import com.grandlineapex.ability.runtime.AbilityInstance;
import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiPredicate;

public class PlayerAbilityRuntimeData {
    private final Map<ResourceLocation, AbilityInstance> instances = new HashMap<>();

    public boolean isOnCooldown(ResourceLocation abilityId) {
        AbilityInstance instance = instances.get(abilityId);
        return instance != null && instance.state() != com.grandlineapex.ability.runtime.AbilityState.IDLE;
    }

    public boolean canStart(ResourceLocation abilityId) {
        AbilityInstance instance = instances.get(abilityId);
        return instance == null || instance.isTerminal();
    }

    public void start(AbilityInstance instance) {
        instances.put(instance.abilityId(), instance);
    }

    public void tickAll(ServerLevel level, ServerPlayer player) {
        Iterator<Map.Entry<ResourceLocation, AbilityInstance>> iterator = instances.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<ResourceLocation, AbilityInstance> entry = iterator.next();
            AbilityInstance instance = entry.getValue();
            Ability ability = AbilityRegistry.get(entry.getKey()).orElse(null);
            if (ability == null) {
                iterator.remove();
                continue;
            }
            boolean finished = instance.tick(level, player, ability);
            if (finished) {
                iterator.remove();
            }
        }
    }

    public void interruptMatching(ServerLevel level,
                                  ServerPlayer player,
                                  String reason,
                                  BiPredicate<AbilityInstance, Ability> rule) {
        for (AbilityInstance instance : instances.values()) {
            Ability ability = AbilityRegistry.get(instance.abilityId()).orElse(null);
            if (ability == null) continue;
            if (!rule.test(instance, ability)) continue;
            instance.interrupt(level, player, ability, reason);
        }
    }

    public void interruptAll(ServerLevel level, ServerPlayer player, String reason) {
        interruptMatching(level, player, reason, (instance, ability) -> true);
    }

    public Map<ResourceLocation, Integer> snapshotCooldowns() {
        Map<ResourceLocation, Integer> snapshot = new HashMap<>();
        for (Map.Entry<ResourceLocation, AbilityInstance> entry : instances.entrySet()) {
            AbilityInstance instance = entry.getValue();
            if (instance.state() == com.grandlineapex.ability.runtime.AbilityState.IDLE) continue;
            snapshot.put(entry.getKey(), Math.max(0, instance.stateTicksRemaining()));
        }
        return snapshot;
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        ListTag list = new ListTag();
        for (AbilityInstance instance : instances.values()) {
            list.add(instance.toTag());
        }
        tag.put("instances", list);
        return tag;
    }

    public void fromTag(CompoundTag tag) {
        instances.clear();
        ListTag list = tag.getList("instances", Tag.TAG_COMPOUND);
        for (Tag t : list) {
            if (!(t instanceof CompoundTag ct)) continue;
            AbilityInstance instance = AbilityInstance.fromTag(ct);
            instances.put(instance.abilityId(), instance);
        }
    }

    public void copyFrom(PlayerAbilityRuntimeData other) {
        fromTag(other.toTag());
    }
}

