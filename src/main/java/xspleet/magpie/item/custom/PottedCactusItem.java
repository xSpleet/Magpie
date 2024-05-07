package xspleet.magpie.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import java.util.Objects;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class PottedCactusItem extends ArtifactItem implements CombatModifier
{

	public PottedCactusItem(Settings settings) {
		super(settings);
	}

	@Override
	public boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
		return !(Objects.equals(damageSource.getName(), "cactus") || Objects.equals(damageSource.getName(), "thorns") || Objects.equals(damageSource.getName(), "sting"));
	}

	@Override
	public void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
		if(damageAmount!=NO_DAMAGE && damageSource.getAttacker() instanceof LivingEntity livingEntity)
			livingEntity.damage(DamageSource.CACTUS, (float) Math.max(damageAmount*0.3,1));
	}
}
