package furtivium.block.custom;

import furtivium.entity.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SculkBrambleBushBlock extends SculkFloraBlock {
    public SculkBrambleBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.WARDEN && entity.getType() != ModEntities.BROKEN1) {
            entity.slowMovement(state, new Vec3d((double)0.8F, (double)0.75F, (double)0.8F));

            }

        }


}

