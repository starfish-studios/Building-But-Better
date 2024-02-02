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
	}

}