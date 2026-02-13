/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\client\hud\MasteryScreen.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.client.hud;

import com.grandlineapex.client.ClientFruitData;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class MasteryScreen extends Screen {
    public MasteryScreen() {
        super(Component.literal("Mastery"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        int x = this.width / 2 - 100;
        int y = this.height / 2 - 40;
        graphics.drawString(this.font, "Fruit: " + ClientFruitData.getFruitId(), x, y, 0xFFFFFF);
        graphics.drawString(this.font, "Mastery: " + ClientFruitData.getMastery(), x, y + 12, 0xFFFFFF);
        graphics.drawString(this.font, "Awakened: " + ClientFruitData.isAwakened(), x, y + 24, 0xFFFFFF);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

