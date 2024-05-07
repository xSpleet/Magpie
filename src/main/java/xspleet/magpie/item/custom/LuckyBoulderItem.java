package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class LuckyBoulderItem extends ArtifactItem
{

	@Override
    protected void registerAttributeModifiers() 
    {
        EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                UUID.fromString("2ab10756-8e5e-4264-a501-fd94ea8f8149"),
                "magpie:lucky_boulder/stronger",
                0.25f,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
    	
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    }
	
    public LuckyBoulderItem(Settings settings)
    {
        super(settings);
    }
    
}
