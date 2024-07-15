package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class BattleAxeItem extends SwordItem {
    public BattleAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    private static final UUID ATTACK_DAMAGE_BONUS_MODIFIER_ID = UUID.randomUUID();

    private static final  EntityAttributeModifier ATTACK_DAMAGE_MODIFIER;

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        PlayerEntity user = ((PlayerEntity) entity);
        if (entity.isPlayer() && !world.isClient) {
            Boolean conditions = selected && !user.getActiveStatusEffects().containsKey(StatusEffects.SLOW_FALLING) && user.fallDistance > 0;
            if (conditions && !user.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_DAMAGE_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttackDamage = user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttackDamage.addTemporaryModifier(ATTACK_DAMAGE_MODIFIER);
            } else if (user.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_DAMAGE_BONUS_MODIFIER_ID) && !conditions) {
                user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(ATTACK_DAMAGE_BONUS_MODIFIER_ID);
            }

        }
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.battleaxe.tooltip").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
        static {
            ATTACK_DAMAGE_MODIFIER = new EntityAttributeModifier(ATTACK_DAMAGE_BONUS_MODIFIER_ID, "Axe critical strike bonus", 0.2D, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        }
}
