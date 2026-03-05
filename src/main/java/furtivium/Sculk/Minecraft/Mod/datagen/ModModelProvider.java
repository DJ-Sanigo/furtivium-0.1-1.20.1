package furtivium.Sculk.Minecraft.Mod.datagen;

import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
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
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FURTIVIUM_BLOCK);

        blockStateModelGenerator.registerSingleton(ModBlocks.SCULK_BONE_BLOCK, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SCULK_ROOTS, ModBlocks.POTTED_SCULK_ROOTS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SCULK_MUSHROOM, ModBlocks.POTTED_SCULK_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SCULK_ORCHID, ModBlocks.POTTED_SCULK_ORCHID, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SCULK_CARNATION, ModBlocks.POTTED_SCULK_CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FURTIVIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_ACTIVE_SCULK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_DORMANT_SCULK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_BONE_AND_TENDRIL_BROTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.A_WARDENS_LULLABY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC, Models.GENERATED);
    }
}
