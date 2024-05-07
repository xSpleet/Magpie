package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class LuckyRockItem extends ArtifactItem
{

	@Override
    protected void registerAttributeModifiers() 
    {
        EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                UUID.fromString("ce409a04-6d4a-40ce-bacb-a1decc7ee300"),
                "magpie:lucky_rock/stronger",
                0.2f,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    }
	
    public LuckyRockItem(Settings settings)
    {
        super(settings);
    }
    
}
