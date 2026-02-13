
package com.grandlineapex.capability.devilfruit;

public class PlayerDevilFruitData {
    // Per-player single-fruit ownership and progression state.
    private String fruitId = "";
    private int mastery = 0;
    private boolean awakened = false;
    // Requirement progress flags used by AwakeningHandler.
    private boolean awakeningBossDefeated = false;
    private boolean awakeningSpecialItemUsed = false;

    public String getFruitId() { return fruitId; }
    public void setFruitId(String id) {
        String value = id == null ? "" : id;
        if (!this.fruitId.isEmpty() && !this.fruitId.equals(value) && !value.isEmpty()) {
            return;
        }
        this.fruitId = value;
    }

    public int getMastery() { return mastery; }
    public void setMastery(int mastery) {
        this.mastery = Math.max(0, mastery);
    }
    public void addMastery(int amount) { setMastery(this.mastery + amount); }

    public boolean isAwakened() { return awakened; }
    public void setAwakened(boolean val) { this.awakened = val; }

    public boolean isAwakeningBossDefeated() {
        return awakeningBossDefeated;
    }

    public void markAwakeningBossDefeated() {
        this.awakeningBossDefeated = true;
    }

    public boolean isAwakeningSpecialItemUsed() {
        return awakeningSpecialItemUsed;
    }

    public void markAwakeningSpecialItemUsed() {
        this.awakeningSpecialItemUsed = true;
    }

    public void clearFruitProgress() {
        // Used when consuming a new fruit or on death/reincarnation to avoid stale unlock state.
        this.fruitId = "";
        this.mastery = 0;
        this.awakened = false;
        this.awakeningBossDefeated = false;
        this.awakeningSpecialItemUsed = false;
    }

    public void copyFrom(PlayerDevilFruitData other) {
        setFruitId(other.getFruitId());
        setMastery(other.getMastery());
        setAwakened(other.isAwakened());
        this.awakeningBossDefeated = other.awakeningBossDefeated;
        this.awakeningSpecialItemUsed = other.awakeningSpecialItemUsed;
    }
}
