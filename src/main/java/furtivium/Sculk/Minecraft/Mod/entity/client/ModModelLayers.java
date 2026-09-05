package furtivium.Sculk.Minecraft.Mod.entity.client;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer BROKEN1 =
            new EntityModelLayer(new Identifier(Furtivium.MOD_ID, "broken1"), "main");
}
