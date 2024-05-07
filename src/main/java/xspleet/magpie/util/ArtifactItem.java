package xspleet.magpie.util;

import java.util.ArrayList;
import java.util.List;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xspleet.magpie.MagpieMod;

import static xspleet.magpie.MagpieMod.NO_DAMAGE;

public class ArtifactItem extends TrinketItem
{

    public ArtifactRarity artifactRarity = ArtifactRarity.COMMON;

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

    protected ArrayList<ArtifactModifier> artifactModifiers = new ArrayList<ArtifactModifier>(0);

    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) 
    {
        if(TrinketsUtil.hasArtifact(entity, stack.getItem()))
        {
            return false;
        }
        return super.canEquip(stack, slot, entity);
    }
    
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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        addArtifactRarity(tooltip);
        if(Screen.hasShiftDown())
        {
            if(stack.getItem() instanceof ActiveArtifactItem)
                tooltip.add(Text.translatable("item.magpie.tooltip.recharge").append(" " + stack.getMaxDamage()/20 + " ").append(Text.translatable("item.magpie.tooltip.seconds")));
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
