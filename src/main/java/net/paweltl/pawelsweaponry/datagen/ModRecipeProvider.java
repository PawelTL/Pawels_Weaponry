package net.paweltl.pawelsweaponry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        hammer(ModItems.WOODEN_HAMMER, ItemTags.PLANKS, exporter);
        hammer(ModItems.GOLD_HAMMER, Items.GOLD_INGOT, exporter);
        hammer(ModItems.STONE_HAMMER, Items.COBBLESTONE, exporter);
        hammer(ModItems.IRON_HAMMER, Items.IRON_INGOT, exporter);
        hammer(ModItems.DIAMOND_HAMMER, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_HAMMER, RecipeCategory.COMBAT, ModItems.NETHERITE_HAMMER);


        spear(ModItems.WOODEN_SPEAR, ItemTags.PLANKS, exporter);
        spear(ModItems.GOLD_SPEAR, Items.GOLD_INGOT, exporter);
        spear(ModItems.STONE_SPEAR, Items.COBBLESTONE, exporter);
        spear(ModItems.IRON_SPEAR, Items.IRON_INGOT, exporter);
        spear(ModItems.DIAMOND_SPEAR, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_SPEAR, RecipeCategory.COMBAT, ModItems.NETHERITE_SPEAR);


        dagger(ModItems.WOODEN_DAGGER, ItemTags.PLANKS, exporter);
        dagger(ModItems.GOLD_DAGGER, Items.GOLD_INGOT, exporter);
        dagger(ModItems.STONE_DAGGER, Items.COBBLESTONE, exporter);
        dagger(ModItems.IRON_DAGGER, Items.IRON_INGOT, exporter);
        dagger(ModItems.DIAMOND_DAGGER, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_DAGGER, RecipeCategory.COMBAT, ModItems.NETHERITE_DAGGER);

        cleaver(ModItems.WOODEN_CLEAVER, ItemTags.PLANKS, exporter);
        cleaver(ModItems.GOLD_CLEAVER, Items.GOLD_INGOT, exporter);
        cleaver(ModItems.STONE_CLEAVER, Items.COBBLESTONE, exporter);
        cleaver(ModItems.IRON_CLEAVER, Items.IRON_INGOT, exporter);
        cleaver(ModItems.DIAMOND_CLEAVER, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_CLEAVER, RecipeCategory.COMBAT, ModItems.NETHERITE_CLEAVER);

        dualblade(ModItems.WOODEN_DUAL_BLADE, ItemTags.PLANKS, exporter);
        dualblade(ModItems.GOLD_DUAL_BLADE, Items.GOLD_INGOT, exporter);
        dualblade(ModItems.STONE_DUAL_BLADE, Items.COBBLESTONE, exporter);
        dualblade(ModItems.IRON_DUAL_BLADE, Items.IRON_INGOT, exporter);
        dualblade(ModItems.DIAMOND_DUAL_BLADE, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_DUAL_BLADE, RecipeCategory.COMBAT, ModItems.NETHERITE_DUAL_BLADE);

        longsword(ModItems.WOODEN_LONGSWORD, ItemTags.PLANKS, exporter);
        longsword(ModItems.GOLD_LONGSWORD, Items.GOLD_INGOT, exporter);
        longsword(ModItems.STONE_LONGSWORD, Items.COBBLESTONE, exporter);
        longsword(ModItems.IRON_LONGSWORD, Items.IRON_INGOT, exporter);
        longsword(ModItems.DIAMOND_LONGSWORD, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_LONGSWORD, RecipeCategory.COMBAT, ModItems.NETHERITE_LONGSWORD);

        katana(ModItems.WOODEN_KATANA, ItemTags.PLANKS, exporter);
        katana(ModItems.GOLD_KATANA, Items.GOLD_INGOT, exporter);
        katana(ModItems.STONE_KATANA, Items.COBBLESTONE, exporter);
        katana(ModItems.IRON_KATANA, Items.IRON_INGOT, exporter);
        katana(ModItems.DIAMOND_KATANA, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_KATANA, RecipeCategory.COMBAT, ModItems.NETHERITE_KATANA);

        battleaxe(ModItems.WOODEN_BATTLEAXE, ItemTags.PLANKS, exporter);
        battleaxe(ModItems.GOLD_BATTLEAXE, Items.GOLD_INGOT, exporter);
        battleaxe(ModItems.STONE_BATTLEAXE, Items.COBBLESTONE, exporter);
        battleaxe(ModItems.IRON_BATTLEAXE, Items.IRON_INGOT, exporter);
        battleaxe(ModItems.DIAMOND_BATTLEAXE, Items.DIAMOND, exporter);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_BATTLEAXE, RecipeCategory.COMBAT, ModItems.NETHERITE_BATTLEAXE);


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
    private void cleaver(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("xx")
                .pattern("/ ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void cleaver(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("xx")
                .pattern("/ ")
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
    private void dualblade(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern(" x ")
                .pattern("/  ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void dualblade(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern(" x ")
                .pattern("/  ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void longsword(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern("xx ")
                .pattern("/x ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void longsword(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern("xx ")
                .pattern("/x ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void katana(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern("xx ")
                .pattern("/x ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void katana(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("  x")
                .pattern("xx ")
                .pattern("/x ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void battleaxe(ItemConvertible output, ItemConvertible material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern(" xx")
                .pattern(" /x")
                .pattern("/  ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
    private void battleaxe(ItemConvertible output, TagKey<Item> material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern(" xx")
                .pattern(" /x")
                .pattern("/  ")
                .input('x', material)
                .input('/', Items.STICK)
                .criterion("has_material", FabricRecipeProvider.conditionsFromTag(material))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }

}
