package furtivium.Sculk.Minecraft.Mod.datagen;

import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FURTIVIUM_SPADONE, 1)
                .pattern("  B")
                .pattern("FB ")
                .pattern("FF ")
                .input('B', ModItems.SCULK_BONE)
                .input('F', ModItems.FURTIVIUM_INGOT)
                .criterion(hasItem(ModItems.FURTIVIUM_INGOT), conditionsFromItem(ModItems.FURTIVIUM_INGOT))
                .criterion(hasItem(ModItems.SCULK_BONE), conditionsFromItem(ModItems.SCULK_BONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FURTIVIUM_SPADONE)));
    }
}
