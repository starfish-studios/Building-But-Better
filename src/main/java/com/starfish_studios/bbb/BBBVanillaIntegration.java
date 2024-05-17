package com.starfish_studios.bbb;

import com.google.common.reflect.Reflection;
import com.starfish_studios.bbb.client.model.BBBModelLayers;
import com.starfish_studios.bbb.client.renderer.blockentity.BlockBlockRenderer;
import com.starfish_studios.bbb.registry.BBBBlockEntityType;
import com.starfish_studios.bbb.registry.BBBBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public class BBBVanillaIntegration {

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerBlockRenderLayers();
            registerBlockEntityRenderers();
        }

        //client methods
        private static void registerBlockEntityRenderers() {
            Reflection.initialize(BBBModelLayers.class);
            BlockEntityRendererRegistry.register(BBBBlockEntityType.BLOCK, context -> new BlockBlockRenderer());
        }

        private static void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                    BBBBlocks.IRON_FENCE,
                    BBBBlocks.ROPE,
                    BBBBlocks.BRAZIER,
                    BBBBlocks.SOUL_BRAZIER,
                    BBBBlocks.STONE_URN,
                    BBBBlocks.BLACKSTONE_URN,
                    BBBBlocks.DEEPSLATE_URN,
                    BBBBlocks.NETHER_BRICK_URN,
                    BBBBlocks.SANDSTONE_URN,
                    BBBBlocks.RED_SANDSTONE_URN,
                    BBBBlocks.QUARTZ_URN,
                    BBBBlocks.OAK_LADDER,
                    BBBBlocks.SPRUCE_LADDER,
                    BBBBlocks.BIRCH_LADDER,
                    BBBBlocks.JUNGLE_LADDER,
                    BBBBlocks.ACACIA_LADDER,
                    BBBBlocks.DARK_OAK_LADDER,
                    BBBBlocks.CRIMSON_LADDER,
                    BBBBlocks.WARPED_LADDER,
                    BBBBlocks.MANGROVE_LADDER,
                    BBBBlocks.BAMBOO_LADDER,
                    BBBBlocks.CHERRY_LADDER
            );
        }
    }

}
