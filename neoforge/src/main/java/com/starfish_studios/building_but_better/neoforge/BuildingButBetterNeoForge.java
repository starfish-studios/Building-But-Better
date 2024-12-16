package com.starfish_studios.building_but_better.neoforge;

import com.starfish_studios.building_but_better.registry.neoforge.ModRegistryImpl;
import com.starfish_studios.building_but_better.registry.neoforge.ModTabsImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.starfish_studios.building_but_better.BuildingButBetter;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(BuildingButBetter.MOD_ID)
public final class BuildingButBetterNeoForge {
    public BuildingButBetterNeoForge(IEventBus bus) {
        // Run our common setup.
        BuildingButBetter.init();

        ModRegistryImpl.BLOCKS.register(bus);
        ModRegistryImpl.ITEMS.register(bus);
        ModRegistryImpl.SOUND_EVENTS.register(bus);
        ModRegistryImpl.ENTITY_TYPES.register(bus);
        ModRegistryImpl.BLOCK_ENTITY_TYPES.register(bus);
        ModTabsImpl.register(bus);

        bus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //ModBlocks.registerFlammables();
        });
    }
}
