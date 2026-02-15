package com.starfish_studios.bbb.fabric;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.registry.BBBFuels;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public final class BuildingButBetterFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        BuildingButBetter.init();
        BBBFuels.registerWoodFuels((item, burnTime) -> FuelRegistry.INSTANCE.add(item, burnTime));
    }
}
