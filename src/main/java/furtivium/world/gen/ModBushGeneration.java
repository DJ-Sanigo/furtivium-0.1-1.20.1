package furtivium.world.gen;

import furtivium.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBushGeneration {
    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_ROOTS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_MUSHROOM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_EYE_FLOWER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_CARNATION_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_SPIDER_PLANT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_FAT_CAP_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCULK_APPLES_EYE_MUSHROOM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_SCULK_SPORE_SHROOM_CLUSTER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WARDENS_SNACK_CLUSTER_PLACED_KEY);
    }
}