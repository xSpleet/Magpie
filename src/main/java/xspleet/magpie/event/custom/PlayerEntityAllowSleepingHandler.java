package xspleet.magpie.event.custom;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents.AllowNearbyMonsters;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

public class PlayerEntityAllowSleepingHandler implements AllowNearbyMonsters{

	@Override
	public ActionResult allowNearbyMonsters(PlayerEntity player, BlockPos sleepingPos, boolean vanillaResult) {
		if(TrinketsUtil.hasArtifact(player, ModItems.DREAM_CATCHER))
		{
			return ActionResult.SUCCESS;
		}
		return ActionResult.PASS;
	}
	
}
