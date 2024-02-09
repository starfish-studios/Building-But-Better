package com.starfish_studios.foundation;

import com.google.common.reflect.Reflection;
import com.starfish_studios.foundation.event.BlockUseEvent;
import com.starfish_studios.foundation.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;


public class Foundation implements ModInitializer {
	public static final String MOD_ID = "foundation";

	@Override
	public void onInitialize() {
		BlockUseEvent.EVENT.register(new BlockUseEvent());
		Reflection.initialize(
				FoundationCreativeModeTab.class,
				FoundationSoundEvents.class,
				FoundationItems.class,
				FoundationBlocks.class
		);

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
			entries.addAfter(Items.SMOOTH_STONE_SLAB, FoundationItems.POLISHED_STONE);
			entries.addAfter(FoundationItems.POLISHED_STONE, FoundationItems.POLISHED_STONE_STAIRS);
			entries.addAfter(FoundationItems.POLISHED_STONE_STAIRS, FoundationItems.POLISHED_STONE_SLAB);
			entries.addAfter(FoundationItems.POLISHED_STONE_SLAB, FoundationItems.STONE_FENCE);
			entries.addAfter(FoundationItems.STONE_FENCE, FoundationItems.STONE_TILES);
			entries.addAfter(FoundationItems.STONE_TILES, FoundationItems.STONE_TILE_STAIRS);
			entries.addAfter(FoundationItems.STONE_TILE_STAIRS, FoundationItems.STONE_TILE_SLAB);


			entries.addAfter(Items.OAK_SLAB, FoundationItems.OAK_LAYER);
			entries.addAfter(Items.SPRUCE_SLAB, FoundationItems.SPRUCE_LAYER);
			entries.addAfter(Items.BIRCH_SLAB, FoundationItems.BIRCH_LAYER);
			entries.addAfter(Items.JUNGLE_SLAB, FoundationItems.JUNGLE_LAYER);
			entries.addAfter(Items.ACACIA_SLAB, FoundationItems.ACACIA_LAYER);
			entries.addAfter(Items.DARK_OAK_SLAB, FoundationItems.DARK_OAK_LAYER);
			entries.addAfter(Items.CRIMSON_SLAB, FoundationItems.CRIMSON_LAYER);
			entries.addAfter(Items.WARPED_SLAB, FoundationItems.WARPED_LAYER);
			entries.addAfter(Items.MANGROVE_SLAB, FoundationItems.MANGROVE_LAYER);
			entries.addAfter(Items.BAMBOO_SLAB, FoundationItems.BAMBOO_LAYER);
			entries.addAfter(Items.BAMBOO_MOSAIC_SLAB, FoundationItems.BAMBOO_MOSAIC_LAYER);
			entries.addAfter(Items.CHERRY_SLAB, FoundationItems.CHERRY_LAYER);

			entries.addAfter(Items.STONE, FoundationItems.STONE_LAYER);
			entries.addAfter(Items.COBBLESTONE, FoundationItems.COBBLESTONE_LAYER);
			entries.addAfter(Items.MOSSY_COBBLESTONE, FoundationItems.MOSSY_COBBLESTONE_LAYER);
			entries.addAfter(Items.SMOOTH_STONE, FoundationItems.SMOOTH_STONE_LAYER);
			entries.addAfter(Items.STONE_BRICKS, FoundationItems.STONE_BRICK_LAYER);
			entries.addAfter(Items.MOSSY_STONE_BRICKS, FoundationItems.MOSSY_STONE_BRICK_LAYER);

			entries.addAfter(Items.GRANITE_SLAB, FoundationItems.GRANITE_LAYER);
			entries.addAfter(Items.POLISHED_GRANITE_SLAB, FoundationItems.POLISHED_GRANITE_LAYER);
			entries.addAfter(Items.DIORITE_SLAB, FoundationItems.DIORITE_LAYER);
			entries.addAfter(Items.POLISHED_DIORITE_SLAB, FoundationItems.POLISHED_DIORITE_LAYER);
			entries.addAfter(Items.ANDESITE_SLAB, FoundationItems.ANDESITE_LAYER);
			entries.addAfter(Items.POLISHED_ANDESITE_SLAB, FoundationItems.POLISHED_ANDESITE_LAYER);
			entries.addAfter(Items.COBBLED_DEEPSLATE_SLAB, FoundationItems.COBBLED_DEEPSLATE_LAYER);
			entries.addAfter(Items.POLISHED_DEEPSLATE_SLAB, FoundationItems.POLISHED_DEEPSLATE_LAYER);
			entries.addAfter(Items.DEEPSLATE_BRICK_SLAB, FoundationItems.DEEPSLATE_BRICK_LAYER);
			entries.addAfter(Items.DEEPSLATE_TILE_SLAB, FoundationItems.DEEPSLATE_TILE_LAYER);

			entries.addAfter(Items.BRICK_SLAB, FoundationItems.BRICK_LAYER);
			entries.addAfter(Items.MUD_BRICK_SLAB, FoundationItems.MUD_BRICK_LAYER);
			entries.addAfter(Items.SANDSTONE_SLAB, FoundationItems.SANDSTONE_LAYER);
			entries.addAfter(Items.SMOOTH_SANDSTONE_SLAB, FoundationItems.SMOOTH_SANDSTONE_LAYER);
			entries.addAfter(Items.RED_SANDSTONE_SLAB, FoundationItems.RED_SANDSTONE_LAYER);
			entries.addAfter(Items.SMOOTH_RED_SANDSTONE_SLAB, FoundationItems.SMOOTH_RED_SANDSTONE_LAYER);
			entries.addAfter(Items.PRISMARINE_SLAB, FoundationItems.PRISMARINE_LAYER);
			entries.addAfter(Items.PRISMARINE_BRICK_SLAB, FoundationItems.PRISMARINE_BRICK_LAYER);
			entries.addAfter(Items.DARK_PRISMARINE_SLAB, FoundationItems.DARK_PRISMARINE_LAYER);
			entries.addAfter(Items.NETHER_BRICK_SLAB, FoundationItems.NETHER_BRICK_LAYER);
			entries.addAfter(Items.RED_NETHER_BRICK_SLAB, FoundationItems.RED_NETHER_BRICK_LAYER);

			entries.addAfter(Items.BLACKSTONE_SLAB, FoundationItems.BLACKSTONE_LAYER);
			entries.addAfter(Items.POLISHED_BLACKSTONE_SLAB, FoundationItems.POLISHED_BLACKSTONE_LAYER);
			entries.addAfter(Items.POLISHED_BLACKSTONE_BRICK_SLAB, FoundationItems.POLISHED_BLACKSTONE_BRICK_LAYER);
			entries.addAfter(Items.END_STONE_BRICK_SLAB, FoundationItems.END_STONE_BRICK_LAYER);
			entries.addAfter(Items.PURPUR_SLAB, FoundationItems.PURPUR_LAYER);
			entries.addAfter(Items.QUARTZ_SLAB, FoundationItems.QUARTZ_LAYER);

			entries.addAfter(Items.CUT_COPPER_SLAB, FoundationItems.CUT_COPPER_LAYER);
			entries.addAfter(Items.EXPOSED_CUT_COPPER_SLAB, FoundationItems.EXPOSED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WEATHERED_CUT_COPPER_SLAB, FoundationItems.WEATHERED_CUT_COPPER_LAYER);
			entries.addAfter(Items.OXIDIZED_CUT_COPPER_SLAB, FoundationItems.OXIDIZED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_CUT_COPPER_SLAB, FoundationItems.WAXED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_EXPOSED_CUT_COPPER_SLAB, FoundationItems.WAXED_EXPOSED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB, FoundationItems.WAXED_WEATHERED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, FoundationItems.WAXED_OXIDIZED_CUT_COPPER_LAYER);
		});
	}
}