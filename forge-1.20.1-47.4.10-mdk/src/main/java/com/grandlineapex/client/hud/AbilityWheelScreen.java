package com.grandlineapex.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

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

    // Later: draw segments, selection, etc.
}