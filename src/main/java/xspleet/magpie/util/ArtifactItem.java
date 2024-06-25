package xspleet.magpie.util;

import java.util.ArrayList;
import java.util.List;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xspleet.magpie.item.custom.ForkItem;

public class ArtifactItem extends TrinketItem
{

    public ArtifactRarity artifactRarity = ArtifactRarity.COMMON;


    /**
     * Used when registering the item to set the artifact rarity
     * @see #appendTooltip(ItemStack, World, List, TooltipContext)
     * @see ArtifactRarity
     * @param artifactRarity the rarity of the Artifact
     * @return the Artifact with the modified rarity
     *
     */
    public ArtifactItem rarity(ArtifactRarity artifactRarity)
    {
        this.artifactRarity = artifactRarity;
        return this;
    }

    private void addArtifactRarity(List<Text> tooltip)
    {
        switch (artifactRarity)
        {
            case COMMON: {
                tooltip.add(Text.translatable("item.magpie.rarity.common").formatted(Formatting.BOLD).formatted(Formatting.GRAY));
                break;
            }
            case RARE: {
                tooltip.add(Text.translatable("item.magpie.rarity.rare").formatted(Formatting.BOLD).formatted(Formatting.BLUE));
                break;
            }
            case EPIC: {
                tooltip.add(Text.translatable("item.magpie.rarity.epic").formatted(Formatting.BOLD).formatted(Formatting.DARK_PURPLE));
                break;
            }
            case LEGENDARY: {
                tooltip.add(Text.translatable("item.magpie.rarity.legendary").formatted(Formatting.BOLD).formatted(Formatting.GOLD));
                break;
            }
        }
    }

    protected ArrayList<ArtifactModifier> artifactModifiers = new ArrayList<>(0);


    /**
     *
     * Forbids the player to have the same Artifact equipped twice
     */
    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) 
    {
        if(TrinketsUtil.hasArtifact(entity, stack.getItem()))
        {
            return false;
        }
        return super.canEquip(stack, slot, entity);
    }


    /**
     * Adds AttributeModifiers to the list of ArtifactModifiers
     * @see ArtifactModifier
     * @see #onEquip(ItemStack, SlotReference, LivingEntity)
     *
     */
    protected void registerAttributeModifiers() {
	}

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) 
    {
    	for(ArtifactModifier artifactModifier: artifactModifiers)
        {
        	artifactModifier.update(entity);
        }
    	super.onEquip(stack, slot, entity);
    }
    
    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) 
    {
    	for(ArtifactModifier artifactModifier: artifactModifiers)
    	{
    		artifactModifier.remove(entity);
    	}
    	super.onUnequip(stack, slot, entity);
    }
    
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
    	super.tick(stack, slot, entity);
	    for(ArtifactModifier artifactModifier: artifactModifiers)
	    {
	    	artifactModifier.update(entity);
	    }
    }

    /**
     * Adds the tooltips written in the lang file
     * For the description of the way of writing the lang file look at the Wiki or an example
     * @see #rarity(ArtifactRarity)
     * @param stack
     * @param world
     * @param tooltip the list of tooltips to show
     * @param context
     */
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        addArtifactRarity(tooltip);
        if(world.isClient && Screen.hasShiftDown())
        {
            if(stack.getItem() instanceof ActiveArtifactItem activeArtifact)
            {
                tooltip.add(Text.translatable("item.magpie.tooltip.recharge", activeArtifact.getCooldown()/20 + " "));
            }
            TextFormatter.addTooltips(Text.translatable("item.magpie.tooltip." + stack.getItem()),tooltip);
        }
        else
        {
            if(stack.getItem() instanceof ActiveArtifactItem)
                TextFormatter.addTooltips(Text.translatable("item.magpie.tooltip.active"), tooltip);
            TextFormatter.addTooltips(Text.translatable("item.magpie.description." + stack.getItem()), tooltip);
            tooltip.add(Text.translatable("item.magpie.tooltip.shiftmoreinfo"));
        }
    }

    public ArtifactItem(Settings settings)
    {
        super(settings);
        registerAttributeModifiers();
    }

}
