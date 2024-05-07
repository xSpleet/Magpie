package xspleet.magpie.mixin;


import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.TrinketsUtil;

@Mixin(VillagerEntity.class)
public abstract class MixinVillagerEntity
{
    @Inject(method = "prepareOffersFor", at = @At("TAIL"))
    private void injected(PlayerEntity player, CallbackInfo ci)
    {
        if(TrinketsUtil.hasArtifact(player, ModItems.SALE_TAG))
        {
            for (TradeOffer tradeOffer : ((VillagerEntity) (Object) this).getOffers())
            {
                tradeOffer.increaseSpecialPrice((int) -Math.round(tradeOffer.getAdjustedFirstBuyItem().getCount()*0.15));
            }
        }
    }
}
