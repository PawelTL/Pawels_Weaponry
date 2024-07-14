package net.paweltl.pawelsweaponry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.paweltl.pawelsweaponry.block.ModBlocks;
import net.paweltl.pawelsweaponry.item.ModItems;
import net.paweltl.pawelsweaponry.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider  extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

    }
}
