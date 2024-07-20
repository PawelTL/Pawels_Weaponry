package net.paweltl.pawelsweaponry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {

    public ModAdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.DIAMOND_BATTLEAXE,
                        Text.literal("Pawel's Weaponry"),
                        Text.literal("Now you can craft your first weapon."),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("crafting_table",InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .build(consumer, PawelsWeaponry.MOD_ID + "/root");

        Advancement netheriteLongswordAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_LONGSWORD,
                        Text.literal("The Knight"),
                        Text.literal("Obtain a Netherite Longsword"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_longsword", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_LONGSWORD))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_longsword");

        Advancement netheriteKatanaAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_KATANA,
                        Text.literal("The Samurai"),
                        Text.literal("Obtain a Netherite Katana"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_katana", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_KATANA))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_katana");

        Advancement netheriteHammerAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_HAMMER,
                        Text.literal("The Juggernaut"),
                        Text.literal("Obtain a Netherite Hammer"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_hammer", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_HAMMER))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_hammer");

        Advancement netheriteDaggerAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_DAGGER,
                        Text.literal("The Rogue"),
                        Text.literal("Obtain a Netherite Dagger"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_dagger", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_DAGGER))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_dagger");

        Advancement netheriteCleaverAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_CLEAVER,
                        Text.literal("The Butcher"),
                        Text.literal("Obtain a Netherite Cleaver"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_cleaver", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_CLEAVER))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_cleaver");

        Advancement netheriteDualBladeAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_DUAL_BLADE,
                        Text.literal("The Berserker"),
                        Text.literal("Obtain a Netherite Dual Blade"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_dual_blade", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_DUAL_BLADE))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_dual_blade");

        Advancement netheriteSpearAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_SPEAR,
                        Text.literal("The Spartan"),
                        Text.literal("Obtain a Netherite Spear"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_spear", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_SPEAR))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_spear");

        Advancement netheriteBattleAxeAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.NETHERITE_BATTLEAXE,
                        Text.literal("The Viking"),
                        Text.literal("Obtain a Netherite BattleAxe"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("netherite_battleaxe", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_BATTLEAXE))
                .build(consumer, PawelsWeaponry.MOD_ID + "/netherite_battleaxe");

        Advancement heavyCrossbowAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.HEAVY_CROSSBOW,
                        Text.literal("The Sniper"),
                        Text.literal("Obtain a Heavy Crossbow"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("heavy_crossbow", InventoryChangedCriterion.Conditions.items(ModItems.HEAVY_CROSSBOW))
                .build(consumer, PawelsWeaponry.MOD_ID + "/heavy_crossbow");

        Advancement weaponMasterAdvancement = Advancement.Builder.create().parent(netheriteHammerAdvancement)
                .display(
                        Items.DRAGON_HEAD,
                        Text.literal("The Weapon Master"),
                        Text.literal("Obtain all of the netherite weapons"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("weapon_master", InventoryChangedCriterion.Conditions.items(ModItems.HEAVY_CROSSBOW ,ModItems.NETHERITE_BATTLEAXE, ModItems.NETHERITE_DUAL_BLADE, ModItems.NETHERITE_DAGGER, ModItems.NETHERITE_CLEAVER, ModItems.NETHERITE_LONGSWORD, ModItems.NETHERITE_HAMMER, ModItems.NETHERITE_KATANA, ModItems.NETHERITE_SPEAR))
                .build(consumer, PawelsWeaponry.MOD_ID + "/weapon_master");


    }

}
