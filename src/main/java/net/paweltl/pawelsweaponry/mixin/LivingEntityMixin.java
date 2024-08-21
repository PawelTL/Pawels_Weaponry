package net.paweltl.pawelsweaponry.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.item.custom.BucklerItem;
import net.paweltl.pawelsweaponry.item.custom.HammerItem;
import net.paweltl.pawelsweaponry.item.custom.KatanaItem;
import net.paweltl.pawelsweaponry.item.custom.LongSwordItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow public abstract boolean isBlocking();

    @Shadow public abstract ItemStack getActiveItem();

    @Shadow public abstract ItemStack getMainHandStack();

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Shadow public abstract @Nullable DamageSource getRecentDamageSource();

    @Shadow public abstract boolean blockedByShield(DamageSource source);

    @Shadow public abstract void damageShield(float amount);

    @Shadow protected abstract void takeShieldHit(LivingEntity attacker);

    @Shadow private @Nullable LivingEntity attacker;

    @Shadow protected abstract void applyDamage(DamageSource source, float amount);

    @Shadow protected abstract void playHurtSound(DamageSource source);

    @Shadow protected abstract @Nullable SoundEvent getHurtSound(DamageSource source);

    @Shadow protected abstract float getSoundVolume();

    @Shadow public abstract float getSoundPitch();

    @Shadow public int maxHurtTime;

    @Shadow public int hurtTime;

    @Shadow public abstract boolean isDead();

    @Shadow protected abstract boolean tryUseTotem(DamageSource source);

    @Shadow protected abstract @Nullable SoundEvent getDeathSound();

    @Shadow public abstract void onDeath(DamageSource damageSource);

    @Shadow @Final public LimbAnimator limbAnimator;

    @Shadow protected float lastDamageTaken;

    @Shadow public abstract Collection<StatusEffectInstance> getStatusEffects();

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow public abstract float getHealth();

    @Shadow public abstract void setHealth(float health);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "blockedByShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;dotProduct(Lnet/minecraft/util/math/Vec3d;)D", shift = At.Shift.AFTER), cancellable = true)
    private void blockedByShieldMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getActiveItem();
        if ( itemStack.getItem() instanceof LongSwordItem) {
            if (livingEntity instanceof PlayerEntity) {
                ((PlayerEntity) livingEntity).getItemCooldownManager().set(itemStack.getItem(), 100);
            }
            livingEntity.clearActiveItem();
            if (!this.getWorld().isClient()) {
                livingEntity.getMainHandStack().damage(1, livingEntity, (e) -> {
                    e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
                });
            }
        }
    }

    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damageShield(F)V"), cancellable = true)
    private void damageBucklerMixin(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (this.getActiveItem().getItem() instanceof BucklerItem) {
            this.damageShield(amount);
            this.limbAnimator.setSpeed(1.5F);
            if ((float)this.timeUntilRegen > 10.0F && !source.isIn(DamageTypeTags.BYPASSES_COOLDOWN)) {
                this.applyDamage(source, amount * 0.5f - this.lastDamageTaken);
                this.lastDamageTaken = amount * 0.5f;
            } else {
                this.lastDamageTaken = amount * 0.5f;
                this.timeUntilRegen = 20;
                this.applyDamage(source, amount * 0.5f);
                this.maxHurtTime = 10;
                this.hurtTime = this.maxHurtTime;
            }
            if (this.isDead()) {
                if (!this.tryUseTotem(source)) {
                    SoundEvent soundEvent = this.getDeathSound();
                    this.playSound(soundEvent, this.getSoundVolume(), this.getSoundPitch());
                    this.onDeath(source);
                }
            } else  {
                getWorld().playSound(null, this.getBlockPos(), SoundEvents.ENTITY_GENERIC_HURT, SoundCategory.PLAYERS , 1f, 1f);
            }

            amount = 0;
        }
    }

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void jumpMixin(CallbackInfo ci) {
        if (this.getActiveItem().getItem() instanceof KatanaItem || this.getActiveItem().getItem() instanceof HammerItem) {
            ci.cancel();
        }
    }

    @Inject(method = "heal", at = @At("HEAD"), cancellable = true)
    private void healMixin(float amount, CallbackInfo ci) {
        if (this.hasStatusEffect(PawelsWeaponry.WOUNDED)) {
            amount *= 0.5;
            float f = this.getHealth();
            if (f > 0.0F) {
                this.setHealth(f + amount);
            }
            ci.cancel();
        }
    }


}
