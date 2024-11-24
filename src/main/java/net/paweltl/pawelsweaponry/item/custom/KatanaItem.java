package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.mixin.EntityInvoker;
import net.paweltl.pawelsweaponry.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KatanaItem  extends SwordItem implements Vanishable {
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
        player.getItemCooldownManager().set(this, 180);
        if (user.isOnGround()) {
            player.getWorld().playSound(null, player.getBlockPos(), ModSounds.KATANA_SLASH, SoundCategory.PLAYERS, 0.8f, 0.8f);
            Vec3d uservec = ((EntityInvoker) user).invokeGetRotationVector(0, player.getYaw());
        List<Entity> targets = world.getOtherEntities(user, Box.of(player.getPos(), uservec.x * 7, 1.5, uservec.z * 7));
        targets.forEach((target) -> {
            target.damage(world.getDamageSources().playerAttack(player), (float) ((user.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + EnchantmentHelper.getAttackDamage(stack, ((LivingEntity) target).getGroup())) * 1.2));
        });
        user.addVelocity(uservec.x * 4.5, 0, uservec.z * 4.5);
        player.velocityModified = true;
        }

        return super.finishUsing(stack, world, user);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.katana.tooltip").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
