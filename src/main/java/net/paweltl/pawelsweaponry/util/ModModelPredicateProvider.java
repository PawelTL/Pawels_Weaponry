package net.paweltl.pawelsweaponry.util;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.item.ModItems;


public class ModModelPredicateProvider {

    public static void registerModModels() {
        registerNewCrossbow(ModItems.HEAVY_CROSSBOW);
        registerNewShield(ModItems.TOWER_SHIELD);
        registerNewShield(ModItems.BUCKLER);
    }

    private static void registerNewCrossbow(Item crossbow) {
        FabricModelPredicateProviderRegistry.register(crossbow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(stack) ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float)CrossbowItem.getPullTime(stack);
            }
        });
        FabricModelPredicateProviderRegistry.register(crossbow, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry.register(crossbow, new Identifier("charged"), (stack, world, entity, seed) -> CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        FabricModelPredicateProviderRegistry.register(crossbow, new Identifier("firework"), (stack, world, entity, seed) -> CrossbowItem.isCharged(stack) && CrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);
    }

    private static void  registerNewShield (Item shield) {
        FabricModelPredicateProviderRegistry.register(shield, new Identifier("blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
    }

}
