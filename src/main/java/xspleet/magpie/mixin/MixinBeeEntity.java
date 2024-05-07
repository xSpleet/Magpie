package xspleet.magpie.mixin;


import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

import java.util.Random;

@Mixin(BeeEntity.class)
public abstract class MixinBeeEntity
{
    @WrapWithCondition(method = "tryAttack",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/BeeEntity;stopAnger()V"))
    private boolean checkAngy(BeeEntity instance)
    {
        return !instance.hasStatusEffect(ModStatusEffects.ANGY);
    }

    @Inject(method = "hasStung", at = @At("HEAD"), cancellable = true)
    private void angyNotStung(CallbackInfoReturnable<Boolean> cir)
    {
        if(((BeeEntity)(Object)this).hasStatusEffect(ModStatusEffects.ANGY))
            cir.setReturnValue(false);
        cir.setReturnValue(cir.getReturnValue());
    }
}
