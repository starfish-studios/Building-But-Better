package com.starfish_studios.foundation;

import com.starfish_studios.foundation.registry.FoundationBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class FoundationVanillaIntegration {

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerModelLayers();
            registerScreens();
            registerBlockRenderLayers();
        }

        //client methods
        private static void registerModelLayers() {
        }

        private static void registerScreens() {
        }

        private static void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                    FoundationBlocks.IRON_FENCE,
                    FoundationBlocks.TALL_OAK_DOOR,
                    FoundationBlocks.ROPE,
                    FoundationBlocks.BRAZIER,
                    FoundationBlocks.URN,
                    FoundationBlocks.OAK_HEDGE,
                    FoundationBlocks.SPRUCE_HEDGE,
                    FoundationBlocks.BIRCH_HEDGE,
                    FoundationBlocks.JUNGLE_HEDGE,
                    FoundationBlocks.ACACIA_HEDGE,
                    FoundationBlocks.DARK_OAK_HEDGE,
                    FoundationBlocks.MANGROVE_HEDGE,
                    FoundationBlocks.CHERRY_HEDGE
            );
        }
    }

}
