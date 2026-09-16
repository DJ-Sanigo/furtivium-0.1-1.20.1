package furtivium.datagen.provider;

import furtivium.item.ModItems;
import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockGen) {
        blockGen.registerSimpleCubeAll(ModBlocks.FURTIVIUM_ORE);
        blockGen.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FURTIVIUM_ORE);
        blockGen.registerSimpleCubeAll(ModBlocks.FURTIVIUM_BLOCK);
        blockGen.registerSimpleCubeAll(ModBlocks.PURIFIED_FURTIVIUM_BLOCK);

        blockGen.registerAxisRotated(ModBlocks.SCULK_BONE_BLOCK, TexturedModel.CUBE_COLUMN);

        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_ROOTS, ModBlocks.POTTED_SCULK_ROOTS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_MUSHROOM, ModBlocks.POTTED_SCULK_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_EYE_FLOWER, ModBlocks.POTTED_SCULK_EYE_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_CARNATION, ModBlocks.POTTED_SCULK_CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_SPIDER_PLANT, ModBlocks.POTTED_SCULK_SPIDER_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_FAT_CAP, ModBlocks.POTTED_SCULK_FAT_CAP, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerFlowerPotPlant(ModBlocks.SCULK_APPLES_EYE_MUSHROOM, ModBlocks.POTTED_SCULK_APPLES_EYE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockGen.registerTintableCross(ModBlocks.SMALL_SCULK_SPORE_SHROOM_CLUSTER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerTintableCross(ModBlocks.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockGen.registerTintableCross(ModBlocks.LARGE_SCULK_SPORE_SHROOM_CLUSTER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockGen.registerTintableCrossBlockState(ModBlocks.WARDENS_SNACK_CLUSTER, BlockStateModelGenerator.TintType.NOT_TINTED);


    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PURIFIED_FURTIVIUM_GLADIUS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURIFIED_FURTIVIUM_GLAIVE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURIFIED_FURTIVIUM_SPADONE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURIFIED_FURTIVIUM_CAZZO_FUCILE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RAW_FURTIVIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.INCOMPLETE_FURTIVIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FURTIVIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURIFIED_FURTIVIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARDEN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_TENDRIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_ACTIVE_SCULK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_DORMANT_SCULK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_LIQUID_FURTIVIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_BONE_AND_TENDRIL_BROTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARDENS_SNACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_LAMINGTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_DOUGHNUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_ROOT_GNOCCHI, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULKZZARELLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_TENDRIL_SPAGHETTI, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_MARGARITA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_TENDRIL_AND_TONIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.A_WARDENS_LULLABY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMMOVABLE_OBJECT_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.THE_ALARM_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_RING_TOKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_RING_NUKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_MATTER, Models.GENERATED);


    }


}
