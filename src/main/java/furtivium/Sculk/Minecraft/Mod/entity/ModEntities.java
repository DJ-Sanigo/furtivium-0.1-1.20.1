package furtivium.Sculk.Minecraft.Mod.entity;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import furtivium.Sculk.Minecraft.Mod.entity.custom.Broken1Entity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<Broken1Entity> BROKEN1 = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Furtivium.MOD_ID, "broken1"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Broken1Entity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
