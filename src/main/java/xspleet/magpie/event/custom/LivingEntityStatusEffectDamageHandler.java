package xspleet.magpie.event.custom;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDamage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;
import xspleet.magpie.effect.ModStatusEffects;

import java.util.Objects;

public class LivingEntityStatusEffectDamageHandler implements AllowDamage
{
	public boolean allowDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(entity.hasStatusEffect(ModStatusEffects.SOFT_BREEZE) && Objects.equals(damageSource.getName(), "fall"))
            return false;
        if((entity.hasStatusEffect(ModStatusEffects.INNER_FLAME))&&damageSource.isIn(DamageTypeTags.IS_FIRE))
            return false;
        return true;
    }
}

