package net.paweltl.pawelsweaponry.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.paweltl.pawelsweaponry.item.custom.HammerItem;
import net.paweltl.pawelsweaponry.item.custom.LongSwordItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "doAttack", at = @At(value = "HEAD"), cancellable = true)
    private void doAttackMixin(CallbackInfoReturnable<Boolean> info) {
        ItemStack itemStack = player.getMainHandStack();
        ItemStack offHandStack = player.getOffHandStack();
        if (((itemStack.getItem() instanceof LongSwordItem || itemStack.getItem() instanceof HammerItem) && !player.getOffHandStack().isEmpty()) ||
                ((offHandStack.getItem() instanceof LongSwordItem || offHandStack.getItem() instanceof HammerItem) && !player.getMainHandStack().isEmpty()))
            info.setReturnValue(false);
    }

    @Inject(method = "doItemUse", at = @At(value = "HEAD"), cancellable = true)
    private void doItemUseMixin(CallbackInfo info) {
        if (player != null) {
            ItemStack itemStack = player.getMainHandStack();
            ItemStack offHandStack = player.getOffHandStack();
            if (((itemStack.getItem() instanceof LongSwordItem || itemStack.getItem() instanceof HammerItem) && !player.getOffHandStack().isEmpty()) ||
                    ((offHandStack.getItem() instanceof LongSwordItem || offHandStack.getItem() instanceof HammerItem) && !player.getMainHandStack().isEmpty()))
                info.cancel();
        }
    }


}
