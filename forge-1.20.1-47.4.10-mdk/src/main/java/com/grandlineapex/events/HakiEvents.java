/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\events\HakiEvents.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.events;

import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.haki.armament.ArmamentLogic;
import com.grandlineapex.haki.HakiType;
import com.grandlineapex.haki.observation.ObservationLogic;
import com.grandlineapex.systems.stamina.StaminaCapability;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HakiEvents {
    @SubscribeEvent
    public static void onPlayerAttack(LivingHurtEvent event) {
        if (event.isCanceled()) return;

        if (event.getSource().getEntity() instanceof ServerPlayer attacker) {
            attacker.getCapability(HakiCapability.HAKI).ifPresent(haki -> {
                if (!haki.isActive() || haki.getActiveType() != HakiType.ARMAMENT) return;
                float multiplier = ArmamentLogic.attackMultiplier(
                        haki.getMastery(HakiType.ARMAMENT),
                        true
                );
                event.setAmount(event.getAmount() * multiplier);
                attacker.getCapability(StaminaCapability.STAMINA).ifPresent(stamina -> stamina.trySpend(1.0f));
            });
        }

        if (!(event.getEntity() instanceof ServerPlayer defender)) return;
        defender.getCapability(HakiCapability.HAKI).ifPresent(haki -> {
            if (haki.isActive() && haki.getActiveType() == HakiType.ARMAMENT) {
                float multiplier = ArmamentLogic.defenseMultiplier(
                        haki.getMastery(HakiType.ARMAMENT),
                        true
                );
                event.setAmount(event.getAmount() * multiplier);
            }

            if (haki.isActive() && haki.getActiveType() == HakiType.OBSERVATION) {
                float dodgeChance = ObservationLogic.evadeChance(
                        haki.getMastery(HakiType.OBSERVATION),
                        true
                );
                if (defender.getRandom().nextFloat() >= dodgeChance) return;
                defender.getCapability(StaminaCapability.STAMINA).ifPresent(stamina -> {
                    if (!stamina.trySpend(5.0f)) return;
                    event.setCanceled(true);
                    defender.displayClientMessage(Component.literal("§e§lDODGED!"), true);
                });
            }
        });
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) return;
        if (event.player.tickCount % 40 != 0) return;
        event.player.getCapability(HakiCapability.HAKI).ifPresent(data -> {
            if (data.isActive() && data.getActiveType() != HakiType.NONE) {
                data.addMastery(data.getActiveType(), 1);
            }
        });
    }
}

