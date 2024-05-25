package xspleet.magpie.util;

import net.minecraft.entity.player.PlayerEntity;

public class ActiveArtifactItem extends ArtifactItem
{

	private int cooldown;

	public ActiveArtifactItem rarity(ArtifactRarity artifactRarity)
	{
		this.artifactRarity = artifactRarity;
		return this;
	}

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
