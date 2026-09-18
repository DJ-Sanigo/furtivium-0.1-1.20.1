package furtivium.world;

import furtivium.Furtivium;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SCULK_ROOTS_PLACED_KEY = registerKey("sculk_roots_placed");
    public static final RegistryKey<PlacedFeature> SCULK_FLAT_CAP_MUSHROOM_PLACED_KEY = registerKey("sculk_mushroom_placed");
    public static final RegistryKey<PlacedFeature> SCULK_EYE_FLOWER_PLACED_KEY = registerKey("sculk_eye_flower_placed");
    public static final RegistryKey<PlacedFeature> SCULK_CARNATION_PLACED_KEY = registerKey("sculk_carnation_placed");
    public static final RegistryKey<PlacedFeature> SCULK_SPIDER_PLANT_PLACED_KEY = registerKey("sculk_spider_plant_placed");
    public static final RegistryKey<PlacedFeature> SCULK_FAT_CAP_MUSHROOM_PLACED_KEY = registerKey("sculk_fat_cap_mushroom_placed");
    public static final RegistryKey<PlacedFeature> SCULK_APPLES_EYE_MUSHROOM_PLACED_KEY = registerKey("sculk_apples_eye_mushroom_placed");
    public static final RegistryKey<PlacedFeature> SMALL_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY = registerKey("small_sculk_spore_shroom_cluster_placed");
    public static final RegistryKey<PlacedFeature> MEDIUM_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY = registerKey("medium_sculk_spore_shroom_cluster_placed");
    public static final RegistryKey<PlacedFeature> LARGE_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY = registerKey("large_sculk_spore_shroom_cluster_placed");
    public static final RegistryKey<PlacedFeature> WARDENS_SNACK_CLUSTER_PLACED_KEY = registerKey("wardens_snack_cluster_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SCULK_ROOTS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_ROOTS_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SCULK_FLAT_CAP_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_FLAT_CAP_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SCULK_EYE_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_EYE_FLOWER_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SCULK_CARNATION_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_CARNATION_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SCULK_SPIDER_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_SPIDER_PLANT_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SCULK_FAT_CAP_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_FAT_CAP_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SCULK_APPLES_EYE_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_APPLES_EYE_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_SCULK_SPORE_SHROOM_CLUSTER_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MEDIUM_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LARGE_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_SCULK_SPORE_SHROOM_CLUSTER_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WARDENS_SNACK_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WARDENS_SNACK_CLUSTER_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Furtivium.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}