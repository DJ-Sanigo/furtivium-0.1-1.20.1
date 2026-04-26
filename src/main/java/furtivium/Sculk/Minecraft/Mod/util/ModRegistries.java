package furtivium.Sculk.Minecraft.Mod.util;

import furtivium.Sculk.Minecraft.Mod.Potion.ModPotions;
import furtivium.Sculk.Minecraft.Mod.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

public class ModRegistries {
    public static void registerModStuffs() {
        registerPotionRecipes();
    }


    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.EMPTY, Items.SCULK, ModPotions.VIAL_OF_DORMANT_SCULK);
    }
}