package net.paweltl.pawelsweaponry.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.item.custom.SpearItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
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
}
