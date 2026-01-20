package furtivium.Sculk.Minecraft.Mod.Item;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item VIAL_OF_DORMANT_SCULK = registerItem("vial_of_dormant_sculk",
    new Item(new FabricItemSettings().maxCount(16).food(ModFoodComponents.VIAL_OF_DORMANT_SCULK)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(VIAL_OF_DORMANT_SCULK);
    }



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Furtivium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Furtivium.LOGGER.debug("Registering Mod Items for " + Furtivium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
