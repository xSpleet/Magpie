package xspleet.magpie.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

@Mixin(EnchantmentHelper.class)
public abstract class MixinEnchantmentHelper
{
    @Inject(method = "getDepthStrider", at = @At("RETURN"), cancellable = true)
    private static void injected1(LivingEntity entity, CallbackInfoReturnable<Integer> cir)
    {
        if(entity.hasStatusEffect(ModStatusEffects.TIDAL_FLOW)||TrinketsUtil.hasArtifact(entity, ModItems.AQUA))
            cir.setReturnValue(cir.getReturnValue()*2+3);
    }

    @Inject(method = "hasAquaAffinity", at = @At("RETURN"), cancellable = true)
    private static void injected2(LivingEntity entity, CallbackInfoReturnable<Boolean> cir)
    {
        if(entity.hasStatusEffect(ModStatusEffects.TIDAL_FLOW)||TrinketsUtil.hasArtifact(entity, ModItems.AQUA))
            cir.setReturnValue(true);
    }
    
    @Inject(method = "getFireAspect", at = @At("RETURN"), cancellable = true)
    private static void injected3(LivingEntity entity, CallbackInfoReturnable<Integer> cir)
    {
        if(TrinketsUtil.hasArtifact(entity, ModItems.IGNIS) || entity.hasStatusEffect(ModStatusEffects.INNER_FLAME))
            cir.setReturnValue(cir.getReturnValue()+2);
    }
    
    @Inject(method = "getKnockback", at = @At("RETURN"), cancellable = true)
    private static void injected4(LivingEntity entity, CallbackInfoReturnable<Integer> cir)
    {
        if(TrinketsUtil.hasArtifact(entity, ModItems.TERRA) || entity.hasStatusEffect(ModStatusEffects.SOLID_GROUND))
            cir.setReturnValue(cir.getReturnValue()+4);
    }
}
