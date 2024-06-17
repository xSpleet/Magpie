package xspleet.magpie.util;

import java.util.function.Predicate;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
 
public class ArtifactModifier 
{

	private Predicate<LivingEntity> livingPredicate;
	private EntityAttribute attribute;
	private EntityAttributeModifier attributeModifier;

	/**
	 * Creates a new ArtifactModifier with a attributeModifier, which is activated when the livingPredicate is true, ans is applied to the attribute
	 * @param livingPredicate
	 * @param attribute
	 * @param attributeModifier
	 */
	public ArtifactModifier(Predicate<LivingEntity> livingPredicate, EntityAttribute attribute, EntityAttributeModifier attributeModifier)
	{
		this.livingPredicate = livingPredicate;
		this.attribute = attribute;
		this.attributeModifier = attributeModifier;
	}
	
	public Predicate<LivingEntity> getLivingPredicate() {
		return livingPredicate;
	}
	public void setLivingPredicate(Predicate<LivingEntity> livingPredicate) {
		this.livingPredicate = livingPredicate;
	}
	
	public EntityAttributeModifier getAttributeModifier() {
		return attributeModifier;
	}
	public void setAttributeModifier(EntityAttributeModifier attributeModifier) {
		this.attributeModifier = attributeModifier;
	}
	
	public EntityAttribute getAttribute() {
		return attribute;
	}
	public void setAttribute(EntityAttribute attribute) {
		this.attribute = attribute;
	}
	
	private EntityAttributeInstance getAttributeInstance(LivingEntity livingEntity)
	{
		return livingEntity.getAttributeInstance(attribute);
	}
	
	public boolean shouldAdd(LivingEntity livingEntity)
	{
		return livingPredicate.test(livingEntity)&&!getAttributeInstance(livingEntity).hasModifier(attributeModifier);
	}
	
	public boolean shouldRemove(LivingEntity livingEntity)
	{
		return !livingPredicate.test(livingEntity)&&getAttributeInstance(livingEntity).hasModifier(attributeModifier);
	}

	/**
	 * Updates the AttributeModifiers on the livingEntity
	 * @param livingEntity
	 */
	public void update(LivingEntity livingEntity)
	{
		if(livingEntity.getWorld().isClient())
    	{
			return;
    	}
		if(shouldAdd(livingEntity))
		{
			getAttributeInstance(livingEntity).addPersistentModifier(attributeModifier);
		}
		if(shouldRemove(livingEntity))
		{
			getAttributeInstance(livingEntity).removeModifier(attributeModifier.getId());
		}
	}


	/**
	 * Removes the AttributeModifiers from the livingEntity
	 * @param livingEntity
	 */
	public void remove(LivingEntity livingEntity)
	{
		if(livingEntity.getWorld().isClient())
    	{
			return;
    	}
		if(getAttributeInstance(livingEntity).hasModifier(attributeModifier))
		{
			getAttributeInstance(livingEntity).removeModifier(attributeModifier.getId());
		}
	}
}
