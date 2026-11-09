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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;



public class FurtiviumSpadoneitem extends SwordItem implements TwoHandedItem {
    // Timing configuration (20 ticks = 1 second)
    public static final int PARRY_WINDOW = 15;
    public static final int PARRY_COOLDOWN = 50;
    public FurtiviumSpadoneitem(ModToolMaterial modToolMaterial, int i, float v, FabricItemSettings fabricItemSettings) {
        super(modToolMaterial, i, v, fabricItemSettings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {


        ItemStack stack = user.getStackInHand(hand);

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(stack);
        }

            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_WARDEN_TENDRIL_CLICKS, SoundCategory.PLAYERS, 1.0F, 2.5F
            );

            // Record the beginning of the parry window
            if (!world.isClient) {
                stack.getOrCreateNbt().putLong(
                        "ParryStartTick",
                        world.getTime()
                );
            }

        user.getItemCooldownManager().set(this, PARRY_COOLDOWN);

        user.setCurrentHand(hand);

        return TypedActionResult.consume(stack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {return 15;}

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {

            if (!((PlayerEntity) attacker).getItemCooldownManager().isCoolingDown(this)) {

                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.RESISTANCE,
                        200,
                        0
                ));

                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.SLOWNESS,
                        100,
                        1
                ));

                ((PlayerEntity) attacker).getItemCooldownManager().set(this, 50);

            }
        }
        return super.postHit(stack, target, attacker);
    }
}

