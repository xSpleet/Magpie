package xspleet.magpie.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public interface CombatModifier
{
    default float modifyIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return damageAmount;
    }
    default float modifyOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return damageAmount;
    }
    default boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return true;
    }
    default boolean dealOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return true;
    }
    default void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {}
    default void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {}
}
