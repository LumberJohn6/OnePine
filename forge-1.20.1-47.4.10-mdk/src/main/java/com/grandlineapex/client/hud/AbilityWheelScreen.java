/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\client\hud\AbilityWheelScreen.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.client.hud;

import com.grandlineapex.client.ClientFruitData;
import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.devilfruit.abilities.Ability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class AbilityWheelScreen extends Screen {
    private static final int RADIUS = 80;
    private static final int SLOT_SIZE = 24;

    public AbilityWheelScreen() { super(Component.literal("Ability Wheel")); }

    @Override
    public boolean isPauseScreen() { return false; }

    @Override
    public void tick() {
        // Close if key released
        if (!com.grandlineapex.client.ClientKeybinds.OPEN_WHEEL.isDown()) {
            Minecraft.getInstance().setScreen(null);
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);

        String fruitId = ClientFruitData.getFruitId();
        if (fruitId.isEmpty()) {
            graphics.drawCenteredString(this.font, "No Devil Fruit Equipped", this.width / 2, this.height / 2, 0xFF5555);
            return;
        }

        var fruitOpt = FruitRegistry.get(ResourceLocation.parse(fruitId));
        if (fruitOpt.isEmpty()) return;

        List<Ability> abilities = fruitOpt.get().abilities().stream().filter(a -> a != null).toList();
        int count = abilities.size();
        if (count == 0) return;

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        double angleStep = (2.0 * Math.PI) / count;
        double angleOffset = -Math.PI / 2.0;

        for (int i = 0; i < count; i++) {
            Ability ability = abilities.get(i);
            double angle = angleOffset + (i * angleStep);
            int x = (int) (centerX + RADIUS * Math.cos(angle));
            int y = (int) (centerY + RADIUS * Math.sin(angle));

            boolean hovered = isMouseOverSlot(mouseX, mouseY, x, y);
            if (hovered) {
                graphics.fill(x - SLOT_SIZE / 2 - 2, y - SLOT_SIZE / 2 - 2, x + SLOT_SIZE / 2 + 2, y + SLOT_SIZE / 2 + 2, 0xFF489CFF);
            }
            graphics.fill(x - SLOT_SIZE / 2, y - SLOT_SIZE / 2, x + SLOT_SIZE / 2, y + SLOT_SIZE / 2, 0xFF222222);

            String label = ability.tier().name();
            if (label.length() > 3) label = label.substring(0, 3);
            graphics.drawCenteredString(this.font, label, x, y - 4, hovered ? 0xFFFF00 : 0xFFFFFF);

            if (hovered) {
                graphics.drawCenteredString(this.font, ability.id().getPath(), centerX, centerY + 15, 0xFFFFFF);
                graphics.drawCenteredString(this.font, "Stamina: " + (int) ability.staminaCost(), centerX, centerY + 25, 0x489CFF);
            }
        }
    }

    private boolean isMouseOverSlot(int mouseX, int mouseY, int slotX, int slotY) {
        int half = SLOT_SIZE / 2;
        return mouseX >= slotX - half && mouseX <= slotX + half
                && mouseY >= slotY - half && mouseY <= slotY + half;
    }
}

