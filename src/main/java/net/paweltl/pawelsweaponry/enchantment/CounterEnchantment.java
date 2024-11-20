package net.paweltl.pawelsweaponry.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.paweltl.pawelsweaponry.PawelsWeaponry;

public class CounterEnchantment extends Enchantment {
    public CounterEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[] {EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 10;
    }

    @Override
    public int getMaxPower(int level) {
        return 100;
    }
}
