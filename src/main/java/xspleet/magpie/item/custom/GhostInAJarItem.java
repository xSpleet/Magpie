package xspleet.magpie.item.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import static net.minecraft.entity.damage.DamageTypes.GENERIC;

public class GhostInAJarItem extends ArtifactItem
                             implements CombatModifier
{


    public GhostInAJarItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        entity.damage(entity.getWorld().getDamageSources().create(GENERIC, damageSource.getSource(), damageSource.getAttacker()), damageAmount);
    }

    @Override
    public void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        entity.damage(entity.getWorld().getDamageSources().create(GENERIC, damageSource.getSource(), damageSource.getAttacker()), damageAmount);
    }

}
