package furtivium.Sculk.Minecraft.Mod;

import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furtivium implements ModInitializer {
	public static final String MOD_ID = "furtivium-sculk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}