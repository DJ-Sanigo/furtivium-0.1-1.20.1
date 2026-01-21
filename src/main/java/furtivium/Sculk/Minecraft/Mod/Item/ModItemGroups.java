package furtivium.Sculk.Minecraft.Mod.Item;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import furtivium.Sculk.Minecraft.Mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FURTIVIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Furtivium.MOD_ID, "furtivium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.furtivium"))
                    .icon(() -> new ItemStack(ModItems.FURTIVIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FURTIVIUM_INGOT);
                        entries.add(ModItems.VIAL_OF_DORMANT_SCULK);
                        entries.add(ModBlocks.FURTIVIUM_BLOCK);

                        entries.add(Items.SCULK);
                        entries.add(Items.SCULK_VEIN);
                        entries.add(Items.SCULK_CATALYST);
                        entries.add(Items.SCULK_SENSOR);
                        entries.add(Items.CALIBRATED_SCULK_SENSOR);
                        entries.add(Items.SCULK_SHRIEKER);

                    }).build());


    public static void registerItemGroups() {
        Furtivium.LOGGER.info("Registering Item Groups for " + Furtivium.MOD_ID);
    }
}
