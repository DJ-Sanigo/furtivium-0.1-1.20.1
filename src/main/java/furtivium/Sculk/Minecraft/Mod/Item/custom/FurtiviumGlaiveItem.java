package furtivium.Sculk.Minecraft.Mod.Item.custom;

import furtivium.Sculk.Minecraft.Mod.Item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;


public class FurtiviumGlaiveItem extends SwordItem {

    public FurtiviumGlaiveItem(ModToolMaterial modToolMaterial, int i, float v, FabricItemSettings fabricItemSettings) {
        super(modToolMaterial, i, v, fabricItemSettings);
    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {

            target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.WEAKNESS,
                    50,
                    0
            ));

            target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.DARKNESS,
                    50,
                    0
            ));

            target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SLOWNESS,
                    50,
                    0
            ));

            target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    50,
                    0
            ));

            target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION,
                    50,
                    0
            ));

        }

        return super.postHit(stack, target, attacker);

    }
}

