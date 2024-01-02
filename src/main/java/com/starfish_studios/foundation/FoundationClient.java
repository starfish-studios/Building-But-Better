package com.starfish_studios.foundation;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FoundationClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		FoundationVanillaIntegration.Client.clientInit();
	}

}