package xspleet.magpie.mixin;


import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.apache.commons.lang3.ObjectUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;
import xspleet.magpie.util.TrinketsUtil;
import java.util.List;
import java.util.Random;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity
{
    @Unique
    DamageSource damageSource = new DamageSource("NULL");

    @WrapWithCondition(method = "eatFood",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
    private boolean checkDecrease(ItemStack instance, int amount)
    {
        return (new Random()).nextInt(2) == 0;
    }


    @Inject(method = "damage", at = @At("HEAD"))
    private void inject(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir)
    {
        damageSource = source;
    }

    @Inject(method = "canWalkOnFluid", at = @At("HEAD"), cancellable = true)
    private void inject(FluidState state, CallbackInfoReturnable<Boolean> cir)
    {
        LivingEntity livingEntity = (LivingEntity)(Object)this;
        if (TrinketsUtil.hasArtifact(livingEntity, ModItems.HOLY_GRAIL) && livingEntity.getFluidHeight(FluidTags.WATER) < 0.39 && !Screen.hasShiftDown())
            cir.setReturnValue(true);
        cir.setReturnValue(cir.getReturnValue());
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), ordinal = 0)
    private float injected(float value)
    {
        LivingEntity entity = (LivingEntity)(Object)this;
        if(damageSource.getAttacker() instanceof PlayerEntity playerAttacker && !playerAttacker.world.isClient())
        {
            List<ArtifactItem> combatModifiers = TrinketsUtil.getCombatModifiers(playerAttacker);
            for(ArtifactItem combatModifier:combatModifiers)
            {
                value = ((CombatModifier)combatModifier).modifyOutgoingDamage(entity,damageSource,value);
            }
        }
        if(entity instanceof PlayerEntity playerAttacked && !playerAttacked.world.isClient())
        {
            List<ArtifactItem> combatModifiers = TrinketsUtil.getCombatModifiers(playerAttacked);
            for(ArtifactItem combatModifier:combatModifiers)
            {
                value = ((CombatModifier)combatModifier).modifyIncomingDamage(entity,damageSource,value);
            }
        }
        return value;
    }

    @ModifyConstant(method = "travel", constant = @Constant(floatValue = 3.0f, ordinal = 0) )
    private float injected1(float h) {
        return 99.0f;
    }

    @ModifyConstant(method = "travel", constant = @Constant(floatValue = 3.0f, ordinal = 1) )
    private float injected2(float h) {
        return 99.0f;
    }
}
