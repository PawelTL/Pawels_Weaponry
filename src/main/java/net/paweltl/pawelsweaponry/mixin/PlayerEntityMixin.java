package net.paweltl.pawelsweaponry.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.item.ModItems;
import net.paweltl.pawelsweaponry.item.custom.SpearItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow public abstract void incrementStat(Stat<?> stat);

    @Shadow public abstract ItemCooldownManager getItemCooldownManager();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @WrapOperation(method = "attack", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;horizontalSpeed:F", opcode = Opcodes.GETFIELD))
    private float alterHorizontalSpeedToSneakilyPreventSweeping(PlayerEntity instance, Operation<Float> original) {
        if (instance.getMainHandStack().getItem() instanceof SpearItem)
            return 10f;
        return original.call(instance);
    }
    @WrapOperation(method = "attack", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;prevHorizontalSpeed:F", opcode = Opcodes.GETFIELD))
    private float alterPrevHorizontalSpeedToSneakilyPreventSweeping(PlayerEntity instance, Operation<Float> original) {
        if (instance.getMainHandStack().getItem() instanceof SpearItem)
            return 0f;
        return original.call(instance);
    }

    @Inject(method = "damageShield", at = @At(value = "HEAD"), cancellable = true)
    private void damageShieldMixin(float amount, CallbackInfo ci) {
        if (this.activeItemStack.isOf(ModItems.TOWER_SHIELD) || this.activeItemStack.isOf(ModItems.BUCKLER)) {
            if (!this.getWorld().isClient) {
                this.incrementStat(Stats.USED.getOrCreateStat(this.activeItemStack.getItem()));
            }

            if (amount >= 3.0F) {
                int i = 1 + MathHelper.floor(amount);
                Hand hand = this.getActiveHand();
                EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                this.activeItemStack.damage(i, (LivingEntity)this, (player) -> {
                    player.sendEquipmentBreakStatus(equipmentSlot);
                });
                if (this.activeItemStack.isEmpty()) {
                    if (hand == Hand.MAIN_HAND) {
                        this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    } else {
                        this.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    }

                    this.activeItemStack = ItemStack.EMPTY;
                    this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.getWorld().random.nextFloat() * 0.4F);
                }
            }
            ci.cancel();

        }
    }

    @Inject(method = "disableShield", at = @At(value = "HEAD"), cancellable = true)
    private void disableShieldMixin(boolean sprinting, CallbackInfo ci) {
        if (this.activeItemStack.isOf(ModItems.TOWER_SHIELD)) {
            float f = 0.25F + (float) EnchantmentHelper.getEfficiency(this) * 0.05F;
            if (sprinting) {
                f += 0.75F;
            }

            if (this.random.nextFloat() < f) {
                this.getItemCooldownManager().set(ModItems.TOWER_SHIELD, 160);
            }
            ci.cancel();
        }
    }

//    @Inject(method = "takeShieldHit", at = @At(value = "TAIL"), cancellable = true)
//    private void disableBucklerMixin(LivingEntity attacker, CallbackInfo ci) {
//        if (this.getActiveItem().getItem() instanceof BucklerItem) {
//            this.getItemCooldownManager().set(this.getActiveItem().getItem(), 10);
//        }
//    }
}
