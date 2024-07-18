package net.paweltl.pawelsweaponry.mixin;


import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.item.custom.HeavyCrossbowItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(CrossbowItem.class)
public abstract class CrossbowItemMixin extends RangedWeaponItem {

    public CrossbowItemMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "getPullTime", at = @At("RETURN"), cancellable = true)
    private static void getPullTimeMixin (ItemStack stack, CallbackInfoReturnable<Integer> cir) {
         if (stack.getItem() instanceof HeavyCrossbowItem) {
             int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
             cir.setReturnValue(60 - 5 * i);
             cir.cancel();
         }
    }

    @Inject(method = "createArrow", at = @At("RETURN"), cancellable = true)
    private static void createArrowMixin (World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow, CallbackInfoReturnable<PersistentProjectileEntity> cir) {
       if (crossbow.getItem() instanceof HeavyCrossbowItem) {
           ArrowItem arrowItem = (ArrowItem) (arrow.getItem() instanceof ArrowItem ? arrow.getItem() : Items.ARROW);
           PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, arrow, entity);
           if (entity instanceof PlayerEntity) {
               persistentProjectileEntity.setCritical(true);
           }

           persistentProjectileEntity.setSound(SoundEvents.ITEM_CROSSBOW_HIT);
           persistentProjectileEntity.setShotFromCrossbow(true);
           int i = EnchantmentHelper.getLevel(Enchantments.PIERCING, crossbow);
           if (i > 0) {
               persistentProjectileEntity.setPierceLevel((byte) i);
           }
           int k = EnchantmentHelper.getEquipmentLevel(Enchantments.POWER, entity);
           persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double) k * 0.45 + 0.45);

           cir.setReturnValue(persistentProjectileEntity);
           cir.cancel();
       }
    }

}
