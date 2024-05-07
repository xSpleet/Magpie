package xspleet.magpie.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import xspleet.magpie.util.ActiveArtifactItem;

public class RainMaracasItem extends ActiveArtifactItem{

	public RainMaracasItem(Settings settings)
	{
		super(settings);
	}
	
	@Override
	public void activate(PlayerEntity playerEntity)
	{
		if(!playerEntity.getWorld().isClient())
		{
			if (playerEntity.getWorld().isRaining())
			{
				ServerWorld world = (ServerWorld) playerEntity.getWorld();
				world.setWeather(60000,0,false,false);
			}
			else
			{
				ServerWorld world = (ServerWorld) playerEntity.getWorld();
				world.setWeather(0,60000,true,false);
			}
		}
		super.activate(playerEntity);
	}
}
