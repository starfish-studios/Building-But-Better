package com.starfish_studios.building_but_better;

import com.starfish_studios.building_but_better.registry.*;
import net.minecraft.resources.ResourceLocation;

public final class BuildingButBetter {
    public static final String MOD_ID = "bbb";

    public static void init() {
        ModBlocks.init();
        ModItems.init();
        ModSoundEvents.init();
        //ModEntityTypes.init();
        ModBlockEntityTypes.init();

        ModItemTags.init();
        ModBlockTags.init();
        ModDataComponents.init();
    }

    public static ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
