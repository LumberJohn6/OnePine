package com.grandlineapex.client.hud;

import com.grandlineapex.client.ClientFruitData;
import com.grandlineapex.devilfruit.FruitRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class AbilityWheelScreen extends Screen {
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
        super.render(graphics, mouseX, mouseY, partialTick);

        int x = this.width / 2 - 90;
        int y = this.height / 2 - 50;
        graphics.drawString(this.font, "Hold R to keep open", x, y, 0xAAAAAA);
        y += 14;

        String fruitId = ClientFruitData.getFruitId();
        graphics.drawString(this.font, "Fruit: " + (fruitId.isEmpty() ? "None" : fruitId), x, y, 0xFFFFFF);
        y += 14;

        if (fruitId.isEmpty()) return;
        var fruit = FruitRegistry.get(ResourceLocation.parse(fruitId)).orElse(null);
        if (fruit == null) return;
        for (var ability : fruit.abilities()) {
            if (ability == null) continue;
            graphics.drawString(this.font, "- " + ability.tier().name() + ": " + ability.id(), x, y, 0x66CCFF);
            y += 12;
        }
    }
}
