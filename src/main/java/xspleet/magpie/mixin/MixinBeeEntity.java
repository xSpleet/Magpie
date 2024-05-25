package xspleet.magpie.mixin;


import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.entity.passive.BeeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import xspleet.magpie.effect.ModStatusEffects;

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

    @WrapWithCondition(method = "tryAttack",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/BeeEntity;setHasStung(Z)V"))
    private boolean checkAngy(BeeEntity instance, boolean hasStung)
    {
        return !instance.hasStatusEffect(ModStatusEffects.ANGY);
    }

}
