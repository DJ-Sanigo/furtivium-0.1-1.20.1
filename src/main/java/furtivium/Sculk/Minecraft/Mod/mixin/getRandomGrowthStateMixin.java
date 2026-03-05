package furtivium.Sculk.Minecraft.Mod.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkBlock;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Debug(export = true)
@Mixin(SculkBlock.class)
abstract class getRandomGrowthStateMixin {

    @Definition(id = "SCULK_SENSOR", field = "Lent/minecraft/world/level/block/Blocks;SCULK_SENSOR:Lent/minecraft/world/level/block/Block;")
    @Definition(id = "defaultBlockState", method = "Lent/minecraft/world/level/block/Blocks;defaultBlockState()Lent/minecraft/world/level/block/state/BlockState;")
    @Expression("SCULK_SENSOR.defaultBlockState()")
    @ModifyExpressionValue(method = "getRandomGrowthState", at = @At("MIXINEXTRAS:EXPRESSION"))
    private BlockState addToSculkGrowthState(BlockState original, LevelAccessor levelAccessor, BlockPos blockPos, RandomSource randomSource, boolean bl) {
        if (randomSource.nextInt(11) == 0) {
            return yourBlockState;
        }
        return original;
    }

}
