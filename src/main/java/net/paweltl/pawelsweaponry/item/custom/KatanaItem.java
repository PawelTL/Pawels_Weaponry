package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class KatanaItem  extends SwordItem {
    public KatanaItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity player = ((PlayerEntity) user);
        if (user.isOnGround()) {
            player.getItemCooldownManager().set(this, 100);
            Vec3d uservec = player.getRotationVec(1);
            List<Entity> targets = world.getOtherEntities(user, Box.of(player.getPos(), uservec.x * 10, 1.5, uservec.z * 10));
            targets.forEach((target) -> {
                target.damage(world.getDamageSources().playerAttack(player), getAttackDamage() * 2 + 5);
            });
            user.addVelocity(uservec.x * 4, 0, uservec.z * 4);

        }
        return super.finishUsing(stack, world, user);
    }
}
