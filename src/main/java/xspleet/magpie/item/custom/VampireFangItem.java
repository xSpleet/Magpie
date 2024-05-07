package xspleet.magpie.item.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class VampireFangItem extends ArtifactItem
{

	@Override
	protected void registerAttributeModifiers()
	{
	    EntityAttributeModifier speedNightModifier = new EntityAttributeModifier(
				UUID.fromString("9401b033-39ac-4508-8a8b-44590ce21342"),
	            "magpie:vampire_fang/faster",
	            0.2f,
	            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
	    );
		artifactModifiers.add(new ArtifactModifier((livingEntity->livingEntity.world.isNight()),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedNightModifier));
		super.registerAttributeModifiers();
	}

    public VampireFangItem(Settings settings) {
        super(settings);
    }
}
