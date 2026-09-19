package furtivium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SculkBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class SculkMushroomSaplingFloraBlock extends SaplingBlock {

    public SculkMushroomSaplingFloraBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos down = pos.down();
        BlockState floor = world.getBlockState(down);
        return floor.getBlock()instanceof SculkBlock && !(floor.getBlock()instanceof SculkFloraBlock);

    }

}
