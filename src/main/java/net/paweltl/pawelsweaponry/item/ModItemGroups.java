package net.paweltl.pawelsweaponry.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup DIAMOND_HAMMER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PawelsWeaponry.MOD_ID, "diamond_hammer"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.diamond_hammer"))
                    .icon(() -> new ItemStack(ModItems.DIAMOND_HAMMER)).entries((displayContext, entries) -> {

                        entries.add(ModItems.DIAMOND_HAMMER);
                        entries.add(ModItems.STONE_HAMMER);
                        entries.add(ModItems.GOLD_HAMMER);
                        entries.add(ModItems.WOODEN_HAMMER);
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.NETHERITE_HAMMER);

                        entries.add(ModItems.DIAMOND_SPEAR);
                        entries.add(ModItems.STONE_SPEAR);
                        entries.add(ModItems.GOLD_SPEAR);
                        entries.add(ModItems.WOODEN_SPEAR);
                        entries.add(ModItems.IRON_SPEAR);
                        entries.add(ModItems.NETHERITE_SPEAR);

                        entries.add(ModItems.DIAMOND_DUAL_BLADE);

                        entries.add(ModItems.DIAMOND_KATANA);

                        entries.add(ModItems.DIAMOND_CLEAVER);

                        entries.add(ModItems.DIAMOND_BATTLE_AXE);

                        entries.add(ModItems.WOODEN_DAGGER);
                        entries.add(ModItems.GOLD_DAGGER);
                        entries.add(ModItems.STONE_DAGGER);
                        entries.add(ModItems.IRON_DAGGER);
                        entries.add(ModItems.DIAMOND_DAGGER);
                        entries.add(ModItems.NETHERITE_DAGGER);


                    }).build());

    public static void registerItemGroups() {
        PawelsWeaponry.LOGGER.info("Registering Item Groups for " + PawelsWeaponry.MOD_ID);
    }
}
