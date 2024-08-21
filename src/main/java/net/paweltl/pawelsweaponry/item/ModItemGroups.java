package net.paweltl.pawelsweaponry.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.PawelsWeaponry;

public class ModItemGroups {

    public static final ItemGroup DIAMOND_HAMMER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PawelsWeaponry.MOD_ID, "netherite_battleaxe"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.netherite_battleaxe"))
                    .icon(() -> new ItemStack(ModItems.NETHERITE_BATTLEAXE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.WOODEN_HAMMER);
                        entries.add(ModItems.STONE_HAMMER);
                        entries.add(ModItems.GOLD_HAMMER);
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.DIAMOND_HAMMER);
                        entries.add(ModItems.NETHERITE_HAMMER);

                        entries.add(ModItems.WOODEN_SPEAR);
                        entries.add(ModItems.GOLD_SPEAR);
                        entries.add(ModItems.STONE_SPEAR);
                        entries.add(ModItems.IRON_SPEAR);
                        entries.add(ModItems.DIAMOND_SPEAR);
                        entries.add(ModItems.NETHERITE_SPEAR);

                        entries.add(ModItems.WOODEN_DUAL_BLADE);
                        entries.add(ModItems.GOLD_DUAL_BLADE);
                        entries.add(ModItems.STONE_DUAL_BLADE);
                        entries.add(ModItems.IRON_DUAL_BLADE);
                        entries.add(ModItems.DIAMOND_DUAL_BLADE);
                        entries.add(ModItems.NETHERITE_DUAL_BLADE);

                        entries.add(ModItems.WOODEN_KATANA);
                        entries.add(ModItems.GOLD_KATANA);
                        entries.add(ModItems.STONE_KATANA);
                        entries.add(ModItems.IRON_KATANA);
                        entries.add(ModItems.DIAMOND_KATANA);
                        entries.add(ModItems.NETHERITE_KATANA);

                        entries.add(ModItems.WOODEN_CLEAVER);
                        entries.add(ModItems.GOLD_CLEAVER);
                        entries.add(ModItems.STONE_CLEAVER);
                        entries.add(ModItems.IRON_CLEAVER);
                        entries.add(ModItems.DIAMOND_CLEAVER);
                        entries.add(ModItems.NETHERITE_CLEAVER);

                        entries.add(ModItems.WOODEN_BATTLEAXE);
                        entries.add(ModItems.GOLD_BATTLEAXE);
                        entries.add(ModItems.STONE_BATTLEAXE);
                        entries.add(ModItems.IRON_BATTLEAXE);
                        entries.add(ModItems.DIAMOND_BATTLEAXE);
                        entries.add(ModItems.NETHERITE_BATTLEAXE);

                        entries.add(ModItems.WOODEN_DAGGER);
                        entries.add(ModItems.GOLD_DAGGER);
                        entries.add(ModItems.STONE_DAGGER);
                        entries.add(ModItems.IRON_DAGGER);
                        entries.add(ModItems.DIAMOND_DAGGER);
                        entries.add(ModItems.NETHERITE_DAGGER);

                        entries.add(ModItems.WOODEN_LONGSWORD);
                        entries.add(ModItems.GOLD_LONGSWORD);
                        entries.add(ModItems.STONE_LONGSWORD);
                        entries.add(ModItems.IRON_LONGSWORD);
                        entries.add(ModItems.DIAMOND_LONGSWORD);
                        entries.add(ModItems.NETHERITE_LONGSWORD);

                        entries.add(ModItems.JUGGERNAUT_HELMET);
                        entries.add(ModItems.JUGGERNAUT_CHESTPLATE);
                        entries.add(ModItems.JUGGERNAUT_LEGGINGS);
                        entries.add(ModItems.JUGGERNAUT_BOOTS);

                        entries.add(ModItems.BERSERKER_HELMET);
                        entries.add(ModItems.BERSERKER_CHESTPLATE);
                        entries.add(ModItems.BERSERKER_LEGGINGS);
                        entries.add(ModItems.BERSERKER_BOOTS);

                        entries.add(ModItems.HEAVY_CROSSBOW);

                        entries.add(ModItems.TOWER_SHIELD);
                        entries.add(ModItems.BUCKLER);

                        entries.add(ModItems.WHIP);



                    }).build());

    public static void registerItemGroups() {
        PawelsWeaponry.LOGGER.info("Registering Item Groups for " + PawelsWeaponry.MOD_ID);
    }
}
