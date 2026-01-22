package furtivium.Sculk.Minecraft.Mod;

import furtivium.Sculk.Minecraft.Mod.Item.ModItemGroups;
import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import furtivium.Sculk.Minecraft.Mod.sound.ModSounds;
import furtivium.Sculk.Minecraft.Mod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furtivium implements ModInitializer {
	public static final String MOD_ID = "furtivium-sculk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();

		ModSounds.registerSounds();

		LOGGER.info("Hello Fabric world!");
	}


}