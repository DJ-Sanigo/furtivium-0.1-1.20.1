package furtivium.world;

import furtivium.Furtivium;
import furtivium.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_ROOTS_KEY = registerKey("sculk_roots");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_FLAT_CAP_MUSHROOM_KEY = registerKey("sculk_flat_cap_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_EYE_FLOWER_KEY = registerKey("sculk_eye_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_CARNATION_KEY = registerKey("sculk_carnation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_SPIDER_PLANT_KEY = registerKey("sculk_spider_plant");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_FAT_CAP_MUSHROOM_KEY = registerKey("sculk_fat_cap_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_APPLES_EYE_MUSHROOM_KEY = registerKey("sculk_apples_eye_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_SCULK_SPORE_SHROOM_CLUSTER_KEY = registerKey("small_sculk_spore_shroom_cluster");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_SCULK_SPORE_SHROOM_CLUSTER_KEY = registerKey("medium_sculk_spore_shroom_cluster");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_SCULK_SPORE_SHROOM_CLUSTER_KEY = registerKey("large_sculk_spore_shroom_cluster");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WARDENS_SNACK_CLUSTER_KEY = registerKey("wardens_snack_cluster");

    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_SCULK_FLAT_CAP_MUSHROOM_KEY = registerKey("big_sculk_flat_cap_mushroom");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, SCULK_ROOTS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_ROOTS
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SCULK_FLAT_CAP_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_FLAT_CAP_MUSHROOM
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SCULK_EYE_FLOWER_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_FAKE_EYE_FLOWER_MUSHROOM
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SCULK_CARNATION_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_CARNATION
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SCULK_SPIDER_PLANT_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_SPIDER_MUSHROOM
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SCULK_FAT_CAP_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_FAT_CAP_MUSHROOM
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SCULK_APPLES_EYE_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SCULK_APPLES_EYE_MUSHROOM
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, SMALL_SCULK_SPORE_SHROOM_CLUSTER_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SMALL_SCULK_SPORE_SHROOM_CLUSTER
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, MEDIUM_SCULK_SPORE_SHROOM_CLUSTER_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, LARGE_SCULK_SPORE_SHROOM_CLUSTER_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_SCULK_SPORE_SHROOM_CLUSTER
                                .getDefaultState())), List.of(Blocks.SCULK)));
        register(context, WARDENS_SNACK_CLUSTER_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WARDENS_SNACK_CLUSTER
                                .getDefaultState())), List.of(Blocks.SCULK)));

        register(context, HUGE_SCULK_FLAT_CAP_MUSHROOM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SCULK_FLAT_CAP_MUSHROOM_STEM),
                new StraightTrunkPlacer(2, 5, 2),

                BlockStateProvider.of(ModBlocks.SCULK_FLAT_CAP_MUSHROOM_BLOCK),
                new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(1), 0),

                new TwoLayersFeatureSize(1, 1, 1)).build());


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Furtivium.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}