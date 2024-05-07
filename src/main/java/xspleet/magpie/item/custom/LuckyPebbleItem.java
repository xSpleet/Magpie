package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class LuckyPebbleItem extends ArtifactItem
{
	
	@Override
    protected void registerAttributeModifiers() 
    {
        EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                UUID.fromString("3542066f-49af-468d-a007-580f11b085a5"),
                "magpie:lucky_pebble/stronger",
                0.1f,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
    	
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    }
	
    public LuckyPebbleItem(Settings settings)
    {
        super(settings);
    }
    
}
