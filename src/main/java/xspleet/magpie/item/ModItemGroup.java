package xspleet.magpie.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xspleet.magpie.MagpieMod;

public class ModItemGroup
{
    public static ItemGroup MAGPIE;
    public static void registerItemGroups()
    {
        MAGPIE = FabricItemGroup.builder(new Identifier(MagpieMod.MOD_ID,"magpie"))
                .displayName(Text.translatable("itemgroup.magpie"))
                .icon(()->new ItemStack(ModItems.FORK)).build();
    }
}
