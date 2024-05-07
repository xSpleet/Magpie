package xspleet.magpie.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class RottenToothItem extends ArtifactItem implements CombatModifier
{

	public RottenToothItem(Settings settings) {
		super(settings);
	}

	@Override
	public void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
		if(damageAmount!=NO_DAMAGE)
			entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,60,0,false,false));
	}
}
