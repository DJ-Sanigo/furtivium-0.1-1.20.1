package furtivium.item.custom;

import furtivium.item.ModToolMaterial;
import furtivium.item.TwoHandedItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class FurtiviumSpadoneitem extends SwordItem implements TwoHandedItem {
    public FurtiviumSpadoneitem(ModToolMaterial modToolMaterial, int i, float v, FabricItemSettings fabricItemSettings) {
        super(modToolMaterial, i, v, fabricItemSettings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.RESISTANCE,
                    100,
                    3
            ));

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SLOWNESS,
                    200,
                    1
            ));

        }

        return super.postHit(stack, target, attacker);

    }

}

