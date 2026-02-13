/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\ability\PassiveAbility.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.ability;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class PassiveAbility extends ActiveAbility {
    protected PassiveAbility(ResourceLocation id, Component name, int cooldown, float stamina, int mastery) {
        super(id, name, cooldown, stamina, mastery);
    }

    public abstract void onTick(AbilityContext context);

    @Override
    public boolean execute(AbilityContext context) {
        onTick(context);
        return true;
    }
}

