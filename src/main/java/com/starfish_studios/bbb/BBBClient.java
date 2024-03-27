package com.starfish_studios.bbb;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BBBClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BBBVanillaIntegration.Client.clientInit();
	}

}