package xspleet.magpie.item.custom;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import xspleet.magpie.util.ArtifactItem;

public class WaxWingItem extends ArtifactItem {


    public int count = 0 ;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if(!entity.getWorld().isClient())
        {
            if(entity instanceof PlayerEntity user)
            {
                if(!user.getAbilities().allowFlying && entity.getWorld().getLightLevel(user.getBlockPos())<6)
                {
                    user.getAbilities().allowFlying = true;
                    user.sendAbilitiesUpdate();
                }
                else if(user.getAbilities().allowFlying && entity.getWorld().getLightLevel(user.getBlockPos())>5 && !user.getAbilities().creativeMode)
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
                if (!user.getAbilities().allowFlying && entity.getWorld().getLightLevel(user.getBlockPos()) < 6)
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

    public WaxWingItem(Settings settings) {
        super(settings);
    }
}
