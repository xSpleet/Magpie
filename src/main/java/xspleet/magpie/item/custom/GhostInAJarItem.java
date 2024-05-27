package xspleet.magpie.item.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import java.util.Objects;

public class GhostInAJarItem extends ArtifactItem
                             implements CombatModifier
{


    public GhostInAJarItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        damageSource.setBypassesArmor();
    }
    @Override
    public void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        damageSource.setBypassesArmor();
    }
}
