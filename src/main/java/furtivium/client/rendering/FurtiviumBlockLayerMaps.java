package furtivium.client.rendering;

import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FurtiviumBlockLayerMaps {

    public static void init(){
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.SCULK_ROOTS,
                ModBlocks.SCULK_MUSHROOM,
                ModBlocks.SCULK_ORCHID,
                ModBlocks.SCULK_CARNATION,
                ModBlocks.SCULK_SPIDER_PLANT,
                ModBlocks.SCULK_FAT_CAP,
                ModBlocks.WARDENS_SNACK_BLOCK,
                ModBlocks.POTTED_SCULK_ROOTS,
                ModBlocks.POTTED_SCULK_MUSHROOM,
                ModBlocks.POTTED_SCULK_ORCHID,
                ModBlocks.POTTED_SCULK_CARNATION,
                ModBlocks.POTTED_SCULK_SPIDER_PLANT,
                ModBlocks.POTTED_SCULK_FAT_CAP,
                ModBlocks.POTTED_WARDENS_SNACK
        );
    }
}
