package com.grandlineapex.client;

public class ClientFruitData {
    private static String fruitId = "";
    private static int mastery = 0;
    private static boolean awakened = false;

    public static void set(String id, int value, boolean isAwakened) {
        fruitId = id == null ? "" : id;
        mastery = Math.max(0, value);
        awakened = isAwakened;
    }

    public static String getFruitId() {
        return fruitId;
    }

    public static int getMastery() {
        return mastery;
    }

    public static boolean isAwakened() {
        return awakened;
    }
}
