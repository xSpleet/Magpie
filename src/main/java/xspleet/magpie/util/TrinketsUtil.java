package xspleet.magpie.util;




import java.util.ArrayList;
import java.util.List;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;

public class TrinketsUtil 
{

	/**
	 * @see SlotReference
	 * @see ActiveArtifactItem
	 * @see #activateAllActiveArtifacts(PlayerEntity)
	 * @param livingEntity
	 * @return the list of SlotReferences and ItemStacks, the items in which are ActiveArtifactItems
	 */
	static public List<Pair<SlotReference, ItemStack>> getActiveArtifacts(LivingEntity livingEntity)
	{
		List<Pair<SlotReference, ItemStack>> activeArtifacts = new ArrayList<>(0);
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

	/**
	 *
	 * @param livingEntity
	 * @return the List of ArtifactItems which have the interface CombatModifier
	 */
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

	/**
	 *
	 * @param livingEntity the entity checked
	 * @param item the item checked
	 * @return whether the livingEntity has the item equipped
	 */
	static public boolean hasArtifact(LivingEntity livingEntity, Item item)
	{
		return TrinketsApi.getTrinketComponent(livingEntity).isPresent() && TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(item);
	}

	/**
	 * Drops the given artifact from the playerEntity
	 * @see xspleet.magpie.item.custom.LizardsTailItem
	 * @param playerEntity
	 * @param item
	 * @return the ItemEntity that was dropped
	 */
	static public ItemEntity dropArtifact(PlayerEntity playerEntity, Item item)
	{
		if(!TrinketsApi.getTrinketComponent(playerEntity).isPresent())
			return null;
		ItemStack stack = TrinketsApi.getTrinketComponent(playerEntity).get().getEquipped(item).get(0).getRight();
		SlotReference ref = TrinketsApi.getTrinketComponent(playerEntity).get().getEquipped(item).get(0).getLeft();
		ref.inventory().setStack(ref.index(), ItemStack.EMPTY);
		return playerEntity.dropStack(stack);
	}

	/**
	 * @see #getActiveArtifacts(LivingEntity)
	 * @see ActiveArtifactItem#activate(PlayerEntity)
	 * It iterates through all the Artifacts the player has eqquiped and activates the charged active artifact
	 * @param playerEntity
	 * @return
	 */
	static public boolean activateAllActiveArtifacts(PlayerEntity playerEntity)
	{
		ItemCooldownManager cooldownManager = playerEntity.getItemCooldownManager();
		boolean playSound = false;
		if(TrinketsApi.getTrinketComponent(playerEntity).isPresent())
		{
			for(Pair<SlotReference, ItemStack> pair:TrinketsApi.getTrinketComponent(playerEntity).get().getEquipped(stack -> stack.getItem() instanceof ActiveArtifactItem))
			{
				Item item = pair.getRight().getItem();
				if(!cooldownManager.isCoolingDown(item))
				{
					((ActiveArtifactItem)item).activate(playerEntity);
					cooldownManager.set(item, ((ActiveArtifactItem) item).getCooldown());
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
