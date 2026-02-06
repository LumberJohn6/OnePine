package com.grandlineapex.events;

import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.devilfruit.PlayerDevilFruitProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerEvents {

    @SubscribeEvent
    public static void attachDevilFruit(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(
                    new ResourceLocation("grandlineapex", "devil_fruit"),
                    new PlayerDevilFruitProvider()
            );
        }
    }

    @SubscribeEvent
    public static void clone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(oldStore -> {
            event.getEntity().getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(newStore -> {
                newStore.setFruitId(oldStore.getFruitId());
                newStore.addMastery(oldStore.getMastery());
                newStore.setAwakened(oldStore.isAwakened());
            });
        });
    }

    @SubscribeEvent
    public static void tick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            // future: passives, mastery regen, stamina, etc.
        }
    }
}