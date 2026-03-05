package furtivium.Sculk.Minecraft.Mod.datagen;

import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FURTIVIUM_BLOCK);
        addDrop(ModBlocks.SCULK_BONE_BLOCK);

        addDrop(ModBlocks.SCULK_ROOTS);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_ROOTS);
        addDrop(ModBlocks.SCULK_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_MUSHROOM);
        addDrop(ModBlocks.SCULK_ORCHID);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_ORCHID);
        addDrop(ModBlocks.SCULK_CARNATION);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_CARNATION);


    }
}
