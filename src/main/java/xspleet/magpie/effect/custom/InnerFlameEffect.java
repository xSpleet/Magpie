package xspleet.magpie.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class InnerFlameEffect extends StatusEffect {
	public InnerFlameEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
      return true;
    }
   
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
      if (entity instanceof PlayerEntity playerEntity) 
      {
    	  entity.setFireTicks(0);
      }
    }
}
