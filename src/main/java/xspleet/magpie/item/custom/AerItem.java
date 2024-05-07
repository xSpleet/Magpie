package xspleet.magpie.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;
import xspleet.magpie.util.CombatModifier;

import java.util.Objects;
import java.util.UUID;

public class AerItem extends ArtifactItem implements CombatModifier
{

    @Override
    protected void registerAttributeModifiers() 
    {
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(
                UUID.fromString("63ab803f-b766-4df8-af22-1edc8af6ca40"),
                "magpie:aer/faster",
                0.2f,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedModifier));
    }
	
    public AerItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        return !Objects.equals(damageSource.getName(), "fall");
    }
}
