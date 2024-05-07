package xspleet.magpie.item.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.TrinketsUtil;

import java.util.UUID;

public class PocketItem extends ArtifactItem
{
    public PocketItem(Settings settings) {
        super(settings);
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        SlotAttributes.addSlotModifier(modifiers, "active_artifacts/active_artifact", uuid, 1, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
    }
}
