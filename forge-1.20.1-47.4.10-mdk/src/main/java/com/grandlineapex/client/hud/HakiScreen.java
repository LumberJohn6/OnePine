package com.grandlineapex.client.hud;

import com.grandlineapex.client.ClientHakiData;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class HakiScreen extends Screen {
    public HakiScreen() {
        super(Component.literal("Haki"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        int x = this.width / 2 - 100;
        int y = this.height / 2 - 40;
        graphics.drawString(this.font, "Type: " + ClientHakiData.getType().name(), x, y, 0xFFFFFF);
        graphics.drawString(this.font, "Mastery: " + ClientHakiData.getMastery(), x, y + 12, 0xFFFFFF);
        graphics.drawString(this.font, "Active: " + ClientHakiData.isActive(), x, y + 24, 0xFFFFFF);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
