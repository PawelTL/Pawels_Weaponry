package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class HammerItem extends SwordItem implements Vanishable{



    public HammerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    private static final UUID ATTACK_DAMAGE_BONUS_MODIFIER_ID = UUID.randomUUID();
    private static final UUID ATTACK_SPEED_BONUS_MODIFIER_ID = UUID.randomUUID();

    private static final  EntityAttributeModifier ATTACK_DAMAGE_MODIFIER;
    private static final  EntityAttributeModifier ATTACK_SPEED_MODIFIER;

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1F;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected) {
            if (entity.isPlayer() && ((PlayerEntity) entity).getItemCooldownManager()
                    .getCooldownProgress(((PlayerEntity) entity).getStackInHand(Hand.OFF_HAND).getItem(), (float)1.0) < 1) {
                PlayerEntity user = ((PlayerEntity) entity);
                user.getItemCooldownManager().set(user.getStackInHand(Hand.OFF_HAND).getItem(), 20);

            }
        }
        PlayerEntity user = ((PlayerEntity) entity) ;
        if (entity.isPlayer() && !world.isClient) {
            Boolean conditions = user.getMainHandStack().getItem() instanceof HammerItem && !user.getOffHandStack().isEmpty();

            if (conditions && !user.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_DAMAGE_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttackDamage = user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                EntityAttributeInstance entityAttackSpeed = user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);
                entityAttackSpeed.addTemporaryModifier(ATTACK_SPEED_MODIFIER);
                entityAttackDamage.addTemporaryModifier(ATTACK_DAMAGE_MODIFIER);
            } else if (user.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_DAMAGE_BONUS_MODIFIER_ID) && !conditions) {
                user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED).removeModifier(ATTACK_SPEED_BONUS_MODIFIER_ID);
                user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(ATTACK_DAMAGE_BONUS_MODIFIER_ID);
            }

        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1), attacker);
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return super.postHit(stack, target, attacker);
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 50;
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Slow but powerful weapon capable of breaking shields."));
        tooltip.add(Text.literal("Hold right click to charge up a powerful slam."));
        tooltip.add(Text.literal("Weaker when offhand is filled."));
        super.appendTooltip(stack, world, tooltip, context);
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ((PlayerEntity)user).getItemCooldownManager().set(this, 200);
        for (int i = 0; i <=360; i+=6) {
            world.addImportantParticle(ParticleTypes.CRIT, user.getX(), user.getY(), user.getZ(), MathHelper.cos(i) * 3, 1f, MathHelper.sin(i) * 3);
        }
        world.playSound(user, user.getBlockPos(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, ((float)1.0), ((float)1.0));
        List<Entity> targets = world.getOtherEntities(user, Box.of(user.getPos(), 8, 3, 8));
        targets.forEach(entity -> {
            if (entity.isLiving()) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(PawelsWeaponry.INCAPACITATED, 100, 0));
                entity.damage(world.getDamageSources().playerAttack(((PlayerEntity)user)), getAttackDamage() * 2 + 10);
            }});
        return super.finishUsing(stack, world, user);
    }

    static {
        ATTACK_DAMAGE_MODIFIER = new EntityAttributeModifier(ATTACK_DAMAGE_BONUS_MODIFIER_ID, "Dual wielding damage bonus", -2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_SPEED_MODIFIER = new EntityAttributeModifier(ATTACK_SPEED_BONUS_MODIFIER_ID, "Dual wielding attack speed bonus", -0.3D, EntityAttributeModifier.Operation.ADDITION);
    }
}

