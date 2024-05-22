package com.starfish_studios.bbb;

import com.starfish_studios.bbb.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BBBDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BBBBlockTagProvider::new);
        pack.addProvider(BBBItemTagProvider::new);
        pack.addProvider(BBBModelProvider::new);
        pack.addProvider(BBBLootTableProvider::new);
        pack.addProvider(BBBRecipeProvider::new);
    }
}
