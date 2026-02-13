package com.grandlineapex.client;

import com.grandlineapex.haki.HakiType;

public class ClientHakiData {
    private static HakiType type = HakiType.NONE;
    private static int mastery = 0;
    private static boolean active = false;

    public static void set(HakiType newType, int newMastery, boolean isActive) {
        type = newType == null ? HakiType.NONE : newType;
        mastery = Math.max(0, newMastery);
        active = isActive;
    }

    public static HakiType getType() {
        return type;
    }

    public static int getMastery() {
        return mastery;
    }

    public static boolean isActive() {
        return active;
    }
}
