package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HammerItem extends SwordItem implements Vanishable{



    public HammerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1F;
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.hammer.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.tutorialmod.two_handed.tooltip").formatted(Formatting.GRAY).formatted(Formatting.BOLD));
        super.appendTooltip(stack, world, tooltip, context);
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        ((PlayerEntity)user).getItemCooldownManager().set(this, 140);
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ((PlayerEntity)user).getItemCooldownManager().set(this, 220);
        for (int i = 0; i <=360; i+=6) {
            world.addImportantParticle(ParticleTypes.CRIT, user.getX(), user.getY(), user.getZ(), MathHelper.cos(i) * 3, 1f, MathHelper.sin(i) * 3);
        }
        world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_IRON_GOLEM_DAMAGE, SoundCategory.PLAYERS, ((float)1.0), ((float)1.0));
        List<Entity> targets = world.getOtherEntities(user, Box.of(user.getPos(), 8, 2, 8));
        targets.forEach(entity -> {
            if (entity.isLiving()) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(PawelsWeaponry.INCAPACITATED, 100, 0));
                entity.damage(world.getDamageSources().playerAttack(((PlayerEntity)user)), (float) ((user.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + EnchantmentHelper.getAttackDamage(stack, ((LivingEntity) entity).getGroup())) * 1.8));
            }});
        return super.finishUsing(stack, world, user);
    }

}

