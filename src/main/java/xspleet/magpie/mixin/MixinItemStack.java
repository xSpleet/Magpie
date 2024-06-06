package xspleet.magpie.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xspleet.magpie.item.ModItems;

import java.util.Random;
import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class MixinItemStack
{
    @Inject(method = "damage(ILnet/minecraft/entity/LivingEntity;Ljava/util/function/Consumer;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
    private <T extends LivingEntity> void dropPocket(int amount, T entity, Consumer<T> breakCallback, CallbackInfo ci)
    {
        if(entity.getEquippedStack(EquipmentSlot.LEGS) == ((ItemStack)(Object)this))
        {
            if((new Random().nextInt(1000)) == 0)
            {
                ItemEntity pocket = new ItemEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.POCKET));
                entity.getWorld().spawnEntity(pocket);
            }
        }
    }
}
