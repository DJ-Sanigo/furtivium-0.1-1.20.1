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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FURTIVIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_ACTIVE_SCULK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIAL_OF_DORMANT_SCULK, Models.GENERATED);
        itemModelGenerator.register(ModItems.A_WARDENS_LULLABY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC, Models.GENERATED);
    }
}
