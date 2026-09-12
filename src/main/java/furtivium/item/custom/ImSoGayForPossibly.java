package furtivium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ImSoGayForPossibly extends SwordItem {
    public ImSoGayForPossibly(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {


            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SPEED,
                    50,
                    3
            ));

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.WEAKNESS,
                    100,
                    0
            ));

        }

        return super.postHit(stack, target, attacker);

    }

}

    //we all say thank you counter strike i mean noelle


