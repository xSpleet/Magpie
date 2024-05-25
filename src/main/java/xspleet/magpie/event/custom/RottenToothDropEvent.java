package xspleet.magpie.event.custom;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDamage;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import xspleet.magpie.item.ModItems;

import java.util.Random;

public class RottenToothDropEvent implements AllowDamage {

    public boolean allowDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        if((entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity) && damageSource.getName().equals("player") && ((PlayerEntity)damageSource.getAttacker()) != null && ((PlayerEntity)damageSource.getAttacker()).getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.AIR)
        {
            if((new Random().nextInt(100)) == 0)
            {
                ItemEntity rottenTooth = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.ROTTEN_TOOTH));
                entity.world.spawnEntity(rottenTooth);
            }
        }
        return true;
    }
}
