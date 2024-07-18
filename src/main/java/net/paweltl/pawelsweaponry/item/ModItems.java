package net.paweltl.pawelsweaponry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.item.custom.*;

public class ModItems {

    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE, 5, -3.2f, new FabricItemSettings().maxCount(1)));
    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer",
            new HammerItem(ToolMaterials.WOOD, 5, -3.2f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_HAMMER = registerItem("gold_hammer",
            new HammerItem(ToolMaterials.GOLD, 5, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON, 6, -3.2f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND, 6, -3.2f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE, 6, -3.2f, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item STONE_SPEAR = registerItem("stone_spear",
            new SpearItem(ToolMaterials.STONE, 4, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item WOODEN_SPEAR = registerItem("wooden_spear",
            new SpearItem(ToolMaterials.WOOD, 4, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_SPEAR = registerItem("gold_spear",
            new SpearItem(ToolMaterials.GOLD, 4, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_SPEAR = registerItem("iron_spear",
            new SpearItem(ToolMaterials.IRON, 4, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_SPEAR = registerItem("diamond_spear",
            new SpearItem(ToolMaterials.DIAMOND, 4, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_SPEAR = registerItem("netherite_spear",
            new SpearItem(ToolMaterials.NETHERITE, 4, -3.0f, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item WOODEN_DUAL_BLADE = registerItem("wooden_dual_blade",
            new DualBladeItem(ToolMaterials.WOOD, 3, -2.5f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_DUAL_BLADE = registerItem("gold_dual_blade",
            new DualBladeItem(ToolMaterials.GOLD, 3, -2.5f, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_DUAL_BLADE = registerItem("stone_dual_blade",
            new DualBladeItem(ToolMaterials.STONE, 3, -2.5f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_DUAL_BLADE = registerItem("iron_dual_blade",
            new DualBladeItem(ToolMaterials.IRON, 3, -2.5f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_DUAL_BLADE = registerItem("diamond_dual_blade",
            new DualBladeItem(ToolMaterials.DIAMOND, 3, -2.5f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_DUAL_BLADE = registerItem("netherite_dual_blade",
            new DualBladeItem(ToolMaterials.NETHERITE, 3, -2.5f, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item WOODEN_KATANA = registerItem("wooden_katana",
            new KatanaItem(ToolMaterials.WOOD, 4, -2.6f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_KATANA = registerItem("gold_katana",
            new KatanaItem(ToolMaterials.GOLD, 4, -2.4f, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_KATANA = registerItem("stone_katana",
            new KatanaItem(ToolMaterials.STONE, 4, -2.6f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_KATANA = registerItem("iron_katana",
            new KatanaItem(ToolMaterials.IRON, 4, -2.6f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_KATANA = registerItem("diamond_katana",
            new KatanaItem(ToolMaterials.DIAMOND, 4, -2.6f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_KATANA = registerItem("netherite_katana",
            new KatanaItem(ToolMaterials.NETHERITE, 4, -2.6f, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item WOODEN_CLEAVER = registerItem("wooden_cleaver",
            new CleaverItem(ToolMaterials.WOOD, 2, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_CLEAVER = registerItem("gold_cleaver",
            new CleaverItem(ToolMaterials.GOLD, 2, -2.6f, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_CLEAVER = registerItem("stone_cleaver",
            new CleaverItem(ToolMaterials.STONE, 2, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_CLEAVER = registerItem("iron_cleaver",
            new CleaverItem(ToolMaterials.IRON, 2, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_CLEAVER = registerItem("diamond_cleaver",
            new CleaverItem(ToolMaterials.DIAMOND, 2, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_CLEAVER = registerItem("netherite_cleaver",
            new CleaverItem(ToolMaterials.NETHERITE, 2, -2.8f, new FabricItemSettings().maxCount(1).fireproof()));


    public static final Item WOODEN_BATTLEAXE = registerItem("wooden_battleaxe",
            new BattleAxeItem(ToolMaterials.WOOD, 5, -2.9f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_BATTLEAXE = registerItem("gold_battleaxe",
            new BattleAxeItem(ToolMaterials.GOLD, 5, -2.7f, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_BATTLEAXE = registerItem("stone_battleaxe",
            new BattleAxeItem(ToolMaterials.STONE, 5, -2.9f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_BATTLEAXE = registerItem("iron_battleaxe",
            new BattleAxeItem(ToolMaterials.IRON, 5, -2.9f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe",
            new BattleAxeItem(ToolMaterials.DIAMOND, 5, -2.9f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe",
            new BattleAxeItem(ToolMaterials.NETHERITE, 5, -2.9f, new FabricItemSettings().maxCount(1).fireproof()));


    public static final Item WOODEN_DAGGER = registerItem("wooden_dagger",
            new DaggerItem(ToolMaterials.WOOD, 2, -2.1f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_DAGGER = registerItem("gold_dagger",
            new DaggerItem(ToolMaterials.GOLD, 2, -2f, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_DAGGER = registerItem("stone_dagger",
            new DaggerItem(ToolMaterials.STONE, 2, -2.1f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_DAGGER = registerItem("iron_dagger",
            new DaggerItem(ToolMaterials.IRON, 2, -2.1f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger",
            new DaggerItem(ToolMaterials.DIAMOND, 2, -2.1f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger",
            new DaggerItem(ToolMaterials.NETHERITE, 2, -2.1f, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item WOODEN_LONGSWORD = registerItem("wooden_longsword",
            new LongSwordItem(ToolMaterials.WOOD, 5, -3f, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_LONGSWORD = registerItem("gold_longsword",
            new LongSwordItem(ToolMaterials.GOLD, 5, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_LONGSWORD = registerItem("stone_longsword",
            new LongSwordItem(ToolMaterials.STONE, 5, -3f, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_LONGSWORD = registerItem("iron_longsword",
            new LongSwordItem(ToolMaterials.IRON, 5, -3f, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword",
            new LongSwordItem(ToolMaterials.DIAMOND, 5, -3f, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_LONGSWORD = registerItem("netherite_longsword",
            new LongSwordItem(ToolMaterials.NETHERITE, 5, -3f, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item HEAVY_CROSSBOW = registerItem("heavy_crossbow",
            new HeavyCrossbowItem(new FabricItemSettings().maxCount(1)));

    public static final Item TOWER_SHIELD = registerItem("tower_shield",
            new TowerShieldItem(new FabricItemSettings().maxCount(1).maxDamage(600)));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PawelsWeaponry.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PawelsWeaponry.LOGGER.info("Registering Mod Items for " + PawelsWeaponry.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
