package net.paweltl.pawelsweaponry.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.paweltl.pawelsweaponry.item.custom.LongSwordItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useWeaponModels(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.WOODEN_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_hammer_3d", "inventory"));
        }
        if (stack.isOf(ModItems.GOLD_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_hammer_3d", "inventory"));
        }
        if (stack.isOf(ModItems.STONE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_hammer_3d", "inventory"));
        }
        if (stack.isOf(ModItems.IRON_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_hammer_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DIAMOND_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_hammer_3d", "inventory"));
        }
        if (stack.isOf(ModItems.NETHERITE_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_hammer_3d", "inventory"));
        }


        if (stack.isOf(ModItems.WOODEN_DUAL_BLADE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_dual_blade_3d", "inventory"));
        }
        if (stack.isOf(ModItems.GOLD_DUAL_BLADE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_dual_blade_3d", "inventory"));
        }
        if (stack.isOf(ModItems.STONE_DUAL_BLADE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_dual_blade_3d", "inventory"));
        }
        if (stack.isOf(ModItems.IRON_DUAL_BLADE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_dual_blade_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DIAMOND_DUAL_BLADE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_dual_blade_3d", "inventory"));
        }
        if (stack.isOf(ModItems.NETHERITE_DUAL_BLADE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_dual_blade_3d", "inventory"));
        }


        if (stack.isOf(ModItems.WOODEN_KATANA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_katana_3d", "inventory"));
        }
        if (stack.isOf(ModItems.GOLD_KATANA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_katana_3d", "inventory"));
        }
        if (stack.isOf(ModItems.STONE_KATANA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_katana_3d", "inventory"));
        }
        if (stack.isOf(ModItems.IRON_KATANA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_katana_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DIAMOND_KATANA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_katana_3d", "inventory"));
        }
        if (stack.isOf(ModItems.NETHERITE_KATANA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_katana_3d", "inventory"));
        }


        if (stack.isOf(ModItems.WOODEN_SPEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_spear_3d", "inventory"));
        }
        if (stack.isOf(ModItems.GOLD_SPEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_spear_3d", "inventory"));
        }
        if (stack.isOf(ModItems.STONE_SPEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_spear_3d", "inventory"));
        }
        if (stack.isOf(ModItems.IRON_SPEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_spear_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DIAMOND_SPEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_spear_3d", "inventory"));
        }
        if (stack.isOf(ModItems.NETHERITE_SPEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_spear_3d", "inventory"));
        }


        if (stack.isOf(ModItems.WOODEN_BATTLEAXE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_battleaxe_3d", "inventory"));
        }
        if (stack.isOf(ModItems.GOLD_BATTLEAXE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_battleaxe_3d", "inventory"));
        }
        if (stack.isOf(ModItems.STONE_BATTLEAXE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_battleaxe_3d", "inventory"));
        }
        if (stack.isOf(ModItems.IRON_BATTLEAXE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_battleaxe_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DIAMOND_BATTLEAXE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_battleaxe_3d", "inventory"));
        }
        if (stack.isOf(ModItems.NETHERITE_BATTLEAXE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_battleaxe_3d", "inventory"));
        }


        if (stack.isOf(ModItems.WOODEN_LONGSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_longsword_3d", "inventory"));
        }
        if (stack.isOf(ModItems.GOLD_LONGSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_longsword_3d", "inventory"));
        }
        if (stack.isOf(ModItems.STONE_LONGSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_longsword_3d", "inventory"));
        }
        if (stack.isOf(ModItems.IRON_LONGSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_longsword_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DIAMOND_LONGSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_longsword_3d", "inventory"));
        }
        if (stack.isOf(ModItems.NETHERITE_LONGSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_longsword_3d", "inventory"));
        }



        return value;
    }

    @Inject(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"))
    private void renderItemMixin(@Nullable LivingEntity entity, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                                 @Nullable World world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && (renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND)
                && entity.isBlocking() && (stack.getItem() instanceof LongSwordItem)) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(leftHanded ? -15F : 15F));
        }
    }
}
