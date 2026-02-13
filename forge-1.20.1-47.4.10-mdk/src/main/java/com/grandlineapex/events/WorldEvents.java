package com.grandlineapex.events;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.raid.RaidManager;
import com.grandlineapex.registry.ModItems;
import com.grandlineapex.world.fruit.DevilFruitWorldAccess;
import com.grandlineapex.world.fruit.DevilFruitWorldProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldEvents {
    private static final int FRUIT_RESPAWN_COOLDOWN_TICKS = 0;

    @SubscribeEvent
    public static void attachLevelCapabilities(AttachCapabilitiesEvent<Level> event) {
        if (!(event.getObject() instanceof ServerLevel serverLevel)) return;
        // Keep one canonical world registry on overworld to avoid per-dimension divergence.
        if (serverLevel.dimension() != Level.OVERWORLD) return;
        event.addCapability(ResourceLocation.parse("grandlineapex:devil_fruit_world"), new DevilFruitWorldProvider());
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            var server = net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                // Advances fruit respawn cooldowns globally.
                DevilFruitWorldAccess.get(server).ifPresent(registry -> registry.tickCooldowns());
            }
        }
        RaidManager.onServerTick(event);
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        player.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df -> {
            if (df.getFruitId().isEmpty()) return;

            ResourceLocation fruitId;
            try {
                fruitId = ResourceLocation.parse(df.getFruitId());
            } catch (Exception ignored) {
                return;
            }

            DevilFruitWorldAccess.get(player.server).ifPresent(registry ->
                    registry.releaseFruit(fruitId, FRUIT_RESPAWN_COOLDOWN_TICKS));

            // Reincarnate into world as an item drop near death position.
            ModItems.stackForFruit(fruitId).ifPresent(stack -> {
                ItemEntity fruitEntity = new ItemEntity(
                        player.level(),
                        player.getX(),
                        player.getY() + 0.5,
                        player.getZ(),
                        stack
                );
                player.level().addFreshEntity(fruitEntity);
            });

            // Clear consumed fruit state and awakening progression for this player.
            df.clearFruitProgress();
        });
    }
}
