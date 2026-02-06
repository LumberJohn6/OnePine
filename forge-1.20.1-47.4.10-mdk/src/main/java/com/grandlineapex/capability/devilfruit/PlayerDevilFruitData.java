
package com.grandlineapex.capability.devilfruit;

public class PlayerDevilFruitData {
    private String fruitId = "";
    private int mastery = 0;
    private boolean awakened = false;

    public String getFruitId() { return fruitId; }
    public void setFruitId(String id) { this.fruitId = id; }

    public int getMastery() { return mastery; }
    public void addMastery(int amount) { this.mastery += amount; }

    public boolean isAwakened() { return awakened; }
    public void setAwakened(boolean val) { this.awakened = val; }
}
