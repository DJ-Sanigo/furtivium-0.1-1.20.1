package furtivium.client.rendering;

import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FurtiviumBlockLayerMaps {

    public static void init(){
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.SCULK_ROOTS,
                ModBlocks.SCULK_MUSHROOM,
                ModBlocks.SCULK_EYE_FLOWER,
                ModBlocks.SCULK_CARNATION,
                ModBlocks.SCULK_SPIDER_PLANT,
                ModBlocks.SCULK_FAT_CAP,
                ModBlocks.SCULK_APPLES_EYE_MUSHROOM,

                ModBlocks.SMALL_SCULK_SPORER_CLUSTER,
                ModBlocks.MEDIUM_SCULK_SPORER_CLUSTER,
                ModBlocks.LARGE_SCULK_SPORER_CLUSTER,

                ModBlocks.POTTED_SCULK_ROOTS,
                ModBlocks.POTTED_SCULK_MUSHROOM,
                ModBlocks.POTTED_SCULK_EYE_FLOWER,
                ModBlocks.POTTED_SCULK_CARNATION,
                ModBlocks.POTTED_SCULK_SPIDER_PLANT,
                ModBlocks.POTTED_SCULK_FAT_CAP,
                ModBlocks.POTTED_SCULK_APPLES_EYE_MUSHROOM,

                ModBlocks.WARDENS_SNACK_CLUSTER

        );
    }
}
