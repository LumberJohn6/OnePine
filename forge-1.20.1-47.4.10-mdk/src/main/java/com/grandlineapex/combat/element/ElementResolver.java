/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\combat\element\ElementResolver.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.combat.element;

import net.minecraft.resources.ResourceLocation;

public class ElementResolver {
    private ElementResolver() {
    }

    public static ElementTag byFruit(ResourceLocation fruitId) {
        if (fruitId == null) return ElementTag.NEUTRAL;
        String path = fruitId.getPath();
        if (path.contains("gomu")) return ElementTag.RUBBER;
        if (path.contains("mera")) return ElementTag.FIRE;
        if (path.contains("hie")) return ElementTag.ICE;
        if (path.contains("goro")) return ElementTag.LIGHTNING;
        return ElementTag.NEUTRAL;
    }

    public static boolean isImmune(ElementTag defender, ElementTag attacker) {
        return defender == ElementTag.RUBBER && attacker == ElementTag.LIGHTNING;
    }
}

