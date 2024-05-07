package xspleet.magpie.util;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ActiveArtifactItem extends ArtifactItem
{



	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		if(!entity.world.isClient() && stack.getDamage()!=0)
    	{
        	stack.setDamage(stack.getDamage()-1);
    	}
		super.tick(stack, slot, entity);
	}

	public void activate(PlayerEntity playerEntity){}

	public ActiveArtifactItem(Settings settings) 
	{
		super(settings);
	}
	
}
