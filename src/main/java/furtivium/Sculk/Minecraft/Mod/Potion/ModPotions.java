package furtivium.Sculk.Minecraft.Mod.Potion;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion VIAL_OF_DORMANT_SCULK = registerPotion("vial_of_dormant_sculk", new Potion(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 0)));

    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(Furtivium.MOD_ID, name), potion);
    }

    public static void registerPotions() {
    }

    public static void onInitialize() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.EMPTY, Items.SCULK, ModPotions.VIAL_OF_DORMANT_SCULK);
    }
}