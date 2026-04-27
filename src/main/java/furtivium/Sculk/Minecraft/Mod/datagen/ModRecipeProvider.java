package furtivium.Sculk.Minecraft.Mod.datagen;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
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

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_BONE, RecipeCategory.DECORATIONS,
                ModBlocks.SCULK_BONE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.BONE_MEAL, 9).input(ModItems.SCULK_BONE).criterion(FabricRecipeProvider.hasItem(Items.BONE_MEAL),
                FabricRecipeProvider.conditionsFromItem(Items.BONE_MEAL)).criterion(FabricRecipeProvider.hasItem(ModItems.SCULK_BONE),
                FabricRecipeProvider.conditionsFromItem(ModItems.SCULK_BONE)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HOMO_BLASTER, 1)
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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HOMO_BLASTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC, 1)
                .pattern(" E ")
                .pattern("EDE")
                .pattern(" E ")
                .input('D', ItemTags.MUSIC_DISCS)
                .input('E', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.A_WARDENS_LULLABY_MUSIC_DISC)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.VIAL_OF_DORMANT_SCULK, 1)
                .pattern("   ")
                .pattern("SSS")
                .pattern(" G ")
                .input('G', Items.GLASS_BOTTLE)
                .input('S', Items.SCULK)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VIAL_OF_DORMANT_SCULK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.VIAL_OF_ACTIVE_SCULK, 2)
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" V ")
                .input('S', Items.SCULK)
                .input('V', ModItems.VIAL_OF_DORMANT_SCULK)
                .input('E', Items.EXPERIENCE_BOTTLE)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(ModItems.VIAL_OF_DORMANT_SCULK), conditionsFromItem(ModItems.VIAL_OF_DORMANT_SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VIAL_OF_ACTIVE_SCULK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.EXPERIENCE_BOTTLE, 3)
                .pattern(" V ")
                .pattern("SES")
                .pattern(" G ")
                .input('V', ModItems.VIAL_OF_ACTIVE_SCULK)
                .input('E', Items.EXPERIENCE_BOTTLE)
                .input('G', Items.GLASS_BOTTLE)
                .input('S', Items.SCULK)
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.EXPERIENCE_BOTTLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SCULK_CATALYST, 1)
                .pattern("SSS")
                .pattern("BWB")
                .pattern("BSB")
                .input('B', ModItems.SCULK_BONE)
                .input('W', ModItems.WARDEN_HEART)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.WARDEN_HEART), conditionsFromItem(ModItems.WARDEN_HEART))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.SCULK_CATALYST)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SCULK_SHRIEKER, 1)
                .pattern("B B")
                .pattern("BWB")
                .pattern("SSS")
                .input('B', ModItems.SCULK_BONE)
                .input('W', ModItems.WARDEN_HEART)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.WARDEN_HEART), conditionsFromItem(ModItems.WARDEN_HEART))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.SCULK_SHRIEKER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SCULK_SENSOR, 1)
                .pattern("   ")
                .pattern("T T")
                .pattern("SSS")
                .input('T', ModItems.SCULK_TENDRIL)
                .input('S', Items.SCULK)
                .criterion(hasItem(ModItems.SCULK_TENDRIL), conditionsFromItem(ModItems.SCULK_TENDRIL))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.SCULK_SENSOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SCULK, 1)
                .pattern("VV")
                .pattern("VV")
                .input('V', Items.SCULK_VEIN)
                .criterion(hasItem(Items.SCULK_VEIN), conditionsFromItem(Items.SCULK_VEIN))
                .offerTo(exporter, new Identifier(getRecipeName(Items.SCULK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SCULK_VEIN, 8)
                .pattern("S ")
                .pattern("S ")
                .input('S', Items.SCULK)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.SCULK_VEIN)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_BONE_AND_TENDRIL_BROTH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_ROOT_GNOCCHI, 1)
                .pattern("SR")
                .pattern(" P")
                .input('P', Items.BOWL)
                .input('S', Items.SCULK)
                .input('R', ModBlocks.SCULK_ROOTS)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(ModBlocks.SCULK_ROOTS), conditionsFromItem(ModBlocks.SCULK_ROOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_ROOT_GNOCCHI)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_LAMINGTON, 4)
                .pattern("SS")
                .pattern("SO")
                .input('S', Items.SCULK)
                .input('O', ModBlocks.SCULK_ORCHID)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .criterion(hasItem(ModBlocks.SCULK_ORCHID), conditionsFromItem(ModBlocks.SCULK_ORCHID))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_LAMINGTON)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_DOUGHNUT)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_TENDRIL_SPAGHETTI)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULKZZARELLA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SCULK_RING_TOKEN, 1)
                .pattern(" S ")
                .pattern("VSV")
                .pattern(" V ")
                .input('S', Items.SCULK)
                .input('V', Items.SCULK_VEIN)
                .criterion(hasItem(Items.SCULK_VEIN), conditionsFromItem(Items.SCULK_VEIN))
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_RING_TOKEN)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_RING_NUKE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.VIAL_OF_ACTIVE_SCULK), Ingredient.ofItems(Items.EMERALD), Ingredient.EMPTY,
                        RecipeCategory.MISC, ModItems.FURTIVIUM_INGOT)
                .criterion(hasItem(ModItems.VIAL_OF_ACTIVE_SCULK), conditionsFromItem(ModItems.VIAL_OF_ACTIVE_SCULK))
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
                        RecipeCategory.MISC, ModItems.FURTIVIUM_GLAVE)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(Items.TRIDENT), conditionsFromItem(Items.TRIDENT))
                .offerTo(exporter, new Identifier(Furtivium.MOD_ID, "furtivium_glave_recipe"));
    }
}

