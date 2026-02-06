package com.grandlineapex.devilfruit.abilities;

import com.grandlineapex.devilfruit.abilities.impl.T1_Jab;

public class AbilityBootstrap {
    public static void init() {
        AbilityRegistry.register(new T1_Jab());
        // register more here
    }
}