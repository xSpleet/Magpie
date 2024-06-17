package xspleet.magpie.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

/**
 * Should be implemented in a class if the ArtifactItem should change the combat
 */
public interface CombatModifier
{

    /**
     * Should be overriden if the incoming damage is modified by the item, otherwise left unoverriden
     * @see xspleet.magpie.event.custom.CombatModifiersHandler
     * @param entity the attacked entity
     * @param damageSource the damageSource of the damage
     * @param damageAmount the damageAmount of the damage
     * @return the modified damageAmount
     */
    default float modifyIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return damageAmount;
    }

    /**
     * Should be overriden if the outgoing damage is modified by the item, otherwise left unoverriden
     * @see xspleet.magpie.event.custom.CombatModifiersHandler
     * @param entity the attacked entity
     * @param damageSource the damageSource of the damage
     * @param damageAmount the damageAmount of the damage
     * @return the modified damageAmount
     */
    default float modifyOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return damageAmount;
    }

    /**
     * Should be overriden if the incoming damage is set to not be dealt in certain conditions
     * Should be overriden to cancel the damage, not {@link #modifyIncomingDamage(LivingEntity, DamageSource, float)}
     * @see xspleet.magpie.event.custom.CombatModifiersHandler
     * @param entity the attacked entity
     * @param damageSource the damageSource of the damage
     * @param damageAmount the damageAmount of the damage
     * @return whether the incoming damage is to be dealt
     */
    default boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return true;
    }

    /**
     * Should be overriden if the outgoing damage is set to not be dealt in certain conditions
     * Should be overriden to cancel the damage, not {@link #modifyIncomingDamage(LivingEntity, DamageSource, float)}
     * @see xspleet.magpie.event.custom.CombatModifiersHandler
     * @param entity the attacked entity
     * @param damageSource the damageSource of the damage
     * @param damageAmount the damageAmount of the damage
     * @return whether the incoming damage is to be dealt
     */
    default boolean dealOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        return true;
    }

    /**
     * Should be overriden if something has to happen on incoming damage
     * Check for damage equal to MagpieMod.NO_DAMAGE to check if there is no damage
     * @see xspleet.magpie.event.custom.CombatModifiersHandler
     * @param entity the attacked entity
     * @param damageSource the damageSource of the damage
     * @param damageAmount the damageAmount of the damage
     */
    default void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {}

    /**
     * Should be overriden if something has to happen on outgoing damage
     * Check for damage equal to MagpieMod.NO_DAMAGE to check if there is no damage
     * @see xspleet.magpie.event.custom.CombatModifiersHandler
     * @param entity the attacked entity
     * @param damageSource the damageSource of the damage
     * @param damageAmount the damageAmount of the damage
     */
    default void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {}
}
