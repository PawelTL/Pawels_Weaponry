package net.paweltl.pawelsweaponry.mixin;

import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void addModel(ModelIdentifier modelId);
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addWeaponModels(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_hammer_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_hammer_3d", "inventory"));

        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_dual_blade_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_dual_blade_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_dual_blade_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_dual_blade_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_dual_blade_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_dual_blade_3d", "inventory"));

        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_longsword_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_longsword_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_longsword_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_longsword_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_longsword_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_longsword_3d", "inventory"));

        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_spear_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_spear_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_spear_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_spear_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_spear_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_spear_3d", "inventory"));

        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_katana_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_katana_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_katana_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_katana_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_katana_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_katana_3d", "inventory"));

        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "wooden_battleaxe_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "gold_battleaxe_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "stone_battleaxe_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "iron_battleaxe_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_battleaxe_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "netherite_battleaxe_3d", "inventory"));

        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_katana_3d", "inventory"));
        this.addModel(new ModelIdentifier(PawelsWeaponry.MOD_ID, "diamond_spear_3d", "inventory"));
    }
}
