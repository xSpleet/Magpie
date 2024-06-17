package xspleet.magpie.util;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ActiveArtifactItem extends ArtifactItem
{

	private int cooldown;

	/**
	 * Used when registering the item to set the artifact rarity
	 * @see #appendTooltip(ItemStack, World, List, TooltipContext)
	 * @see ArtifactRarity
	 * @param artifactRarity the rarity of the Artifact
	 * @return the Artifact with the modified rarity
	 *
	 */
	public ActiveArtifactItem rarity(ArtifactRarity artifactRarity)
	{
		this.artifactRarity = artifactRarity;
		return this;
	}

	/**
	 * @see #activate(PlayerEntity)
	 * @param cooldown the cooldown of the Active Artifact
	 * @return the ActiveArtifact with the modified cooldown
	 */
	public ActiveArtifactItem cooldown(int cooldown)
	{
		this.cooldown = cooldown;
		return this;
	}

	public int getCooldown()
	{
		return this.cooldown;
	}

	public void activate(PlayerEntity playerEntity){}

	public ActiveArtifactItem(Settings settings) 
	{
		super(settings);
	}
	
}
