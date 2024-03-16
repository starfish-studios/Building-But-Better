package com.starfish_studios.foundation;

import com.starfish_studios.foundation.client.renderer.blockentity.BlockBlockRenderer;
import com.starfish_studios.foundation.registry.FoundationBlockEntityType;
import com.starfish_studios.foundation.registry.FoundationBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;

public class FoundationVanillaIntegration {

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerModelLayers();
            registerScreens();
            registerBlockRenderLayers();
            registerBlockEntityRenderers();
        }

        //client methods
        private static void registerModelLayers() {
        }

        private static void registerScreens() {
        }

        private static void registerBlockEntityRenderers() {
            BlockEntityRendererRegistry.register(FoundationBlockEntityType.BLOCK,
                    context -> new BlockBlockRenderer());
        }

        private static void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                    FoundationBlocks.IRON_FENCE,
                    // FoundationBlocks.ROPE,
                    FoundationBlocks.BRAZIER,
                    FoundationBlocks.SOUL_BRAZIER,
                    FoundationBlocks.STONE_URN,
                    FoundationBlocks.BLACKSTONE_URN,
                    FoundationBlocks.DEEPSLATE_URN,
                    FoundationBlocks.NETHER_BRICK_URN,
                    FoundationBlocks.SANDSTONE_URN,
                    FoundationBlocks.RED_SANDSTONE_URN,
                    FoundationBlocks.QUARTZ_URN,
                    FoundationBlocks.OAK_LADDER,
                    FoundationBlocks.SPRUCE_LADDER,
                    FoundationBlocks.BIRCH_LADDER,
                    FoundationBlocks.JUNGLE_LADDER,
                    FoundationBlocks.ACACIA_LADDER,
                    FoundationBlocks.DARK_OAK_LADDER,
                    FoundationBlocks.CRIMSON_LADDER,
                    FoundationBlocks.WARPED_LADDER,
                    FoundationBlocks.MANGROVE_LADDER,
                    FoundationBlocks.BAMBOO_LADDER,
                    FoundationBlocks.CHERRY_LADDER
                    // FoundationBlocks.OAK_WALL
            );
        }
    }

}
