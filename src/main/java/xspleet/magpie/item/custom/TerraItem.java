package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class TerraItem extends ArtifactItem
{
	
	@Override
	protected void registerAttributeModifiers() 
	{
	    EntityAttributeModifier knockbackModifier = new EntityAttributeModifier(
				UUID.fromString("8b5a56fa-67b1-4c4b-ae40-7106fb496718"),
	            "magpie:terra/no_knockback",
	            10.0f,
	            EntityAttributeModifier.Operation.ADDITION
	    );
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,knockbackModifier));

	}
    
    public TerraItem(Settings settings) {
        super(settings);
    }
}
