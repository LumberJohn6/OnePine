package com.grandlineapex.haki.armament;

public class ArmamentLogic {
    private ArmamentLogic() {}

    public static float attackMultiplier(int mastery, boolean active) {
        if (!active) return 1.0f;
        float bonus = Math.min(0.35f, mastery * 0.0015f);
        return 1.0f + bonus;
    }

    public static float defenseMultiplier(int mastery, boolean active) {
        if (!active) return 1.0f;
        float reduction = Math.min(0.30f, mastery * 0.0010f);
        return Math.max(0.1f, 1.0f - reduction);
    }
}
