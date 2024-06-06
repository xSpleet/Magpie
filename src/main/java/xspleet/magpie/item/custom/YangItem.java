package xspleet.magpie.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xspleet.magpie.MagpieMod;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.*;

import java.util.List;
import java.util.UUID;

public class YangItem extends ArtifactItem
{
	
	@Override
	protected void registerAttributeModifiers() 
	{
	    EntityAttributeModifier attackModifier = new EntityAttributeModifier(
				UUID.fromString("68218aac-8ba3-4e2d-b9aa-5d5da1093b19"),
	            "magpie:yang/stronger",
	            3.0f,
	            EntityAttributeModifier.Operation.ADDITION
	    );
	    EntityAttributeModifier speedDayModifier = new EntityAttributeModifier(
				UUID.fromString("00a6acb2-b844-4525-9a91-8bca4d4e3848"),
	            "magpie:yang/faster",
	            0.2f,
	            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
	    );
	    EntityAttributeModifier speedNightModifier = new EntityAttributeModifier(
				UUID.fromString("5f66cf2d-5865-478c-b3cd-7d3740af7c09"),
	            "magpie:yang/slower",
	            -0.2f,
	            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
	    );
	    
    	artifactModifiers.add(new ArtifactModifier((livingEntity-> livingEntity.getWorld().isDay()),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    	artifactModifiers.add(new ArtifactModifier((livingEntity-> livingEntity.getWorld().isDay()),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedDayModifier));
    	artifactModifiers.add(new ArtifactModifier((livingEntity-> livingEntity.getWorld().isNight()&&!TrinketsUtil.hasArtifact(livingEntity,ModItems.YIN)),EntityAttributes.GENERIC_MOVEMENT_SPEED,speedNightModifier));
		super.registerAttributeModifiers();
		
	}

	public YangItem(Settings settings) {
        super(settings);
    }
}
