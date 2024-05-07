package xspleet.magpie.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class TidalFlowEffect extends StatusEffect {
    public TidalFlowEffect(StatusEffectCategory category, int color) {
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
    	  playerEntity.setAir(playerEntity.getMaxAir());
      }
    }
}
