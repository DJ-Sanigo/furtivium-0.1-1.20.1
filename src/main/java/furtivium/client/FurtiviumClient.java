package furtivium.client;

import furtivium.block.ModBlocks;

import furtivium.client.rendering.FurtiviumBlockLayerMaps;
import furtivium.entity.ModEntities;
import furtivium.entity.client.Broken1Model;
import furtivium.entity.client.Broken1Renderer;
import furtivium.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;


public class FurtiviumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        FurtiviumBlockLayerMaps.init();

        EntityRendererRegistry.register(ModEntities.BROKEN1, Broken1Renderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BROKEN1, Broken1Model::getTexturedModelData);
    }
}