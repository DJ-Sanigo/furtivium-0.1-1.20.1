package furtivium.Sculk.Minecraft.Mod.Item.custom;

import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import furtivium.Sculk.Minecraft.Mod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LiquidFurtiviumVialItem extends Item {
    public LiquidFurtiviumVialItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (world.isClient) {
            return ActionResult.FAIL;
        }

        if (state.isOf(Blocks.EMERALD_ORE)) {

            world.playSound(
                    null,
                    pos,
                    ModSounds.FURTIVIUM_BOTTLE_USE,
                    SoundCategory.BLOCKS,
                    1.0F,
                    1.0F
            );

            world.setBlockState(
                    pos,
                    ModBlocks.FURTIVIUM_ORE.getDefaultState(),
                    Block.NOTIFY_ALL
            );

            return ActionResult.SUCCESS;
        }

        if (state.isOf(Blocks.DEEPSLATE_EMERALD_ORE)) {

            world.playSound(
                    null,
                    pos,
                    ModSounds.FURTIVIUM_BOTTLE_USE,
                    SoundCategory.BLOCKS,
                    1.0F,
                    1.0F
            );

            world.setBlockState(
                    pos,
                    ModBlocks.DEEPSLATE_FURTIVIUM_ORE.getDefaultState(),
                    Block.NOTIFY_ALL
            );

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }


}

