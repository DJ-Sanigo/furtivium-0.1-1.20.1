package furtivium.Sculk.Minecraft.Mod.Item.custom;

import furtivium.Sculk.Minecraft.Mod.Item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;

import static net.minecraft.entity.effect.StatusEffects.SLOW_FALLING;

public class TheHomoBlasterItem extends CrossbowItem {
    private boolean charged = false;
    private boolean loaded = false;

    public TheHomoBlasterItem(int i, float v, FabricItemSettings fabricItemSettings) {
        super(fabricItemSettings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (isCharged(stack)) {
            shootAll(world, user, hand, stack, getSpeed(stack), 1.0F);
            setCharged(stack, false);
            return TypedActionResult.consume(stack);
        } else if (!user.getProjectileType(stack).isEmpty()) {
            if (!isCharged(stack)) {
                this.charged = false;
                this.loaded = false;
                user.setCurrentHand(hand);
            }

        if (!world.isClient) {
            Vec3d start = user.getEyePos();
            Vec3d look = user.getRotationVec(1.0F);
            Vec3d end = start.add(look.multiply(20.0));


            ServerWorld serverWorld = (ServerWorld) world;
            for (int i = 0; i < 40; i++) {
                Vec3d pos = start.add(look.multiply(i * 0.5));
                serverWorld.spawnParticles(
                        ParticleTypes.SONIC_BOOM,
                        pos.x, pos.y, pos.z,
                        1, 0, 0, 0, 0
                );
            }


            Box box = new Box(start, end).expand(2);
            List<LivingEntity> targets = world.getEntitiesByClass(
                    LivingEntity.class,
                    box,
                    entity -> entity != user
            );

            for (LivingEntity target : targets) {
                Vec3d toTarget = target.getPos().subtract(start);
                double projection = toTarget.dotProduct(look);

                if (projection >= 0 && projection <= 20) {
                    Vec3d closestPoint = start.add(look.multiply(projection));
                    if (target.getBoundingBox().expand(0.5).contains(closestPoint)) { // Range - 0.5 = 1 Block
                        target.damage(
                                world.getDamageSources().sonicBoom(user),
                                5.0F // Damage - 2 = 1 Heart/ 1 = Half A Heart
                        );

                        target.addVelocity(
                                look.x * 2.0,
                                0.5,
                                look.z * 2.0 //Knockback - 0.5 = 1 Block
                        );

                        target.velocityModified = true;
                    }
                }
            }

            world.playSound(
                    null,
                    user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_WARDEN_SONIC_BOOM,
                    SoundCategory.PLAYERS,
                    2.0F,
                    5.0F
            );

        }
            return TypedActionResult.success(stack, world.isClient());
        } else {
            return TypedActionResult.fail(stack);
        }
    }

    private static float getSpeed(ItemStack stack) {
        return hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6F : 3.15F;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        float f = getPullTime(i, stack);
        if (f >= 1.0F && !isCharged(stack) && loadProjectiles(user, stack)) {
            setCharged(stack, true);
            SoundCategory soundCategory = user instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundCategory, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
        }

    }

    private float getPullTime(int i, ItemStack stack) {
        return 1;
    }
    
    private static boolean loadProjectiles(LivingEntity shooter, ItemStack crossbow) {
        int i = EnchantmentHelper.getLevel(Enchantments.MULTISHOT, crossbow);
        int j = i == 0 ? 1 : 3;
        boolean bl = shooter instanceof PlayerEntity && ((PlayerEntity)shooter).getAbilities().creativeMode;
        ItemStack itemStack = shooter.getProjectileType(crossbow);
        ItemStack itemStack2 = itemStack.copy();

        for(int k = 0; k < j; ++k) {
            if (k > 0) {
                itemStack = itemStack2.copy();
            }

            if (itemStack.isEmpty() && bl) {
                itemStack = new ItemStack(Items.ECHO_SHARD);
                itemStack2 = itemStack.copy();
            }

            if (!loadProjectiles(shooter, crossbow, itemStack, k > 0, bl)) {
                return false;
            }
        }

        return true;
    }

    private static boolean loadProjectiles(LivingEntity shooter, ItemStack crossbow, ItemStack itemStack, boolean b, boolean bl) {
        return false;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {

            target.addStatusEffect(new StatusEffectInstance(
                    SLOW_FALLING,
                    20,
                    0
            ));

            Vec3d velocity = target.getVelocity();
            target.setVelocity(velocity.x, 1.0D, velocity.z);
            target.velocityModified = true;

        }

        return super.postHit(stack, target, attacker);
    }
}

