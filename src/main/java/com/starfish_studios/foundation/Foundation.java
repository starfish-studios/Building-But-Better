package com.starfish_studios.foundation;

import com.google.common.reflect.Reflection;
import com.starfish_studios.foundation.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;


public class Foundation implements ModInitializer {
	public static final String MOD_ID = "foundation";

	@Override
	public void onInitialize() {
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
		});
	}
}