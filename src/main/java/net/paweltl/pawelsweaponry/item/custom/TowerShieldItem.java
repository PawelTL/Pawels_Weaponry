package net.paweltl.pawelsweaponry.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ShieldItem;

public class TowerShieldItem extends ShieldItem {

    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public TowerShieldItem(Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Weapon modifier", 4.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier("Weapon modifier", -0.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier("Weapon modifier", -0.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        this.attributeModifiers = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }



}
