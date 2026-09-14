package furtivium.entity.client;

import furtivium.Furtivium;
import furtivium.entity.custom.Broken1Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class Broken1Renderer extends MobEntityRenderer<Broken1Entity, Broken1Model<Broken1Entity>> {
    private static final Identifier TEXTURE = Furtivium.id("textures/entity/sculky-var1_texture.png");

    public Broken1Renderer(EntityRendererFactory.Context context) {
        super(context, new Broken1Model<>(context.getPart(ModModelLayers.BROKEN1)), 0.6f);
    }

    @Override
    public Identifier getTexture(Broken1Entity entity) {
        return TEXTURE;
    }

}
