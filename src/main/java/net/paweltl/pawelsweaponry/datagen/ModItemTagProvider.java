package net.paweltl.pawelsweaponry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.paweltl.pawelsweaponry.item.ModItems;
import net.paweltl.pawelsweaponry.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider  extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.PAWELS_WEAPONS)
                .add(ModItems.DIAMOND_HAMMER)
                .add(ModItems.DIAMOND_LONGSWORD)
                .add(ModItems.DIAMOND_DAGGER)
                .add(ModItems.DIAMOND_DUAL_BLADE)
                .add(ModItems.DIAMOND_KATANA)
                .add(ModItems.DIAMOND_CLEAVER)
                .add(ModItems.DIAMOND_SPEAR)
                .add(ModItems.DIAMOND_BATTLEAXE)
                .add(ModItems.IRON_HAMMER)
                .add(ModItems.IRON_LONGSWORD)
                .add(ModItems.IRON_DAGGER)
                .add(ModItems.IRON_DUAL_BLADE)
                .add(ModItems.IRON_KATANA)
                .add(ModItems.IRON_CLEAVER)
                .add(ModItems.IRON_SPEAR)
                .add(ModItems.IRON_BATTLEAXE)
                .add(ModItems.WOODEN_HAMMER)
                .add(ModItems.WOODEN_LONGSWORD)
                .add(ModItems.WOODEN_DAGGER)
                .add(ModItems.WOODEN_DUAL_BLADE)
                .add(ModItems.WOODEN_KATANA)
                .add(ModItems.WOODEN_CLEAVER)
                .add(ModItems.WOODEN_SPEAR)
                .add(ModItems.WOODEN_BATTLEAXE)
                .add(ModItems.NETHERITE_HAMMER)
                .add(ModItems.NETHERITE_LONGSWORD)
                .add(ModItems.NETHERITE_DAGGER)
                .add(ModItems.NETHERITE_DUAL_BLADE)
                .add(ModItems.NETHERITE_KATANA)
                .add(ModItems.NETHERITE_CLEAVER)
                .add(ModItems.NETHERITE_SPEAR)
                .add(ModItems.NETHERITE_BATTLEAXE)
                .add(ModItems.STONE_HAMMER)
                .add(ModItems.STONE_LONGSWORD)
                .add(ModItems.STONE_DAGGER)
                .add(ModItems.STONE_DUAL_BLADE)
                .add(ModItems.STONE_KATANA)
                .add(ModItems.STONE_CLEAVER)
                .add(ModItems.STONE_SPEAR)
                .add(ModItems.STONE_BATTLEAXE)
                .add(ModItems.GOLD_HAMMER)
                .add(ModItems.GOLD_LONGSWORD)
                .add(ModItems.GOLD_DAGGER)
                .add(ModItems.GOLD_DUAL_BLADE)
                .add(ModItems.GOLD_KATANA)
                .add(ModItems.GOLD_CLEAVER)
                .add(ModItems.GOLD_SPEAR)
                .add(ModItems.GOLD_BATTLEAXE);


    }
}
