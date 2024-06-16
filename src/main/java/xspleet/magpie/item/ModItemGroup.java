package xspleet.magpie.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xspleet.magpie.MagpieMod;

import static xspleet.magpie.item.ModItems.*;

public class ModItemGroup
{

    public static void registerItemGroup()
    {
        Registry.register(Registries.ITEM_GROUP, new Identifier(MagpieMod.MOD_ID,"magpie"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.magpie"))
                        .icon(() -> new ItemStack(FORK))
                        .entries((displayContext, entries) -> {
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
                        })
                        .build()
        );
    }
}
