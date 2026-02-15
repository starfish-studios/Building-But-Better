package com.starfish_studios.bbb.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public final class BBBFuels {

    public static final int BURN_TIME = 100;

    public static void registerWoodFuels(BiConsumer<Item, Integer> consumer) {
        accept(consumer, BBBItems.OAK_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.SPRUCE_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.BIRCH_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.JUNGLE_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.ACACIA_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.DARK_OAK_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.CRIMSON_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.WARPED_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.MANGROVE_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.BAMBOO_BEAM_SLAB, BURN_TIME);
        accept(consumer, BBBItems.CHERRY_BEAM_SLAB, BURN_TIME);

        registerWoodItem(consumer, BBBItems.OAK_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.SPRUCE_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.BIRCH_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.JUNGLE_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.ACACIA_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.DARK_OAK_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.CRIMSON_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.WARPED_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.MANGROVE_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.BAMBOO_BALUSTRADE);
        registerWoodItem(consumer, BBBItems.CHERRY_BALUSTRADE);

        registerWoodItem(consumer, BBBItems.OAK_LATTICE);
        registerWoodItem(consumer, BBBItems.SPRUCE_LATTICE);
        registerWoodItem(consumer, BBBItems.BIRCH_LATTICE);
        registerWoodItem(consumer, BBBItems.JUNGLE_LATTICE);
        registerWoodItem(consumer, BBBItems.ACACIA_LATTICE);
        registerWoodItem(consumer, BBBItems.DARK_OAK_LATTICE);
        registerWoodItem(consumer, BBBItems.CRIMSON_LATTICE);
        registerWoodItem(consumer, BBBItems.WARPED_LATTICE);
        registerWoodItem(consumer, BBBItems.MANGROVE_LATTICE);
        registerWoodItem(consumer, BBBItems.BAMBOO_LATTICE);
        registerWoodItem(consumer, BBBItems.CHERRY_LATTICE);

        registerWoodItem(consumer, BBBItems.OAK_WALL);
        registerWoodItem(consumer, BBBItems.SPRUCE_WALL);
        registerWoodItem(consumer, BBBItems.BIRCH_WALL);
        registerWoodItem(consumer, BBBItems.JUNGLE_WALL);
        registerWoodItem(consumer, BBBItems.ACACIA_WALL);
        registerWoodItem(consumer, BBBItems.DARK_OAK_WALL);
        registerWoodItem(consumer, BBBItems.CRIMSON_WALL);
        registerWoodItem(consumer, BBBItems.WARPED_WALL);
        registerWoodItem(consumer, BBBItems.MANGROVE_WALL);
        registerWoodItem(consumer, BBBItems.BAMBOO_WALL);
        registerWoodItem(consumer, BBBItems.CHERRY_WALL);

        registerWoodItem(consumer, BBBItems.OAK_BEAM);
        registerWoodItem(consumer, BBBItems.SPRUCE_BEAM);
        registerWoodItem(consumer, BBBItems.BIRCH_BEAM);
        registerWoodItem(consumer, BBBItems.JUNGLE_BEAM);
        registerWoodItem(consumer, BBBItems.ACACIA_BEAM);
        registerWoodItem(consumer, BBBItems.DARK_OAK_BEAM);
        registerWoodItem(consumer, BBBItems.CRIMSON_BEAM);
        registerWoodItem(consumer, BBBItems.WARPED_BEAM);
        registerWoodItem(consumer, BBBItems.MANGROVE_BEAM);
        registerWoodItem(consumer, BBBItems.BAMBOO_BEAM);
        registerWoodItem(consumer, BBBItems.CHERRY_BEAM);

        registerWoodItem(consumer, BBBItems.OAK_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.SPRUCE_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.BIRCH_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.JUNGLE_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.ACACIA_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.DARK_OAK_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.CRIMSON_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.WARPED_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.MANGROVE_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.BAMBOO_BEAM_STAIRS);
        registerWoodItem(consumer, BBBItems.CHERRY_BEAM_STAIRS);

        registerWoodItem(consumer, BBBItems.OAK_SUPPORT);
        registerWoodItem(consumer, BBBItems.SPRUCE_SUPPORT);
        registerWoodItem(consumer, BBBItems.BIRCH_SUPPORT);
        registerWoodItem(consumer, BBBItems.JUNGLE_SUPPORT);
        registerWoodItem(consumer, BBBItems.ACACIA_SUPPORT);
        registerWoodItem(consumer, BBBItems.DARK_OAK_SUPPORT);
        registerWoodItem(consumer, BBBItems.CRIMSON_SUPPORT);
        registerWoodItem(consumer, BBBItems.WARPED_SUPPORT);
        registerWoodItem(consumer, BBBItems.MANGROVE_SUPPORT);
        registerWoodItem(consumer, BBBItems.BAMBOO_SUPPORT);
        registerWoodItem(consumer, BBBItems.CHERRY_SUPPORT);

        registerWoodItem(consumer, BBBItems.OAK_PALLET);
        registerWoodItem(consumer, BBBItems.SPRUCE_PALLET);
        registerWoodItem(consumer, BBBItems.BIRCH_PALLET);
        registerWoodItem(consumer, BBBItems.JUNGLE_PALLET);
        registerWoodItem(consumer, BBBItems.ACACIA_PALLET);
        registerWoodItem(consumer, BBBItems.DARK_OAK_PALLET);
        registerWoodItem(consumer, BBBItems.CRIMSON_PALLET);
        registerWoodItem(consumer, BBBItems.WARPED_PALLET);
        registerWoodItem(consumer, BBBItems.MANGROVE_PALLET);
        registerWoodItem(consumer, BBBItems.BAMBOO_PALLET);
        registerWoodItem(consumer, BBBItems.CHERRY_PALLET);

        registerWoodItem(consumer, BBBItems.OAK_FRAME);
        registerWoodItem(consumer, BBBItems.SPRUCE_FRAME);
        registerWoodItem(consumer, BBBItems.BIRCH_FRAME);
        registerWoodItem(consumer, BBBItems.JUNGLE_FRAME);
        registerWoodItem(consumer, BBBItems.ACACIA_FRAME);
        registerWoodItem(consumer, BBBItems.DARK_OAK_FRAME);
        registerWoodItem(consumer, BBBItems.CRIMSON_FRAME);
        registerWoodItem(consumer, BBBItems.WARPED_FRAME);
        registerWoodItem(consumer, BBBItems.MANGROVE_FRAME);
        registerWoodItem(consumer, BBBItems.BAMBOO_FRAME);
        registerWoodItem(consumer, BBBItems.CHERRY_FRAME);

        registerWoodItem(consumer, BBBItems.OAK_LANTERN);
        registerWoodItem(consumer, BBBItems.SPRUCE_LANTERN);
        registerWoodItem(consumer, BBBItems.BIRCH_LANTERN);
        registerWoodItem(consumer, BBBItems.JUNGLE_LANTERN);
        registerWoodItem(consumer, BBBItems.ACACIA_LANTERN);
        registerWoodItem(consumer, BBBItems.DARK_OAK_LANTERN);
        registerWoodItem(consumer, BBBItems.CRIMSON_LANTERN);
        registerWoodItem(consumer, BBBItems.WARPED_LANTERN);
        registerWoodItem(consumer, BBBItems.MANGROVE_LANTERN);
        registerWoodItem(consumer, BBBItems.BAMBOO_LANTERN);
        registerWoodItem(consumer, BBBItems.CHERRY_LANTERN);

        registerWoodItem(consumer, BBBItems.OAK_TRIM);
        registerWoodItem(consumer, BBBItems.SPRUCE_TRIM);
        registerWoodItem(consumer, BBBItems.BIRCH_TRIM);
        registerWoodItem(consumer, BBBItems.JUNGLE_TRIM);
        registerWoodItem(consumer, BBBItems.ACACIA_TRIM);
        registerWoodItem(consumer, BBBItems.DARK_OAK_TRIM);
        registerWoodItem(consumer, BBBItems.CRIMSON_TRIM);
        registerWoodItem(consumer, BBBItems.WARPED_TRIM);
        registerWoodItem(consumer, BBBItems.MANGROVE_TRIM);
        registerWoodItem(consumer, BBBItems.BAMBOO_TRIM);
        registerWoodItem(consumer, BBBItems.CHERRY_TRIM);

        registerWoodItem(consumer, BBBItems.OAK_LAYER);
        registerWoodItem(consumer, BBBItems.SPRUCE_LAYER);
        registerWoodItem(consumer, BBBItems.BIRCH_LAYER);
        registerWoodItem(consumer, BBBItems.JUNGLE_LAYER);
        registerWoodItem(consumer, BBBItems.ACACIA_LAYER);
        registerWoodItem(consumer, BBBItems.DARK_OAK_LAYER);
        registerWoodItem(consumer, BBBItems.CRIMSON_LAYER);
        registerWoodItem(consumer, BBBItems.WARPED_LAYER);
        registerWoodItem(consumer, BBBItems.MANGROVE_LAYER);
        registerWoodItem(consumer, BBBItems.BAMBOO_LAYER);
        registerWoodItem(consumer, BBBItems.BAMBOO_MOSAIC_LAYER);
        registerWoodItem(consumer, BBBItems.CHERRY_LAYER);

        registerWoodItem(consumer, BBBItems.OAK_LADDER);
        registerWoodItem(consumer, BBBItems.SPRUCE_LADDER);
        registerWoodItem(consumer, BBBItems.BIRCH_LADDER);
        registerWoodItem(consumer, BBBItems.JUNGLE_LADDER);
        registerWoodItem(consumer, BBBItems.ACACIA_LADDER);
        registerWoodItem(consumer, BBBItems.DARK_OAK_LADDER);
        registerWoodItem(consumer, BBBItems.CRIMSON_LADDER);
        registerWoodItem(consumer, BBBItems.WARPED_LADDER);
        registerWoodItem(consumer, BBBItems.MANGROVE_LADDER);
        registerWoodItem(consumer, BBBItems.BAMBOO_LADDER);
        registerWoodItem(consumer, BBBItems.CHERRY_LADDER);
    }

    private static void accept(BiConsumer<Item, Integer> consumer, RegistrySupplier<Item> item, int burnTime) {
        consumer.accept(item.get(), burnTime);
    }

    private static void registerWoodItem(BiConsumer<Item, Integer> consumer, RegistrySupplier<Item> item) {
        accept(consumer, item, BURN_TIME); // I'm too lazy to figure out burn times for all of them so they all get Stick burn times
    }

    private BBBFuels() {}
}
