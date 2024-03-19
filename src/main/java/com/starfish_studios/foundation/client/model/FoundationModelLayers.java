package com.starfish_studios.foundation.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.starfish_studios.foundation.Foundation.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class FoundationModelLayers {

    public static final ModelLayerLocation STONE_BLOCK = main("stone_block", BlockModel::createBlockModel);
    public static final ModelLayerLocation BLACKSTONE_BLOCK = main("blackstone_block", BlockModel::createBlockModel);
    public static final ModelLayerLocation DEEPSLATE_BLOCK = main("deepslate_block", BlockModel::createBlockModel);
    public static final ModelLayerLocation NETHER_BRICK_BLOCK = main("nether_brick_block", BlockModel::createBlockModel);
    public static final ModelLayerLocation SANDSTONE_BLOCK = main("sandstone_block", BlockModel::createBlockModel);
    public static final ModelLayerLocation RED_SANDSTONE_BLOCK = main("red_sandstone_block", BlockModel::createBlockModel);
    public static final ModelLayerLocation QUARTZ_BLOCK = main("quartz_block", BlockModel::createBlockModel);


    private static ModelLayerLocation register(String id, String name, EntityModelLayerRegistry.TexturedModelDataProvider provider) {
        ModelLayerLocation layer = new ModelLayerLocation(new ResourceLocation(MOD_ID, id), name);
        EntityModelLayerRegistry.registerModelLayer(layer, provider);
        return layer;
    }

    private static ModelLayerLocation main(String id, EntityModelLayerRegistry.TexturedModelDataProvider provider) {
        return register(id, "main", provider);
    }
}
