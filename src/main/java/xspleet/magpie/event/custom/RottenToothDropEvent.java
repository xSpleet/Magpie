package xspleet.magpie.event.custom;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDamage;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.SkeletonHorseTrapTriggerGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.village.TradeOffer;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;
import xspleet.magpie.util.TrinketsUtil;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class RottenToothDropEvent implements AllowDamage {

    public boolean allowDamage(LivingEntity entity, DamageSource damageSource, float damageAmount)
    {
        if((entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity) && damageSource.getName().equals("player") && ((PlayerEntity)damageSource.getAttacker()).getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.AIR)
        {
            damageSource.getAttacker().sendMessage(Text.literal("You are a monster!"));
            if((new Random().nextInt(100)) == 0)
            {
                ItemEntity rottenTooth = new ItemEntity(entity.world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.ROTTEN_TOOTH));
                entity.world.spawnEntity(rottenTooth);
            }
        }
        return true;
    }
}
