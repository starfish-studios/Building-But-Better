package com.starfish_studios.bbb.datagen;

import com.starfish_studios.bbb.registry.BBBBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class BBBLootTableProvider extends FabricBlockLootTableProvider {

    public BBBLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dropSelf(BBBBlocks.OAK_FRAME);
    }
}
