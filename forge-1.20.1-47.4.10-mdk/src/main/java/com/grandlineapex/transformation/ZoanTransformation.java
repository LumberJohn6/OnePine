/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\transformation\ZoanTransformation.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.transformation;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

public class ZoanTransformation implements Transformation {
    private final ResourceLocation id;
    private final MobEffectInstance[] activeEffects;

    public ZoanTransformation(ResourceLocation id, MobEffectInstance... activeEffects) {
        this.id = id;
        this.activeEffects = activeEffects;
    }

    @Override
    public ResourceLocation id() {
        return id;
    }

    @Override
    public void onStart(ServerPlayer player) {
        for (MobEffectInstance effect : activeEffects) {
            player.addEffect(new MobEffectInstance(effect));
        }
    }

    @Override
    public void onEnd(ServerPlayer player) {
        for (MobEffectInstance effect : activeEffects) {
            MobEffect mobEffect = effect.getEffect();
            player.removeEffect(mobEffect);
        }
    }
}

