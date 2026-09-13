package furtivium.client;

import furtivium.block.ModBlocks;

import furtivium.client.rendering.FurtiviumBlockLayerMaps;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.render.RenderLayer;


public class FurtiviumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FurtiviumBlockLayerMaps.init();
    }
}