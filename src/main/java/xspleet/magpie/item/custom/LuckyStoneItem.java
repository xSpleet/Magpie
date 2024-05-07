package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class LuckyStoneItem extends ArtifactItem
{
	
	@Override
    protected void registerAttributeModifiers() 
    {
        EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                UUID.fromString("ee203a2d-fb79-4c69-b814-9059009d52d8"),
                "magpie:lucky_stone/stronger",
                0.15f,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
    	
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    }
	
    public LuckyStoneItem(Settings settings)
    {
        super(settings);
    }
    
}
