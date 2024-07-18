package net.paweltl.pawelsweaponry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.paweltl.pawelsweaponry.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


        itemModelGenerator.register(ModItems.WOODEN_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_CLEAVER, Models.HANDHELD);


        itemModelGenerator.register(ModItems.WOODEN_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_DAGGER, Models.HANDHELD);


    }
}
