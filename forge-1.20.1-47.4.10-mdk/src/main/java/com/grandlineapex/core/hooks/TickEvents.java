package com.grandlineapex.core.hooks;

import com.grandlineapex.combat.energy.CooldownHandler;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Global tick handlers.
 * Server tick → runs once per server tick on the logical server.
 * Client tick  → runs per client tick (useful for client-side UI, particles).
 */
@Mod.EventBusSubscriber // bus = MOD is default for mod-lifecycle events; we want Forge event bus here.
public class TickEvents {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            // Tick global cooldowns (your CooldownHandler)
            CooldownHandler.tick();

            // You can tick other global systems here as well:
            // - Raid scheduler
            // - Sea events manager
            // - World simulators that are not tied to a specific level
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            // Client-only ticking: UI animations, HUD cooldown rings, key handling, etc.
            // DO NOT modify server state here.
        }
    }
}