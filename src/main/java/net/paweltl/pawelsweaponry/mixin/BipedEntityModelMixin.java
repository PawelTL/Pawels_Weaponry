package net.paweltl.pawelsweaponry.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.paweltl.pawelsweaponry.item.custom.DualBladeItem;
import net.paweltl.pawelsweaponry.item.custom.HammerItem;
import net.paweltl.pawelsweaponry.item.custom.SpearItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead {

    @Shadow
    public ModelPart rightArm;
    @Shadow
    public ModelPart leftArm;
    @Shadow
    public ModelPart head;


    @Shadow public BipedEntityModel.ArmPose leftArmPose;

    @Shadow public BipedEntityModel.ArmPose rightArmPose;

    @Inject(method = "setAngles", at = @At(value = "TAIL"))
    private void setAnglesMixin(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo info) {
        if (livingEntity.getMainHandStack().getItem() instanceof SpearItem) {
            this.rightArm.yaw = this.head.yaw * 0.5f;
            this.rightArm.pitch = this.head.pitch * 0.5f - 0.2f;

            if (this.handSwingProgress > 0) {
                float gx = 1.0F - this.handSwingProgress;
                float hx = MathHelper.sin(gx * 3.1415927F);
                float kx = this.head.pitch;
                if (kx < 0) {
                    kx = 0.25F;
                }
                float ix = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
                this.rightArm.roll = (float) ((double) this.rightArm.roll - ((double) hx * 0.1D + (double) ix * 0.15));
                this.rightArm.yaw = (float) ((double) this.rightArm.yaw - ((double) hx * 0.1D + (double) ix * 0.15));
                this.rightArm.pitch = (float) ((double) this.rightArm.pitch - ((double) hx * 0.1D + (double) ix * 0.15));
            }
        }
        if ( livingEntity.getMainHandStack().getItem() instanceof HammerItem && livingEntity.getOffHandStack().isEmpty()) {
            this.rightArm.pitch = -0.8727F + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
            this.rightArm.yaw = -0.5672F;
            this.rightArm.roll = 0.0F;
            this.leftArm.pitch = -1.0472F + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
            this.leftArm.yaw = 0.829F;
            this.leftArm.roll = -0.0436F;
            if (this.handSwingProgress > 0) {
                float gx = 1.0F - this.handSwingProgress;
                float hx = MathHelper.sin(gx * 3.1415927F);
                float kx = this.head.pitch;
                if (kx < 0) {
                    kx = 0.25F;
                }
                float ix = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
                this.rightArm.pitch = (float) ((double) this.rightArm.pitch - ((double) hx + (double) ix * 0.85D));
                this.leftArm.pitch = (float) ((double) this.leftArm.pitch - ((double) hx  + (double) ix)) * 0.75F;
            }
            if (livingEntity.isUsingItem()) {
                this.leftArm.pitch = this.leftArm.pitch - 0.8f;
                this.leftArm.yaw = this.leftArm.yaw - 0.05f;
                this.rightArm.pitch = this.rightArm.pitch - 0.8f;
                this.rightArm.yaw = this.rightArm.yaw + 0.05f;

            }
        }

    }

}
