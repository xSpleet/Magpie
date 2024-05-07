package xspleet.magpie.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import java.util.Objects;
import java.util.Random;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class JupitersThunderboltItem extends ArtifactItem implements CombatModifier
{

    public JupitersThunderboltItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        return !Objects.equals(damageSource.getName(), "lightningBolt");
    }

    @Override
    public void onOutgoingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if (damageAmount != NO_DAMAGE)
        {
            if ((new Random()).nextInt(5) == 0)
            {
                LightningEntity le = new LightningEntity(EntityType.LIGHTNING_BOLT,entity.getWorld());
                le.setPosition(entity.getPos());
                entity.getWorld().spawnEntity(le);
            }
        }
    }
}
