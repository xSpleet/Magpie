package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class LightbulbItem extends ArtifactItem
{

    @Override
    protected void registerAttributeModifiers() 
    {
        EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                UUID.fromString("65fd0606-ae54-423d-81e1-8c84091b176b"),
                "magpie:lightbulb/stronger",
                3.0f,
                EntityAttributeModifier.Operation.ADDITION
        );
        
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(
                UUID.fromString("c61cd8f3-bcd1-4705-8193-38f7615f0436"),
                "magpie:lightbulb/faster",
                0.2f,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
        
    	artifactModifiers.add(new ArtifactModifier((livingEntity->livingEntity.getHealth()>livingEntity.getMaxHealth()-0.5),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedModifier));
    	artifactModifiers.add(new ArtifactModifier((livingEntity->livingEntity.getHealth()>livingEntity.getMaxHealth()-0.5),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    }
    
    public LightbulbItem(Settings settings)
    {
        super(settings);
    }
}
