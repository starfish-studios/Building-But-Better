package com.starfish_studios.bbb;

import com.starfish_studios.bbb.event.MiscEvents;
import com.starfish_studios.bbb.registry.BBBBlockEntityType;
import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBCreativeModeTab;
import com.starfish_studios.bbb.registry.BBBItems;
import com.starfish_studios.bbb.registry.BBBSoundEvents;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BuildingButBetter.MOD_ID)
public class BuildingButBetter {
	//TODO: FIX COPPER WAXING

	public static final String MOD_ID = "bbb";

	public BuildingButBetter() {
		MidnightConfig.init(BuildingButBetter.MOD_ID, BBBConfig.class);

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus eventBus = MinecraftForge.EVENT_BUS;

		modEventBus.addListener(this::setup);

		BBBBlocks.BLOCKS.register(modEventBus);
		BBBBlockEntityType.BLOCK_ENTITIES.register(modEventBus);
		BBBItems.ITEMS.register(modEventBus);
		BBBCreativeModeTab.CREATIVE_MODE_TABS.register(modEventBus);
		BBBSoundEvents.SOUND_EVENTS.register(modEventBus);

		eventBus.register(this);
		eventBus.register(new MiscEvents());
	}

	public void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(BBBVanillaIntegration::init);
	}

}