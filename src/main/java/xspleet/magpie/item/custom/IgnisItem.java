package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

public class IgnisItem extends ArtifactItem implements CombatModifier
{

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		entity.setFireTicks(0);
		super.tick(stack, slot, entity);
	}
	
    public IgnisItem(Settings settings) {
        super(settings);
    }

	@Override
	public boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
		return !damageSource.isIn(DamageTypeTags.IS_FIRE);
	}
}
