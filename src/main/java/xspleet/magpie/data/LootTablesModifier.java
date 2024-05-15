package xspleet.magpie.data;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.util.Identifier;
import xspleet.magpie.MagpieMod;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import xspleet.magpie.item.ModItems;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;


public class LootTablesModifier
{
    private static final Identifier PILLAGER_OUTPOST_CHEST_ID =
            new Identifier("minecraft", "chests/pillager_outpost");
    private static final Identifier STRONGHOLD_LIBRARY_CHEST_ID =
            new Identifier("minecraft", "chests/stronghold_library");
    private static final Identifier VILLAGE_SAVANNA_HOUSE_CHEST_ID =
            new Identifier("minecraft", "chests/village/village_savanna_house");
    private static final Identifier VILLAGE_DESERT_HOUSE_CHEST_ID =
            new Identifier("minecraft", "chests/village/village_desert_house");
    private static final Identifier VILLAGE_SNOWY_HOUSE_CHEST_ID =
            new Identifier("minecraft", "chests/village/village_snowy_house");
    private static final Identifier VILLAGE_TAIGA_HOUSE_CHEST_ID =
            new Identifier("minecraft", "chests/village/village_taiga_house");
    private static final Identifier VILLAGE_PLAINS_HOUSE_CHEST_ID =
            new Identifier("minecraft", "chests/village/village_plains_house");
    private static final Identifier ANCIENT_CITY_CHEST_ID =
            new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier ABANDONED_MINESHAFT_CHEST_ID =
            new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier UNDERWATER_RUIN_BIG_CHEST_ID =
            new Identifier("minecraft", "chests/underwater_ruin_big");
    private static final Identifier NETHER_BRIDGE_CHEST_ID =
            new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier BURIED_TREASURE_CHEST_ID =
            new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier WOODLAND_MANSION_CHEST_ID =
            new Identifier("minecraft", "chests/woodland_mansion");
    private static final Identifier BASTION_TREASURE_CHEST_ID =
            new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier DESERT_PYRAMID_CHEST_ID =
            new Identifier("minecraft", "chests/desert_pyramid");
    private static final Identifier SHIPWRECK_TREASURE_CHEST_ID =
            new Identifier("minecraft", "chests/shipwreck_treasure");
    private static final Identifier JUNGLE_TEMPLE_CHEST_ID =
            new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier END_CITY_TREASURE_CHEST_ID =
            new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier STONE_DROP_ID =
            new Identifier("minecraft", "blocks/stone");
    private static final Identifier BAT_LOOT_ID =
            new Identifier("minecraft", "entities/bat");

    public static void modifyLootTables() {
        MagpieMod.LOGGER.info("Modifying loot tables");
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(id.equals(PILLAGER_OUTPOST_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.MARS_SPEAR)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(STRONGHOLD_LIBRARY_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.NERD_GLASSES)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(28))
                        .with(ItemEntry.builder(ModItems.AETHER)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(2));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(VILLAGE_SAVANNA_HOUSE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.PLASTIC_SPOON)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(VILLAGE_DESERT_HOUSE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.POTTED_CACTUS)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(VILLAGE_TAIGA_HOUSE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.08f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.MELATONIN_PILL)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(VILLAGE_PLAINS_HOUSE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.WASP_NEST)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(ANCIENT_CITY_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.SELENES_TORCH)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1))
                        .with(ItemEntry.builder(ModItems.TERRA)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(ABANDONED_MINESHAFT_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.YIN)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1))
                        .with(ItemEntry.builder(ModItems.YANG)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(ABANDONED_MINESHAFT_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.WAX_WING)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1))
                        .with(ItemEntry.builder(ModItems.AER)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(ABANDONED_MINESHAFT_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.WAX_WING)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1))
                        .with(ItemEntry.builder(ModItems.AER)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(UNDERWATER_RUIN_BIG_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.AQUA)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(NETHER_BRIDGE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.BAG_OF_DUST)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(NETHER_BRIDGE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.BAG_OF_DUST)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(WOODLAND_MANSION_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.GHOST_IN_A_JAR)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(BURIED_TREASURE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.HOLY_GRAIL)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(BASTION_TREASURE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.IGNIS)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(BASTION_TREASURE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.IGNIS)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(DESERT_PYRAMID_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.JUPITERS_THUNDERBOLT)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1))
                        .with(ItemEntry.builder(ModItems.URANUS_BLOOD)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(SHIPWRECK_TREASURE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.LIGHT_BULB)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1))
                        .with(ItemEntry.builder(ModItems.UMBRELLA)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .weight(1));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(JUNGLE_TEMPLE_CHEST_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.LIZARDS_TAIL)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(BAT_LOOT_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.33f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.VAMPIRE_FANG)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(STONE_DROP_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.LUCKY_PEBBLE)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))));
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }
}
