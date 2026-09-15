package furtivium.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import furtivium.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.A_WARDENS_LULLABY_MUSIC_DISC,  ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC,
                        ModItems.IMMOVABLE_OBJECT_MUSIC_DISC, ModItems.THE_ALARM_MUSIC_DISC);

    }
}