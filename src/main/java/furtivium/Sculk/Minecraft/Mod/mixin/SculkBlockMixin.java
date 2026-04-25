//package furtivium.Sculk.Minecraft.Mod.mixin;

//import com.llamalad7.mixinextras.expression.Definition;
//import com.llamalad7.mixinextras.expression.Expression;
//import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
//import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.SculkBlock;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.WorldAccess;
//import org.spongepowered.asm.mixin.Debug;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;

//import java.util.Random;

//@Debug(export = true)
//@Mixin(SculkBlock.class)
//abstract class SculkBlockMixin {

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

//} //Under Construction
