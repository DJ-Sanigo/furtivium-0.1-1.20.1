package furtivium.datagen.provider;

import furtivium.item.ModItems;
import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FURTIVIUM_BLOCK);
        addDrop(ModBlocks.PURIFIED_FURTIVIUM_BLOCK);
        addDrop(ModBlocks.SCULK_BONE_BLOCK);

        addDrop(ModBlocks.FURTIVIUM_ORE, oreDrops(ModBlocks.FURTIVIUM_ORE, ModItems.RAW_FURTIVIUM));
        addDrop(ModBlocks.DEEPSLATE_FURTIVIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_FURTIVIUM_ORE, ModItems.RAW_FURTIVIUM));

        addDrop(ModBlocks.SCULK_ROOTS);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_ROOTS);
        addDrop(ModBlocks.SCULK_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_MUSHROOM);
        addDrop(ModBlocks.SCULK_EYE_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_EYE_FLOWER);
        addDrop(ModBlocks.SCULK_CARNATION);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_CARNATION);
        addDrop(ModBlocks.SCULK_SPIDER_PLANT);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_SPIDER_PLANT);
        addDrop(ModBlocks.SCULK_FAT_CAP);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_FAT_CAP);
        addDrop(ModBlocks.SCULK_APPLES_EYE_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_SCULK_APPLES_EYE_MUSHROOM);

        addDrop(ModBlocks.SMALL_SCULK_SPORER_CLUSTER);
        addDrop(ModBlocks.MEDIUM_SCULK_SPORER_CLUSTER);
        addDrop(ModBlocks.LARGE_SCULK_SPORER_CLUSTER);

        addDrop(ModBlocks.WARDENS_SNACK_CLUSTER);

        this.addDrop
                (ModBlocks.WARDENS_SNACK_CLUSTER,
                        (block) -> (LootTable.Builder)this.applyExplosionDecay
                                (block, LootTable.builder()
                                        .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder
                                                (ModBlocks.WARDENS_SNACK_CLUSTER).properties
                                                (StatePredicate.Builder.create())).with(ItemEntry.builder
                                                (ModItems.WARDENS_SNACK)).apply(SetCountLootFunction.builder
                                                (UniformLootNumberProvider.create(2.0F, 3.0F))).apply
                                                (ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));


    }


}
