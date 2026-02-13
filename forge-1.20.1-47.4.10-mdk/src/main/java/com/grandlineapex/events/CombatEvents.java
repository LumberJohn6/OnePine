package com.grandlineapex.events;

import com.grandlineapex.bounty.BountyManager;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.capability.player.AbilityRuntimeCapability;
import com.grandlineapex.combat.CombatManager;
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
            event.setAmount(CombatManager.modifyIncomingDamage(player, event.getAmount()));

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
        }
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
