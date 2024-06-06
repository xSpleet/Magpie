package xspleet.magpie.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

public class MarsSpearItem extends ArtifactItem implements CombatModifier
{
    public MarsSpearItem(Settings settings) {
        super(settings);
    }

    private boolean isMelee(DamageSource damageSource)
    {
        return damageSource.getAttacker() instanceof LivingEntity && damageSource.getSource() instanceof LivingEntity;
    }

    @Override
    public float modifyOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(isMelee(damageSource))
            return damageAmount * 2;
        return damageAmount;
    }

    @Override
    public float modifyIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(isMelee(damageSource))
            return damageAmount*2;
        return damageAmount;
    }
}
