package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.Vanishable;
import net.minecraft.world.World;

public class BucklerItem extends ShieldItem implements Vanishable {
    public BucklerItem(Settings settings) {
        super(settings);
    }


    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 70;
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            player.getItemCooldownManager().set(player.getActiveItem().getItem(), 100);
        }
        return super.finishUsing(stack, world, user);
    }
}
