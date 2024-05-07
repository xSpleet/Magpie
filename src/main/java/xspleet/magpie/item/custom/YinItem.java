package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;
import xspleet.magpie.util.TrinketsUtil;

import java.util.UUID;

public class YinItem extends ArtifactItem
{
	
	@Override
	protected void registerAttributeModifiers() 
	{
	    EntityAttributeModifier attackModifier = new EntityAttributeModifier(
				UUID.fromString("2e53c332-0030-468f-80d9-108175cb922e"),
	            "magpie:yin/stronger",
	            3.0f,
	            EntityAttributeModifier.Operation.ADDITION
	    );
	    EntityAttributeModifier speedDayModifier = new EntityAttributeModifier(
				UUID.fromString("71651df3-16d4-4327-aeb3-87c95145ecc8"),
	            "magpie:yin/slower",
	            -0.2f,
	            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
	    );
	    EntityAttributeModifier speedNightModifier = new EntityAttributeModifier(
				UUID.fromString("fd1f1e3b-03f4-4a52-8032-100f70d8e744"),
	            "magpie:yin/faster",
	            0.2f,
	            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
	    );
	    artifactModifiers.add(new ArtifactModifier((livingEntity->!livingEntity.world.isNight()),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
		artifactModifiers.add(new ArtifactModifier((livingEntity->livingEntity.world.isNight()),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedNightModifier));
		artifactModifiers.add(new ArtifactModifier((livingEntity->livingEntity.world.isDay()&&!TrinketsUtil.hasArtifact(livingEntity,ModItems.YANG)),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedDayModifier));
		super.registerAttributeModifiers();
	}
	
    public YinItem(Settings settings) {
        super(settings);
    }
}
