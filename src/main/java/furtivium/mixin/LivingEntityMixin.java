package furtivium.mixin;

import furtivium.combat.ParryEffects;
import furtivium.item.custom.FurtiviumGlaiveItem;
import furtivium.item.custom.FurtiviumSpadoneitem;
import furtivium.item.custom.VoidTouchedFurtiviumGlaiveItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @ModifyVariable(
            method = "damage",
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    private float blockDamage(float amount, DamageSource source) {

        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof PlayerEntity player)) {
            return amount;
        }

        if (!player.isUsingItem()) {
            return amount;
        }

        ItemStack active = player.getActiveItem();

        if (!(active.getItem() instanceof FurtiviumGlaiveItem)) {
            return amount * 0.05F;
        }

        if (!(active.getItem() instanceof VoidTouchedFurtiviumGlaiveItem)) {
            return amount * 0.25F;
        }

        return amount;
    }

    @Inject(
            method = "damage",
            at = @At("RETURN")
    )
    private void playBlockingSound(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        if ((Object) this instanceof PlayerEntity player) {

            if (!player.getWorld().isClient && cir.getReturnValue() && player.isUsingItem() && player.getActiveItem().getItem()
                    instanceof FurtiviumGlaiveItem) {

                player.getWorld().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_WARDEN_HURT, SoundCategory.PLAYERS, 2F, 1.0F
                );

                player.getWorld().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.PLAYERS, 3F, 3.0F
                );

            }

            if (!player.getWorld().isClient && cir.getReturnValue() && player.isUsingItem() && player.getActiveItem().getItem()
                    instanceof VoidTouchedFurtiviumGlaiveItem) {

                player.getWorld().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_WARDEN_HURT, SoundCategory.PLAYERS, 2F, 1.0F
                );

                player.getWorld().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.PLAYERS, 3F, 3.0F
                );

            }
        }
    }

    @Inject(
            method = "damage",
            at = @At("HEAD"),
            cancellable = true
    )
    private void tryParry(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        if (!((Object) this instanceof PlayerEntity player)) {
            return;
        }

        // Only process parries on the server
        if (player.getWorld().isClient) {
            return;
        }

        // Is the player actively blocking
        if (!player.isUsingItem()) {
            return;
        }

        ItemStack stack = player.getActiveItem();

        if (!(stack.getItem() instanceof FurtiviumSpadoneitem)) {
            return;
        }

        NbtCompound nbt = stack.getNbt();

        if (nbt == null || !nbt.contains("ParryStartTick")) {
            return;
        }

        // Calculate elapsed blocking time
        long startTick = nbt.getLong("ParryStartTick");

        long elapsedTicks = player.getWorld().getTime() - startTick;

        // 15 ticks = 750 milliseconds
        if (elapsedTicks >= 0 && elapsedTicks <= 15) {

            // Identify the attacker
            LivingEntity attacker = ParryEffects.getAttacker(source);

            // Only recognise attacks from living entities
            if (attacker == null) {
                return;
            }

            // Calculate the reflected damage value
            float reflectedDamage = ParryEffects.calculateReflectedDamage(amount);

        }

        // Successful parry
        player.getItemCooldownManager().remove(stack.getItem());

        // Spawn successful parry particles
        ParryEffects.spawnParryParticles(player);

        // Consume the parry window
        nbt.remove("ParryStartTick");

        // Play the successful parry sound
        player.getWorld().playSound(
                null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 5.0F, 2.5F
        );

        // Completely cancel the incoming damage
        cir.setReturnValue(true);
    }
}
