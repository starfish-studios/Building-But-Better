package com.starfish_studios.bbb.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

public class BBBModelLayers {

    public static final ModelLayerLocation STONE_BLOCK = register("stone_block");
    public static final ModelLayerLocation BLACKSTONE_BLOCK = register("blackstone_block");
    public static final ModelLayerLocation DEEPSLATE_BLOCK = register("deepslate_block");
    public static final ModelLayerLocation NETHER_BRICK_BLOCK = register("nether_brick_block");
    public static final ModelLayerLocation SANDSTONE_BLOCK = register("sandstone_block");
    public static final ModelLayerLocation RED_SANDSTONE_BLOCK = register("red_sandstone_block");
    public static final ModelLayerLocation QUARTZ_BLOCK = register("quartz_block");

    private static ModelLayerLocation register(String id) {
        return new ModelLayerLocation(new ResourceLocation(MOD_ID, id), "main");
    }
}
