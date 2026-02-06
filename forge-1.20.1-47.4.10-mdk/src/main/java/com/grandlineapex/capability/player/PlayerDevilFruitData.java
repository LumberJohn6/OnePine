package com.grandlineapex.capability.player;

public class PlayerDevilFruitData {
    private String fruitId = "";
    private int mastery = 0;
    private boolean awakened = false;

    public String getFruitId() { return fruitId; }
    public void setFruitId(String fruitId) { this.fruitId = fruitId; }

    public int getMastery() { return mastery; }
    public void addMastery(int amount) { this.mastery += amount; }

    public boolean isAwakened() { return awakened; }
    public void setAwakened(boolean val) { this.awakened = val; }
}
