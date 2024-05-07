package xspleet.magpie.item.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class RitualCandleItem extends ArtifactItem implements CombatModifier
{

    public RitualCandleItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(damageAmount!=NO_DAMAGE)
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,400,0,false,false));
    }
}
