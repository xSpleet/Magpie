package xspleet.magpie.util;




import java.util.ArrayList;
import java.util.List;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;

public class TrinketsUtil 
{
	
	static public List<Pair<SlotReference, ItemStack>> getActiveArtifacts(LivingEntity livingEntity)
	{
		List<Pair<SlotReference, ItemStack>> activeArtifacts = new ArrayList<Pair<SlotReference, ItemStack>>(0);
		if(TrinketsApi.getTrinketComponent(livingEntity).isPresent())
		{
			List<Pair<SlotReference, ItemStack>> allArtifacts = TrinketsApi.getTrinketComponent(livingEntity).get().getAllEquipped();
			for(Pair<SlotReference, ItemStack> pair: allArtifacts)
			{
				if(pair.getRight().getItem() instanceof ActiveArtifactItem)
				{
					activeArtifacts.add(pair);
				}
			}
		}
		return activeArtifacts;
	}

	static public List<ArtifactItem> getCombatModifiers(LivingEntity livingEntity)
	{
		List<ArtifactItem> combatModifiers = new ArrayList<>(0);
		if(TrinketsApi.getTrinketComponent(livingEntity).isPresent())
		{
			List<Pair<SlotReference, ItemStack>> allArtifacts = TrinketsApi.getTrinketComponent(livingEntity).get().getAllEquipped();
			for(Pair<SlotReference, ItemStack> pair: allArtifacts)
			{
				if(pair.getRight().getItem() instanceof CombatModifier)
				{
					combatModifiers.add((ArtifactItem) pair.getRight().getItem());
				}
			}
		}
		return combatModifiers;
	}
	
	static public boolean hasArtifact(LivingEntity livingEntity, Item item)
	{
		return TrinketsApi.getTrinketComponent(livingEntity).isPresent() && TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(item);
	}
	
	static public ItemEntity dropArtifact(PlayerEntity playerEntity, Item item)
	{
		ItemStack stack = TrinketsApi.getTrinketComponent(playerEntity).get().getEquipped(item).get(0).getRight();
		SlotReference ref = TrinketsApi.getTrinketComponent(playerEntity).get().getEquipped(item).get(0).getLeft();
		ref.inventory().setStack(ref.index(), ItemStack.EMPTY);
		return playerEntity.dropStack(stack);
	}
	
	static public boolean activateAllActiveArtifacts(PlayerEntity playerEntity)
	{
		boolean playSound = false;
		if(TrinketsApi.getTrinketComponent(playerEntity).isPresent())
		{
			
			for(Pair<SlotReference, ItemStack> pair:TrinketsApi.getTrinketComponent(playerEntity).get().getEquipped(stack -> stack.getItem() instanceof ActiveArtifactItem))
			{
				ItemStack itemStack = pair.getRight();
				if(itemStack.getDamage()==0)
				{
					((ActiveArtifactItem) itemStack.getItem()).activate(playerEntity);
					itemStack.setDamage(itemStack.getMaxDamage());
				}
				else
				{
					playSound = true;
				}
			}
		}
		return playSound;
	}
}
