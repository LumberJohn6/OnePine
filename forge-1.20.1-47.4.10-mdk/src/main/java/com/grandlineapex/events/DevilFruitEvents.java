package com.grandlineapex.events;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.devilfruit.FruitRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DevilFruitEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) return;
        if (!(event.player instanceof ServerPlayer player)) return;

        // Runtime passive loop for equipped fruit and baseline weakness handling.
        player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(data -> {
            if (data.getFruitId().isEmpty()) return;
            net.minecraft.resources.ResourceLocation fruitId;
            try {
                fruitId = net.minecraft.resources.ResourceLocation.parse(data.getFruitId());
            } catch (Exception ignored) {
                return;
            }
            var fruitOpt = FruitRegistry.get(fruitId);
            if (fruitOpt.isEmpty()) return;

            var fruit = fruitOpt.get();
            fruit.tickPassive(player);

            if (fruit.hasWaterWeakness() && player.isInWaterRainOrBubble()) {
                // Entering water suppresses interruptible fruit abilities in flight.
                player.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(runtime ->
                        runtime.interruptMatching(
                                (net.minecraft.server.level.ServerLevel) player.level(),
                                player,
                                "water",
                                (instance, ability) -> instance.isBusy() && ability.canInterruptInWater()
                        ));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, false, false, true));
            }
        });
    }
}
