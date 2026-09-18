package furtivium.block.custom;

import furtivium.entity.custom.Broken1Entity;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SculkSporeShroomCluster extends SculkFloraBlock {
    public SculkSporeShroomCluster(Settings settings) {
        super(settings);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);
        ((World)world).createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 0.5F,  World.ExplosionSourceType.NONE);
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            if (!(entity instanceof WardenEntity) && !(entity instanceof Broken1Entity)) {
                    world.breakBlock(pos, false);

                    super.onEntityCollision(state, world, pos, entity);
                    ((World)world).createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 0.5F,  World.ExplosionSourceType.NONE);
            }
        }

    }



}
