package xspleet.magpie.item.custom;

import java.util.Random;
import java.util.UUID;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

public class ForkItem extends ArtifactItem
{
	private int counter = 0;

    @Override
	protected void registerAttributeModifiers() 
	{
	    EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                UUID.fromString("532e5533-ddbe-4b16-bbdd-92ea5ed07e42"),
	            "magpie:fork/stronger",
	            2.0f,
	            EntityAttributeModifier.Operation.ADDITION
	    );
	    EntityAttributeModifier rainAttackModifier = new EntityAttributeModifier(
                UUID.fromString("f7a656b9-5cfc-42b7-a91b-3496728896bd"),
	            "magpie:fork/rain_stronger",
	            4.0f,
	            EntityAttributeModifier.Operation.ADDITION
	    );
	    
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_ATTACK_DAMAGE,attackModifier));
    	artifactModifiers.add(new ArtifactModifier((livingEntity->livingEntity.world.hasRain(livingEntity.getBlockPos())),EntityAttributes.GENERIC_ATTACK_DAMAGE,rainAttackModifier));

		super.registerAttributeModifiers();
	}
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        World world = entity.getWorld();
        if(!world.isClient())
        {
        	counter=Math.min(counter+1,40);
            if(world.hasRain(entity.getBlockPos()))
            {
            	Random r = new Random();
                if(counter == 40 && r.nextInt(1000)<3)
                {
                	LightningEntity le = new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                    le.setPosition(entity.getPos());
                    world.spawnEntity(le);
                    counter = 0;
                }
            }
        }
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) 
    {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(!world.isClient())
        {
        	counter=Math.min(counter+1,40);
            if(world.hasRain(entity.getBlockPos()))
            {
            	Random r = new Random();
                if(counter == 40 && r.nextInt(1000)<3)
                {
                	LightningEntity le = new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                    le.setPosition(entity.getPos());
                    world.spawnEntity(le);
                    counter = 0;
                }
            }
        }
    }
    public ForkItem(Settings settings)
    {
        super(settings);
    }
}
