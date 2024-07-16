package net.paweltl.pawelsweaponry.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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

public class DualBladeItem extends SwordItem {
    public DualBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    private static final UUID ATTACK_DAMAGE_BONUS_MODIFIER_ID = UUID.randomUUID();
    private static final UUID ATTACK_SPEED_BONUS_MODIFIER_ID = UUID.randomUUID();

    private static final  EntityAttributeModifier ATTACK_DAMAGE_MODIFIER;
    private static final  EntityAttributeModifier ATTACK_SPEED_MODIFIER;

    @Override 
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        PlayerEntity user = ((PlayerEntity) entity) ;
        if (entity.isPlayer() && !world.isClient) {
            Boolean conditions = user.getStackInHand(Hand.OFF_HAND).getItem() instanceof DualBladeItem && user.getStackInHand(Hand.MAIN_HAND).getItem() instanceof DualBladeItem;

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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.dual_blade.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.tutorialmod.dual_wielding.tooltip").formatted(Formatting.GRAY).formatted(Formatting.BOLD));
        super.appendTooltip(stack, world, tooltip, context);
    }

    static {
        ATTACK_DAMAGE_MODIFIER = new EntityAttributeModifier(ATTACK_DAMAGE_BONUS_MODIFIER_ID, "Dual wielding damage bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_SPEED_MODIFIER = new EntityAttributeModifier(ATTACK_SPEED_BONUS_MODIFIER_ID, "Dual wielding attack speed bonus", 0.5D, EntityAttributeModifier.Operation.ADDITION);
    }
}
