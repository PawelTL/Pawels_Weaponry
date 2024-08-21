package net.paweltl.pawelsweaponry.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.paweltl.pawelsweaponry.PawelsWeaponry;

public class ToxinEffect extends StatusEffect {
    public ToxinEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 30 == 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (amplifier > 3) {
            entity.damage(PawelsWeaponry.of(entity.getWorld(), PawelsWeaponry.TOXIN_DAMAGE_TYPE), (float) Math.ceil(amplifier * 0.15));
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
