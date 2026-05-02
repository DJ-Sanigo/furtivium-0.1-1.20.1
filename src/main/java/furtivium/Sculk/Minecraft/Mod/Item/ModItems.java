package furtivium.Sculk.Minecraft.Mod.Item;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import furtivium.Sculk.Minecraft.Mod.Item.custom.*;
import furtivium.Sculk.Minecraft.Mod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VIAL_OF_DORMANT_SCULK = registerItem("vial_of_dormant_sculk",
                new VialOfSculkItem(new FabricItemSettings().food(ModFoodComponents.VIAL_OF_DORMANT_SCULK).maxCount(16)));
    public static final Item VIAL_OF_ACTIVE_SCULK = registerItem("vial_of_active_sculk",
                new VialOfSculkItem(new FabricItemSettings().food(ModFoodComponents.VIAL_OF_ACTIVE_SCULK).maxCount(16)));

    public static final Item SCULK_MARGARITA = registerItem("sculk_margarita",
            new VialOfSculkItem(new FabricItemSettings().food(ModFoodComponents.SCULK_MARGARITA).maxCount(16)));
    public static final Item SCULK_TENDRIL_AND_TONIC = registerItem("sculk_tendril_and_tonic",
            new VialOfSculkItem(new FabricItemSettings().food(ModFoodComponents.SCULK_TENDRIL_AND_TONIC).maxCount(16)));
    public static final Item SCULK_BONE_AND_TENDRIL_BROTH = registerItem("sculk_bone_and_tendril_broth",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.SCULK_BONE_AND_TENDRIL_BROTH).maxCount(1)));
    public static final Item SCULK_LAMINGTON = registerItem("sculk_lamington",
            new Item(new FabricItemSettings().food(ModFoodComponents.SCULK_LAMINGTON)));
    public static final Item SCULK_ROOT_GNOCCHI = registerItem("sculk_root_gnocchi",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.SCULK_ROOT_GNOCCHI).maxCount(1)));
    public static final Item SCULK_DOUGHNUT = registerItem("sculk_doughnut",
            new Item(new FabricItemSettings().food(ModFoodComponents.SCULK_DOUGHNUT)));
    public static final Item SCULK_TENDRIL_SPAGHETTI = registerItem("sculk_tendril_spaghetti",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.SCULK_TENDRIL_SPAGHETTI).maxCount(1)));
    public static final Item SCULKZZARELLA = registerItem("sculkzzarella",
            new Item(new FabricItemSettings().food(ModFoodComponents.SCULKZZARELLA)));

    public static final Item FURTIVIUM_INGOT = registerItem("furtivium_ingot", new Item(new FabricItemSettings()));
    public static final Item SCULK_BONE = registerItem("sculk_bone", new Item(new FabricItemSettings()));
    public static final Item WARDEN_HEART = registerItem("warden_heart", new Item(new FabricItemSettings()));
    public static final Item SCULK_TENDRIL = registerItem("sculk_tendril", new Item(new FabricItemSettings()));

    public static final Item SCULK_RING_TOKEN = registerItem("sculk_ring_token", new Item(new FabricItemSettings()));
    public static final Item COPPER_RING_NUKE = registerItem("copper_ring_nuke", new Item(new FabricItemSettings()));

    public static final Item A_WARDENS_LULLABY_MUSIC_DISC = registerItem("a_wardens_lullaby_music_disc",
            new MusicDiscItem(7, ModSounds.A_WARDENS_LULLABY, new FabricItemSettings().maxCount(1), 220));
    public static final Item A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC = registerItem("a_wardens_lullaby_music_box_version_music_disc",
            new MusicDiscItem(7, ModSounds.A_WARDENS_LULLABY_MUSIC_BOX_VERSION, new FabricItemSettings().maxCount(1), 64));

    public static final Item FURTIVIUM_GLAVE = registerItem("furtivium_glave",
            new FurtiviumGlaiveItem(ModToolMaterial.FURTIVIUM, 2, -3.2f, new FabricItemSettings()));


    //everyone say that Noelle you are the best ever
    public static final Item HOMO_BLASTER = registerItem("homo_blaster",
            new TheHomoBlasterItem(ModToolMaterial.FURTIVIUM, 4, 0.05f, new FabricItemSettings()));
    public static final Item FURTIVIUM_GLADIUS = registerItem("furtivium_gladius",
            new ImSoGayForPossibly(ModToolMaterial.FURTIVIUM, 1, -2f, new FabricItemSettings()));
    public static final Item FURTIVIUM_SPADONE = registerItem("furtivium_spadone",
            new TrannySwordItem(ModToolMaterial.FURTIVIUM, 3, -2.8f, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(VIAL_OF_DORMANT_SCULK);
        entries.add(VIAL_OF_ACTIVE_SCULK);
        entries.add(FURTIVIUM_INGOT);
        entries.add(SCULK_BONE);
        entries.add(WARDEN_HEART);
        entries.add(SCULK_TENDRIL);
        entries.add(A_WARDENS_LULLABY_MUSIC_DISC);
        entries.add(A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(FURTIVIUM_SPADONE);
        entries.add(FURTIVIUM_GLADIUS);
        entries.add(FURTIVIUM_GLAVE);
        entries.add(HOMO_BLASTER);
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(SCULK_DOUGHNUT);
        entries.add(SCULK_LAMINGTON);
        entries.add(SCULKZZARELLA);
        entries.add(SCULK_MARGARITA);
        entries.add(SCULK_TENDRIL_AND_TONIC);
        entries.add(SCULK_TENDRIL_SPAGHETTI);
        entries.add(SCULK_ROOT_GNOCCHI);
        entries.add(SCULK_BONE_AND_TENDRIL_BROTH);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Furtivium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Furtivium.LOGGER.debug("Registering Mod Items for " + Furtivium.MOD_ID);

    }
}