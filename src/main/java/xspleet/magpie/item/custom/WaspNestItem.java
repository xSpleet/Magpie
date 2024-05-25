package xspleet.magpie.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.world.Difficulty;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;

import java.util.Random;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class WaspNestItem extends ArtifactItem implements CombatModifier
{

    private int counter = 1;

    public WaspNestItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(entity.world.getDifficulty()!= Difficulty.PEACEFUL && damageAmount != NO_DAMAGE && damageSource.getAttacker() instanceof LivingEntity attacker)
        {
            if(attacker.isAlive() && !attacker.isRemoved() && (new Random()).nextInt(10)<counter)
            {
                for(int i = 0 ; i <= counter/2; i++ )
                {
                    BeeEntity bee = new BeeEntity(EntityType.BEE, entity.getWorld());
                    bee.addStatusEffect(new StatusEffectInstance(ModStatusEffects.ANGY, 200, 0, false, false));
                    bee.setPosition(entity.getPos());
                    bee.setAngryAt(attacker.getUuid());
                    bee.setTarget(attacker);
                    bee.setAngerTime(200);
                    entity.getWorld().spawnEntity(bee);
                }
                counter = 1;
            }
            else
                counter = Math.min(counter+1, 6);
        }
    }
}
