package com.grandlineapex.systems.stamina;

public class PlayerStaminaData {
    private float current = 100f;
    private float max = 100f;
    private float regenPerSecond = 5f;

    public float getCurrent() { return current; }
    public float getMax() { return max; }
    public void setMax(float v) { max = v; if (current > max) current = max; }

    public void set(float v) { current = Math.max(0f, Math.min(v, max)); }
    public boolean trySpend(float amount) {
        if (current >= amount) { current -= amount; return true; }
        return false;
    }
    public void regen(float seconds) {
        if (current < max) {
            current = Math.min(max, current + regenPerSecond * seconds);
        }
    }
}