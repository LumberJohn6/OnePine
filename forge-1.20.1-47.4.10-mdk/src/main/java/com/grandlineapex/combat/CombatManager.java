package com.grandlineapex.combat;

import com.grandlineapex.capability.player.CombatCapability;
import com.grandlineapex.capability.player.BountyCapability;
import com.grandlineapex.capability.player.HakiCapability;
import com.grandlineapex.capability.player.StatsCapability;
import com.grandlineapex.capability.devilfruit.DevilFruitCapability;
import com.grandlineapex.devilfruit.awakening.AwakeningHandler;
import com.grandlineapex.haki.HakiType;
import com.grandlineapex.haki.armament.ArmamentLogic;
import com.grandlineapex.haki.conqueror.ConquerorLogic;
import net.minecraft.world.entity.player.Player;

public class CombatManager {
    private CombatManager() {}

    public static float modifyOutgoingDamage(Player attacker, float baseDamage) {
        // Outgoing damage composes style + haki + stat scaling into one multiplier.
        float multiplier = 1.0f;

        multiplier *= attacker.getCapability(CombatCapability.COMBAT)
                .map(data -> {
                    FightingStyle style = FightingStyle.byId(data.getFightingStyleId());
                    boolean unlocked = attacker.getCapability(BountyCapability.BOUNTY)
                            .map(bounty -> bounty.getTier().isAtLeast(style.unlockTier()))
                            .orElse(false);
                    if (!unlocked) return 1.0f;
                    return style.damageMultiplier(data.getStyleMastery());
                })
                .orElse(1.0f);

        multiplier *= attacker.getCapability(HakiCapability.HAKI)
                .map(data -> {
                    HakiType type = data.getActiveType();
                    int mastery = data.getMastery(type);
                    if (type == HakiType.ARMAMENT) return ArmamentLogic.attackMultiplier(mastery, data.isActive());
                    if (type == HakiType.CONQUEROR) return 1.0f + ConquerorLogic.intimidationDamageBonus(mastery, data.isActive());
                    return 1.0f;
                })
                .orElse(1.0f);

        multiplier += attacker.getCapability(StatsCapability.STATS)
                .map(stats -> stats.getStrength() * 0.01f)
                .orElse(0.0f);

        multiplier *= attacker.getCapability(DevilFruitCapability.DEVIL_FRUIT)
                .map(AwakeningHandler::damageMultiplier)
                .orElse(1.0f);

        return baseDamage * multiplier;
    }

    public static float modifyIncomingDamage(Player defender, float baseDamage) {
        // Incoming damage applies defensive modifiers (currently armament + defense stat).
        float multiplier = 1.0f;

        multiplier *= defender.getCapability(HakiCapability.HAKI)
                .map(data -> {
                    if (data.getActiveType() != HakiType.ARMAMENT) return 1.0f;
                    return ArmamentLogic.defenseMultiplier(data.getMastery(HakiType.ARMAMENT), data.isActive());
                })
                .orElse(1.0f);

        multiplier -= defender.getCapability(StatsCapability.STATS)
                .map(stats -> Math.min(0.25f, stats.getDefense() * 0.01f))
                .orElse(0.0f);

        return Math.max(0.0f, baseDamage * Math.max(0.1f, multiplier));
    }
}
