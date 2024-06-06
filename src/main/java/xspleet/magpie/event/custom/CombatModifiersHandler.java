package xspleet.magpie.event.custom;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;
import xspleet.magpie.util.TrinketsUtil;

import java.util.List;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class CombatModifiersHandler implements AllowDamage {

	public boolean allowDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) 
	{
		boolean dealDamage = true;
		Entity attacker = damageSource.getAttacker();
		if(entity instanceof PlayerEntity playerAttacked && !playerAttacked.getWorld().isClient())
		{
			List<ArtifactItem> combatModifiers = TrinketsUtil.getCombatModifiers(playerAttacked);
			for(ArtifactItem combatModifier:combatModifiers)
			{
				dealDamage = dealDamage && ((CombatModifier)combatModifier).dealIncomingDamage(entity, damageSource, damageAmount);
			}
		}

		if(attacker instanceof PlayerEntity playerAttacker && !playerAttacker.getWorld().isClient())
		{
			List<ArtifactItem> combatModifiers = TrinketsUtil.getCombatModifiers(playerAttacker);
			for(ArtifactItem combatModifier:combatModifiers)
			{
				dealDamage = dealDamage && ((CombatModifier)combatModifier).dealOutgoingDamage(entity, damageSource, damageAmount);
			}
		}
		if(!dealDamage)
			damageAmount = NO_DAMAGE;
		if(entity instanceof PlayerEntity playerAttacked && !playerAttacked.getWorld().isClient())
		{
			List<ArtifactItem> combatModifiers = TrinketsUtil.getCombatModifiers(playerAttacked);
			for(ArtifactItem combatModifier:combatModifiers)
			{
				((CombatModifier)combatModifier).onIncomingDamage(entity, damageSource, damageAmount);
			}
		}
		if(attacker instanceof PlayerEntity playerAttacker && !playerAttacker.getWorld().isClient())
		{
			List<ArtifactItem> combatModifiers = TrinketsUtil.getCombatModifiers(playerAttacker);
			for(ArtifactItem combatModifier:combatModifiers)
			{
				((CombatModifier)combatModifier).onOutgoingDamage(entity, damageSource, damageAmount);
			}
		}
        return dealDamage;
    }
}
