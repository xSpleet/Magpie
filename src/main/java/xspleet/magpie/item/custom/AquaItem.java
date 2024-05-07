package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import xspleet.magpie.util.ArtifactItem;

public class AquaItem extends ArtifactItem
{
	
	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		if (entity.isSubmergedIn(FluidTags.WATER) && !entity.world.getBlockState(new BlockPos(entity.getX(), entity.getEyeY(), entity.getZ())).isOf(Blocks.BUBBLE_COLUMN)) 
			entity.setAir(entity.getMaxAir());
		super.tick(stack, slot, entity);
	}
	
    public AquaItem(Settings settings) {
        super(settings);
    }
}
