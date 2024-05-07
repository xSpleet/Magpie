package xspleet.magpie.mixin;


import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

import java.util.Objects;
import java.util.Random;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinDoubleJump
{

    int jumps = 0;
    boolean jumped = false;
    private int extraJumps(ClientPlayerEntity player)
    {
        int extra = 0;
        if(TrinketsUtil.hasArtifact(player, ModItems.BAG_OF_DUST))
        {
            extra += 1;
        }
        return extra;
    }

    @Inject(method = "tickMovement", at = @At(value = "HEAD"))
    private void injected(CallbackInfo ci)
    {
        ClientPlayerEntity player = (ClientPlayerEntity)(Object)this;
        if(player.isClimbing() || player.isOnGround())
        {
            jumps = extraJumps(player);
        }
        else if(!jumped && jumps > 0 && player.getVelocity().y < 0)
        {
            if(player.input.jumping && !player.getAbilities().flying)
            {
                ItemStack stack = player.getEquippedStack(EquipmentSlot.CHEST);
                boolean b1 = stack.getItem() == Items.ELYTRA && ElytraItem.isUsable(stack);
                boolean canJump = !b1 && !player.isFallFlying() && !player.hasVehicle() && !player.isTouchingWater() && !player.hasStatusEffect(StatusEffects.LEVITATION);
                if(canJump)
                {
                    jumps--;
                    player.jump();
                }
            }
        }
        jumped = player.input.jumping;
    }
}
