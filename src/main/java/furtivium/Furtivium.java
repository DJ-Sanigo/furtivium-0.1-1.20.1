package furtivium;

import furtivium.entity.ModEntities;
import furtivium.entity.custom.Broken1Entity;
import furtivium.item.ModItemGroups;
import furtivium.item.ModItems;
import furtivium.block.ModBlocks;
import furtivium.sound.ModSounds;
import furtivium.util.ModLootTableModifiers;
import furtivium.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.ItemConvertible;
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

		ModWorldGeneration.generateModWorldGen();

		FabricDefaultAttributeRegistry.register(ModEntities.BROKEN1, Broken1Entity.createBroken1Attributes());

		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SCULK_CARNATION, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SCULK_FLAT_CAP_MUSHROOM, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SCULK_FAKE_EYE_FLOWER_MUSHROOM, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SCULK_ROOTS, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SCULK_FAT_CAP_MUSHROOM, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SCULK_SPIDER_MUSHROOM, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.SMALL_SCULK_SPORE_SHROOM_CLUSTER, 0.05F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER, 0.10F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModBlocks.LARGE_SCULK_SPORE_SHROOM_CLUSTER, 0.15F);
		CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ModItems.WARDENS_SNACK, 0.05F);

		LOGGER.info("Hello Fabric world!");
	}


}