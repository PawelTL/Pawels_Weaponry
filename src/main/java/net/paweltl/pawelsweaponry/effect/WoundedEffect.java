package net.paweltl.pawelsweaponry.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class WoundedEffect extends StatusEffect {
    public WoundedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(StatusEffects.ABSORPTION)) {entity.removeStatusEffect(StatusEffects.ABSORPTION);}
        if (entity instanceof PlayerEntity) {
            if (((PlayerEntity) entity).getHungerManager().getSaturationLevel() > 2) {
                ((PlayerEntity) entity).getHungerManager().setSaturationLevel(2);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
