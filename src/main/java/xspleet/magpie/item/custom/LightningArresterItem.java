package xspleet.magpie.item.custom;


import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import xspleet.magpie.util.ArtifactItem;
import xspleet.magpie.util.CombatModifier;
import xspleet.magpie.util.TrinketsUtil;

import java.util.List;
import java.util.Objects;

public class LightningArresterItem extends ArtifactItem implements CombatModifier
{

    @Override
    public boolean dealIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        return !Objects.equals(damageSource.getName(), "lightningBolt");
    }

    @Override
    public void onIncomingDamage(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if(Objects.equals(damageSource.getName(), "lightningBolt"))
        {
            List<Pair<SlotReference, ItemStack>> activeArtifacts = TrinketsUtil.getActiveArtifacts(entity);
            for(Pair<SlotReference,ItemStack> activeArtifact:activeArtifacts)
            {
                if(!entity.world.isClient())
                {
                    activeArtifact.getRight().setDamage(0);
                }
            }
        }
    }

    public LightningArresterItem(Settings settings)
    {
        super(settings);
    }
    
}
