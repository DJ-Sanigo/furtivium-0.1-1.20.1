package furtivium.datagen.provider;

import furtivium.item.ModItems;
import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FURTIVIUM_BLOCK);
        addDrop(ModBlocks.PURIFIED_FURTIVIUM_BLOCK);
        addDrop(ModBlocks.SCULK_BONE_BLOCK);

        addDrop(ModBlocks.FURTIVIUM_ORE, oreDrops(ModBlocks.FURTIVIUM_ORE, ModItems.RAW_FURTIVIUM));
        addDrop(ModBlocks.DEEPSLATE_FURTIVIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_FURTIVIUM_ORE, ModItems.RAW_FURTIVIUM));

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
