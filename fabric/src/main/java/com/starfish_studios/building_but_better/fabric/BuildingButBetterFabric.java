package com.starfish_studios.building_but_better.fabric;

import com.starfish_studios.building_but_better.registry.fabric.ModTabsImpl;
import net.fabricmc.api.ModInitializer;

import com.starfish_studios.building_but_better.BuildingButBetter;

public final class BuildingButBetterFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BuildingButBetter.init();
        ModTabsImpl.register();
    }
}
