package xspleet.magpie.item.custom;

import java.util.Random;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.util.ActiveArtifactItem;

public class AetherItem extends ActiveArtifactItem
{

	public AetherItem(Settings settings)
    {
        super(settings);
    }

	@Override
	public void activate(PlayerEntity user) 
	{
		Random r = new Random();
		int effect = r.nextInt(4);
		switch(effect)
		{
			case 0:
				user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.TIDAL_FLOW,6000,0,false,false));
				break;
			case 1:
				user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.INNER_FLAME,6000,0,false,false));
				break;
			case 2:
				user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SOLID_GROUND,6000,0,false,false));
				break;
			case 3:
				user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SOFT_BREEZE,6000,0,false,false));
				break;
		}
	}
}
