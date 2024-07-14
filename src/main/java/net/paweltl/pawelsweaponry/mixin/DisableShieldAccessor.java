package net.paweltl.pawelsweaponry.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.item.custom.HammerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class DisableShieldAccessor extends Entity
{
    @Shadow public abstract ItemStack getMainHandStack();

    public DisableShieldAccessor(EntityType<? extends LivingEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Inject(method = "disablesShield", at = @At("HEAD"), cancellable = true)
    private void disableShieldAccessor$onDisablesShield(CallbackInfoReturnable<Boolean> cir)
    {
        if (this.getMainHandStack().getItem() instanceof HammerItem)
        {
            cir.setReturnValue(true);
        }

    }
}
