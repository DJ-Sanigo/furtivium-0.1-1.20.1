package furtivium.Sculk.Minecraft.Mod.Item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent VIAL_OF_DORMANT_SCULK =
            new FoodComponent.Builder().alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 0), 1f).build();

    public static final FoodComponent VIAL_OF_ACTIVE_SCULK =
            new FoodComponent.Builder().alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1200, 4), 1f ).build();

    public static final FoodComponent SCULK_MARGARITA =
            new FoodComponent.Builder().alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 9), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 9), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 14), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 100, 9), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 9), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 500, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 3600, 4), 1f ).build();

    public static final FoodComponent SCULK_TENDRIL_AND_TONIC =
            new FoodComponent.Builder().alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 9), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 9), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 50, 19), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300, 14), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 500, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 3600, 4), 1f ).build();

    public static final FoodComponent SCULK_BONE_AND_TENDRIL_BROTH =
            new FoodComponent.Builder().hunger(12).saturationModifier(1.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 4), 1f ).build();

    public static final FoodComponent SCULK_LAMINGTON =
            new FoodComponent.Builder().hunger(8).saturationModifier(1.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0), 1f )
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 4), 1f )
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 4), 1f ).build();

    public static final FoodComponent SCULK_ROOT_GNOCCHI =
            new FoodComponent.Builder().hunger(18).saturationModifier(1.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 3600, 4), 1f).build();

    public static final FoodComponent SCULK_DOUGHNUT =
            new FoodComponent.Builder().hunger(6).saturationModifier(2.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 1f )
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 4), 1f ).build();

    public static final FoodComponent SCULK_TENDRIL_SPAGHETTI =
            new FoodComponent.Builder().hunger(15).saturationModifier(1.75F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600, 0), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 0), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 2400, 4), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 0), 1f).build();

    public static final FoodComponent SCULKZZARELLA =
            new FoodComponent.Builder().hunger(2).saturationModifier(1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 0), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0), 1f )
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 4), 1f ).build();
}