/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\abilities\AbilityBootstrap.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit.abilities;

import com.grandlineapex.devilfruit.abilities.impl.giraffe.GiraffeAwakening;
import com.grandlineapex.devilfruit.abilities.impl.giraffe.GiraffeCharge;
import com.grandlineapex.devilfruit.abilities.impl.giraffe.NeckWhip;
import com.grandlineapex.devilfruit.abilities.impl.giraffe.PastaMachine;
import com.grandlineapex.devilfruit.abilities.impl.gomu.GomuBazooka;
import com.grandlineapex.devilfruit.abilities.impl.gomu.GomuGatling;
import com.grandlineapex.devilfruit.abilities.impl.gomu.GomuGigant;
import com.grandlineapex.devilfruit.abilities.impl.gomu.GomuPistol;
import com.grandlineapex.devilfruit.abilities.impl.hie.IceAge;
import com.grandlineapex.devilfruit.abilities.impl.hie.IceSpear;
import com.grandlineapex.devilfruit.abilities.impl.hie.IceWall;
import com.grandlineapex.devilfruit.abilities.impl.hie.PheasantBeak;
import com.grandlineapex.devilfruit.abilities.impl.mera.DaiEnkai;
import com.grandlineapex.devilfruit.abilities.impl.mera.FireFist;
import com.grandlineapex.devilfruit.abilities.impl.mera.FlameBurst;
import com.grandlineapex.devilfruit.abilities.impl.mera.FlameStep;
import com.grandlineapex.devilfruit.abilities.impl.ope.GammaKnife;
import com.grandlineapex.devilfruit.abilities.impl.ope.Room;
import com.grandlineapex.devilfruit.abilities.impl.ope.Shambles;
import com.grandlineapex.devilfruit.abilities.impl.ope.Tact;
import com.grandlineapex.devilfruit.abilities.impl.test.T1_Jab;

public class AbilityBootstrap {
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;

        // Baseline test ability
        AbilityRegistry.register(new T1_Jab());

        // Gomu ability set
        AbilityRegistry.register(new GomuPistol());
        AbilityRegistry.register(new GomuBazooka());
        AbilityRegistry.register(new GomuGatling());
        AbilityRegistry.register(new GomuGigant());

        // Mera ability set
        AbilityRegistry.register(new FireFist());
        AbilityRegistry.register(new FlameBurst());
        AbilityRegistry.register(new FlameStep());
        AbilityRegistry.register(new DaiEnkai());

        // Ope ability set
        AbilityRegistry.register(new Room());
        AbilityRegistry.register(new Shambles());
        AbilityRegistry.register(new Tact());
        AbilityRegistry.register(new GammaKnife());

        // Hie ability set
        AbilityRegistry.register(new IceSpear());
        AbilityRegistry.register(new IceAge());
        AbilityRegistry.register(new IceWall());
        AbilityRegistry.register(new PheasantBeak());

        // Giraffe Zoan ability set
        AbilityRegistry.register(new NeckWhip());
        AbilityRegistry.register(new GiraffeCharge());
        AbilityRegistry.register(new PastaMachine());
        AbilityRegistry.register(new GiraffeAwakening());
    }
}

