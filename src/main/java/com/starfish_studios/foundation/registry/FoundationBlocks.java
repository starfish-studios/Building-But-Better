package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FoundationBlocks {

    // public static final Block SHORT_GRASS = register("short_grass", new ShortGrassBlock(FabricBlockSettings.copy(Blocks.TALL_GRASS)));

    public static final Block COBBLESTONE_LAYER = register("cobblestone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.COBBLESTONE))));
    public static final Block IRON_FENCE = register("iron_fence", new BalustradeBlock(FabricBlockSettings.copy((Blocks.IRON_BARS))));

    public static final Block OAK_SUPPORT = register("oak_support", new SupportBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));


    public static final Block OAK_BEAM = register("oak_beam", new BeamBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));

    public static final Block OAK_BALUSTRADE = register("oak_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));
    public static final Block SPRUCE_BALUSTRADE = register("spruce_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS))));
    public static final Block BIRCH_BALUSTRADE = register("birch_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS))));
    public static final Block JUNGLE_BALUSTRADE = register("jungle_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS))));
    public static final Block ACACIA_BALUSTRADE = register("acacia_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS))));
    public static final Block DARK_OAK_BALUSTRADE = register("dark_oak_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS))));
    public static final Block CRIMSON_BALUSTRADE = register("crimson_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS))));
    public static final Block WARPED_BALUSTRADE = register("warped_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS))));


    public static final Block STONE_BALUSTRADE = register("stone_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.STONE))));
    public static final Block STONE_MOULDING = register("stone_moulding", new StairBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final Block BIG_OAK_DOOR = register("big_oak_door", new BigDoorBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));


    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Foundation.MOD_ID, id), block);
    }
}
