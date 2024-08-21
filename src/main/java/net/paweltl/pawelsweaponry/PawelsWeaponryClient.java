package net.paweltl.pawelsweaponry;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.paweltl.pawelsweaponry.util.ModModelPredicateProvider;


public class PawelsWeaponryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModModels();
    }
}
