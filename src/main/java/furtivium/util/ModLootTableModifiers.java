package furtivium.util;

import furtivium.block.ModBlocks;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import furtivium.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier WARDEN_ID = new Identifier("minecraft", "entities/warden");
    private static final Identifier SHRIEKER_ID = new Identifier("minecraft", "blocks/sculk_shrieker");
    private static final Identifier CATALYST_ID = new Identifier("minecraft", "blocks/sculk_catalyst");
    private static final Identifier SENSOR_ID = new Identifier("minecraft", "blocks/sculk_sensor");
    private static final Identifier CALIBRATED_ID = new Identifier("minecraft", "blocks/calibrated_sculk_sensor");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, builder, lootTableSource) ->  {
            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FURTIVIUM_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.SCULK_BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 15.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.SCULK_TENDRIL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.VIAL_OF_DORMANT_SCULK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.VIAL_OF_ACTIVE_SCULK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.075f))
                        .with(ItemEntry.builder(ModItems.A_WARDENS_LULLABY_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.015f))
                        .with(ItemEntry.builder(ModItems.A_WARDENS_LULLABY_MUSIC_BOX_VERSION_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.RAW_FURTIVIUM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 7.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(ModItems.INCOMPLETE_FURTIVIUM_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.20f))
                        .with(ItemEntry.builder(ModItems.VIAL_OF_LIQUID_FURTIVIUM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.WARDEN_HEART))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_BONE_BLOCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.SCULK_DOUGHNUT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.SCULK_LAMINGTON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.WARDENS_SNACK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.SCULKZZARELLA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.SCULK_MARGARITA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.SCULK_TENDRIL_AND_TONIC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.SCULK_BONE_AND_TENDRIL_BROTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.SCULK_TENDRIL_SPAGHETTI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.SCULK_ROOT_GNOCCHI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.IMMOVABLE_OBJECT_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.MAGICAL_DOCTOR_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.MAGICAL_DOCTOR_SNACK_REMIX_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.THE_ALARM_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_ROOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_MUSHROOM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_EYE_FLOWER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_CARNATION))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_SPIDER_PLANT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_FAT_CAP))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_APPLES_EYE_MUSHROOM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.SMALL_SCULK_SPORE_SHROOM_CLUSTER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.MEDIUM_SCULK_SPORE_SHROOM_CLUSTER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(ANCIENT_CITY_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModBlocks.LARGE_SCULK_SPORE_SHROOM_CLUSTER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(WARDEN_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.SCULK_BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0f, 15.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(WARDEN_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModBlocks.SCULK_BONE_BLOCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(WARDEN_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.WARDEN_HEART))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(WARDEN_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.SCULK_TENDRIL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(SHRIEKER_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS)).build())
                        .with(ItemEntry.builder(ModItems.SCULK_BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(CATALYST_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS)).build())
                        .with(ItemEntry.builder(ModItems.SCULK_BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(CATALYST_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS)).build())
                        .with(ItemEntry.builder(ModBlocks.SCULK_BONE_BLOCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(SENSOR_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS)).build())
                        .with(ItemEntry.builder(ModItems.SCULK_TENDRIL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(CALIBRATED_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS)).build())
                        .with(ItemEntry.builder(ModItems.SCULK_TENDRIL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build());

                builder.pool(poolBuilder.build());

            }

            if(CALIBRATED_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS)).build())
                        .with(ItemEntry.builder(Items.AMETHYST_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                builder.pool(poolBuilder.build());

            }

        });

    }
}
