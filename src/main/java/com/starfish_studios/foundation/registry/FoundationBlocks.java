package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class FoundationBlocks {

    // public static final Block SHORT_GRASS = register("short_grass", new ShortGrassBlock(FabricBlockSettings.copy(Blocks.TALL_GRASS)));

    public static final Block COBBLESTONE_LAYER = register("cobblestone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.COBBLESTONE))));
    public static final Block IRON_FENCE = register("iron_fence", new IronFenceBlock(FabricBlockSettings.copy((Blocks.IRON_BARS))));

    public static final Block OAK_SUPPORT = register("oak_support", new SupportBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));


    public static final Block OAK_BEAM = register("oak_beam", new BeamBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));

    public static final Block STONE_BALUSTRADE = register("stone_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.STONE))));


    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Foundation.MOD_ID, id), block);
    }
}
