/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\weakness\SeastoneHandler.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.weakness;

import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.devilfruit.DevilFruit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.state.BlockState;

public class SeastoneHandler {
    private SeastoneHandler() {
    }

    public static boolean isWeakened(ServerPlayer player, DevilFruit fruit) {
        if (!fruit.hasSeastoneWeakness()) return false;
        BlockPos center = player.blockPosition();
        for (BlockPos pos : BlockPos.betweenClosed(center.offset(-1, -1, -1), center.offset(1, 1, 1))) {
            BlockState state = player.level().getBlockState(pos);
            String id = BuiltInRegistries.BLOCK.getKey(state.getBlock()).getPath();
            if (id.contains("seastone")) {
                return true;
            }
        }
        return false;
    }

    public static void apply(ServerLevel level, ServerPlayer player) {
        player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME)
                .ifPresent(runtime -> runtime.interruptAll(level, player, "seastone"));
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1, false, false, true));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2, false, false, true));
    }
}

