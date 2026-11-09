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
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class FurtiviumGlaiveItem extends SwordItem implements TwoHandedItem {

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
    public int getMaxUseTime(ItemStack stack) {return 200;}

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {

            if (!((PlayerEntity) attacker).getItemCooldownManager().isCoolingDown(this)) {

                target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.DARKNESS,
                    100,
                    3
                ));

                target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.BLINDNESS,
                    100,
                    3
                ));

                target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    100,
                    3
                ));

                target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NIGHT_VISION,
                    100,
                    3
                ));

                target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION,
                    200,
                    1
                ));

                ((PlayerEntity) attacker).getItemCooldownManager().set(this, 50);

            }
        }
        return super.postHit(stack, target, attacker);
    }
}

