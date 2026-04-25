package furtivium.Sculk.Minecraft.Mod.Item.custom;

import furtivium.Sculk.Minecraft.Mod.Item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

import java.util.List;

public class TheHomoBlasterItem extends ToolItem {

    public TheHomoBlasterItem(ModToolMaterial modToolMaterial, int i, float v, FabricItemSettings fabricItemSettings) {
        super(modToolMaterial, fabricItemSettings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

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
                    if (target.getBoundingBox().expand(0.5).contains(closestPoint)) {
                        target.damage(
                                world.getDamageSources().sonicBoom(user),
                                10.0F
                        );

                        target.addVelocity(
                                look.x * 3,
                                0.5,
                                look.z * 2.5
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
                    1.0F
            );


            user.getItemCooldownManager().set(this, 60);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postHit(stack, target, attacker);

        Vec3d velocity = target.getVelocity();
        target.setVelocity(velocity.x, 0.7, velocity.z);
        target.velocityModified = true;

        return true;
    }

}

