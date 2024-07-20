package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HeavyCrossbowItem extends CrossbowItem implements Vanishable {

    public HeavyCrossbowItem(Settings settings) {
        super(settings);
    }

    private static float getSpeed(ItemStack stack) {
        return hasProjectile(stack, Items.FIREWORK_ROCKET) ? 2.4F : 4.3F;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (isCharged(itemStack)) {
            shootAll(world, user, hand, itemStack, getSpeed(itemStack), 0.6F);
            setCharged(itemStack, false);
            return TypedActionResult.consume(itemStack);
        }
        return super.use(world, user, hand);
    }
}
