package net.paweltl.pawelsweaponry;

import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.effect.IncapacitateEffect;
import net.paweltl.pawelsweaponry.effect.ToxinEffect;
import net.paweltl.pawelsweaponry.effect.WoundedEffect;
import net.paweltl.pawelsweaponry.enchantment.ToxicEnchantment;
import net.paweltl.pawelsweaponry.item.ModItemGroups;
import net.paweltl.pawelsweaponry.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PawelsWeaponry implements ModInitializer {
	public static final String MOD_ID = "pawelsweaponry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final StatusEffect INCAPACITATED = new IncapacitateEffect(StatusEffectCategory.HARMFUL, 0x505250)
			.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,  "f81d4fae-7dec-11d0-a765-00a0c91e6bf6", -0.5, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
	public static final StatusEffect WOUNDED = new WoundedEffect(StatusEffectCategory.HARMFUL, 0x8a0416);
	public static final StatusEffect TOXIN = new ToxinEffect(StatusEffectCategory.HARMFUL, 0x0f4d02);

	public static final RegistryKey<DamageType> TOXIN_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("pawelsweaponry", "toxin_damage_type"));

	public static DamageSource of(World world, RegistryKey<DamageType> key) {
		return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
	}

	public static Enchantment TOXIC = new ToxicEnchantment();

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		Registry.register(Registries.STATUS_EFFECT, new Identifier(PawelsWeaponry.MOD_ID, "incapacitated"), INCAPACITATED);
		Registry.register(Registries.STATUS_EFFECT, new Identifier(PawelsWeaponry.MOD_ID, "wounded"), WOUNDED);
		Registry.register(Registries.STATUS_EFFECT, new Identifier(PawelsWeaponry.MOD_ID, "toxin"), TOXIN);

		Registry.register(Registries.ENCHANTMENT, new Identifier("pawelsweaponry", "toxic"), TOXIC);



	}
}