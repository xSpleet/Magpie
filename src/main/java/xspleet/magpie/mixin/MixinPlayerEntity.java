package xspleet.magpie.mixin;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

import java.util.Random;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity
{
    @Inject(method = "eatFood", at = @At(value = "HEAD"), cancellable=true)
    private void injected(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir)
    {
    	if(((LivingEntity)(Object)this) instanceof PlayerEntity user)
            if(TrinketsUtil.hasArtifact(user, ModItems.PLASTIC_SPOON))
            {
                Random r = new Random();
                if(r.nextInt(10)<3 && stack.getMaxCount() != 1)
                    stack.increment(1);
            }
    }
}
