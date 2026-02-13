/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\capability\PlayerDataStorage.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class PlayerDataStorage {
    public static final Capability<PlayerData> PLAYER_DATA =
            CapabilityManager.get(new CapabilityToken<>() {
            });

    private PlayerDataStorage() {
    }
}

