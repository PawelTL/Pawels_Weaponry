package net.paweltl.pawelsweaponry;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.paweltl.pawelsweaponry.datagen.*;

public class PawelsWeaponryDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
	FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

	pack.addProvider(ModItemTagProvider::new);
	pack.addProvider(ModModelProvider::new);
	pack.addProvider(ModRecipeProvider::new);
	pack.addProvider(ModAdvancementsProvider::new);

	}
}
