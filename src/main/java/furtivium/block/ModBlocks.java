package furtivium.block;

import furtivium.Furtivium;
import furtivium.block.custom.SculkSporeShroomCluster;
import furtivium.item.ModItems;
import furtivium.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block FURTIVIUM_ORE = registerBlock("furtivium_ore", new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));
    public static final Block DEEPSLATE_FURTIVIUM_ORE = registerBlock("deepslate_furtivium_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)));
    public static final Block FURTIVIUM_BLOCK = registerBlock("furtivium_block", new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(ModSounds.FURTIVIUM_BLOCK_SOUNDS)));
    public static final Block PURIFIED_FURTIVIUM_BLOCK = registerBlock("purified_furtivium_block", new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(ModSounds.FURTIVIUM_BLOCK_SOUNDS)));
    public static final Block SCULK_BONE_BLOCK = registerBlock("sculk_bone_block", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)));

    public static final Block SCULK_ROOTS = registerBlock("sculk_roots", new SculkBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_ROOTS = registerBlockWithoutItem(("potted_sculk_roots"), new FlowerPotBlock(SCULK_ROOTS, FabricBlockSettings.copyOf(Blocks.POTTED_CRIMSON_ROOTS).nonOpaque()));
    public static final Block SCULK_MUSHROOM = registerBlock("sculk_mushroom", new SculkBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_MUSHROOM = registerBlockWithoutItem(("potted_sculk_mushroom"), new FlowerPotBlock(SCULK_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));
    public static final Block SCULK_EYE_FLOWER = registerBlock("sculk_eye_flower", new SculkBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_EYE_FLOWER = registerBlockWithoutItem(("potted_sculk_eye_flower"), new FlowerPotBlock(SCULK_EYE_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));
    public static final Block SCULK_CARNATION = registerBlock("sculk_carnation", new SculkBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_CARNATION = registerBlockWithoutItem(("potted_sculk_carnation"), new FlowerPotBlock(SCULK_CARNATION, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));
    public static final Block SCULK_SPIDER_PLANT = registerBlock("sculk_spider_plant", new SculkBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_SPIDER_PLANT = registerBlockWithoutItem(("potted_sculk_spider_plant"), new FlowerPotBlock(SCULK_SPIDER_PLANT, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));
    public static final Block SCULK_FAT_CAP = registerBlock("sculk_fat_cap", new SculkBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_FAT_CAP = registerBlockWithoutItem(("potted_sculk_fat_cap"), new FlowerPotBlock(SCULK_FAT_CAP, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));
    public static final Block SCULK_APPLES_EYE_MUSHROOM = registerBlock("sculk_apples_eye_mushroom", new SculkBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_APPLES_EYE_MUSHROOM = registerBlockWithoutItem(("potted_sculk_apples_eye_mushroom"), new FlowerPotBlock(SCULK_APPLES_EYE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));

    public static final Block SMALL_SCULK_SPORE_SHROOM_CLUSTER = registerBlock("small_sculk_spore_shroom_cluster", new SculkSporeShroomCluster(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block MEDIUM_SCULK_SPORE_SHROOM_CLUSTER = registerBlock("medium_sculk_spore_shroom_cluster", new SculkSporeShroomCluster(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));
    public static final Block LARGE_SCULK_SPORE_SHROOM_CLUSTER = registerBlock("large_sculk_spore_shroom_cluster", new SculkSporeShroomCluster(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).sounds(BlockSoundGroup.SCULK).nonOpaque().noCollision()));

    public static final Block WARDENS_SNACK_CLUSTER = registerBlockWithoutItem("wardens_snack_cluster", new SculkBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).sounds(BlockSoundGroup.SCULK)));



    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Furtivium.id(name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Furtivium.id(name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Furtivium.LOGGER.info("Registering ModBlocks for " + Furtivium.MOD_ID);
    }
}
