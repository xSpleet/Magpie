package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import xspleet.magpie.util.ArtifactItem;

public class UranusBloodItem extends ArtifactItem {


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(!entity.getWorld().isClient())
        {
            if(entity instanceof PlayerEntity user)
            {
                if(!user.getAbilities().allowFlying && entity.getWorld().hasRain(entity.getBlockPos()))
                {
                    user.getAbilities().allowFlying = true;
                    user.sendAbilitiesUpdate();
                }
                else if(user.getAbilities().allowFlying && !entity.getWorld().hasRain(entity.getBlockPos()) && !user.getAbilities().creativeMode)
                {
                    user.getAbilities().allowFlying = false;
                    user.getAbilities().flying = false;
                    user.sendAbilitiesUpdate();
                }
            }
        }
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if(!entity.getWorld().isClient())
        {
            if (entity instanceof PlayerEntity user)
            {
                if (!user.getAbilities().allowFlying && entity.getWorld().hasRain(entity.getBlockPos()))
                {
                    user.getAbilities().allowFlying = true;
                    user.sendAbilitiesUpdate();
                }
            }
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        if(!entity.getWorld().isClient())
        {
            if (entity instanceof PlayerEntity user)
            {
                if(user.getAbilities().allowFlying && !user.getAbilities().creativeMode)
                {
                    user.getAbilities().allowFlying = false;
                    user.getAbilities().flying = false;
                    user.sendAbilitiesUpdate();
                }
            }
        }
    }

    public UranusBloodItem(Settings settings) {
        super(settings);
    }
}
