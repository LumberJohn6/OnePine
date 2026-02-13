/*
 * AUTO-FILE-DOC
 * File: src/main/java/\com\grandlineapex\events\CombatEvents.java
 * Purpose: Project source file supporting mod runtime behavior.
 */
package com.grandlineapex.events;

import com.grandlineapex.bounty.BountyManager;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.combat.element.ElementResolver;
import com.grandlineapex.combat.CombatManager;
import com.grandlineapex.devilfruit.FruitRegistry;
import com.grandlineapex.haki.HakiType;
import com.grandlineapex.weakness.SeastoneHandler;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.grandlineapex.GrandLineApex.MODID,
                bus = Mod.EventBusSubscriber.Bus.FORGE)

public class CombatEvents {

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        // Bridge event -> CombatManager so all combat scaling stays centralized.
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();

        if (attacker instanceof Player player) {
            event.setAmount(CombatManager.modifyOutgoingDamage(player, event.getAmount()));
        }

        if (event.getEntity() instanceof Player player) {
            if (attacker instanceof ServerPlayer spAttacker && player instanceof ServerPlayer spDefender) {
                maybeApplyElementCounter(event, spAttacker, spDefender);
            }
            if (isLogiaIntangible(event)) {
                event.setCanceled(true);
                return;
            }

            event.setAmount(CombatManager.modifyIncomingDamage(player, event.getAmount()));

            if (player instanceof ServerPlayer sp) {
                sp.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df -> {
                    if (df.getFruitId().isEmpty()) return;
                    try {
                        var fruitId = net.minecraft.resources.ResourceLocation.parse(df.getFruitId());
                        FruitRegistry.get(fruitId).ifPresent(fruit ->
                                event.setAmount(fruit.onDamageTaken(sp, event.getSource(), event.getAmount())));
                    } catch (Exception ignored) {
                    }
                });
            }

            // Damage can interrupt charge/channel/active abilities.
            if (player instanceof ServerPlayer sp) {
                sp.getCapability(AbilityRuntimeCapability.ABILITY_RUNTIME).ifPresent(runtime ->
                        runtime.interruptMatching(
                                (net.minecraft.server.level.ServerLevel) sp.level(),
                                sp,
                                "damage",
                                (instance, ability) -> instance.isBusy() && ability.canInterruptOnDamage()
                        ));
            }

            if (attacker instanceof Player atk && player instanceof Player def) {
                CombatHookEvent hook = new CombatHookEvent(atk, def, event.getAmount());
                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(hook);
                event.setAmount(hook.amount());
            }
        }
    }

    private static void maybeApplyElementCounter(LivingHurtEvent event, ServerPlayer attacker, ServerPlayer defender) {
        var attackerFruit = attacker.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df -> df.getFruitIdValue()).orElse(null);
        var defenderFruit = defender.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df -> df.getFruitIdValue()).orElse(null);
        if (ElementResolver.isImmune(ElementResolver.byFruit(defenderFruit), ElementResolver.byFruit(attackerFruit))) {
            event.setAmount(0.0f);
        }
    }

    private static boolean isLogiaIntangible(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer defender)) return false;
        if (event.getSource().is(net.minecraft.tags.DamageTypeTags.BYPASSES_INVULNERABILITY)) return false;

        return defender.getCapability(DevilFruitCapability.DEVIL_FRUIT).map(df -> {
            if (df.getFruitId().isEmpty()) return false;
            if (df.isSubmergedWeakness()) return false;

            net.minecraft.resources.ResourceLocation fruitId;
            try {
                fruitId = net.minecraft.resources.ResourceLocation.parse(df.getFruitId());
            } catch (Exception ignored) {
                return false;
            }
            var fruit = FruitRegistry.get(fruitId).orElse(null);
            if (fruit == null || fruit.type() != com.grandlineapex.devilfruit.FruitType.LOGIA) return false;
            if (SeastoneHandler.isWeakened(defender, fruit)) return false;

            Entity attacker = event.getSource().getEntity();
            if (!(attacker instanceof ServerPlayer spAttacker)) return true;
            return spAttacker.getCapability(HakiCapability.HAKI).map(haki ->
                    !(haki.isActive() && haki.getActiveType() == HakiType.ARMAMENT)
            ).orElse(true);
        }).orElse(false);
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        // Route kill outcomes into bounty progression.
        Entity source = event.getSource().getEntity();
        if (!(source instanceof ServerPlayer killer)) return;
        LivingEntity defeated = event.getEntity();
        if (defeated == killer) return;
        BountyManager.onEntityDefeated(killer, defeated);

        boolean bossLike = defeated.getMaxHealth() >= 80f
                || (defeated.getCustomName() != null
                && defeated.getCustomName().getString().toLowerCase().contains("boss"));
        if (bossLike) {
            // Boss defeat is one awakening requirement; progression is stored on fruit capability.
            killer.getCapability(DevilFruitCapability.DEVIL_FRUIT).ifPresent(df -> {
                if (!df.getFruitId().isEmpty()) {
                    df.markAwakeningBossDefeated();
                }
            });
        }
    }
}

