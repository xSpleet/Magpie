package xspleet.magpie.event.custom;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDamage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

import java.util.Objects;

public class LivingEntityStatusEffectDamageHandler implements AllowDamage
{
	public boolean allowDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(entity.hasStatusEffect(ModStatusEffects.SOFT_BREEZE) && Objects.equals(damageSource.getName(), "fall"))
            return false;
        if((entity.hasStatusEffect(ModStatusEffects.INNER_FLAME))&&(Objects.equals(damageSource.getName(), "inFire") || Objects.equals(damageSource.getName(), "onFire") || Objects.equals(damageSource.getName(), "lava")))
            return false;
        return true;
    }
}

