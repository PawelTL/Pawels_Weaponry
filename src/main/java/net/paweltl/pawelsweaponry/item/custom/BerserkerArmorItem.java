package net.paweltl.pawelsweaponry.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.paweltl.pawelsweaponry.item.ModItems;

public class BerserkerArmorItem extends ArmorItem{
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;


    public BerserkerArmorItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor Modifier", material.getProtection(type), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier("Armor Modifier", material.getToughness(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier("Armor Modifier", material.getKnockbackResistance(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier("Armor Modifier", 0.5, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier("Armor Modifier", 0.1, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        this.attributeModifiers = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (this.asItem() == ModItems.BERSERKER_HELMET) {return slot == EquipmentSlot.HEAD ? this.attributeModifiers : super.getAttributeModifiers(slot);}
        if (this.asItem() == ModItems.BERSERKER_CHESTPLATE) {return slot == EquipmentSlot.CHEST ? this.attributeModifiers : super.getAttributeModifiers(slot);}
        if (this.asItem() == ModItems.BERSERKER_LEGGINGS) {return slot == EquipmentSlot.LEGS ? this.attributeModifiers : super.getAttributeModifiers(slot);}
        if (this.asItem() == ModItems.BERSERKER_BOOTS) {return slot == EquipmentSlot.FEET ? this.attributeModifiers : super.getAttributeModifiers(slot);}
        return super.getAttributeModifiers(slot);
    }
}
