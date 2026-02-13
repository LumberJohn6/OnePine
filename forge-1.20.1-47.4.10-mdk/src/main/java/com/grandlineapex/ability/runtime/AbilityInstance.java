/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\ability\runtime\AbilityInstance.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.ability.runtime;

import com.grandlineapex.devilfruit.abilities.Ability;
import com.grandlineapex.devilfruit.abilities.AbilityTier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class AbilityInstance {
    private final ResourceLocation fruitId;
    private final ResourceLocation abilityId;
    private final AbilityTier tier;
    private final int masterySnapshot;
    private final int cooldownTicks;

    private AbilityState state;
    private int stateTicksRemaining;
    private int totalElapsedTicks;
    private boolean activated;

    private AbilityInstance(ResourceLocation fruitId,
                            ResourceLocation abilityId,
                            AbilityTier tier,
                            int masterySnapshot,
                            int cooldownTicks,
                            AbilityState state,
                            int stateTicksRemaining) {
        this.fruitId = fruitId;
        this.abilityId = abilityId;
        this.tier = tier;
        this.masterySnapshot = masterySnapshot;
        this.cooldownTicks = cooldownTicks;
        this.state = state;
        this.stateTicksRemaining = Math.max(0, stateTicksRemaining);
    }

    public static AbilityInstance start(ResourceLocation fruitId, Ability ability, int masterySnapshot, int cooldownTicks) {
        int charge = ability.chargeDurationTicks(masterySnapshot);
        if (charge > 0) {
            return new AbilityInstance(fruitId, ability.id(), ability.tier(), masterySnapshot, cooldownTicks, AbilityState.CHARGING, charge);
        }
        int channel = ability.channelDurationTicks(masterySnapshot);
        if (channel > 0) {
            return new AbilityInstance(fruitId, ability.id(), ability.tier(), masterySnapshot, cooldownTicks, AbilityState.CHANNELING, channel);
        }
        return new AbilityInstance(
                fruitId,
                ability.id(),
                ability.tier(),
                masterySnapshot,
                cooldownTicks,
                AbilityState.ACTIVE,
                Math.max(1, ability.activeDurationTicks(masterySnapshot))
        );
    }

    public ResourceLocation abilityId() {
        return abilityId;
    }

    public ResourceLocation fruitId() {
        return fruitId;
    }

    public AbilityState state() {
        return state;
    }

    public int stateTicksRemaining() {
        return stateTicksRemaining;
    }

    public boolean isTerminal() {
        return state == AbilityState.IDLE;
    }

    public boolean isBusy() {
        return state == AbilityState.CHARGING || state == AbilityState.CHANNELING || state == AbilityState.ACTIVE;
    }

    public boolean tick(ServerLevel level, ServerPlayer player, Ability ability) {
        totalElapsedTicks++;

        switch (state) {
            case CHARGING -> {
                if (advanceAndIsDone()) {
                    int channel = ability.channelDurationTicks(masterySnapshot);
                    if (channel > 0) {
                        state = AbilityState.CHANNELING;
                        stateTicksRemaining = channel;
                    } else {
                        state = AbilityState.ACTIVE;
                        stateTicksRemaining = Math.max(1, ability.activeDurationTicks(masterySnapshot));
                    }
                }
            }
            case CHANNELING -> {
                if (advanceAndIsDone()) {
                    state = AbilityState.ACTIVE;
                    stateTicksRemaining = Math.max(1, ability.activeDurationTicks(masterySnapshot));
                }
            }
            case ACTIVE -> {
                if (!activated) {
                    activated = ability.onActivate(level, player, masterySnapshot);
                    if (!activated) {
                        enterCooldown();
                        break;
                    }
                }
                ability.onActiveTick(level, player, masterySnapshot, stateTicksRemaining);
                if (advanceAndIsDone()) {
                    enterCooldown();
                }
            }
            case COOLDOWN -> {
                if (advanceAndIsDone()) {
                    state = AbilityState.IDLE;
                }
            }
            case INTERRUPTED -> {
                enterCooldown();
            }
            case IDLE -> {
                return true;
            }
        }
        return isTerminal();
    }

    public void interrupt(ServerLevel level, ServerPlayer player, Ability ability, String reason) {
        if (!isBusy()) return;
        state = AbilityState.INTERRUPTED;
        stateTicksRemaining = 0;
        ability.onInterrupted(level, player, masterySnapshot, reason);
    }

    private void enterCooldown() {
        state = AbilityState.COOLDOWN;
        stateTicksRemaining = Math.max(1, cooldownTicks);
    }

    private boolean advanceAndIsDone() {
        if (stateTicksRemaining > 0) {
            stateTicksRemaining--;
        }
        return stateTicksRemaining <= 0;
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putString("fruitId", fruitId.toString());
        tag.putString("abilityId", abilityId.toString());
        tag.putString("tier", tier.name());
        tag.putInt("masterySnapshot", masterySnapshot);
        tag.putInt("cooldownTicks", cooldownTicks);
        tag.putString("state", state.name());
        tag.putInt("stateTicksRemaining", stateTicksRemaining);
        tag.putInt("totalElapsedTicks", totalElapsedTicks);
        tag.putBoolean("activated", activated);
        return tag;
    }

    public static AbilityInstance fromTag(CompoundTag tag) {
        ResourceLocation fruitId = ResourceLocation.parse(tag.getString("fruitId"));
        ResourceLocation abilityId = ResourceLocation.parse(tag.getString("abilityId"));
        AbilityTier tier = AbilityTier.valueOf(tag.getString("tier"));
        int masterySnapshot = Math.max(0, tag.getInt("masterySnapshot"));
        int cooldownTicks = Math.max(1, tag.getInt("cooldownTicks"));
        AbilityState state = AbilityState.valueOf(tag.getString("state"));
        int stateTicksRemaining = Math.max(0, tag.getInt("stateTicksRemaining"));
        AbilityInstance instance = new AbilityInstance(
                fruitId, abilityId, tier, masterySnapshot, cooldownTicks, state, stateTicksRemaining
        );
        instance.totalElapsedTicks = Math.max(0, tag.getInt("totalElapsedTicks"));
        instance.activated = tag.getBoolean("activated");
        return instance;
    }
}

