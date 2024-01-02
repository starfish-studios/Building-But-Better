package com.starfish_studios.foundation;

import com.google.common.reflect.Reflection;
import com.starfish_studios.foundation.registry.*;
import net.fabricmc.api.ModInitializer;


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
	}
}