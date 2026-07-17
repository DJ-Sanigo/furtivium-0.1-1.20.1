package furtivium.Sculk.Minecraft.Mod.Item.custom;

import furtivium.Sculk.Minecraft.Mod.Item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class FurtiviumGlaiveItem extends SwordItem {

    public FurtiviumGlaiveItem(ModToolMaterial modToolMaterial, int i, float v, FabricItemSettings fabricItemSettings) {
        super(modToolMaterial, i, v, fabricItemSettings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        user.setCurrentHand(hand);

        return TypedActionResult.consume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
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
                    100,
                    0
            ));

        }

        return super.postHit(stack, target, attacker);

    }

}

