package furtivium.datagen.provider;

import furtivium.Furtivium;
import furtivium.item.ModItems;
import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FURTIVIUM_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.FURTIVIUM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PURIFIED_FURTIVIUM_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.PURIFIED_FURTIVIUM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_BONE, RecipeCategory.DECORATIONS,
                ModBlocks.SCULK_BONE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.BONE_MEAL, 9).input(ModItems.SCULK_BONE).criterion(FabricRecipeProvider.hasItem(Items.BONE_MEAL),
                FabricRecipeProvider.conditionsFromItem(Items.BONE_MEAL)).criterion(FabricRecipeProvider.hasItem(ModItems.SCULK_BONE),
                FabricRecipeProvider.conditionsFromItem(ModItems.SCULK_BONE)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FURTIVIUM_CAZZO_FUCILE, 1)
                .pattern(" B ")
                .pattern("SWC")
                .pattern("FS ")
                .input('B', ModItems.SCULK_BONE)
                .input('W', ModItems.WARDEN_HEART)
                .input('S', Items.SCULK)
                .input('C', Items.SCULK_SHRIEKER)
                .input('F', ModItems.FURTIVIUM_INGOT)
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.WARDEN_HEART), conditionsFromItem(ModItems.WARDEN_HEART))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.SCULK_SHRIEKER), conditionsFromItem(Items.SCULK_SHRIEKER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC, 1)
                .pattern(" E ")
                .pattern("EDE")
                .pattern(" E ")
                .input('D', ItemTags.MUSIC_DISCS)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.A_WARDENS_LULLABY_MUSIC_DISC, 1)
                .pattern("SFS")
                .pattern("FDF")
                .pattern("SFS")
                .input('D', ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC)
                .input('F', ModItems.FURTIVIUM_INGOT)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC), conditionsFromItem(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC))
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMMOVABLE_OBJECT_MUSIC_DISC, 1)
                .pattern("RLR")
                .pattern("LDL")
                .pattern("RLR")
                .input('D', ItemTags.MUSIC_DISCS)
                .input('L', Items.LAPIS_LAZULI)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THE_ALARM_MUSIC_DISC, 1)
                .pattern("QQQ")
                .pattern("LDR")
                .pattern("QQQ")
                .input('D', ItemTags.MUSIC_DISCS)
                .input('Q', Items.QUARTZ)
                .input('L', Items.LAPIS_LAZULI)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.VIAL_OF_DORMANT_SCULK, 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" G ")
                .input('G', Items.GLASS_BOTTLE)
                .input('S', Items.SCULK)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.VIAL_OF_ACTIVE_SCULK, 2)
                .pattern(" E ")
                .pattern("SCS")
                .pattern(" V ")
                .input('C', Items.SCULK_CATALYST)
                .input('V', ModItems.VIAL_OF_DORMANT_SCULK)
                .input('E', Items.EXPERIENCE_BOTTLE)
                .input('S', Items.SCULK)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.SCULK_CATALYST), conditionsFromItem(Items.SCULK_CATALYST))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(ModItems.VIAL_OF_DORMANT_SCULK), conditionsFromItem(ModItems.VIAL_OF_DORMANT_SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.VIAL_OF_LIQUID_FURTIVIUM, 1)
                .pattern("EEE")
                .pattern("EEE")
                .pattern(" V ")
                .input('V', ModItems.VIAL_OF_ACTIVE_SCULK)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(ModItems.VIAL_OF_ACTIVE_SCULK), conditionsFromItem(ModItems.VIAL_OF_ACTIVE_SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.EXPERIENCE_BOTTLE, 3)
                .pattern(" V ")
                .pattern("SES")
                .pattern(" G ")
                .input('V', ModItems.VIAL_OF_ACTIVE_SCULK)
                .input('E', Items.EXPERIENCE_BOTTLE)
                .input('G', Items.GLASS_BOTTLE)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.VIAL_OF_ACTIVE_SCULK), conditionsFromItem(ModItems.VIAL_OF_ACTIVE_SCULK))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.SCULK_CATALYST, 1)
                .pattern("SSS")
                .pattern("BWB")
                .pattern("BSB")
                .input('B', ModItems.SCULK_BONE)
                .input('W', ModItems.WARDEN_HEART)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.WARDEN_HEART), conditionsFromItem(ModItems.WARDEN_HEART))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.SCULK_SHRIEKER, 1)
                .pattern("B B")
                .pattern("BSB")
                .pattern("SWS")
                .input('B', ModItems.SCULK_BONE)
                .input('S', Items.SCULK)
                .input('W', ModItems.WARDEN_HEART)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(ModItems.WARDEN_HEART), conditionsFromItem(ModItems.WARDEN_HEART))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.SCULK_SENSOR, 1)
                .pattern("   ")
                .pattern("T T")
                .pattern("SSS")
                .input('T', ModItems.SCULK_TENDRIL)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.SCULK_TENDRIL), conditionsFromItem(ModItems.SCULK_TENDRIL))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.SCULK, 1)
                .pattern("VV")
                .pattern("VV")
                .input('V', Items.SCULK_VEIN)
                .criterion(hasItem(Items.SCULK_VEIN), conditionsFromItem(Items.SCULK_VEIN))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.SCULK_VEIN, 8)
                .pattern("S ")
                .pattern("S ")
                .input('S', Items.SCULK)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ECHO_SHARD, 2)
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .input('S', Items.SCULK)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_TENDRIL_AND_TONIC, 1)
                .pattern(" S ")
                .pattern("TSV")
                .pattern(" G ")
                .input('G', Items.GLASS_BOTTLE)
                .input('S', Items.SCULK)
                .input('V', ModItems.VIAL_OF_ACTIVE_SCULK)
                .input('T', ModItems.SCULK_TENDRIL)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(ModItems.VIAL_OF_ACTIVE_SCULK), conditionsFromItem(ModItems.VIAL_OF_ACTIVE_SCULK))
                .criterion(hasItem(ModItems.SCULK_TENDRIL), conditionsFromItem(ModItems.SCULK_TENDRIL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_MARGARITA, 1)
                .pattern("   ")
                .pattern("BSV")
                .pattern(" G ")
                .input('G', Items.GLASS_BOTTLE)
                .input('S', Items.SCULK)
                .input('V', ModItems.VIAL_OF_ACTIVE_SCULK)
                .input('B', ModItems.SCULK_BONE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(ModItems.VIAL_OF_ACTIVE_SCULK), conditionsFromItem(ModItems.VIAL_OF_ACTIVE_SCULK))
                .criterion(hasItem(ModItems.SCULK_TENDRIL), conditionsFromItem(ModItems.SCULK_TENDRIL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_BONE_AND_TENDRIL_BROTH, 1)
                .pattern("TB")
                .pattern("SP")
                .input('P', Items.BOWL)
                .input('S', Items.SCULK)
                .input('B', ModItems.SCULK_BONE)
                .input('T', ModItems.SCULK_TENDRIL)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(ModItems.SCULK_TENDRIL), conditionsFromItem(ModItems.SCULK_TENDRIL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_ROOT_GNOCCHI, 1)
                .pattern("SR")
                .pattern(" P")
                .input('P', Items.BOWL)
                .input('S', Items.SCULK)
                .input('R', ModBlocks.SCULK_ROOTS)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(ModBlocks.SCULK_ROOTS), conditionsFromItem(ModBlocks.SCULK_ROOTS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_LAMINGTON, 4)
                .pattern("SS")
                .pattern("SO")
                .input('S', Items.SCULK)
                .input('O', ModBlocks.SCULK_ORCHID)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(ModBlocks.SCULK_ORCHID), conditionsFromItem(ModBlocks.SCULK_ORCHID))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_DOUGHNUT, 8)
                .pattern("VSV")
                .pattern("SCS")
                .pattern("VSV")
                .input('S', Items.SCULK)
                .input('V', Items.SCULK_VEIN)
                .input('C', ModBlocks.SCULK_CARNATION)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.SCULK_VEIN), conditionsFromItem(Items.SCULK_VEIN))
                .criterion(hasItem(ModBlocks.SCULK_CARNATION), conditionsFromItem(ModBlocks.SCULK_CARNATION))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_TENDRIL_SPAGHETTI, 1)
                .pattern("BC ")
                .pattern("TST")
                .pattern(" P ")
                .input('P', Items.BOWL)
                .input('S', Items.SCULK)
                .input('T', ModItems.SCULK_TENDRIL)
                .input('B', ModItems.SCULK_BONE)
                .input('C', ModItems.SCULKZZARELLA)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(ModItems.SCULK_TENDRIL), conditionsFromItem(ModItems.SCULK_TENDRIL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULKZZARELLA, 16)
                .pattern("MMM")
                .pattern("VSV")
                .pattern(" B ")
                .input('S', Items.SCULK)
                .input('V', Items.SCULK_VEIN)
                .input('B', Items.MILK_BUCKET)
                .input('M', ModBlocks.SCULK_MUSHROOM)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.SCULK_VEIN), conditionsFromItem(Items.SCULK_VEIN))
                .criterion(hasItem(ModBlocks.SCULK_MUSHROOM), conditionsFromItem(ModBlocks.SCULK_MUSHROOM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SCULK_RING_TOKEN, 1)
                .pattern(" S ")
                .pattern("VSV")
                .pattern(" V ")
                .input('S', Items.SCULK)
                .input('V', Items.SCULK_VEIN)
                .criterion(hasItem(Items.SCULK_VEIN), conditionsFromItem(Items.SCULK_VEIN))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_RING_NUKE, 1)
                .pattern("SE ")
                .pattern("C C")
                .pattern(" C ")
                .input('S', Items.SCULK)
                .input('C', Items.COPPER_INGOT)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.RAW_FURTIVIUM, ModBlocks.DEEPSLATE_FURTIVIUM_ORE, ModBlocks.FURTIVIUM_ORE),
                        RecipeCategory.MISC, ModItems.INCOMPLETE_FURTIVIUM_INGOT, 0.2f, 1200)
                .criterion(hasItem(ModItems.RAW_FURTIVIUM), conditionsFromItem(ModItems.RAW_FURTIVIUM))
                .criterion(hasItem(ModBlocks.DEEPSLATE_FURTIVIUM_ORE), conditionsFromItem(ModBlocks.DEEPSLATE_FURTIVIUM_ORE))
                .criterion(hasItem(ModBlocks.FURTIVIUM_ORE), conditionsFromItem(ModBlocks.FURTIVIUM_ORE))
                .offerTo(exporter);

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.VIAL_OF_LIQUID_FURTIVIUM), Ingredient.ofItems(ModItems.INCOMPLETE_FURTIVIUM_INGOT), Ingredient.ofItems(Items.EMERALD),
                        RecipeCategory.MISC, ModItems.FURTIVIUM_INGOT)
                .criterion(hasItem(ModItems.VIAL_OF_LIQUID_FURTIVIUM), conditionsFromItem(ModItems.VIAL_OF_LIQUID_FURTIVIUM))
                .criterion(hasItem(ModItems.INCOMPLETE_FURTIVIUM_INGOT), conditionsFromItem(ModItems.INCOMPLETE_FURTIVIUM_INGOT))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(Furtivium.MOD_ID, "furtivium_ingot_recipe"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.FURTIVIUM_INGOT), Ingredient.ofItems(ModItems.SCULK_BONE), Ingredient.ofItems(Items.DIAMOND_SWORD),
                        RecipeCategory.MISC, ModItems.FURTIVIUM_GLADIUS)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter, new Identifier(Furtivium.MOD_ID, "furtivium_gladius_recipe"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.FURTIVIUM_INGOT), Ingredient.ofItems(ModItems.SCULK_BONE), Ingredient.ofItems(Items.DIAMOND_AXE),
                        RecipeCategory.MISC, ModItems.FURTIVIUM_SPADONE)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(Items.DIAMOND_AXE), conditionsFromItem(Items.DIAMOND_AXE))
                .offerTo(exporter, new Identifier(Furtivium.MOD_ID, "furtivium_spadone_recipe"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.FURTIVIUM_INGOT), Ingredient.ofItems(ModItems.SCULK_BONE), Ingredient.ofItems(Items.TRIDENT),
                        RecipeCategory.MISC, ModItems.FURTIVIUM_GLAIVE)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(Items.TRIDENT), conditionsFromItem(Items.TRIDENT))
                .offerTo(exporter, new Identifier(Furtivium.MOD_ID, "furtivium_glave_recipe"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.FURTIVIUM_INGOT), Ingredient.ofItems(ModItems.VOID_MATTER), Ingredient.ofItems(ModItems.FURTIVIUM_GLAIVE),
                        RecipeCategory.MISC, ModItems.VOID_TOUCHED_FURTIVIUM_GLAIVE)
                .criterion(hasItem(ModItems.VOID_MATTER), conditionsFromItem(ModItems.VOID_MATTER))
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(ModItems.FURTIVIUM_GLAIVE), conditionsFromItem(ModItems.FURTIVIUM_GLAIVE))
                .offerTo(exporter, new Identifier(Furtivium.MOD_ID, "void_touched_furtivium_glave_recipe"));

    }
}
