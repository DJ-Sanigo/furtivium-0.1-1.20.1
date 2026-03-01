package furtivium.Sculk.Minecraft.Mod.Item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent VIAL_OF_DORMANT_SCULK =
            new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 0), 1f).build();

    public static final FoodComponent VIAL_OF_ACTIVE_SCULK =
            new FoodComponent.Builder().alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1000, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1000, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1000, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1000, 4), 1f ).build();

    public static final FoodComponent SCULK_BONE_AND_TENDRIL_BROTH =
            new FoodComponent.Builder().hunger(14).saturationModifier(1.25F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 120, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 4), 1f ).build();
}