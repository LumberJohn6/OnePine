/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\item\AwakeningCatalystItem.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.item;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AwakeningCatalystItem extends Item {
    public AwakeningCatalystItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) return InteractionResultHolder.success(stack);
        if (!(player instanceof net.minecraft.server.level.ServerPlayer sp)) return InteractionResultHolder.fail(stack);

        return sp.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df -> {
            if (df.getFruitId().isEmpty()) {
                sp.displayClientMessage(Component.literal("You need a Devil Fruit first.").withStyle(ChatFormatting.RED), true);
                return InteractionResultHolder.fail(stack);
            }
            if (df.isAwakeningSpecialItemUsed()) {
                sp.displayClientMessage(Component.literal("Awakening catalyst already consumed.").withStyle(ChatFormatting.YELLOW), true);
                return InteractionResultHolder.fail(stack);
            }
            df.markAwakeningSpecialItemUsed();
            if (!sp.getAbilities().instabuild) {
                stack.shrink(1);
            }
            sp.displayClientMessage(Component.literal("You feel your fruit resonating...").withStyle(ChatFormatting.LIGHT_PURPLE), true);
            return InteractionResultHolder.consume(stack);
        }).orElseGet(() -> InteractionResultHolder.fail(stack));
    }
}

