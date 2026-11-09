package furtivium.combat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

public class ParryEffects {

    // Damage reflection configuration
    public static final float REFLECT_DAMAGE_MULTIPLIER = 1.0F;

    // Identify the attacking entity
    public static LivingEntity getAttacker(DamageSource source) {

        Entity attacker = source.getAttacker();

        if (attacker instanceof LivingEntity living) {
            return living;
        }

        return null;
    }

    // Calculate the reflected damage amount
    public static float calculateReflectedDamage(float incomingDamage) {

        return incomingDamage * REFLECT_DAMAGE_MULTIPLIER;
    }

    public static void spawnParryParticles(LivingEntity player) {
        if (!(player.getWorld() instanceof ServerWorld world)) {
            return;
        }

        world.spawnParticles(
                ParticleTypes.FLASH, player.getX(), player.getY() + 1.0, player.getZ(),
                1, 0.5, 0.5, 0.5, 0.1
        );

        world.spawnParticles(
                ParticleTypes.SCULK_CHARGE_POP, player.getX(), player.getY() + 1.0, player.getZ(),
                20, 0.5, 0.5, 0.5, 0.1
        );
    }
}