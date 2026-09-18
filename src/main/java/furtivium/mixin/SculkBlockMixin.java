package furtivium.mixin;

import furtivium.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SculkBlock.class)
public abstract class SculkBlockMixin {
    @Inject(method = "getExtraBlockState", at = @At("RETURN"), cancellable = true)
    private void furtivium$addSculkRoots(WorldAccess world, BlockPos pos, Random random, boolean allowShrieker, CallbackInfoReturnable<BlockState> cir) {
        List<Block> sculkBlocks = List.of(
                ModBlocks.SCULK_ROOTS,
                ModBlocks.SCULK_CARNATION,
                ModBlocks.SCULK_FLAT_CAP_MUSHROOM,
                ModBlocks.SCULK_FAKE_EYE_FLOWER_MUSHROOM,
                ModBlocks.SCULK_SPIDER_MUSHROOM,
                ModBlocks.SCULK_FAT_CAP_MUSHROOM,
                ModBlocks.SCULK_APPLES_EYE_MUSHROOM,

                ModBlocks.SMALL_SCULK_SPORE_SHROOM_CLUSTER,
                ModBlocks.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER,
                ModBlocks.LARGE_SCULK_SPORE_SHROOM_CLUSTER,

                ModBlocks.WARDENS_SNACK_CLUSTER
        );

        if (random.nextInt(2) == 0) {

            int sculkBlockRandom = random.nextInt(sculkBlocks.toArray().length);
            BlockState state;
            state = sculkBlocks.get(sculkBlockRandom).getDefaultState();


            if (state.contains(Properties.WATERLOGGED) && !world.getFluidState(pos).isEmpty()) {
                state = state.with(Properties.WATERLOGGED, true);
            }

            cir.setReturnValue(state);
        }
    }
}
//Nyx Is Like, So Like, Cool. Amarite!
