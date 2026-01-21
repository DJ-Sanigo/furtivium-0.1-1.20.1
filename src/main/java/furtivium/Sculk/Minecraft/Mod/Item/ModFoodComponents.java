package furtivium.Sculk.Minecraft.Mod.Item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent VIAL_OF_DORMANT_SCULK = new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 4), 1f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 0), 1f).build();
}