package furtivium.Sculk.Minecraft.Mod.Item.custom;

import furtivium.Sculk.Minecraft.Mod.Item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class TrannySwordItem extends SwordItem {
    public TrannySwordItem(ModToolMaterial modToolMaterial, int i, float v, FabricItemSettings fabricItemSettings) {
        super(modToolMaterial, i, v, fabricItemSettings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {


            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.ABSORPTION,
                    30,
                    0
            ));

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SPEED,
                    30,
                    0
            ));

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.STRENGTH,
                    30,
                    0
            ));


        }

        return super.postHit(stack, target, attacker);

    }

}

