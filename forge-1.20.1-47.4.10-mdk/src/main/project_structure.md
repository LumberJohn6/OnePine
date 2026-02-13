# Project Structure

## Tree

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── grandlineapex/
    │           ├── ability/
    │           │   ├── runtime/
    │           │   │   ├── AbilityInstance.java
    │           │   │   └── AbilityState.java
    │           │   ├── Ability.java
    │           │   ├── AbilityContext.java
    │           │   ├── ActiveAbility.java
    │           │   ├── CooldownAbility.java
    │           │   └── PassiveAbility.java
    │           ├── attribute/
    │           │   └── ModAttributes.java
    │           ├── bounty/
    │           │   ├── quest/
    │           │   │   ├── BountyQuest.java
    │           │   │   └── QuestGenerator.java
    │           │   ├── BountyManager.java
    │           │   ├── BountyRewardHandler.java
    │           │   └── BountyTier.java
    │           ├── capability/
    │           │   ├── devilfruit/
    │           │   │   ├── DevilFruitCapability.java
    │           │   │   ├── DevilFruitData.java
    │           │   │   ├── DevilFruitProvider.java
    │           │   │   ├── IDevilFruitData.java
    │           │   │   ├── PlayerDevilFruitData.java
    │           │   │   └── PlayerDevilFruitProvider.java
    │           │   ├── player/
    │           │   │   ├── AbilityRuntimeCapability.java
    │           │   │   ├── BountyCapability.java
    │           │   │   ├── CombatCapability.java
    │           │   │   ├── HakiCapability.java
    │           │   │   ├── PlayerAbilityRuntimeData.java
    │           │   │   ├── PlayerAbilityRuntimeProvider.java
    │           │   │   ├── PlayerBountyData.java
    │           │   │   ├── PlayerBountyProvider.java
    │           │   │   ├── PlayerCombatData.java
    │           │   │   ├── PlayerCombatProvider.java
    │           │   │   ├── PlayerHakiData.java
    │           │   │   ├── PlayerHakiProvider.java
    │           │   │   ├── PlayerStatsData.java
    │           │   │   ├── PlayerStatsProvider.java
    │           │   │   └── StatsCapability.java
    │           │   ├── CapabilityRegistry.java
    │           │   ├── IPlayerData.java
    │           │   ├── PlayerData.java
    │           │   ├── PlayerDataProvider.java
    │           │   └── PlayerDataStorage.java
    │           ├── client/
    │           │   ├── hud/
    │           │   │   ├── AbilityWheelScreen.java
    │           │   │   ├── HakiScreen.java
    │           │   │   ├── MasteryScreen.java
    │           │   │   └── StaminaHudOverlay.java
    │           │   ├── input/
    │           │   │   └── ClientInputHandler.java
    │           │   ├── render/
    │           │   ├── ClientBountyData.java
    │           │   ├── ClientFruitData.java
    │           │   ├── ClientHakiData.java
    │           │   ├── ClientKeybinds.java
    │           │   ├── ClientSetup.java
    │           │   └── ClientStaminaData.java
    │           ├── combat/
    │           │   ├── element/
    │           │   │   ├── ElementResolver.java
    │           │   │   └── ElementTag.java
    │           │   ├── energy/
    │           │   │   ├── CooldownHandler.java
    │           │   │   └── EnergyHandler.java
    │           │   ├── scaling/
    │           │   │   └── PowerScalingHandler.java
    │           │   ├── styles/
    │           │   │   ├── BrawlerStyle.java
    │           │   │   └── SwordsmanStyle.java
    │           │   ├── CombatManager.java
    │           │   └── FightingStyle.java
    │           ├── common/
    │           ├── core/
    │           │   └── hooks/
    │           │       └── TickEvents.java
    │           ├── devilfruit/
    │           │   ├── abilities/
    │           │   │   ├── effects/
    │           │   │   │   ├── AOEEffect.java
    │           │   │   │   ├── BuffEffect.java
    │           │   │   │   ├── DebuffEffect.java
    │           │   │   │   ├── MeleeEffect.java
    │           │   │   │   ├── ProjectileEffect.java
    │           │   │   │   ├── SummonEffect.java
    │           │   │   │   ├── TeleportEffect.java
    │           │   │   │   └── TransformEffect.java
    │           │   │   ├── impl/
    │           │   │   │   ├── BaseAbility.java
    │           │   │   │   ├── DaiEnkai.java
    │           │   │   │   ├── FireFist.java
    │           │   │   │   ├── FlameBurst.java
    │           │   │   │   ├── FlameStep.java
    │           │   │   │   ├── GammaKnife.java
    │           │   │   │   ├── GiraffeAwakening.java
    │           │   │   │   ├── GiraffeCharge.java
    │           │   │   │   ├── GomuBazooka.java
    │           │   │   │   ├── GomuGatling.java
    │           │   │   │   ├── GomuGigant.java
    │           │   │   │   ├── GomuPistol.java
    │           │   │   │   ├── IceAge.java
    │           │   │   │   ├── IceSpear.java
    │           │   │   │   ├── IceWall.java
    │           │   │   │   ├── NeckWhip.java
    │           │   │   │   ├── PastaMachine.java
    │           │   │   │   ├── PheasantBeak.java
    │           │   │   │   ├── Room.java
    │           │   │   │   ├── Shambles.java
    │           │   │   │   ├── T1_Jab.java
    │           │   │   │   └── Tact.java
    │           │   │   ├── Ability.java
    │           │   │   ├── AbilityBootstrap.java
    │           │   │   ├── AbilityCooldownTracker.java
    │           │   │   ├── AbilityManager.java
    │           │   │   ├── AbilityRegistry.java
    │           │   │   ├── AbilityTier.java
    │           │   │   ├── AbilityType.java
    │           │   │   └── AbstractAbility.java
    │           │   ├── adapters/
    │           │   │   └── FruitAbilityAdapter.java
    │           │   ├── api/
    │           │   │   ├── IDevilFruit.java
    │           │   │   └── IFruitAbility.java
    │           │   ├── awakening/
    │           │   │   ├── requirements/
    │           │   │   │   ├── BossDefeatAwakeningRequirement.java
    │           │   │   │   ├── BountyAwakeningRequirement.java
    │           │   │   │   ├── ConquerorUnlockAwakeningRequirement.java
    │           │   │   │   ├── MasteryAwakeningRequirement.java
    │           │   │   │   └── SpecialItemAwakeningRequirement.java
    │           │   │   ├── AwakeningHandler.java
    │           │   │   └── AwakeningRequirement.java
    │           │   ├── fruits/
    │           │   │   ├── GomuGomuNoMi.java
    │           │   │   ├── HieHieNoMi.java
    │           │   │   ├── MeraMeraNoMi.java
    │           │   │   ├── OpeOpeNoMi.java
    │           │   │   └── UshiUshiNoMiModelGiraffe.java
    │           │   ├── logia/
    │           │   ├── paramecia/
    │           │   ├── progression/
    │           │   │   ├── FruitProgressionData.java
    │           │   │   └── IFruitProgression.java
    │           │   ├── zoan/
    │           │   ├── DevilFruit.java
    │           │   ├── FruitBootstrap.java
    │           │   ├── FruitRegistry.java
    │           │   ├── FruitType.java
    │           │   └── TestFruit.java
    │           ├── events/
    │           │   ├── CombatEvents.java
    │           │   ├── CombatHookEvent.java
    │           │   ├── DevilFruitEvents.java
    │           │   ├── HakiEvents.java
    │           │   ├── PlayerEvents.java
    │           │   └── WorldEvents.java
    │           ├── fruit/
    │           │   ├── DevilFruit.java
    │           │   ├── FruitRegistry.java
    │           │   ├── FruitType.java
    │           │   └── LegacyFruitAdapter.java
    │           ├── haki/
    │           │   ├── armament/
    │           │   │   └── ArmamentLogic.java
    │           │   ├── conqueror/
    │           │   │   └── ConquerorLogic.java
    │           │   ├── observation/
    │           │   │   └── ObservationLogic.java
    │           │   ├── HakiManager.java
    │           │   └── HakiType.java
    │           ├── item/
    │           │   ├── AwakeningCatalystItem.java
    │           │   └── DevilFruitItem.java
    │           ├── network/
    │           │   ├── packets/
    │           │   │   ├── c2s/
    │           │   │   │   └── ServerAbilityPacket.java
    │           │   │   ├── AbilityUsePacket.java
    │           │   │   ├── ActivateAbilityC2S.java
    │           │   │   ├── SyncBountyPacket.java
    │           │   │   ├── SyncFruitPacket.java
    │           │   │   ├── SyncHakiPacket.java
    │           │   │   ├── SyncStaminaS2C.java
    │           │   │   └── ToggleHakiC2S.java
    │           │   ├── ModNetwork.java
    │           │   └── NetworkHandler.java
    │           ├── raid/
    │           │   ├── RaidDifficultyScaler.java
    │           │   ├── RaidManager.java
    │           │   ├── RaidSpawner.java
    │           │   └── RaidType.java
    │           ├── registry/
    │           │   ├── ModEffects.java
    │           │   ├── ModEntities.java
    │           │   ├── ModItems.java
    │           │   ├── ModParticles.java
    │           │   ├── ModSounds.java
    │           │   └── ModStructures.java
    │           ├── systems/
    │           │   └── stamina/
    │           │       ├── PlayerStaminaData.java
    │           │       ├── PlayerStaminaProvider.java
    │           │       └── StaminaCapability.java
    │           ├── transformation/
    │           │   ├── Transformation.java
    │           │   └── ZoanTransformation.java
    │           ├── util/
    │           ├── weakness/
    │           │   ├── SeastoneHandler.java
    │           │   └── WaterWeaknessHandler.java
    │           ├── world/
    │           │   ├── biome/
    │           │   ├── dimension/
    │           │   ├── fruit/
    │           │   │   ├── DevilFruitWorldAccess.java
    │           │   │   ├── DevilFruitWorldCapability.java
    │           │   │   ├── DevilFruitWorldProvider.java
    │           │   │   └── DevilFruitWorldRegistry.java
    │           │   ├── loot/
    │           │   └── structure/
    │           │       ├── MarineBaseStructure.java
    │           │       ├── PirateShipStructure.java
    │           │       └── TempleStructure.java
    │           └── GrandLineApex.java
    ├── resources/
    │   ├── META-INF/
    │   │   └── mods.toml
    │   ├── assets/
    │   │   └── grandlineapex/
    │   │       ├── animations/
    │   │       ├── lang/
    │   │       ├── models/
    │   │       ├── particles/
    │   │       ├── sounds/
    │   │       └── textures/
    │   ├── data/
    │   │   └── grandlineapex/
    │   │       ├── loot_tables/
    │   │       ├── recipes/
    │   │       ├── structures/
    │   │       ├── tags/
    │   │       └── worldgen/
    │   └── pack.mcmeta
    └── project_structure.json
```


## File Descriptions

### `src/main/\java\com\grandlineapex\ability\Ability.java`

- What: [0] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\Ability.java}
- Does: [0] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\ability\Ability.java}
- Why: [0] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\Ability.java}

### `src/main/\java\com\grandlineapex\ability\AbilityContext.java`

- What: [1] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\AbilityContext.java}
- Does: [1] It executes logic through methods [AbilityContext] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\ability\AbilityContext.java}
- Why: [1] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\AbilityContext.java}

### `src/main/\java\com\grandlineapex\ability\ActiveAbility.java`

- What: [2] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\ActiveAbility.java}
- Does: [2] It executes logic through methods [id, name, cooldownTicks, staminaCost] and uses state [id, name, cooldown, stamina] where applicable. {PathToken=src/main/\java\com\grandlineapex\ability\ActiveAbility.java}
- Why: [2] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\ActiveAbility.java}

### `src/main/\java\com\grandlineapex\ability\CooldownAbility.java`

- What: [3] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\CooldownAbility.java}
- Does: [3] It executes logic through methods [scaleCooldownByMastery] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\ability\CooldownAbility.java}
- Why: [3] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\CooldownAbility.java}

### `src/main/\java\com\grandlineapex\ability\PassiveAbility.java`

- What: [4] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\PassiveAbility.java}
- Does: [4] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\ability\PassiveAbility.java}
- Why: [4] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\PassiveAbility.java}

### `src/main/\java\com\grandlineapex\ability\runtime\AbilityInstance.java`

- What: [5] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\runtime\AbilityInstance.java}
- Does: [5] It executes logic through methods [start, abilityId, fruitId, state] and uses state [fruitId, abilityId, tier, masterySnapshot] where applicable. {PathToken=src/main/\java\com\grandlineapex\ability\runtime\AbilityInstance.java}
- Why: [5] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\runtime\AbilityInstance.java}

### `src/main/\java\com\grandlineapex\ability\runtime\AbilityState.java`

- What: [6] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\ability\runtime\AbilityState.java}
- Does: [6] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\ability\runtime\AbilityState.java}
- Why: [6] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\ability\runtime\AbilityState.java}

### `src/main/\java\com\grandlineapex\attribute\ModAttributes.java`

- What: [7] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\attribute\ModAttributes.java}
- Does: [7] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\attribute\ModAttributes.java}
- Why: [7] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\attribute\ModAttributes.java}

### `src/main/\java\com\grandlineapex\bounty\BountyManager.java`

- What: [8] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyManager.java}
- Does: [8] It executes logic through methods [rewardForEntity, onEntityDefeated] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyManager.java}
- Why: [8] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyManager.java}

### `src/main/\java\com\grandlineapex\bounty\BountyRewardHandler.java`

- What: [9] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyRewardHandler.java}
- Does: [9] It executes logic through methods [onTierReached] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyRewardHandler.java}
- Why: [9] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyRewardHandler.java}

### `src/main/\java\com\grandlineapex\bounty\BountyTier.java`

- What: [10] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyTier.java}
- Does: [10] It executes logic through methods [minBounty, isAtLeast, fromBounty] and uses state [minBounty] where applicable. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyTier.java}
- Why: [10] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\bounty\BountyTier.java}

### `src/main/\java\com\grandlineapex\bounty\quest\BountyQuest.java`

- What: [11] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\bounty\quest\BountyQuest.java}
- Does: [11] It executes logic through methods [id, title, description, targetCount] and uses state [id, title, description, targetCount] where applicable. {PathToken=src/main/\java\com\grandlineapex\bounty\quest\BountyQuest.java}
- Why: [11] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\bounty\quest\BountyQuest.java}

### `src/main/\java\com\grandlineapex\bounty\quest\QuestGenerator.java`

- What: [12] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\bounty\quest\QuestGenerator.java}
- Does: [12] It executes logic through methods [generate] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\bounty\quest\QuestGenerator.java}
- Why: [12] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\bounty\quest\QuestGenerator.java}

### `src/main/\java\com\grandlineapex\capability\CapabilityRegistry.java`

- What: [13] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\CapabilityRegistry.java}
- Does: [13] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\CapabilityRegistry.java}
- Why: [13] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\CapabilityRegistry.java}

### `src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitCapability.java`

- What: [14] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitCapability.java}
- Does: [14] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitCapability.java}
- Why: [14] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitCapability.java}

### `src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitData.java`

- What: [15] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitData.java}
- Does: [15] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitData.java}
- Why: [15] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitData.java}

### `src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitProvider.java`

- What: [16] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitProvider.java}
- Does: [16] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitProvider.java}
- Why: [16] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\DevilFruitProvider.java}

### `src/main/\java\com\grandlineapex\capability\devilfruit\IDevilFruitData.java`

- What: [17] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\IDevilFruitData.java}
- Does: [17] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\IDevilFruitData.java}
- Why: [17] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\IDevilFruitData.java}

### `src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitData.java`

- What: [18] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitData.java}
- Does: [18] It executes logic through methods [getFruitId, getFruitIdValue, setFruitId, getMastery] and uses state [fruitId, mastery, awakened, submergedWeakness] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitData.java}
- Why: [18] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitData.java}

### `src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitProvider.java`

- What: [19] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitProvider.java}
- Does: [19] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitProvider.java}
- Why: [19] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\devilfruit\PlayerDevilFruitProvider.java}

### `src/main/\java\com\grandlineapex\capability\IPlayerData.java`

- What: [20] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\IPlayerData.java}
- Does: [20] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\IPlayerData.java}
- Why: [20] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\IPlayerData.java}

### `src/main/\java\com\grandlineapex\capability\player\AbilityRuntimeCapability.java`

- What: [21] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\AbilityRuntimeCapability.java}
- Does: [21] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\player\AbilityRuntimeCapability.java}
- Why: [21] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\AbilityRuntimeCapability.java}

### `src/main/\java\com\grandlineapex\capability\player\BountyCapability.java`

- What: [22] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\BountyCapability.java}
- Does: [22] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\player\BountyCapability.java}
- Why: [22] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\BountyCapability.java}

### `src/main/\java\com\grandlineapex\capability\player\CombatCapability.java`

- What: [23] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\CombatCapability.java}
- Does: [23] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\player\CombatCapability.java}
- Why: [23] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\CombatCapability.java}

### `src/main/\java\com\grandlineapex\capability\player\HakiCapability.java`

- What: [24] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\HakiCapability.java}
- Does: [24] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\player\HakiCapability.java}
- Why: [24] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\HakiCapability.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeData.java`

- What: [25] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeData.java}
- Does: [25] It executes logic through methods [isOnCooldown, canStart, start, tickAll] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeData.java}
- Why: [25] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeData.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeProvider.java`

- What: [26] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeProvider.java}
- Does: [26] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeProvider.java}
- Why: [26] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerAbilityRuntimeProvider.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerBountyData.java`

- What: [27] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerBountyData.java}
- Does: [27] It executes logic through methods [getBounty, getTier, addBounty, setBounty] and uses state [bounty, tier] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerBountyData.java}
- Why: [27] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerBountyData.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerBountyProvider.java`

- What: [28] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerBountyProvider.java}
- Does: [28] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerBountyProvider.java}
- Why: [28] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerBountyProvider.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerCombatData.java`

- What: [29] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerCombatData.java}
- Does: [29] It executes logic through methods [getFightingStyleId, setFightingStyleId, getStyleMastery, setStyleMastery] and uses state [fightingStyleId, styleMastery, comboCounter] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerCombatData.java}
- Why: [29] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerCombatData.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerCombatProvider.java`

- What: [30] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerCombatProvider.java}
- Does: [30] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerCombatProvider.java}
- Why: [30] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerCombatProvider.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerHakiData.java`

- What: [31] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerHakiData.java}
- Does: [31] It executes logic through methods [getMastery, setMastery, addMastery, isUnlocked] and uses state [activeType, active] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerHakiData.java}
- Why: [31] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerHakiData.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerHakiProvider.java`

- What: [32] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerHakiProvider.java}
- Does: [32] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerHakiProvider.java}
- Why: [32] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerHakiProvider.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerStatsData.java`

- What: [33] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerStatsData.java}
- Does: [33] It executes logic through methods [getStrength, addStrength, getDefense, addDefense] and uses state [strength, defense, agility] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerStatsData.java}
- Why: [33] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerStatsData.java}

### `src/main/\java\com\grandlineapex\capability\player\PlayerStatsProvider.java`

- What: [34] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerStatsProvider.java}
- Does: [34] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerStatsProvider.java}
- Why: [34] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\PlayerStatsProvider.java}

### `src/main/\java\com\grandlineapex\capability\player\StatsCapability.java`

- What: [35] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\player\StatsCapability.java}
- Does: [35] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\player\StatsCapability.java}
- Why: [35] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\player\StatsCapability.java}

### `src/main/\java\com\grandlineapex\capability\PlayerData.java`

- What: [36] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerData.java}
- Does: [36] It executes logic through methods [hasFruit, setFruit, fruitId, masteryLevel] and uses state [hasFruit, fruitId, masteryLevel, armamentUnlocked] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerData.java}
- Why: [36] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerData.java}

### `src/main/\java\com\grandlineapex\capability\PlayerDataProvider.java`

- What: [37] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerDataProvider.java}
- Does: [37] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerDataProvider.java}
- Why: [37] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerDataProvider.java}

### `src/main/\java\com\grandlineapex\capability\PlayerDataStorage.java`

- What: [38] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerDataStorage.java}
- Does: [38] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerDataStorage.java}
- Why: [38] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\capability\PlayerDataStorage.java}

### `src/main/\java\com\grandlineapex\client\ClientBountyData.java`

- What: [39] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\ClientBountyData.java}
- Does: [39] It executes logic through methods [set, get] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\ClientBountyData.java}
- Why: [39] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\ClientBountyData.java}

### `src/main/\java\com\grandlineapex\client\ClientFruitData.java`

- What: [40] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\ClientFruitData.java}
- Does: [40] It executes logic through methods [set, getFruitId, getMastery, isAwakened] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\ClientFruitData.java}
- Why: [40] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\ClientFruitData.java}

### `src/main/\java\com\grandlineapex\client\ClientHakiData.java`

- What: [41] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\ClientHakiData.java}
- Does: [41] It executes logic through methods [set, getType, getMastery, isActive] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\ClientHakiData.java}
- Why: [41] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\ClientHakiData.java}

### `src/main/\java\com\grandlineapex\client\ClientKeybinds.java`

- What: [42] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\ClientKeybinds.java}
- Does: [42] It executes logic through methods [registerKeys] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\ClientKeybinds.java}
- Why: [42] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\ClientKeybinds.java}

### `src/main/\java\com\grandlineapex\client\ClientSetup.java`

- What: [43] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\ClientSetup.java}
- Does: [43] It executes logic through methods [onRegisterOverlays] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\ClientSetup.java}
- Why: [43] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\ClientSetup.java}

### `src/main/\java\com\grandlineapex\client\ClientStaminaData.java`

- What: [44] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\ClientStaminaData.java}
- Does: [44] It executes logic through methods [set, getCurrent, getMax, getRatio] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\ClientStaminaData.java}
- Why: [44] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\ClientStaminaData.java}

### `src/main/\java\com\grandlineapex\client\hud\AbilityWheelScreen.java`

- What: [45] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\hud\AbilityWheelScreen.java}
- Does: [45] It executes logic through methods [isPauseScreen, tick, render, isMouseOverSlot] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\hud\AbilityWheelScreen.java}
- Why: [45] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\hud\AbilityWheelScreen.java}

### `src/main/\java\com\grandlineapex\client\hud\HakiScreen.java`

- What: [46] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\hud\HakiScreen.java}
- Does: [46] It executes logic through methods [render, isPauseScreen] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\hud\HakiScreen.java}
- Why: [46] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\hud\HakiScreen.java}

### `src/main/\java\com\grandlineapex\client\hud\MasteryScreen.java`

- What: [47] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\hud\MasteryScreen.java}
- Does: [47] It executes logic through methods [render, isPauseScreen] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\hud\MasteryScreen.java}
- Why: [47] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\hud\MasteryScreen.java}

### `src/main/\java\com\grandlineapex\client\hud\StaminaHudOverlay.java`

- What: [48] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\hud\StaminaHudOverlay.java}
- Does: [48] It executes logic through methods [fill] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\hud\StaminaHudOverlay.java}
- Why: [48] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\hud\StaminaHudOverlay.java}

### `src/main/\java\com\grandlineapex\client\input\ClientInputHandler.java`

- What: [49] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\client\input\ClientInputHandler.java}
- Does: [49] It executes logic through methods [onClientTick] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\client\input\ClientInputHandler.java}
- Why: [49] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\client\input\ClientInputHandler.java}

### `src/main/\java\com\grandlineapex\combat\CombatManager.java`

- What: [50] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\CombatManager.java}
- Does: [50] It executes logic through methods [modifyOutgoingDamage, modifyIncomingDamage] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\CombatManager.java}
- Why: [50] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\CombatManager.java}

### `src/main/\java\com\grandlineapex\combat\element\ElementResolver.java`

- What: [51] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\element\ElementResolver.java}
- Does: [51] It executes logic through methods [byFruit, isImmune] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\element\ElementResolver.java}
- Why: [51] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\element\ElementResolver.java}

### `src/main/\java\com\grandlineapex\combat\element\ElementTag.java`

- What: [52] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\element\ElementTag.java}
- Does: [52] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\combat\element\ElementTag.java}
- Why: [52] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\element\ElementTag.java}

### `src/main/\java\com\grandlineapex\combat\energy\CooldownHandler.java`

- What: [53] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\energy\CooldownHandler.java}
- Does: [53] It executes logic through methods [tick, tickCooldowns, key, set] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\energy\CooldownHandler.java}
- Why: [53] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\energy\CooldownHandler.java}

### `src/main/\java\com\grandlineapex\combat\energy\EnergyHandler.java`

- What: [54] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\energy\EnergyHandler.java}
- Does: [54] It executes logic through methods [getEnergy, spendEnergy, regenEnergy] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\energy\EnergyHandler.java}
- Why: [54] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\energy\EnergyHandler.java}

### `src/main/\java\com\grandlineapex\combat\FightingStyle.java`

- What: [55] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\FightingStyle.java}
- Does: [55] It executes logic through methods [byId] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\FightingStyle.java}
- Why: [55] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\FightingStyle.java}

### `src/main/\java\com\grandlineapex\combat\scaling\PowerScalingHandler.java`

- What: [56] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\scaling\PowerScalingHandler.java}
- Does: [56] It executes logic through methods [apply] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\scaling\PowerScalingHandler.java}
- Why: [56] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\scaling\PowerScalingHandler.java}

### `src/main/\java\com\grandlineapex\combat\styles\BrawlerStyle.java`

- What: [57] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\styles\BrawlerStyle.java}
- Does: [57] It executes logic through methods [id, damageMultiplier, staminaCostMultiplier, unlockTier] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\styles\BrawlerStyle.java}
- Why: [57] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\styles\BrawlerStyle.java}

### `src/main/\java\com\grandlineapex\combat\styles\SwordsmanStyle.java`

- What: [58] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\combat\styles\SwordsmanStyle.java}
- Does: [58] It executes logic through methods [id, damageMultiplier, staminaCostMultiplier, unlockTier] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\combat\styles\SwordsmanStyle.java}
- Why: [58] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\combat\styles\SwordsmanStyle.java}

### `src/main/\java\com\grandlineapex\core\hooks\TickEvents.java`

- What: [59] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\core\hooks\TickEvents.java}
- Does: [59] It executes logic through methods [onServerTick, onClientTick] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\core\hooks\TickEvents.java}
- Why: [59] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\core\hooks\TickEvents.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\Ability.java`

- What: [60] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\Ability.java}
- Does: [60] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\Ability.java}
- Why: [60] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\Ability.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityBootstrap.java`

- What: [61] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityBootstrap.java}
- Does: [61] It executes logic through methods [init] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityBootstrap.java}
- Why: [61] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityBootstrap.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityCooldownTracker.java`

- What: [62] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityCooldownTracker.java}
- Does: [62] It executes logic through methods [isOnCooldown, setCooldown] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityCooldownTracker.java}
- Why: [62] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityCooldownTracker.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityManager.java`

- What: [63] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityManager.java}
- Does: [63] It executes logic through methods [executeValidated] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityManager.java}
- Why: [63] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityManager.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityRegistry.java`

- What: [64] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityRegistry.java}
- Does: [64] It executes logic through methods [register, get, all] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityRegistry.java}
- Why: [64] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityRegistry.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityTier.java`

- What: [65] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityTier.java}
- Does: [65] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityTier.java}
- Why: [65] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityTier.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityType.java`

- What: [66] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityType.java}
- Does: [66] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityType.java}
- Why: [66] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbilityType.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\AbstractAbility.java`

- What: [67] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbstractAbility.java}
- Does: [67] It executes logic through methods [id, tier, type, baseCooldownTicks] and uses state [id, tier, type, cooldown] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbstractAbility.java}
- Why: [67] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\AbstractAbility.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\AOEEffect.java`

- What: [68] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\AOEEffect.java}
- Does: [68] It executes logic through methods [blast] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\AOEEffect.java}
- Why: [68] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\AOEEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\BuffEffect.java`

- What: [69] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\BuffEffect.java}
- Does: [69] It executes logic through methods [apply] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\BuffEffect.java}
- Why: [69] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\BuffEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\DebuffEffect.java`

- What: [70] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\DebuffEffect.java}
- Does: [70] It executes logic through methods [applyInRadius] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\DebuffEffect.java}
- Why: [70] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\DebuffEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\MeleeEffect.java`

- What: [71] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\MeleeEffect.java}
- Does: [71] It executes logic through methods [strikeInFront, strikeSphere] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\MeleeEffect.java}
- Why: [71] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\MeleeEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\ProjectileEffect.java`

- What: [72] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\ProjectileEffect.java}
- Does: [72] It executes logic through methods [shootFireball, shootSnowball] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\ProjectileEffect.java}
- Why: [72] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\ProjectileEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\SummonEffect.java`

- What: [73] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\SummonEffect.java}
- Does: [73] It executes logic through methods [summonAround] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\SummonEffect.java}
- Why: [73] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\SummonEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TeleportEffect.java`

- What: [74] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TeleportEffect.java}
- Does: [74] It executes logic through methods [blinkForward] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TeleportEffect.java}
- Why: [74] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TeleportEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TransformEffect.java`

- What: [75] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TransformEffect.java}
- Does: [75] It executes logic through methods [zoanForm] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TransformEffect.java}
- Why: [75] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\effects\TransformEffect.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\common\BaseAbility.java`

- What: [76] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\common\BaseAbility.java}
- Does: [76] It executes logic through methods [id, tier, baseCooldownTicks, staminaCost] and uses state [id, tier, cooldown, stamina] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\common\BaseAbility.java}
- Why: [76] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\common\BaseAbility.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeAwakening.java`

- What: [77] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeAwakening.java}
- Does: [77] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeAwakening.java}
- Why: [77] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeAwakening.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeCharge.java`

- What: [78] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeCharge.java}
- Does: [78] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeCharge.java}
- Why: [78] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\GiraffeCharge.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\NeckWhip.java`

- What: [79] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\NeckWhip.java}
- Does: [79] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\NeckWhip.java}
- Why: [79] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\NeckWhip.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\PastaMachine.java`

- What: [80] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\PastaMachine.java}
- Does: [80] It executes logic through methods [activeDurationTicks, onActivate, onActiveTick, execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\PastaMachine.java}
- Why: [80] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\giraffe\PastaMachine.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuBazooka.java`

- What: [81] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuBazooka.java}
- Does: [81] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuBazooka.java}
- Why: [81] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuBazooka.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGatling.java`

- What: [82] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGatling.java}
- Does: [82] It executes logic through methods [activeDurationTicks, onActivate, onActiveTick, execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGatling.java}
- Why: [82] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGatling.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGigant.java`

- What: [83] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGigant.java}
- Does: [83] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGigant.java}
- Why: [83] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuGigant.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuPistol.java`

- What: [84] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuPistol.java}
- Does: [84] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuPistol.java}
- Why: [84] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\gomu\GomuPistol.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceAge.java`

- What: [85] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceAge.java}
- Does: [85] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceAge.java}
- Why: [85] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceAge.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceSpear.java`

- What: [86] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceSpear.java}
- Does: [86] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceSpear.java}
- Why: [86] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceSpear.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceWall.java`

- What: [87] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceWall.java}
- Does: [87] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceWall.java}
- Why: [87] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\IceWall.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\PheasantBeak.java`

- What: [88] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\PheasantBeak.java}
- Does: [88] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\PheasantBeak.java}
- Why: [88] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\hie\PheasantBeak.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\DaiEnkai.java`

- What: [89] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\DaiEnkai.java}
- Does: [89] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\DaiEnkai.java}
- Why: [89] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\DaiEnkai.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FireFist.java`

- What: [90] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FireFist.java}
- Does: [90] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FireFist.java}
- Why: [90] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FireFist.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameBurst.java`

- What: [91] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameBurst.java}
- Does: [91] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameBurst.java}
- Why: [91] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameBurst.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameStep.java`

- What: [92] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameStep.java}
- Does: [92] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameStep.java}
- Why: [92] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\mera\FlameStep.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\GammaKnife.java`

- What: [93] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\GammaKnife.java}
- Does: [93] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\GammaKnife.java}
- Why: [93] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\GammaKnife.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Room.java`

- What: [94] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Room.java}
- Does: [94] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Room.java}
- Why: [94] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Room.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Shambles.java`

- What: [95] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Shambles.java}
- Does: [95] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Shambles.java}
- Why: [95] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Shambles.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Tact.java`

- What: [96] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Tact.java}
- Does: [96] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Tact.java}
- Why: [96] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\ope\Tact.java}

### `src/main/\java\com\grandlineapex\devilfruit\abilities\impl\test\T1_Jab.java`

- What: [97] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\test\T1_Jab.java}
- Does: [97] It executes logic through methods [execute] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\test\T1_Jab.java}
- Why: [97] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\abilities\impl\test\T1_Jab.java}

### `src/main/\java\com\grandlineapex\devilfruit\adapters\FruitAbilityAdapter.java`

- What: [98] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\adapters\FruitAbilityAdapter.java}
- Does: [98] It executes logic through methods [FruitAbilityAdapter, onUse, getCooldown, getId] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\adapters\FruitAbilityAdapter.java}
- Why: [98] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\adapters\FruitAbilityAdapter.java}

### `src/main/\java\com\grandlineapex\devilfruit\api\IDevilFruit.java`

- What: [99] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\api\IDevilFruit.java}
- Does: [99] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\api\IDevilFruit.java}
- Why: [99] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\api\IDevilFruit.java}

### `src/main/\java\com\grandlineapex\devilfruit\api\IFruitAbility.java`

- What: [100] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\api\IFruitAbility.java}
- Does: [100] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\api\IFruitAbility.java}
- Why: [100] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\api\IFruitAbility.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningHandler.java`

- What: [101] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningHandler.java}
- Does: [101] It executes logic through methods [meetsAllRequirements, tryAwaken, tick, staminaMultiplier] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningHandler.java}
- Why: [101] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningHandler.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningRequirement.java`

- What: [102] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningRequirement.java}
- Does: [102] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningRequirement.java}
- Why: [102] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\AwakeningRequirement.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BossDefeatAwakeningRequirement.java`

- What: [103] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BossDefeatAwakeningRequirement.java}
- Does: [103] It executes logic through methods [id, isMet] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BossDefeatAwakeningRequirement.java}
- Why: [103] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BossDefeatAwakeningRequirement.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BountyAwakeningRequirement.java`

- What: [104] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BountyAwakeningRequirement.java}
- Does: [104] It executes logic through methods [id, isMet] and uses state [minimumTier] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BountyAwakeningRequirement.java}
- Why: [104] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\BountyAwakeningRequirement.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\ConquerorUnlockAwakeningRequirement.java`

- What: [105] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\ConquerorUnlockAwakeningRequirement.java}
- Does: [105] It executes logic through methods [id, isMet] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\ConquerorUnlockAwakeningRequirement.java}
- Why: [105] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\ConquerorUnlockAwakeningRequirement.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\MasteryAwakeningRequirement.java`

- What: [106] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\MasteryAwakeningRequirement.java}
- Does: [106] It executes logic through methods [id, isMet] and uses state [threshold] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\MasteryAwakeningRequirement.java}
- Why: [106] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\MasteryAwakeningRequirement.java}

### `src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\SpecialItemAwakeningRequirement.java`

- What: [107] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\SpecialItemAwakeningRequirement.java}
- Does: [107] It executes logic through methods [id, isMet] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\SpecialItemAwakeningRequirement.java}
- Why: [107] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\awakening\requirements\SpecialItemAwakeningRequirement.java}

### `src/main/\java\com\grandlineapex\devilfruit\DevilFruit.java`

- What: [108] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\DevilFruit.java}
- Does: [108] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\DevilFruit.java}
- Why: [108] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\DevilFruit.java}

### `src/main/\java\com\grandlineapex\devilfruit\FruitBootstrap.java`

- What: [109] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitBootstrap.java}
- Does: [109] It executes logic through methods [init, register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitBootstrap.java}
- Why: [109] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitBootstrap.java}

### `src/main/\java\com\grandlineapex\devilfruit\FruitRegistry.java`

- What: [110] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitRegistry.java}
- Does: [110] It executes logic through methods [register, get, all] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitRegistry.java}
- Why: [110] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitRegistry.java}

### `src/main/\java\com\grandlineapex\devilfruit\fruits\logia\HieHieNoMi.java`

- What: [111] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\logia\HieHieNoMi.java}
- Does: [111] It executes logic through methods [id, type, tickPassive, abilities] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\logia\HieHieNoMi.java}
- Why: [111] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\logia\HieHieNoMi.java}

### `src/main/\java\com\grandlineapex\devilfruit\fruits\logia\MeraMeraNoMi.java`

- What: [112] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\logia\MeraMeraNoMi.java}
- Does: [112] It executes logic through methods [id, type, tickPassive, abilities] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\logia\MeraMeraNoMi.java}
- Why: [112] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\logia\MeraMeraNoMi.java}

### `src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\GomuGomuNoMi.java`

- What: [113] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\GomuGomuNoMi.java}
- Does: [113] It executes logic through methods [id, type, tickPassive, abilities] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\GomuGomuNoMi.java}
- Why: [113] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\GomuGomuNoMi.java}

### `src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\OpeOpeNoMi.java`

- What: [114] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\OpeOpeNoMi.java}
- Does: [114] It executes logic through methods [id, type, tickPassive, abilities] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\OpeOpeNoMi.java}
- Why: [114] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\paramecia\OpeOpeNoMi.java}

### `src/main/\java\com\grandlineapex\devilfruit\fruits\zoan\UshiUshiNoMiModelGiraffe.java`

- What: [115] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\zoan\UshiUshiNoMiModelGiraffe.java}
- Does: [115] It executes logic through methods [id, type, tickPassive, abilities] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\zoan\UshiUshiNoMiModelGiraffe.java}
- Why: [115] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\fruits\zoan\UshiUshiNoMiModelGiraffe.java}

### `src/main/\java\com\grandlineapex\devilfruit\FruitType.java`

- What: [116] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitType.java}
- Does: [116] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitType.java}
- Why: [116] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\FruitType.java}

### `src/main/\java\com\grandlineapex\devilfruit\progression\FruitProgressionData.java`

- What: [117] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\progression\FruitProgressionData.java}
- Does: [117] It executes logic through methods [mastery, xp, addXp, xpToNextLevel] and uses state [mastery, xp] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\progression\FruitProgressionData.java}
- Why: [117] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\progression\FruitProgressionData.java}

### `src/main/\java\com\grandlineapex\devilfruit\progression\IFruitProgression.java`

- What: [118] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\progression\IFruitProgression.java}
- Does: [118] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\devilfruit\progression\IFruitProgression.java}
- Why: [118] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\progression\IFruitProgression.java}

### `src/main/\java\com\grandlineapex\devilfruit\TestFruit.java`

- What: [119] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\devilfruit\TestFruit.java}
- Does: [119] It executes logic through methods [abilities, register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\devilfruit\TestFruit.java}
- Why: [119] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\devilfruit\TestFruit.java}

### `src/main/\java\com\grandlineapex\events\CombatEvents.java`

- What: [120] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\events\CombatEvents.java}
- Does: [120] It executes logic through methods [onEntityHurt, maybeApplyElementCounter, isLogiaIntangible, onEntityDeath] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\events\CombatEvents.java}
- Why: [120] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\events\CombatEvents.java}

### `src/main/\java\com\grandlineapex\events\CombatHookEvent.java`

- What: [121] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\events\CombatHookEvent.java}
- Does: [121] It executes logic through methods [attacker, defender, amount, setAmount] and uses state [attacker, defender, amount] where applicable. {PathToken=src/main/\java\com\grandlineapex\events\CombatHookEvent.java}
- Why: [121] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\events\CombatHookEvent.java}

### `src/main/\java\com\grandlineapex\events\DevilFruitEvents.java`

- What: [122] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\events\DevilFruitEvents.java}
- Does: [122] It executes logic through methods [onPlayerTick] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\events\DevilFruitEvents.java}
- Why: [122] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\events\DevilFruitEvents.java}

### `src/main/\java\com\grandlineapex\events\HakiEvents.java`

- What: [123] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\events\HakiEvents.java}
- Does: [123] It executes logic through methods [onPlayerAttack, onPlayerTick] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\events\HakiEvents.java}
- Why: [123] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\events\HakiEvents.java}

### `src/main/\java\com\grandlineapex\events\PlayerEvents.java`

- What: [124] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\events\PlayerEvents.java}
- Does: [124] It executes logic through methods [attachCapabilities, clone, tick] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\events\PlayerEvents.java}
- Why: [124] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\events\PlayerEvents.java}

### `src/main/\java\com\grandlineapex\events\WorldEvents.java`

- What: [125] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\events\WorldEvents.java}
- Does: [125] It executes logic through methods [attachLevelCapabilities, onServerTick, onPlayerDeath] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\events\WorldEvents.java}
- Why: [125] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\events\WorldEvents.java}

### `src/main/\java\com\grandlineapex\fruit\DevilFruit.java`

- What: [126] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\fruit\DevilFruit.java}
- Does: [126] It executes logic through methods [hasWaterWeakness, hasSeastoneWeakness, onEat, onRemove] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\fruit\DevilFruit.java}
- Why: [126] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\fruit\DevilFruit.java}

### `src/main/\java\com\grandlineapex\fruit\FruitRegistry.java`

- What: [127] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\fruit\FruitRegistry.java}
- Does: [127] It executes logic through methods [register, get, all] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\fruit\FruitRegistry.java}
- Why: [127] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\fruit\FruitRegistry.java}

### `src/main/\java\com\grandlineapex\fruit\FruitType.java`

- What: [128] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\fruit\FruitType.java}
- Does: [128] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\fruit\FruitType.java}
- Why: [128] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\fruit\FruitType.java}

### `src/main/\java\com\grandlineapex\fruit\LegacyFruitAdapter.java`

- What: [129] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\fruit\LegacyFruitAdapter.java}
- Does: [129] It executes logic through methods [id, displayName, type, abilities] and uses state [legacy] where applicable. {PathToken=src/main/\java\com\grandlineapex\fruit\LegacyFruitAdapter.java}
- Why: [129] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\fruit\LegacyFruitAdapter.java}

### `src/main/\java\com\grandlineapex\GrandLineApex.java`

- What: [130] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\GrandLineApex.java}
- Does: [130] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\GrandLineApex.java}
- Why: [130] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\GrandLineApex.java}

### `src/main/\java\com\grandlineapex\haki\armament\ArmamentLogic.java`

- What: [131] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\haki\armament\ArmamentLogic.java}
- Does: [131] It executes logic through methods [attackMultiplier, defenseMultiplier] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\haki\armament\ArmamentLogic.java}
- Why: [131] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\haki\armament\ArmamentLogic.java}

### `src/main/\java\com\grandlineapex\haki\conqueror\ConquerorLogic.java`

- What: [132] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\haki\conqueror\ConquerorLogic.java}
- Does: [132] It executes logic through methods [intimidationDamageBonus] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\haki\conqueror\ConquerorLogic.java}
- Why: [132] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\haki\conqueror\ConquerorLogic.java}

### `src/main/\java\com\grandlineapex\haki\HakiManager.java`

- What: [133] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\haki\HakiManager.java}
- Does: [133] It executes logic through methods [unlockTier, canUnlock, getActiveMastery] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\haki\HakiManager.java}
- Why: [133] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\haki\HakiManager.java}

### `src/main/\java\com\grandlineapex\haki\HakiType.java`

- What: [134] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\haki\HakiType.java}
- Does: [134] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\haki\HakiType.java}
- Why: [134] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\haki\HakiType.java}

### `src/main/\java\com\grandlineapex\haki\observation\ObservationLogic.java`

- What: [135] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\haki\observation\ObservationLogic.java}
- Does: [135] It executes logic through methods [evadeChance] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\haki\observation\ObservationLogic.java}
- Why: [135] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\haki\observation\ObservationLogic.java}

### `src/main/\java\com\grandlineapex\item\AwakeningCatalystItem.java`

- What: [136] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\item\AwakeningCatalystItem.java}
- Does: [136] It executes logic through methods [use] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\item\AwakeningCatalystItem.java}
- Why: [136] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\item\AwakeningCatalystItem.java}

### `src/main/\java\com\grandlineapex\item\DevilFruitItem.java`

- What: [137] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\item\DevilFruitItem.java}
- Does: [137] It executes logic through methods [fruitId, use] and uses state [fruitId] where applicable. {PathToken=src/main/\java\com\grandlineapex\item\DevilFruitItem.java}
- Why: [137] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\item\DevilFruitItem.java}

### `src/main/\java\com\grandlineapex\network\ModNetwork.java`

- What: [138] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\ModNetwork.java}
- Does: [138] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\ModNetwork.java}
- Why: [138] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\ModNetwork.java}

### `src/main/\java\com\grandlineapex\network\NetworkHandler.java`

- What: [139] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\NetworkHandler.java}
- Does: [139] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\NetworkHandler.java}
- Why: [139] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\NetworkHandler.java}

### `src/main/\java\com\grandlineapex\network\packets\AbilityUsePacket.java`

- What: [140] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\AbilityUsePacket.java}
- Does: [140] It executes logic through methods [encode, decode, handle] and uses state [fruitId, tier] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\AbilityUsePacket.java}
- Why: [140] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\AbilityUsePacket.java}

### `src/main/\java\com\grandlineapex\network\packets\ActivateAbilityC2S.java`

- What: [141] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\ActivateAbilityC2S.java}
- Does: [141] It executes logic through methods [encode, decode, handle] and uses state [fruitId, tier] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\ActivateAbilityC2S.java}
- Why: [141] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\ActivateAbilityC2S.java}

### `src/main/\java\com\grandlineapex\network\packets\c2s\ServerAbilityPacket.java`

- What: [142] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\c2s\ServerAbilityPacket.java}
- Does: [142] It executes logic through methods [encode, decode, handle] and uses state [fruitId, tier] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\c2s\ServerAbilityPacket.java}
- Why: [142] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\c2s\ServerAbilityPacket.java}

### `src/main/\java\com\grandlineapex\network\packets\SyncBountyPacket.java`

- What: [143] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncBountyPacket.java}
- Does: [143] It executes logic through methods [encode, decode, handle] and uses state [bounty] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncBountyPacket.java}
- Why: [143] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncBountyPacket.java}

### `src/main/\java\com\grandlineapex\network\packets\SyncFruitPacket.java`

- What: [144] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncFruitPacket.java}
- Does: [144] It executes logic through methods [encode, decode, handle] and uses state [fruitId, mastery, awakened] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncFruitPacket.java}
- Why: [144] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncFruitPacket.java}

### `src/main/\java\com\grandlineapex\network\packets\SyncHakiPacket.java`

- What: [145] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncHakiPacket.java}
- Does: [145] It executes logic through methods [encode, decode, handle] and uses state [type, mastery, active] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncHakiPacket.java}
- Why: [145] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncHakiPacket.java}

### `src/main/\java\com\grandlineapex\network\packets\SyncStaminaS2C.java`

- What: [146] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncStaminaS2C.java}
- Does: [146] It executes logic through methods [encode, decode, handle] and uses state [current, max] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncStaminaS2C.java}
- Why: [146] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\SyncStaminaS2C.java}

### `src/main/\java\com\grandlineapex\network\packets\ToggleHakiC2S.java`

- What: [147] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\network\packets\ToggleHakiC2S.java}
- Does: [147] It executes logic through methods [encode, decode, handle] and uses state [type] where applicable. {PathToken=src/main/\java\com\grandlineapex\network\packets\ToggleHakiC2S.java}
- Why: [147] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\network\packets\ToggleHakiC2S.java}

### `src/main/\java\com\grandlineapex\raid\RaidDifficultyScaler.java`

- What: [148] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\raid\RaidDifficultyScaler.java}
- Does: [148] It executes logic through methods [difficultyFor] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\raid\RaidDifficultyScaler.java}
- Why: [148] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\raid\RaidDifficultyScaler.java}

### `src/main/\java\com\grandlineapex\raid\RaidManager.java`

- What: [149] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\raid\RaidManager.java}
- Does: [149] It executes logic through methods [onServerTick, triggerRaidForPlayer] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\raid\RaidManager.java}
- Why: [149] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\raid\RaidManager.java}

### `src/main/\java\com\grandlineapex\raid\RaidSpawner.java`

- What: [150] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\raid\RaidSpawner.java}
- Does: [150] It executes logic through methods [spawnWave] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\raid\RaidSpawner.java}
- Why: [150] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\raid\RaidSpawner.java}

### `src/main/\java\com\grandlineapex\raid\RaidType.java`

- What: [151] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\raid\RaidType.java}
- Does: [151] It executes logic through methods [baseMultiplier] and uses state [baseMultiplier] where applicable. {PathToken=src/main/\java\com\grandlineapex\raid\RaidType.java}
- Why: [151] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\raid\RaidType.java}

### `src/main/\java\com\grandlineapex\registry\ModEffects.java`

- What: [152] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\registry\ModEffects.java}
- Does: [152] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\registry\ModEffects.java}
- Why: [152] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\registry\ModEffects.java}

### `src/main/\java\com\grandlineapex\registry\ModEntities.java`

- What: [153] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\registry\ModEntities.java}
- Does: [153] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\registry\ModEntities.java}
- Why: [153] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\registry\ModEntities.java}

### `src/main/\java\com\grandlineapex\registry\ModItems.java`

- What: [154] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\registry\ModItems.java}
- Does: [154] It executes logic through methods [registerDevilFruitItem, stackForFruit, register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\registry\ModItems.java}
- Why: [154] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\registry\ModItems.java}

### `src/main/\java\com\grandlineapex\registry\ModParticles.java`

- What: [155] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\registry\ModParticles.java}
- Does: [155] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\registry\ModParticles.java}
- Why: [155] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\registry\ModParticles.java}

### `src/main/\java\com\grandlineapex\registry\ModSounds.java`

- What: [156] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\registry\ModSounds.java}
- Does: [156] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\registry\ModSounds.java}
- Why: [156] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\registry\ModSounds.java}

### `src/main/\java\com\grandlineapex\registry\ModStructures.java`

- What: [157] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\registry\ModStructures.java}
- Does: [157] It executes logic through methods [register] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\registry\ModStructures.java}
- Why: [157] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\registry\ModStructures.java}

### `src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaData.java`

- What: [158] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaData.java}
- Does: [158] It executes logic through methods [getCurrent, getMax, setMax, set] and uses state [current, max, regenPerSecond, regenDelayTicks] where applicable. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaData.java}
- Why: [158] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaData.java}

### `src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaProvider.java`

- What: [159] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaProvider.java}
- Does: [159] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaProvider.java}
- Why: [159] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\PlayerStaminaProvider.java}

### `src/main/\java\com\grandlineapex\systems\stamina\StaminaCapability.java`

- What: [160] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\StaminaCapability.java}
- Does: [160] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\StaminaCapability.java}
- Why: [160] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\systems\stamina\StaminaCapability.java}

### `src/main/\java\com\grandlineapex\transformation\Transformation.java`

- What: [161] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\transformation\Transformation.java}
- Does: [161] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\transformation\Transformation.java}
- Why: [161] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\transformation\Transformation.java}

### `src/main/\java\com\grandlineapex\transformation\ZoanTransformation.java`

- What: [162] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\transformation\ZoanTransformation.java}
- Does: [162] It executes logic through methods [id, onStart, onEnd] and uses state [id, activeEffects] where applicable. {PathToken=src/main/\java\com\grandlineapex\transformation\ZoanTransformation.java}
- Why: [162] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\transformation\ZoanTransformation.java}

### `src/main/\java\com\grandlineapex\weakness\SeastoneHandler.java`

- What: [163] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\weakness\SeastoneHandler.java}
- Does: [163] It executes logic through methods [isWeakened, apply] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\weakness\SeastoneHandler.java}
- Why: [163] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\weakness\SeastoneHandler.java}

### `src/main/\java\com\grandlineapex\weakness\WaterWeaknessHandler.java`

- What: [164] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\weakness\WaterWeaknessHandler.java}
- Does: [164] It executes logic through methods [isWeakened, apply] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\weakness\WaterWeaknessHandler.java}
- Why: [164] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\weakness\WaterWeaknessHandler.java}

### `src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldAccess.java`

- What: [165] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldAccess.java}
- Does: [165] It executes logic through methods [get] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldAccess.java}
- Why: [165] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldAccess.java}

### `src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldCapability.java`

- What: [166] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldCapability.java}
- Does: [166] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldCapability.java}
- Why: [166] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldCapability.java}

### `src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldProvider.java`

- What: [167] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldProvider.java}
- Does: [167] It executes logic through methods [serializeNBT, deserializeNBT] and uses state [data, optional] where applicable. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldProvider.java}
- Why: [167] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldProvider.java}

### `src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldRegistry.java`

- What: [168] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldRegistry.java}
- Does: [168] It executes logic through methods [isConsumed, isOnCooldown, isAvailable, tryConsume] and uses state [] where applicable. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldRegistry.java}
- Why: [168] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\fruit\DevilFruitWorldRegistry.java}

### `src/main/\java\com\grandlineapex\world\structure\MarineBaseStructure.java`

- What: [169] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\structure\MarineBaseStructure.java}
- Does: [169] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\world\structure\MarineBaseStructure.java}
- Why: [169] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\structure\MarineBaseStructure.java}

### `src/main/\java\com\grandlineapex\world\structure\PirateShipStructure.java`

- What: [170] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\structure\PirateShipStructure.java}
- Does: [170] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\world\structure\PirateShipStructure.java}
- Why: [170] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\structure\PirateShipStructure.java}

### `src/main/\java\com\grandlineapex\world\structure\TempleStructure.java`

- What: [171] $leaf defines $decl in package $(System.Collections.Specialized.OrderedDictionary.pkg) for this mod subsystem. {PathToken=src/main/\java\com\grandlineapex\world\structure\TempleStructure.java}
- Does: [171] It provides static type/config glue for its package and integration points. {PathToken=src/main/\java\com\grandlineapex\world\structure\TempleStructure.java}
- Why: [171] You keep $leaf to isolate one responsibility and avoid coupling unrelated gameplay logic into larger classes. {PathToken=src/main/\java\com\grandlineapex\world\structure\TempleStructure.java}

### `src/main/\project_structure.md`

- What: [172] $leaf is a non-Java file located at src/main/\project_structure.md. {PathToken=src/main/\project_structure.md}
- Does: [172] It supplies resource/documentation data consumed by runtime or tooling from this path. {PathToken=src/main/\project_structure.md}
- Why: [172] You keep $leaf because the game/tooling expects this artifact in the project layout. {PathToken=src/main/\project_structure.md}

### `src/main/\resources\META-INF\mods.toml`

- What: [173] $leaf is a non-Java file located at src/main/\resources\META-INF\mods.toml. {PathToken=src/main/\resources\META-INF\mods.toml}
- Does: [173] It supplies resource/documentation data consumed by runtime or tooling from this path. {PathToken=src/main/\resources\META-INF\mods.toml}
- Why: [173] You keep $leaf because the game/tooling expects this artifact in the project layout. {PathToken=src/main/\resources\META-INF\mods.toml}

### `src/main/\resources\pack.mcmeta`

- What: [174] $leaf is a non-Java file located at src/main/\resources\pack.mcmeta. {PathToken=src/main/\resources\pack.mcmeta}
- Does: [174] It supplies resource/documentation data consumed by runtime or tooling from this path. {PathToken=src/main/\resources\pack.mcmeta}
- Why: [174] You keep $leaf because the game/tooling expects this artifact in the project layout. {PathToken=src/main/\resources\pack.mcmeta}

