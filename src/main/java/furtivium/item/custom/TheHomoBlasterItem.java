package furtivium.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

import static net.minecraft.entity.effect.StatusEffects.SLOW_FALLING;

public class TheHomoBlasterItem extends CrossbowItem {

    private static final int RANGE = 20;
    private static final float DAMAGE = 10.0F;
    private static final int COOLDOWN = 300;

    public TheHomoBlasterItem(FabricItemSettings fabricItemSettings) {
        super(fabricItemSettings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return stack -> stack.isOf(Items.ECHO_SHARD);
    }

    @Override
    public Predicate<ItemStack> getHeldProjectiles() {
        return stack -> stack.isOf(Items.ECHO_SHARD);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(stack);
        }

        if (isCharged(stack)) {
            if (!world.isClient) {
                fireBlaster(world, user);
                setCharged(stack, false);
                user.getItemCooldownManager().set(this, COOLDOWN);
            }

            return TypedActionResult.success(stack, world.isClient());
        }

        if (!hasEchoShard(user)) {
            return TypedActionResult.fail(stack);
        }

        user.setCurrentHand(hand);

        return TypedActionResult.consume(stack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (world.isClient || !(user instanceof PlayerEntity player)) {
            return;
        }

        int useTicks = getMaxUseTime(stack) - remainingUseTicks;

        if (useTicks < getPullTime(stack)) {return;}
        if (isCharged(stack)) {return;}
        if (loadEchoShard(player)) {setCharged(stack, true);}
    }

    private boolean hasEchoShard(PlayerEntity player) {
        if (player.getAbilities().creativeMode) {return true;}
        return player.getInventory().contains(Items.ECHO_SHARD.getDefaultStack());
    }

    private boolean loadEchoShard(PlayerEntity player) {
        if (player.getAbilities().creativeMode) {
            return true;
        }
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.isOf(Items.ECHO_SHARD)) {
                stack.decrement(1);
                return true;
            }
        }

        return false;
    }

    private void fireBlaster(World world, PlayerEntity user) {
        Vec3d start = user.getEyePos();
        Vec3d look = user.getRotationVec(1.0F);
        Vec3d end = start.add(look.multiply(RANGE));

        spawnBlastParticles(world, start, look);
        damageTargets(world, user, start, look, end);
        playBlastSound(world, user);
    }
    private void spawnBlastParticles(World world, Vec3d start, Vec3d look) {
        if (!(world instanceof ServerWorld serverWorld)) {
            return;
        }

        for (int i = 0; i < RANGE * 2; i++) {
            Vec3d pos = start.add(look.multiply(i * 0.5));
            serverWorld.spawnParticles(ParticleTypes.SONIC_BOOM, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
        }
    }


    private void damageTargets(World world, PlayerEntity user, Vec3d start, Vec3d look, Vec3d end) {
        Box box = new Box(start, end).expand(2);

        List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user);

        for (LivingEntity target : targets) {
            Vec3d toTarget = target.getPos().subtract(start);
            double projection = toTarget.dotProduct(look);

            if (projection < 0 || projection > RANGE) {continue;}

            Vec3d closestPoint = start.add(look.multiply(projection));

            if (!target.getBoundingBox().expand(0.5).contains(closestPoint)) {continue;}

            damageTarget(world, user, target, look);
        }
    }

    private void damageTarget(World world, PlayerEntity user, LivingEntity target, Vec3d look) {
        target.damage(world.getDamageSources().sonicBoom(user), DAMAGE);
        target.addVelocity(look.x * 2.0, 0.5, look.z * 1.5);

        target.velocityModified = true;
        target.addStatusEffect(new StatusEffectInstance(SLOW_FALLING, 10, 0));
    }

    private void playBlastSound(World world, PlayerEntity user) {
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS, 2.0F, 5.0F);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {

            target.addStatusEffect(new StatusEffectInstance(SLOW_FALLING, 10, 0));

            Vec3d velocity = target.getVelocity();
            target.setVelocity(velocity.x, 1.0D, velocity.z);

            target.velocityModified = true;

            player.getItemCooldownManager().remove(this);
        }

        return super.postHit(stack, target, attacker);
    }
}