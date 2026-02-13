package com.grandlineapex.haki.observation;

public class ObservationLogic {
    private ObservationLogic() {}

    public static float evadeChance(int mastery, boolean active) {
        if (!active) return 0.0f;
        return Math.min(0.25f, mastery * 0.0008f);
    }
}
