package com.grandlineapex.client;

public class ClientStaminaData {
    private static float current = 100f;
    private static float max = 100f;

    public static void set(float c, float m) { current = c; max = m <= 0 ? 1f : m; }
    public static float getCurrent() { return current; }
    public static float getMax() { return max; }
    public static float getRatio() { return Math.max(0f, Math.min(current / max, 1f)); }
}