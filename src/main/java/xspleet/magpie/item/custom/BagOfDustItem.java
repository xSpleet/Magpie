package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.ArtifactModifier;

import java.util.UUID;

public class BagOfDustItem extends ArtifactItem
{
    public BagOfDustItem(Settings settings) {
        super(settings);
    }

    @Override
    protected void registerAttributeModifiers() {
        EntityAttributeModifier healthModifier = new EntityAttributeModifier(
                UUID.fromString("22ea71b6-af02-4959-b4b1-effd116a8990"),
                "magpie:bag_of_dust/less_hearts",
                -4,
                EntityAttributeModifier.Operation.ADDITION
        );
        
    	artifactModifiers.add(new ArtifactModifier((livingEntity->true),EntityAttributes.GENERIC_MAX_HEALTH,healthModifier));
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        entity.setHealth(Math.min(entity.getHealth(),entity.getMaxHealth()));
    }
}
