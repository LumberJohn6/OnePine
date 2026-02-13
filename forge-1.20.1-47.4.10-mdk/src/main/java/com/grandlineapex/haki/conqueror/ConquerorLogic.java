package com.grandlineapex.haki.conqueror;

public class ConquerorLogic {
    private ConquerorLogic() {}

    public static float intimidationDamageBonus(int mastery, boolean active) {
        if (!active) return 0.0f;
        return Math.min(0.25f, mastery * 0.0012f);
    }
}
