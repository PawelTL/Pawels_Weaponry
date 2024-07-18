package net.paweltl.pawelsweaponry.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.item.custom.DaggerItem;
import net.paweltl.pawelsweaponry.item.custom.HeavyCrossbowItem;
import net.paweltl.pawelsweaponry.item.custom.SpearItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Shadow @Final public EnchantmentTarget target;

    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void isAcceptableItemMixin(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if ((Object) this == Enchantments.SWEEPING && stack.getItem() instanceof SpearItem) {
            info.setReturnValue(false);
        }
        if ((Object) this == PawelsWeaponry.TOXIC && stack.getItem() instanceof DaggerItem) {
            info.setReturnValue(true);
        }
        if ((Object) this == PawelsWeaponry.TOXIC && stack.getItem() instanceof FishingRodItem) {
            info.setReturnValue(false);
        }
        if ((Object) this == Enchantments.POWER && stack.getItem() instanceof HeavyCrossbowItem) {
            info.setReturnValue(true);
        }
    }
}
