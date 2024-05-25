package xspleet.magpie.event.custom;

import java.util.Random;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDeath;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

public class LivingEntityDeathHandler implements AllowDeath 
{

	@Override
	public boolean allowDeath(LivingEntity entity, DamageSource damageSource, float damageAmount) 
	{
		if(TrinketsUtil.hasArtifact(entity, ModItems.LIZARDS_TAIL))
		{
			Random r = new Random();
            if(r.nextInt(10)<3)
            {
            	entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.AUTOTOMY,300,0,false,false));
            	entity.setHealth(1);
            	if(entity instanceof PlayerEntity playerEntity)
            	{
                	TrinketsUtil.dropArtifact(playerEntity, ModItems.LIZARDS_TAIL).setPickupDelay(300);;
            	}
            	return false;
            }
		}
		if(entity.hasStatusEffect(ModStatusEffects.AUTOTOMY))
		{
			entity.setHealth(1);
			return false;
		}
		if(damageSource.getAttacker() instanceof PlayerEntity playerEntity)
		{
			if(TrinketsUtil.hasArtifact(playerEntity, ModItems.VAMPIRE_FANG))
			{
				playerEntity.heal(1.0f + entity.getMaxHealth()/16);
			}
		}
		return true;
	}
}
