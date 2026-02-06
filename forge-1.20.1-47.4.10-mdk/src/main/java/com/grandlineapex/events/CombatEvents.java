package com.grandlineapex.events;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber
public class CombatEvents {

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        // Modify damage based on Haki, stats
        // This is where you check fruit/passives
    }
}
