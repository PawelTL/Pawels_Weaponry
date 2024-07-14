package net.paweltl.pawelsweaponry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.block.ModBlocks;
import net.paweltl.pawelsweaponry.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        hammer(ModItems.WOODEN_HAMMER, ItemTags.PLANKS, exporter);
        hammer(ModItems.GOLD_HAMMER, Items.GOLD_INGOT, exporter);
        hammer(ModItems.STONE_HAMMER, Items.STONE, exporter);
        hammer(ModItems.IRON_HAMMER, Items.IRON_INGOT, exporter);
        hammer(ModItems.DIAMOND_HAMMER, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_HAMMER, RecipeCategory.COMBAT, ModItems.NETHERITE_HAMMER);


        spear(ModItems.WOODEN_SPEAR, ItemTags.PLANKS, exporter);
        spear(ModItems.GOLD_SPEAR, Items.GOLD_INGOT, exporter);
        spear(ModItems.STONE_SPEAR, Items.STONE, exporter);
        spear(ModItems.IRON_SPEAR, Items.IRON_INGOT, exporter);
        spear(ModItems.DIAMOND_SPEAR, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_SPEAR, RecipeCategory.COMBAT, ModItems.NETHERITE_SPEAR);


        dagger(ModItems.WOODEN_DAGGER, ItemTags.PLANKS, exporter);
        dagger(ModItems.GOLD_DAGGER, Items.GOLD_INGOT, exporter);
        dagger(ModItems.STONE_DAGGER, Items.STONE, exporter);
        dagger(ModItems.IRON_DAGGER, Items.IRON_INGOT, exporter);
        dagger(ModItems.DIAMOND_DAGGER, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_DAGGER, RecipeCategory.COMBAT, ModItems.NETHERITE_DAGGER);


    }
    private void dagger(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("x")
                .pattern("/")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void dagger(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("x")
                .pattern("/")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void hammer(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("xxx")
                .pattern("x/x")
                .pattern(" / ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void hammer(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("xxx")
                .pattern("x/x")
                .pattern(" / ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void spear(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern(" / ")
                .pattern("/  ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void spear(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern(" / ")
                .pattern("/  ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
}
