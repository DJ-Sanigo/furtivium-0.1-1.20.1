package furtivium.Sculk.Minecraft.Mod.block;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import furtivium.Sculk.Minecraft.Mod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block FURTIVIUM_BLOCK = registerBlock("furtivium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(ModSounds.FURTIVIUM_BLOCK_SOUNDS)));
    public static final Block SCULK_BONE_BLOCK = registerBlock("sculk_bone_block",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)));

    public static final Block SCULK_ROOTS = registerBlock("sculk_roots",
            new SculkBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_ROOTS = Registry.register(Registries.BLOCK, new Identifier(Furtivium.MOD_ID, "potted_sculk_roots"),
            new FlowerPotBlock(SCULK_ROOTS, FabricBlockSettings.copyOf(Blocks.POTTED_CRIMSON_ROOTS).nonOpaque()));
    public static final Block SCULK_MUSHROOM = registerBlock("sculk_mushroom",
            new SculkBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(Furtivium.MOD_ID, "potted_sculk_mushroom"),
            new FlowerPotBlock(SCULK_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_CRIMSON_ROOTS).nonOpaque()));
    public static final Block SCULK_ORCHID = registerBlock("sculk_orchid",
            new SculkSensorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_ORCHID = Registry.register(Registries.BLOCK, new Identifier(Furtivium.MOD_ID, "potted_sculk_orchid"),
            new FlowerPotBlock(SCULK_ORCHID, FabricBlockSettings.copyOf(Blocks.POTTED_CRIMSON_ROOTS).nonOpaque()));
    public static final Block SCULK_CARNATION = registerBlock("sculk_carnation",
            new SculkSensorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).nonOpaque().noCollision()));
    public static final Block POTTED_SCULK_CARNATION = Registry.register(Registries.BLOCK, new Identifier(Furtivium.MOD_ID, "potted_sculk_carnation"),
            new FlowerPotBlock(SCULK_CARNATION, FabricBlockSettings.copyOf(Blocks.POTTED_CRIMSON_ROOTS).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Furtivium.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Furtivium.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Furtivium.LOGGER.info("Registering ModBlocks for " + Furtivium.MOD_ID);
    }
}
