package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import xspleet.magpie.util.ArtifactItem;

public class SelenesTorchItem extends ArtifactItem
{

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		super.tick(stack, slot, entity);
		entity.removeStatusEffect(StatusEffects.DARKNESS);
		entity.removeStatusEffect(StatusEffects.BLINDNESS);
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,400,0,false,false));
	}

	@Override
	public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
		super.onEquip(stack, slot, entity);
	}

	public SelenesTorchItem(Settings settings) {
		super(settings);
	}
	
}
