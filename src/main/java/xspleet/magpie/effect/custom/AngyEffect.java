package xspleet.magpie.effect.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.text.Text;

public class AngyEffect extends StatusEffect {
    public AngyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    LivingEntity entity;
    public void onRemoved(AttributeContainer attributes) {
        if(entity instanceof BeeEntity)
            entity.kill();
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.entity = entity;
        if(entity instanceof BeeEntity bee)
            if(!bee.hasAngerTime())
                bee.kill();
    }
}
