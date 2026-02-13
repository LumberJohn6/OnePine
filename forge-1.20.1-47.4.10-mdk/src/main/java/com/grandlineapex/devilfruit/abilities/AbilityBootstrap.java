package com.grandlineapex.devilfruit.abilities;

import com.grandlineapex.devilfruit.abilities.impl.T1_Jab;

public class AbilityBootstrap {
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;
        AbilityRegistry.register(new T1_Jab());
        // register more here
    }
}
