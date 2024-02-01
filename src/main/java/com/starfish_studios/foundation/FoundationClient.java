package com.starfish_studios.foundation;

import com.starfish_studios.foundation.registry.FoundationBlocks;
import com.starfish_studios.foundation.registry.FoundationItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.ItemLike;

import java.awt.*;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public class FoundationClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		FoundationVanillaIntegration.Client.clientInit();

		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				BiomeColors.getAverageFoliageColor(pos, world) : -1, Objects.requireNonNull(
				FoundationBlocks.OAK_HEDGE
		));
		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				6396257 : -1, Objects.requireNonNull(
				FoundationBlocks.SPRUCE_HEDGE
		));
		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				8431445 : -1, Objects.requireNonNull(
				FoundationBlocks.BIRCH_HEDGE
		));
		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				BiomeColors.getAverageFoliageColor(pos, world) : -1, Objects.requireNonNull(
				FoundationBlocks.JUNGLE_HEDGE
		));
		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				BiomeColors.getAverageFoliageColor(pos, world) : -1, Objects.requireNonNull(
				FoundationBlocks.ACACIA_HEDGE
		));
		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				BiomeColors.getAverageFoliageColor(pos, world) : -1, Objects.requireNonNull(
				FoundationBlocks.DARK_OAK_HEDGE
		));
		ColorProviderRegistry.BLOCK.register((block, pos, world, layer) -> world != null && pos != null ?
				BiomeColors.getAverageFoliageColor(pos, world) : -1, Objects.requireNonNull(
				FoundationBlocks.MANGROVE_HEDGE
		));

		ColorProviderRegistry.ITEM.register((stack, layer) -> {
			ItemLike item = stack.getItem();
			if (item == FoundationItems.OAK_HEDGE.asItem()) {
				return 4764952;
			}
			return -1;
		}, FoundationItems.OAK_HEDGE, FoundationItems.JUNGLE_HEDGE, FoundationItems.ACACIA_HEDGE, FoundationItems.DARK_OAK_HEDGE);
		ColorProviderRegistry.ITEM.register((stack, layer) -> {
			ItemLike item = stack.getItem();
			if (item == FoundationItems.SPRUCE_HEDGE.asItem()) {
				return 6396257;
			}
			return -1;
		}, FoundationItems.SPRUCE_HEDGE);
		ColorProviderRegistry.ITEM.register((stack, layer) -> {
			ItemLike item = stack.getItem();
			if (item == FoundationItems.BIRCH_HEDGE.asItem()) {
				return 8431445;
			}
			return -1;
		}, FoundationItems.BIRCH_HEDGE);
		ColorProviderRegistry.ITEM.register((stack, layer) -> {
			ItemLike item = stack.getItem();
			if (item == FoundationItems.MANGROVE_HEDGE.asItem()) {
				return 9619016;
			}
			return -1;
		}, FoundationItems.MANGROVE_HEDGE);



	}

}