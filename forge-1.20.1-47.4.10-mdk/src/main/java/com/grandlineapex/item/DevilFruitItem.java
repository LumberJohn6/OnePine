package com.grandlineapex.item;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.world.fruit.DevilFruitWorldAccess;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DevilFruitItem extends Item {
    // Item is bound to a concrete fruit definition (e.g. grandlineapex:testfruit).
    private final ResourceLocation fruitId;

    public DevilFruitItem(ResourceLocation fruitId, Properties properties) {
        super(properties.stacksTo(1));
        this.fruitId = fruitId;
    }

    public ResourceLocation fruitId() {
        return fruitId;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }
        if (!(player instanceof net.minecraft.server.level.ServerPlayer sp)) {
            return InteractionResultHolder.fail(stack);
        }
        if (FruitRegistry.get(fruitId).isEmpty()) {
            sp.displayClientMessage(Component.literal("Unknown fruit: " + fruitId).withStyle(ChatFormatting.RED), true);
            return InteractionResultHolder.fail(stack);
        }

        return sp.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df -> {
            if (!df.getFruitId().isEmpty()) {
                sp.displayClientMessage(Component.literal("You already consumed a Devil Fruit.")
                        .withStyle(ChatFormatting.RED), true);
                return InteractionResultHolder.fail(stack);
            }

            var worldRegistry = DevilFruitWorldAccess.get(sp.server).orElse(null);
            if (worldRegistry == null) {
                sp.displayClientMessage(Component.literal("World fruit registry unavailable.")
                        .withStyle(ChatFormatting.RED), true);
                return InteractionResultHolder.fail(stack);
            }
            // Cross-player exclusivity gate; prevents duplicate ownership of same fruit id.
            if (!worldRegistry.tryConsume(fruitId, sp.getUUID())) {
                sp.displayClientMessage(Component.literal("This fruit is not available right now.")
                        .withStyle(ChatFormatting.RED), true);
                return InteractionResultHolder.fail(stack);
            }

            // Persist ownership to player capability after world registry grants the consume.
            df.clearFruitProgress();
            df.setFruitId(fruitId.toString());

            if (!sp.getAbilities().instabuild) {
                stack.shrink(1);
            }
            sp.displayClientMessage(Component.literal("Consumed " + fruitId + ".").withStyle(ChatFormatting.GOLD), true);
            return InteractionResultHolder.consume(stack);
        }).orElseGet(() -> InteractionResultHolder.fail(stack));
    }
}
