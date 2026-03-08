package furtivium.Sculk.Minecraft.Mod.datagen;

import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FURTIVIUM_SPADONE, 1)
                .pattern("  B")
                .pattern("FB ")
                .pattern("FF ")
                .input('B', ModItems.SCULK_BONE)
                .input('F', ModItems.FURTIVIUM_INGOT)
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FURTIVIUM_SPADONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FURTIVIUM_GLADIUS, 1)
                .pattern("  B")
                .pattern(" F ")
                .pattern("F  ")
                .input('B', ModItems.SCULK_BONE)
                .input('F', ModItems.FURTIVIUM_INGOT)
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FURTIVIUM_GLADIUS)));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SCULK_BONE_AND_TENDRIL_BROTH, 1)
                .pattern("RS")
                .pattern(" B")
                .input('B', Items.BOWL)
                .input('S', ModItems.SCULK_BONE)
                .input('R', ModBlocks.SCULK_ROOTS)
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .criterion(hasItem(ModBlocks.SCULK_ROOTS), conditionsFromItem(ModBlocks.SCULK_ROOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCULK_BONE_AND_TENDRIL_BROTH)));

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
    }
}

