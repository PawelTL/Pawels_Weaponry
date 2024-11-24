package net.paweltl.pawelsweaponry.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityInvoker {

    @Invoker("getRotationVector")
    public Vec3d invokeGetRotationVector(float pitch, float yaw);
}
