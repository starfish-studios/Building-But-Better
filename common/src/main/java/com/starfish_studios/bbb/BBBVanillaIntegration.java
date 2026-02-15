package com.starfish_studios.bbb;

import com.starfish_studios.bbb.client.renderer.blockentity.BlockBlockRenderer;
import com.starfish_studios.bbb.registry.BBBBlockEntityType;
import com.starfish_studios.bbb.registry.BBBBlocks;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;

public class BBBVanillaIntegration {

    public static class Client {

        public static void clientInit() {
            registerBlockRenderLayers();
            registerBlockEntityRenderers();
            registerBlockColors();
        }

        //client methods
        private static void registerBlockEntityRenderers() {
            BlockEntityRendererRegistry.register(BBBBlockEntityType.BLOCK.get(), context -> new BlockBlockRenderer());
        }

        private static void registerBlockColors() {

            ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
                        if (tintIndex != 1) return -1;
                        if (world == null || pos == null) {
                            return FoliageColor.getDefaultColor();
                        }
                        return BiomeColors.getAverageFoliageColor(world, pos);
                    },
                    BBBBlocks.OAK_LATTICE.get(),
                    BBBBlocks.SPRUCE_LATTICE.get(),
                    BBBBlocks.BIRCH_LATTICE.get(),
                    BBBBlocks.JUNGLE_LATTICE.get(),
                    BBBBlocks.ACACIA_LATTICE.get(),
                    BBBBlocks.DARK_OAK_LATTICE.get(),
                    BBBBlocks.CRIMSON_LATTICE.get(),
                    BBBBlocks.WARPED_LATTICE.get(),
                    BBBBlocks.MANGROVE_LATTICE.get(),
                    BBBBlocks.BAMBOO_LATTICE.get(),
                    BBBBlocks.CHERRY_LATTICE.get()

            );
        }

        private static void registerBlockRenderLayers() {

            RenderTypeRegistry.register(RenderType.cutout(),
                    BBBBlocks.OAK_LATTICE.get(),
                    BBBBlocks.SPRUCE_LATTICE.get(),
                    BBBBlocks.BIRCH_LATTICE.get(),
                    BBBBlocks.JUNGLE_LATTICE.get(),
                    BBBBlocks.ACACIA_LATTICE.get(),
                    BBBBlocks.DARK_OAK_LATTICE.get(),
                    BBBBlocks.CRIMSON_LATTICE.get(),
                    BBBBlocks.WARPED_LATTICE.get(),
                    BBBBlocks.MANGROVE_LATTICE.get(),
                    BBBBlocks.BAMBOO_LATTICE.get(),
                    BBBBlocks.CHERRY_LATTICE.get());

            RenderTypeRegistry.register(RenderType.cutout(),
                    BBBBlocks.OAK_LADDER.get(),
                    BBBBlocks.SPRUCE_LADDER.get(),
                    BBBBlocks.BIRCH_LADDER.get(),
                    BBBBlocks.JUNGLE_LADDER.get(),
                    BBBBlocks.ACACIA_LADDER.get(),
                    BBBBlocks.DARK_OAK_LADDER.get(),
                    BBBBlocks.CRIMSON_LADDER.get(),
                    BBBBlocks.WARPED_LADDER.get(),
                    BBBBlocks.MANGROVE_LADDER.get(),
                    BBBBlocks.BAMBOO_LADDER.get(),
                    BBBBlocks.CHERRY_LADDER.get());

            RenderTypeRegistry.register(RenderType.cutout(),
                    BBBBlocks.IRON_FENCE.get(),
                    BBBBlocks.ROPE.get(),
                    BBBBlocks.BRAZIER.get(),
                    BBBBlocks.SOUL_BRAZIER.get(),
                    BBBBlocks.STONE_URN.get(),
                    BBBBlocks.BLACKSTONE_URN.get(),
                    BBBBlocks.DEEPSLATE_URN.get(),
                    BBBBlocks.NETHER_BRICK_URN.get(),
                    BBBBlocks.SANDSTONE_URN.get(),
                    BBBBlocks.RED_SANDSTONE_URN.get(),
                    BBBBlocks.QUARTZ_URN.get()
            );
        }
    }
}
