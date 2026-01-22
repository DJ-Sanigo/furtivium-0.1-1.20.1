package furtivium.Sculk.Minecraft.Mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import furtivium.Sculk.Minecraft.Mod.datagen.ModItemTagProvider;
import net.minecraft.client.gui.screen.pack.ResourcePackOrganizer;
import net.minecraft.data.DataGenerator;

public class FurtiviumDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);

	}
}