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
        Objects.requireNonNull(damageSource.getAttacker()).sendMessage(Text.literal("ON OUTGOING"));
        damageSource.setBypassesArmor();
    }
    @Override
    public void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        entity.sendMessage(Text.literal("ON INCOMING"));
        damageSource.setBypassesArmor();
    }
}
