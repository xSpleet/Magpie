package xspleet.magpie.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xspleet.magpie.MagpieMod;
import xspleet.magpie.item.custom.*;
import xspleet.magpie.util.ArtifactRarity;

public class ModItems
{

    public static final Item FORK = registerItem("fork",
            new ForkItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item LIGHT_BULB = registerItem("light_bulb",
            new LightbulbItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item RITUAL_CANDLE = registerItem("ritual_candle",
            new RitualCandleItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.COMMON));
    public static final Item BAG_OF_DUST = registerItem("bag_of_dust",
            new BagOfDustItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item TRANQ_DART = registerItem("tranq_dart",
            new TranqDartItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.COMMON));
    public static final Item ROTTEN_TOOTH = registerItem("rotten_tooth",
            new RottenToothItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.COMMON));
    public static final Item PLASTIC_SPOON = registerItem("plastic_spoon",
            new PlasticSpoonItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.COMMON));
    public static final Item WAX_WING = registerItem("wax_wing",
            new WaxWingItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item AQUA = registerItem("aqua",
            new AquaItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item AER = registerItem("aer",
            new AerItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item TERRA = registerItem("terra",
            new TerraItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item IGNIS = registerItem("ignis",
            new IgnisItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item POTTED_CACTUS = registerItem("potted_cactus",
            new PottedCactusItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item YANG = registerItem("yang",
            new YangItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item YIN = registerItem("yin",
            new YinItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item GHOST_IN_A_JAR = registerItem("ghost_in_a_jar",
            new GhostInAJarItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item LIZARDS_TAIL = registerItem("lizards_tail",
            new LizardsTailItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item AETHER = registerItem("aether",
            new AetherItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC).cooldown(6000));
    public static final Item LUCKY_PEBBLE = registerItem("lucky_pebble",
            new LuckyPebbleItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.COMMON));
    public static final Item LUCKY_STONE = registerItem("lucky_stone",
            new LuckyStoneItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.COMMON));
    public static final Item LUCKY_ROCK = registerItem("lucky_rock",
            new LuckyRockItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item LUCKY_BOULDER = registerItem("lucky_boulder",
            new LuckyBoulderItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item LIGHTNING_ARRESTER = registerItem("lightning_arrester",
            new LightningArresterItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item MELATONIN_PILL = registerItem("melatonin_pill",
            new MelatoninPillItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item NERD_GLASSES = registerItem("nerd_glasses",
            new NerdGlassesItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item RAIN_MARACAS = registerItem("rain_maracas",
            new RainMaracasItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE).cooldown(6000));
    public static final Item VAMPIRE_FANG = registerItem("vampire_fang",
            new VampireFangItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item UMBRELLA = registerItem("umbrella",
            new UmbrellaItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC).cooldown(1200));
    public static final Item POCKET = registerItem("pocket",
            new PocketItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item JUPITERS_THUNDERBOLT = registerItem("jupiters_thunderbolt",
            new JupitersThunderboltItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item URANUS_BLOOD = registerItem("uranus_blood",
            new UranusBloodItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.LEGENDARY));
    public static final Item MARS_SPEAR = registerItem("mars_spear",
            new MarsSpearItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item SELENES_TORCH = registerItem("selenes_torch",
            new SelenesTorchItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item WASP_NEST = registerItem("wasp_nest",
            new WaspNestItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    public static final Item SALE_TAG = registerItem("sale_tag",
            new SaleTagItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.RARE));
    public static final Item HOLY_GRAIL = registerItem("holy_grail",
            new HolyGrailItem( new FabricItemSettings().maxCount(1)).rarity(ArtifactRarity.EPIC));
    
    private static Item registerItem(String name, Item item)
    {                                                                                                                                                     
        return Registry.register(Registries.ITEM, new Identifier(MagpieMod.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        MagpieMod.LOGGER.info("Registering Mod Items for " + MagpieMod.MOD_ID);
    }

    public static void addItemsToEntries(ItemGroup.Entries entries)
    {
        entries.add(FORK);
        entries.add(LIGHT_BULB);
        entries.add(RITUAL_CANDLE);
        entries.add(ROTTEN_TOOTH);
        entries.add(TRANQ_DART);
        entries.add(BAG_OF_DUST);
        entries.add(PLASTIC_SPOON);
        entries.add(WAX_WING);
        entries.add(AQUA);
        entries.add(AER);
        entries.add(TERRA);
        entries.add(IGNIS);
        entries.add(POTTED_CACTUS);
        entries.add(YANG);
        entries.add(YIN);
        entries.add(GHOST_IN_A_JAR);
        entries.add(LIZARDS_TAIL);
        entries.add(AETHER);
        entries.add(LUCKY_PEBBLE);
        entries.add(LUCKY_STONE);
        entries.add(LUCKY_ROCK);
        entries.add(LUCKY_BOULDER);
        entries.add(LIGHTNING_ARRESTER);
        entries.add(MELATONIN_PILL);
        entries.add(NERD_GLASSES);
        entries.add(RAIN_MARACAS);
        entries.add(VAMPIRE_FANG);
        entries.add(UMBRELLA);
        entries.add(POCKET);
        entries.add(JUPITERS_THUNDERBOLT);
        entries.add(URANUS_BLOOD);
        entries.add(SELENES_TORCH);
        entries.add(MARS_SPEAR);
        entries.add(WASP_NEST);
        entries.add(SALE_TAG);
        entries.add(HOLY_GRAIL);
    }
}
