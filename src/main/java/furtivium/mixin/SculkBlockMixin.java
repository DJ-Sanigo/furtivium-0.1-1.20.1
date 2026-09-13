package furtivium.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SculkBlock;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Method;
import java.util.List;

@Mixin(SculkBlock.class)
public abstract class SculkBlockMixin {

//    @Definition(id = "SCULK_SENSOR", field = "Lent/minecraft/world/level/block/Blocks;SCULK_SENSOR:Lent/minecraft/world/level/block/Block;")
//    @Definition(id = "getDefaultState", method = "Lent/net/minecraft/block/BlockState;getDefaultState()Lent/net/minecraft/block/BlockState;")
//    @Expression("SCULK_SENSOR.getDefaultState()")
//    @ModifyExpressionValue(method = "getExtraBlockState", at = @At("MIXINEXTRAS:EXPRESSION"))
//    private BlockState addSculk(BlockState original, WorldAccess worldAccess, BlockPos blockPos, Random random, boolean bl) {
//        if (random.nextInt(11) == 0) {
//            return new SculkBlock();
//        }
//        return original;
//    }


    @Inject(method = "getExtraBlockState", at = @At("RETURN"), cancellable = true)
    private void furtivium$addSculkRoots(WorldAccess world, BlockPos pos, Random random, boolean allowShrieker, CallbackInfoReturnable<BlockState> cir) {
        List<Block> sculkBlocks = List.of(
                ModBlocks.SCULK_ROOTS,
                ModBlocks.SCULK_CARNATION,
                ModBlocks.SCULK_MUSHROOM,
                ModBlocks.SCULK_ORCHID
        );

        if (random.nextInt(3) == 0) {

            int sculkBlockRandom = random.nextInt(sculkBlocks.toArray().length);
            BlockState state;
            state = sculkBlocks.get(sculkBlockRandom).getDefaultState();


            if (state.contains(Properties.WATERLOGGED) && !world.getFluidState(pos).isEmpty()) {
                state = state.with(Properties.WATERLOGGED, true);
            }

            cir.setReturnValue(state);
        }
    }

} //Under Construction
