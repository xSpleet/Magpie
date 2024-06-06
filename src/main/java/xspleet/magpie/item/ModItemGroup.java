package xspleet.magpie.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xspleet.magpie.MagpieMod;

public class ModItemGroup
{
    public static final ItemGroup MAGPIE = Registry.register(Registries.ITEM_GROUP, new Identifier(MagpieMod.MOD_ID,"magpie"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.magpie"))
                    .icon(() -> new ItemStack(ModItems.FORK))
                    .entries(((displayContext, entries) -> {
                        ModItems.addItemsToEntries(entries);
                    })).build());
}
