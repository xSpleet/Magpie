package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import java.util.Objects;

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
		return !Objects.equals(damageSource.getName(), "inFire") && !Objects.equals(damageSource.getName(), "onFire") && !Objects.equals(damageSource.getName(), "lava");
	}
}
