package com.starfish_studios.foundation;

import com.google.common.reflect.Reflection;
import com.starfish_studios.foundation.event.BlockUseEvent;
import com.starfish_studios.foundation.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.Util;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.List;

import static com.starfish_studios.foundation.registry.FoundationItems.*;


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

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
			entries.addAfter(Items.SOUL_CAMPFIRE, BRAZIER);
			entries.addAfter(BRAZIER, SOUL_BRAZIER);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
			entries.addAfter(Items.SMOOTH_STONE_SLAB, POLISHED_STONE);
			entries.addAfter(POLISHED_STONE, POLISHED_STONE_STAIRS);
			entries.addAfter(POLISHED_STONE_STAIRS, POLISHED_STONE_SLAB);
			entries.addAfter(POLISHED_STONE_SLAB, STONE_TILES);
			entries.addAfter(STONE_TILES, STONE_TILE_STAIRS);
			entries.addAfter(STONE_TILE_STAIRS, STONE_TILE_SLAB);

			entries.addAfter(Items.CHISELED_STONE_BRICKS, STONE_COLUMN);
			entries.addAfter(STONE_COLUMN, STONE_URN);
			entries.addAfter(STONE_URN, STONE_FENCE);
			entries.addAfter(STONE_FENCE, STONE_MOULDING);
			entries.addAfter(STONE_MOULDING, STONE_BLOCK);

			entries.addAfter(Items.CHISELED_POLISHED_BLACKSTONE, BLACKSTONE_COLUMN);
			entries.addAfter(BLACKSTONE_COLUMN, BLACKSTONE_URN);
			entries.addAfter(BLACKSTONE_URN, BLACKSTONE_FENCE);
			entries.addAfter(BLACKSTONE_FENCE, BLACKSTONE_MOULDING);
			entries.addAfter(BLACKSTONE_MOULDING, BLACKSTONE_BLOCK);

			entries.addAfter(Items.CHISELED_DEEPSLATE, DEEPSLATE_COLUMN);
			entries.addAfter(DEEPSLATE_COLUMN, DEEPSLATE_URN);
			entries.addAfter(DEEPSLATE_URN, DEEPSLATE_FENCE);
			entries.addAfter(DEEPSLATE_FENCE, DEEPSLATE_MOULDING);
			entries.addAfter(DEEPSLATE_MOULDING, DEEPSLATE_BLOCK);

			entries.addAfter(Items.CHISELED_NETHER_BRICKS, NETHER_BRICK_COLUMN);
			entries.addAfter(NETHER_BRICK_COLUMN, NETHER_BRICK_URN);
			entries.addAfter(NETHER_BRICK_URN, NETHER_BRICK_FENCE);
			entries.addAfter(NETHER_BRICK_FENCE, NETHER_BRICK_MOULDING);
			entries.addAfter(NETHER_BRICK_MOULDING, NETHER_BRICK_BLOCK);

			entries.addAfter(Items.CHISELED_SANDSTONE, SANDSTONE_COLUMN);
			entries.addAfter(SANDSTONE_COLUMN, SANDSTONE_URN);
			entries.addAfter(SANDSTONE_URN, SANDSTONE_FENCE);
			entries.addAfter(SANDSTONE_FENCE, SANDSTONE_MOULDING);
			entries.addAfter(SANDSTONE_MOULDING, SANDSTONE_BLOCK);

			entries.addAfter(Items.CHISELED_RED_SANDSTONE, RED_SANDSTONE_COLUMN);
			entries.addAfter(RED_SANDSTONE_COLUMN, RED_SANDSTONE_URN);
			entries.addAfter(RED_SANDSTONE_URN, RED_SANDSTONE_FENCE);
			entries.addAfter(RED_SANDSTONE_FENCE, RED_SANDSTONE_MOULDING);
			entries.addAfter(RED_SANDSTONE_MOULDING, RED_SANDSTONE_BLOCK);

			entries.addAfter(Items.CHISELED_QUARTZ_BLOCK, QUARTZ_COLUMN);
			entries.addAfter(QUARTZ_COLUMN, QUARTZ_URN);
			entries.addAfter(QUARTZ_URN, QUARTZ_FENCE);
			entries.addAfter(QUARTZ_FENCE, QUARTZ_MOULDING);
			entries.addAfter(QUARTZ_MOULDING, QUARTZ_BLOCK);

			//region WOODEN INJECTIONS
			entries.addAfter(Items.OAK_SLAB, OAK_LAYER);
			entries.addAfter(OAK_LAYER, OAK_TRIM);
			entries.addAfter(OAK_TRIM, OAK_BEAM);
			entries.addAfter(OAK_BEAM, OAK_BEAM_STAIRS);
			entries.addAfter(OAK_BEAM_STAIRS, OAK_BEAM_SLAB);
			entries.addAfter(Items.OAK_BUTTON, OAK_SUPPORT);
			entries.addAfter(OAK_SUPPORT, OAK_FRAME);
			entries.addAfter(OAK_FRAME, OAK_PALLET);
			entries.addAfter(OAK_PALLET, OAK_LANTERN);
			entries.addAfter(OAK_LANTERN, OAK_LADDER);

			entries.addAfter(Items.SPRUCE_SLAB, SPRUCE_LAYER);
			entries.addAfter(SPRUCE_LAYER, SPRUCE_TRIM);
			entries.addAfter(SPRUCE_TRIM, SPRUCE_BEAM);
			entries.addAfter(SPRUCE_BEAM, SPRUCE_BEAM_STAIRS);
			entries.addAfter(SPRUCE_BEAM_STAIRS, SPRUCE_BEAM_SLAB);
			entries.addAfter(Items.SPRUCE_BUTTON, SPRUCE_SUPPORT);
			entries.addAfter(SPRUCE_SUPPORT, SPRUCE_FRAME);
			entries.addAfter(SPRUCE_FRAME, SPRUCE_PALLET);
			entries.addAfter(SPRUCE_PALLET, SPRUCE_LANTERN);
			entries.addAfter(SPRUCE_LANTERN, SPRUCE_LADDER);

			entries.addAfter(Items.BIRCH_SLAB, BIRCH_LAYER);
			entries.addAfter(BIRCH_LAYER, BIRCH_TRIM);
			entries.addAfter(BIRCH_TRIM, BIRCH_BEAM);
			entries.addAfter(BIRCH_BEAM, BIRCH_BEAM_STAIRS);
			entries.addAfter(BIRCH_BEAM_STAIRS, BIRCH_BEAM_SLAB);
			entries.addAfter(Items.BIRCH_BUTTON, BIRCH_SUPPORT);
			entries.addAfter(BIRCH_SUPPORT, BIRCH_FRAME);
			entries.addAfter(BIRCH_FRAME, BIRCH_PALLET);
			entries.addAfter(BIRCH_PALLET, BIRCH_LANTERN);
			entries.addAfter(BIRCH_LANTERN, BIRCH_LADDER);

			entries.addAfter(Items.JUNGLE_SLAB, JUNGLE_LAYER);
			entries.addAfter(JUNGLE_LAYER, JUNGLE_TRIM);
			entries.addAfter(JUNGLE_TRIM, JUNGLE_BEAM);
			entries.addAfter(JUNGLE_BEAM, JUNGLE_BEAM_STAIRS);
			entries.addAfter(JUNGLE_BEAM_STAIRS, JUNGLE_BEAM_SLAB);
			entries.addAfter(Items.JUNGLE_BUTTON, JUNGLE_SUPPORT);
			entries.addAfter(JUNGLE_SUPPORT, JUNGLE_FRAME);
			entries.addAfter(JUNGLE_FRAME, JUNGLE_PALLET);
			entries.addAfter(JUNGLE_PALLET, JUNGLE_LANTERN);
			entries.addAfter(JUNGLE_LANTERN, JUNGLE_LADDER);

			entries.addAfter(Items.ACACIA_SLAB, ACACIA_LAYER);
			entries.addAfter(ACACIA_LAYER, ACACIA_TRIM);
			entries.addAfter(ACACIA_TRIM, ACACIA_BEAM);
			entries.addAfter(ACACIA_BEAM, ACACIA_BEAM_STAIRS);
			entries.addAfter(ACACIA_BEAM_STAIRS, ACACIA_BEAM_SLAB);
			entries.addAfter(Items.ACACIA_BUTTON, ACACIA_SUPPORT);
			entries.addAfter(ACACIA_SUPPORT, ACACIA_FRAME);
			entries.addAfter(ACACIA_FRAME, ACACIA_PALLET);
			entries.addAfter(ACACIA_PALLET, ACACIA_LANTERN);
			entries.addAfter(ACACIA_LANTERN, ACACIA_LADDER);

			entries.addAfter(Items.DARK_OAK_SLAB, DARK_OAK_LAYER);
			entries.addAfter(DARK_OAK_LAYER, DARK_OAK_TRIM);
			entries.addAfter(DARK_OAK_TRIM, DARK_OAK_BEAM);
			entries.addAfter(DARK_OAK_BEAM, DARK_OAK_BEAM_STAIRS);
			entries.addAfter(DARK_OAK_BEAM_STAIRS, DARK_OAK_BEAM_SLAB);
			entries.addAfter(Items.DARK_OAK_BUTTON, DARK_OAK_SUPPORT);
			entries.addAfter(DARK_OAK_SUPPORT, DARK_OAK_FRAME);
			entries.addAfter(DARK_OAK_FRAME, DARK_OAK_PALLET);
			entries.addAfter(DARK_OAK_PALLET, DARK_OAK_LANTERN);
			entries.addAfter(DARK_OAK_LANTERN, DARK_OAK_LADDER);

			entries.addAfter(Items.CRIMSON_SLAB, CRIMSON_LAYER);
			entries.addAfter(CRIMSON_LAYER, CRIMSON_TRIM);
			entries.addAfter(CRIMSON_TRIM, CRIMSON_BEAM);
			entries.addAfter(CRIMSON_BEAM, CRIMSON_BEAM_STAIRS);
			entries.addAfter(CRIMSON_BEAM_STAIRS, CRIMSON_BEAM_SLAB);
			entries.addAfter(Items.CRIMSON_BUTTON, CRIMSON_SUPPORT);
			entries.addAfter(CRIMSON_SUPPORT, CRIMSON_FRAME);
			entries.addAfter(CRIMSON_FRAME, CRIMSON_PALLET);
			entries.addAfter(CRIMSON_PALLET, CRIMSON_LANTERN);
			entries.addAfter(CRIMSON_LANTERN, CRIMSON_LADDER);

			entries.addAfter(Items.WARPED_SLAB, WARPED_LAYER);
			entries.addAfter(WARPED_LAYER, WARPED_TRIM);
			entries.addAfter(WARPED_TRIM, WARPED_BEAM);
			entries.addAfter(WARPED_BEAM, WARPED_BEAM_STAIRS);
			entries.addAfter(WARPED_BEAM_STAIRS, WARPED_BEAM_SLAB);
			entries.addAfter(Items.WARPED_BUTTON, WARPED_SUPPORT);
			entries.addAfter(WARPED_SUPPORT, WARPED_FRAME);
			entries.addAfter(WARPED_FRAME, WARPED_PALLET);
			entries.addAfter(WARPED_PALLET, WARPED_LANTERN);
			entries.addAfter(WARPED_LANTERN, WARPED_LADDER);

			entries.addAfter(Items.MANGROVE_SLAB, MANGROVE_LAYER);
			entries.addAfter(MANGROVE_LAYER, MANGROVE_TRIM);
			entries.addAfter(MANGROVE_TRIM, MANGROVE_BEAM);
			entries.addAfter(MANGROVE_BEAM, MANGROVE_BEAM_STAIRS);
			entries.addAfter(MANGROVE_BEAM_STAIRS, MANGROVE_BEAM_SLAB);
			entries.addAfter(Items.MANGROVE_BUTTON, MANGROVE_SUPPORT);
			entries.addAfter(MANGROVE_SUPPORT, MANGROVE_FRAME);
			entries.addAfter(MANGROVE_FRAME, MANGROVE_PALLET);
			entries.addAfter(MANGROVE_PALLET, MANGROVE_LANTERN);
			entries.addAfter(MANGROVE_LANTERN, MANGROVE_LADDER);

			entries.addAfter(Items.BAMBOO_SLAB, BAMBOO_LAYER);
			entries.addAfter(BAMBOO_LAYER, BAMBOO_TRIM);
			entries.addAfter(BAMBOO_TRIM, BAMBOO_BEAM);
			entries.addAfter(BAMBOO_BEAM, BAMBOO_BEAM_STAIRS);
			entries.addAfter(BAMBOO_BEAM_STAIRS, BAMBOO_BEAM_SLAB);
			entries.addAfter(Items.BAMBOO_BUTTON, BAMBOO_SUPPORT);
			entries.addAfter(BAMBOO_SUPPORT, BAMBOO_FRAME);
			entries.addAfter(BAMBOO_FRAME, BAMBOO_PALLET);
			entries.addAfter(BAMBOO_PALLET, BAMBOO_LANTERN);
			entries.addAfter(BAMBOO_LANTERN, BAMBOO_LADDER);

			entries.addAfter(Items.CHERRY_SLAB, CHERRY_LAYER);
			entries.addAfter(CHERRY_LAYER, CHERRY_TRIM);
			entries.addAfter(CHERRY_TRIM, CHERRY_BEAM);
			entries.addAfter(CHERRY_BEAM, CHERRY_BEAM_STAIRS);
			entries.addAfter(CHERRY_BEAM_STAIRS, CHERRY_BEAM_SLAB);
			entries.addAfter(Items.CHERRY_BUTTON, CHERRY_SUPPORT);
			entries.addAfter(CHERRY_SUPPORT, CHERRY_FRAME);
			entries.addAfter(CHERRY_FRAME, CHERRY_PALLET);
			entries.addAfter(CHERRY_PALLET, CHERRY_LANTERN);
			entries.addAfter(CHERRY_LANTERN, CHERRY_LADDER);

			//endregion

			//region LAYER INJECTIONS

			entries.addAfter(Items.STONE_SLAB, STONE_LAYER);
			entries.addAfter(Items.COBBLESTONE_SLAB, COBBLESTONE_LAYER);
			entries.addAfter(Items.MOSSY_COBBLESTONE_SLAB, MOSSY_COBBLESTONE_LAYER);
			entries.addAfter(Items.SMOOTH_STONE_SLAB, SMOOTH_STONE_LAYER);
			entries.addAfter(Items.STONE_BRICK_SLAB, STONE_BRICK_LAYER);
			entries.addAfter(Items.MOSSY_STONE_BRICK_SLAB, MOSSY_STONE_BRICK_LAYER);

			entries.addAfter(Items.GRANITE_SLAB, GRANITE_LAYER);
			entries.addAfter(Items.POLISHED_GRANITE_SLAB, POLISHED_GRANITE_LAYER);
			entries.addAfter(Items.DIORITE_SLAB, DIORITE_LAYER);
			entries.addAfter(Items.POLISHED_DIORITE_SLAB, POLISHED_DIORITE_LAYER);
			entries.addAfter(Items.ANDESITE_SLAB, ANDESITE_LAYER);
			entries.addAfter(Items.POLISHED_ANDESITE_SLAB, POLISHED_ANDESITE_LAYER);
			entries.addAfter(Items.COBBLED_DEEPSLATE_SLAB, COBBLED_DEEPSLATE_LAYER);
			entries.addAfter(Items.POLISHED_DEEPSLATE_SLAB, POLISHED_DEEPSLATE_LAYER);
			entries.addAfter(Items.DEEPSLATE_BRICK_SLAB, DEEPSLATE_BRICK_LAYER);
			entries.addAfter(Items.DEEPSLATE_TILE_SLAB, DEEPSLATE_TILE_LAYER);

			entries.addAfter(Items.BRICK_SLAB, BRICK_LAYER);
			entries.addAfter(Items.MUD_BRICK_SLAB, MUD_BRICK_LAYER);
			entries.addAfter(Items.SANDSTONE_SLAB, SANDSTONE_LAYER);
			entries.addAfter(Items.SMOOTH_SANDSTONE_SLAB, SMOOTH_SANDSTONE_LAYER);
			entries.addAfter(Items.RED_SANDSTONE_SLAB, RED_SANDSTONE_LAYER);
			entries.addAfter(Items.SMOOTH_RED_SANDSTONE_SLAB, SMOOTH_RED_SANDSTONE_LAYER);
			entries.addAfter(Items.PRISMARINE_SLAB, PRISMARINE_LAYER);
			entries.addAfter(Items.PRISMARINE_BRICK_SLAB, PRISMARINE_BRICK_LAYER);
			entries.addAfter(Items.DARK_PRISMARINE_SLAB, DARK_PRISMARINE_LAYER);
			entries.addAfter(Items.NETHER_BRICK_SLAB, NETHER_BRICK_LAYER);
			entries.addAfter(Items.RED_NETHER_BRICK_SLAB, RED_NETHER_BRICK_LAYER);

			entries.addAfter(Items.BLACKSTONE_SLAB, BLACKSTONE_LAYER);
			entries.addAfter(Items.POLISHED_BLACKSTONE_SLAB, POLISHED_BLACKSTONE_LAYER);
			entries.addAfter(Items.POLISHED_BLACKSTONE_BRICK_SLAB, POLISHED_BLACKSTONE_BRICK_LAYER);
			entries.addAfter(Items.END_STONE_BRICK_SLAB, END_STONE_BRICK_LAYER);
			entries.addAfter(Items.PURPUR_SLAB, PURPUR_LAYER);
			entries.addAfter(Items.QUARTZ_SLAB, QUARTZ_LAYER);

			entries.addAfter(Items.CUT_COPPER_SLAB, CUT_COPPER_LAYER);
			entries.addAfter(Items.EXPOSED_CUT_COPPER_SLAB, EXPOSED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WEATHERED_CUT_COPPER_SLAB, WEATHERED_CUT_COPPER_LAYER);
			entries.addAfter(Items.OXIDIZED_CUT_COPPER_SLAB, OXIDIZED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_CUT_COPPER_SLAB, WAXED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_EXPOSED_CUT_COPPER_SLAB, WAXED_EXPOSED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB, WAXED_WEATHERED_CUT_COPPER_LAYER);
			entries.addAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, WAXED_OXIDIZED_CUT_COPPER_LAYER);

			//endregion
		});

		Util.make(new LinkedHashMap<Block, Block>(), pairs -> {
			pairs.put(FoundationBlocks.CUT_COPPER_LAYER, FoundationBlocks.WAXED_CUT_COPPER_LAYER);
			pairs.put(FoundationBlocks.EXPOSED_CUT_COPPER_LAYER, FoundationBlocks.WAXED_EXPOSED_CUT_COPPER_LAYER);
			pairs.put(FoundationBlocks.WEATHERED_CUT_COPPER_LAYER, FoundationBlocks.WAXED_WEATHERED_CUT_COPPER_LAYER);
			pairs.put(FoundationBlocks.OXIDIZED_CUT_COPPER_LAYER, FoundationBlocks.WAXED_OXIDIZED_CUT_COPPER_LAYER);

			pairs.forEach(OxidizableBlocksRegistry::registerWaxableBlockPair);

			List<Block> unwaxed = List.copyOf(pairs.keySet());
			for (int i = 0, l = unwaxed.size(); i < l - 1; i++) {
				OxidizableBlocksRegistry.registerOxidizableBlockPair(unwaxed.get(i), unwaxed.get(i + 1));
			}
		});
	}
}