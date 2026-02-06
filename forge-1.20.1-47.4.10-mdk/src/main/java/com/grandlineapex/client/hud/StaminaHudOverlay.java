package com.grandlineapex.client.hud;

import com.grandlineapex.client.ClientStaminaData;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.awt.*;

public class StaminaHudOverlay {
    public static final IGuiOverlay HUD_STAMINA = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        var mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) return;

        final int barWidth  = 92;
        final int barHeight = 8;
        final int x = (screenWidth / 2) - (barWidth / 2);
        final int y = screenHeight - 48; // above hotbar

        float ratio = ClientStaminaData.getRatio();
        int filled = Math.round(barWidth * ratio);

        // Background (dark)
        fill(guiGraphics, x, y, barWidth, barHeight, new Color(0,0,0,160).getRGB());

        // Foreground (blue)
        fill(guiGraphics, x+1, y+1, Math.max(0, filled-2), barHeight-2, new Color(72, 156, 255, 220).getRGB());
    };

    private static void fill(GuiGraphics g, int x, int y, int w, int h, int color) {
        RenderSystem.enableBlend();
        g.fill(x, y, x + w, y + h, color);
        RenderSystem.disableBlend();
    }
}