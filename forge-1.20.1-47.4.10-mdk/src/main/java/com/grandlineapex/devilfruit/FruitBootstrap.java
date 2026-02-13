/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\devilfruit\FruitBootstrap.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.devilfruit;

import com.grandlineapex.devilfruit.fruits.logia.HieHieNoMi;
import com.grandlineapex.devilfruit.fruits.logia.MeraMeraNoMi;
import com.grandlineapex.devilfruit.fruits.paramecia.GomuGomuNoMi;
import com.grandlineapex.devilfruit.fruits.paramecia.OpeOpeNoMi;
import com.grandlineapex.devilfruit.fruits.zoan.UshiUshiNoMiModelGiraffe;

public class FruitBootstrap {
    private static boolean initialized;

    private FruitBootstrap() {}

    public static void init() {
        if (initialized) return;
        initialized = true;

        // Baseline testing fruit
        register(new TestFruit());

        // Paramecia fruits
        register(new GomuGomuNoMi());
        register(new OpeOpeNoMi());

        // Logia fruits
        register(new MeraMeraNoMi());
        register(new HieHieNoMi());

        // Zoan fruits
        register(new UshiUshiNoMiModelGiraffe());
    }

    private static void register(DevilFruit fruit) {
        FruitRegistry.register(fruit);
        com.grandlineapex.fruit.FruitRegistry.register(new com.grandlineapex.fruit.LegacyFruitAdapter(fruit));
    }
}

