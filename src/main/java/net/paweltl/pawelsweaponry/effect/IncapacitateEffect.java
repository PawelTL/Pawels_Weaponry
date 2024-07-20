package net.paweltl.pawelsweaponry.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class IncapacitateEffect extends StatusEffect {
    public IncapacitateEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        double x = entity.getVelocity().x;
        double y = 0;
        if (entity.getVelocity().y > 0) {y = 0.4 * entity.getVelocity().y;}
        else {y = entity.getVelocity().y;}
        double z = entity.getVelocity().z;
        entity.setVelocity(0.75 * x, y, 0.75 * z);
    }
}
