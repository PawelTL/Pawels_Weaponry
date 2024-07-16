package net.paweltl.pawelsweaponry.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.paweltl.pawelsweaponry.PawelsWeaponry;

public class ToxicEnchantment extends Enchantment {
    public ToxicEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.FISHING_ROD, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }


    @Override
    public int getMinPower(int level) {
        return level * 10;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity entity) {
            if (entity.hasStatusEffect(PawelsWeaponry.TOXIN)) {
                int oldAmplifier = entity.getStatusEffect(PawelsWeaponry.TOXIN).getAmplifier();
                int oldDuration = entity.getStatusEffect(PawelsWeaponry.TOXIN).getDuration();
                entity.addStatusEffect(new StatusEffectInstance(PawelsWeaponry.TOXIN, oldDuration % 30 + 60 + 30 * (level - 1), oldAmplifier + 1), user);
            } else {
                entity.addStatusEffect(new StatusEffectInstance(PawelsWeaponry.TOXIN, 60 + 30 * (level - 1), 0), user);
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
