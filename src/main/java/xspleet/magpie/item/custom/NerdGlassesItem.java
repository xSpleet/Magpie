package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import xspleet.magpie.util.ArtifactItem;

public class NerdGlassesItem extends ArtifactItem
{

	
	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		super.tick(stack, slot, entity);
		entity.removeStatusEffect(StatusEffects.NAUSEA);
		entity.removeStatusEffect(StatusEffects.NIGHT_VISION);
		entity.removeStatusEffect(StatusEffects.DARKNESS);
		entity.removeStatusEffect(StatusEffects.BLINDNESS);
	}
	
	public NerdGlassesItem(Settings settings) {
		super(settings);
	}
	
}
