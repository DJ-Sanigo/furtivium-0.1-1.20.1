package furtivium.Sculk.Minecraft.Mod.Item;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import furtivium.Sculk.Minecraft.Mod.Item.custom.VialOfActiveSculkItem;
import furtivium.Sculk.Minecraft.Mod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VIAL_OF_DORMANT_SCULK = registerItem("vial_of_dormant_sculk",
    new Item(new FabricItemSettings().food(ModFoodComponents.VIAL_OF_DORMANT_SCULK).maxCount(16)));
    public static final Item VIAL_OF_ACTIVE_SCULK = registerItem("vial_of_active_sculk",
                new Item(new FabricItemSettings().food(ModFoodComponents.VIAL_OF_ACTIVE_SCULK).maxCount(16)));

    public static final Item SCULK_BONE_AND_TENDRIL_BROTH = registerItem("sculk_bone_and_tendril_broth",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.SCULK_BONE_AND_TENDRIL_BROTH).maxCount(1)));

    public static final Item FURTIVIUM_INGOT = registerItem("furtivium_ingot", new Item(new FabricItemSettings()));
    public static final Item SCULK_BONE = registerItem("sculk_bone", new Item(new FabricItemSettings()));

    public static final Item A_WARDENS_LULLABY_MUSIC_DISC = registerItem("a_wardens_lullaby_music_disc",
            new MusicDiscItem(7, ModSounds.A_WARDENS_LULLABY, new FabricItemSettings().maxCount(1), 220));
    public static final Item A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC = registerItem("a_wardens_lullaby_music_box_version_music_disc",
            new MusicDiscItem(7, ModSounds.A_WARDENS_LULLABY_MUSIC_BOX_VERSION, new FabricItemSettings().maxCount(1), 64));

    public static final Item FURTIVIUM_SPADONE = registerItem("furtivium_spadone",
            new SwordItem(ModToolMaterial.FURTIVIUM, 5, 0.00000005f, new FabricItemSettings()));
    public static final Item FURTIVIUM_GLADIUS = registerItem("furtivium_gladius",
            new SwordItem(ModToolMaterial.FURTIVIUM, 3, 0.5f, new FabricItemSettings()));
    public static final Item FURTIVIUM_GLAVE = registerItem("furtivium_glave",
            new SwordItem(ModToolMaterial.FURTIVIUM, 4, 0.05f, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(VIAL_OF_DORMANT_SCULK);
        entries.add(VIAL_OF_ACTIVE_SCULK);
        entries.add(FURTIVIUM_INGOT);
        entries.add(SCULK_BONE);
        entries.add(A_WARDENS_LULLABY_MUSIC_DISC);
        entries.add(A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(FURTIVIUM_SPADONE);
        entries.add(FURTIVIUM_GLADIUS);
        entries.add(FURTIVIUM_GLAVE);
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(SCULK_BONE_AND_TENDRIL_BROTH);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Furtivium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Furtivium.LOGGER.debug("Registering Mod Items for " + Furtivium.MOD_ID);

    }
}