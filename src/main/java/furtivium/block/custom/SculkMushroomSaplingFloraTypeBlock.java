package furtivium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class SculkMushroomSaplingFloraTypeBlock extends SculkFloraBlock implements Fertilizable {
    private final SaplingGenerator generator;

    public SculkMushroomSaplingFloraTypeBlock(Settings settings, SaplingGenerator generator) {
        super(settings);
        this.generator = generator;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {

    }

    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
            this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
    }

}
