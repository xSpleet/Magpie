package xspleet.magpie.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import xspleet.magpie.util.ActiveArtifactItem;

public class UmbrellaItem extends ActiveArtifactItem
{

    public UmbrellaItem(Settings settings)
    {
        super(settings);
    }

	@Override
	public void activate(PlayerEntity user) 
	{
		user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,400,0,false,false));
	}
}
