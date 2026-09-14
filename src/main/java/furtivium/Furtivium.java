package furtivium;

import furtivium.entity.ModEntities;
import furtivium.entity.custom.Broken1Entity;
import furtivium.item.ModItemGroups;
import furtivium.item.ModItems;
import furtivium.block.ModBlocks;
import furtivium.sound.ModSounds;
import furtivium.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furtivium implements ModInitializer {
	public static final String MOD_ID = "furtivium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String name) {
		return Identifier.of(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		ModLootTableModifiers.modifyLootTables();

		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.BROKEN1, Broken1Entity.createBroken1Attributes());

		LOGGER.info("Hello Fabric world!");
	}


}