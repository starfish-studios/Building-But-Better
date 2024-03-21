package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;

import static net.minecraft.world.level.block.Blocks.litBlockEmission;

public class FoundationBlocks {

    // public static final Block OAK_WALL = register("oak_wall", new WallBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));


    // Stone, Blackstone, Deepslate, Nether Brick, Sandstone, Red Sandstone, Quartz
    public static final Block STONE_BLOCK = register("stone_block", new BlockBlock(BlockBlock.Types.STONE, FabricBlockSettings.copy((Blocks.STONE)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_STONE_BLOCK = register("wall_stone_block", new WallBlockBlock(BlockBlock.Types.STONE, FabricBlockSettings.copy((Blocks.STONE)).pushReaction(PushReaction.DESTROY).dropsLike(STONE_BLOCK)));
    public static final Block BLACKSTONE_BLOCK = register("blackstone_block", new BlockBlock(BlockBlock.Types.BLACKSTONE, FabricBlockSettings.copy((Blocks.BLACKSTONE)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_BLACKSTONE_BLOCK = register("wall_blackstone_block", new WallBlockBlock(BlockBlock.Types.BLACKSTONE, FabricBlockSettings.copy((Blocks.BLACKSTONE)).pushReaction(PushReaction.DESTROY).dropsLike(BLACKSTONE_BLOCK)));
    public static final Block DEEPSLATE_BLOCK = register("deepslate_block", new BlockBlock(BlockBlock.Types.DEEPSLATE, FabricBlockSettings.copy((Blocks.DEEPSLATE)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_DEEPSLATE_BLOCK = register("wall_deepslate_block", new WallBlockBlock(BlockBlock.Types.DEEPSLATE, FabricBlockSettings.copy((Blocks.DEEPSLATE)).pushReaction(PushReaction.DESTROY).dropsLike(DEEPSLATE_BLOCK)));
    public static final Block NETHER_BRICK_BLOCK = register("nether_brick_block", new BlockBlock(BlockBlock.Types.NETHER_BRICK, FabricBlockSettings.copy((Blocks.NETHER_BRICKS)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_NETHER_BRICK_BLOCK = register("wall_nether_brick_block", new WallBlockBlock(BlockBlock.Types.NETHER_BRICK, FabricBlockSettings.copy((Blocks.NETHER_BRICKS)).pushReaction(PushReaction.DESTROY).dropsLike(NETHER_BRICK_BLOCK)));
    public static final Block SANDSTONE_BLOCK = register("sandstone_block", new BlockBlock(BlockBlock.Types.SANDSTONE, FabricBlockSettings.copy((Blocks.SANDSTONE)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_SANDSTONE_BLOCK = register("wall_sandstone_block", new WallBlockBlock(BlockBlock.Types.SANDSTONE, FabricBlockSettings.copy((Blocks.SANDSTONE)).pushReaction(PushReaction.DESTROY).dropsLike(SANDSTONE_BLOCK)));
    public static final Block RED_SANDSTONE_BLOCK = register("red_sandstone_block", new BlockBlock(BlockBlock.Types.RED_SANDSTONE, FabricBlockSettings.copy((Blocks.RED_SANDSTONE)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_RED_SANDSTONE_BLOCK = register("wall_red_sandstone_block", new WallBlockBlock(BlockBlock.Types.RED_SANDSTONE, FabricBlockSettings.copy((Blocks.RED_SANDSTONE)).pushReaction(PushReaction.DESTROY).dropsLike(RED_SANDSTONE_BLOCK)));
    public static final Block QUARTZ_BLOCK = register("quartz_block", new BlockBlock(BlockBlock.Types.QUARTZ, FabricBlockSettings.copy((Blocks.QUARTZ_BLOCK)).pushReaction(PushReaction.DESTROY)));
    public static final Block WALL_QUARTZ_BLOCK = register("wall_quartz_block", new WallBlockBlock(BlockBlock.Types.QUARTZ, FabricBlockSettings.copy((Blocks.QUARTZ_BLOCK)).pushReaction(PushReaction.DESTROY).dropsLike(QUARTZ_BLOCK)));

    public static final Block STONE_COLUMN = register("stone_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.STONE_BRICKS)).noOcclusion()));
    public static final Block BLACKSTONE_COLUMN = register("blackstone_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.BLACKSTONE)).noOcclusion()));
    public static final Block DEEPSLATE_COLUMN = register("deepslate_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion()));
    public static final Block NETHER_BRICK_COLUMN = register("nether_brick_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.NETHER_BRICKS)).noOcclusion()));
    public static final Block SANDSTONE_COLUMN = register("sandstone_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.SANDSTONE)).noOcclusion()));
    public static final Block RED_SANDSTONE_COLUMN = register("red_sandstone_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.RED_SANDSTONE)).noOcclusion()));
    public static final Block QUARTZ_COLUMN = register("quartz_column", new ColumnBlock(FabricBlockSettings.copy((Blocks.QUARTZ_BLOCK)).noOcclusion()));



    public static final Block STONE_URN = register("stone_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.STONE)).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block BLACKSTONE_URN = register("blackstone_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.BLACKSTONE)).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block DEEPSLATE_URN = register("deepslate_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block NETHER_BRICK_URN = register("nether_brick_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.NETHER_BRICKS)).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block SANDSTONE_URN = register("sandstone_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.SANDSTONE)).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block RED_SANDSTONE_URN = register("red_sandstone_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.RED_SANDSTONE)).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block QUARTZ_URN = register("quartz_urn", new UrnBlock(FabricBlockSettings.copy((Blocks.QUARTZ_BLOCK)).noOcclusion().pushReaction(PushReaction.DESTROY)));


    // Stone, Blackstone, Deepslate, Nether Brick, Sandstone, Red Sandstone, Quartz
    public static final Block STONE_MOULDING = register("stone_moulding", new MouldingBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final Block BLACKSTONE_MOULDING = register("blackstone_moulding", new MouldingBlock((Blocks.BLACKSTONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));
    public static final Block DEEPSLATE_MOULDING = register("deepslate_moulding", new MouldingBlock((Blocks.DEEPSLATE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));
    public static final Block NETHER_BRICK_MOULDING = register("nether_brick_moulding", new MouldingBlock((Blocks.NETHER_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).noOcclusion()));
    public static final Block SANDSTONE_MOULDING = register("sandstone_moulding", new MouldingBlock((Blocks.SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));
    public static final Block RED_SANDSTONE_MOULDING = register("red_sandstone_moulding", new MouldingBlock((Blocks.RED_SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.RED_SANDSTONE).noOcclusion()));
    public static final Block QUARTZ_MOULDING = register("quartz_moulding", new MouldingBlock((Blocks.QUARTZ_BLOCK.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()));


    public static final Block STONE_FENCE = register("stone_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.STONE_BRICKS)).noOcclusion()));
    public static final Block BLACKSTONE_FENCE = register("blackstone_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.BLACKSTONE)).noOcclusion()));
    public static final Block DEEPSLATE_FENCE = register("deepslate_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion()));
    public static final Block NETHER_BRICK_FENCE = register("nether_brick_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.NETHER_BRICKS)).noOcclusion()));
    public static final Block SANDSTONE_FENCE = register("sandstone_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.SANDSTONE)).noOcclusion()));
    public static final Block RED_SANDSTONE_FENCE = register("red_sandstone_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.RED_SANDSTONE)).noOcclusion()));
    public static final Block QUARTZ_FENCE = register("quartz_fence", new StoneFenceBlock(FabricBlockSettings.copy((Blocks.QUARTZ_BLOCK)).noOcclusion()));

    


    // region BEAMS
    public static final Block OAK_BEAM = register("oak_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_OAK_LOG))));
    public static final Block OAK_BEAM_STAIRS = register("oak_beam_stairs", new StairBlock((Blocks.OAK_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Block OAK_BEAM_SLAB = register("oak_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));
    public static final Block SPRUCE_BEAM = register("spruce_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_SPRUCE_LOG))));
    public static final Block SPRUCE_BEAM_STAIRS = register("spruce_beam_stairs", new StairBlock((Blocks.SPRUCE_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block SPRUCE_BEAM_SLAB = register("spruce_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS))));
    public static final Block BIRCH_BEAM = register("birch_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_BIRCH_LOG))));
    public static final Block BIRCH_BEAM_STAIRS = register("birch_beam_stairs", new StairBlock((Blocks.BIRCH_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Block BIRCH_BEAM_SLAB = register("birch_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS))));
    public static final Block JUNGLE_BEAM = register("jungle_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_JUNGLE_LOG))));
    public static final Block JUNGLE_BEAM_STAIRS = register("jungle_beam_stairs", new StairBlock((Blocks.JUNGLE_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block JUNGLE_BEAM_SLAB = register("jungle_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS))));
    public static final Block ACACIA_BEAM = register("acacia_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_ACACIA_LOG))));
    public static final Block ACACIA_BEAM_STAIRS = register("acacia_beam_stairs", new StairBlock((Blocks.ACACIA_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Block ACACIA_BEAM_SLAB = register("acacia_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS))));
    public static final Block DARK_OAK_BEAM = register("dark_oak_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_DARK_OAK_LOG))));
    public static final Block DARK_OAK_BEAM_STAIRS = register("dark_oak_beam_stairs", new StairBlock((Blocks.DARK_OAK_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block DARK_OAK_BEAM_SLAB = register("dark_oak_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS))));
    public static final Block CRIMSON_BEAM = register("crimson_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_CRIMSON_STEM))));
    public static final Block CRIMSON_BEAM_STAIRS = register("crimson_beam_stairs", new StairBlock((Blocks.CRIMSON_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CRIMSON_BEAM_SLAB = register("crimson_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS))));
    public static final Block WARPED_BEAM = register("warped_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_WARPED_STEM))));
    public static final Block WARPED_BEAM_STAIRS = register("warped_beam_stairs", new StairBlock((Blocks.WARPED_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final Block WARPED_BEAM_SLAB = register("warped_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS))));
    public static final Block MANGROVE_BEAM = register("mangrove_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_MANGROVE_LOG))));
    public static final Block MANGROVE_BEAM_STAIRS = register("mangrove_beam_stairs", new StairBlock((Blocks.MANGROVE_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block MANGROVE_BEAM_SLAB = register("mangrove_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS))));
    public static final Block BAMBOO_BEAM = register("bamboo_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.BAMBOO))));
    public static final Block BAMBOO_BEAM_STAIRS = register("bamboo_beam_stairs", new StairBlock((Blocks.BAMBOO_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block BAMBOO_BEAM_SLAB = register("bamboo_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS))));
    public static final Block CHERRY_BEAM = register("cherry_beam", new RotatedPillarBlock(FabricBlockSettings.copy((Blocks.STRIPPED_CHERRY_LOG))));
    public static final Block CHERRY_BEAM_STAIRS = register("cherry_beam_stairs", new StairBlock((Blocks.CHERRY_PLANKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CHERRY_BEAM_SLAB = register("cherry_beam_slab", new FacingSlabBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS))));
    
    // endregion

    // region SUPPORTS
    public static final Block OAK_SUPPORT = register("oak_support", new SupportBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));
    public static final Block SPRUCE_SUPPORT = register("spruce_support", new SupportBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS)).noOcclusion()));
    public static final Block BIRCH_SUPPORT = register("birch_support", new SupportBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS)).noOcclusion()));
    public static final Block JUNGLE_SUPPORT = register("jungle_support", new SupportBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS)).noOcclusion()));
    public static final Block ACACIA_SUPPORT = register("acacia_support", new SupportBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS)).noOcclusion()));
    public static final Block DARK_OAK_SUPPORT = register("dark_oak_support", new SupportBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS)).noOcclusion()));
    public static final Block CRIMSON_SUPPORT = register("crimson_support", new SupportBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS)).noOcclusion()));
    public static final Block WARPED_SUPPORT = register("warped_support", new SupportBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS)).noOcclusion()));
    public static final Block MANGROVE_SUPPORT = register("mangrove_support", new SupportBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS)).noOcclusion()));
    public static final Block CHERRY_SUPPORT = register("cherry_support", new SupportBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS)).noOcclusion()));
    public static final Block BAMBOO_SUPPORT = register("bamboo_support", new SupportBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS)).noOcclusion()));
    // endregion

    //region LADDERS
    public static final Block OAK_LADDER = register("oak_ladder", new FoundationLadderBlock(1, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block SPRUCE_LADDER = register("spruce_ladder", new FoundationLadderBlock(2, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block BIRCH_LADDER = register("birch_ladder", new FoundationLadderBlock(3, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block JUNGLE_LADDER = register("jungle_ladder", new FoundationLadderBlock(4, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block ACACIA_LADDER = register("acacia_ladder", new FoundationLadderBlock(5, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block DARK_OAK_LADDER = register("dark_oak_ladder", new FoundationLadderBlock(6, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block CRIMSON_LADDER = register("crimson_ladder", new FoundationLadderBlock(7, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block WARPED_LADDER = register("warped_ladder", new FoundationLadderBlock(8, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block MANGROVE_LADDER = register("mangrove_ladder", new FoundationLadderBlock(9, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block BAMBOO_LADDER = register("bamboo_ladder", new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final Block CHERRY_LADDER = register("cherry_ladder", new FoundationLadderBlock(10, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    //endregion

    // region LAYERS
    public static final Block OAK_LAYER = register("oak_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));
    public static final Block SPRUCE_LAYER = register("spruce_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS))));
    public static final Block BIRCH_LAYER = register("birch_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS))));
    public static final Block JUNGLE_LAYER = register("jungle_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS))));
    public static final Block ACACIA_LAYER = register("acacia_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS))));
    public static final Block DARK_OAK_LAYER = register("dark_oak_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS))));
    public static final Block CRIMSON_LAYER = register("crimson_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS))));
    public static final Block WARPED_LAYER = register("warped_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS))));
    public static final Block MANGROVE_LAYER = register("mangrove_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS))));
    public static final Block BAMBOO_LAYER = register("bamboo_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS))));
    public static final Block BAMBOO_MOSAIC_LAYER = register("bamboo_mosaic_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.BAMBOO_MOSAIC))));
    public static final Block CHERRY_LAYER = register("cherry_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS))));
    public static final Block STONE_LAYER = register("stone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.STONE))));
    public static final Block COBBLESTONE_LAYER = register("cobblestone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.COBBLESTONE))));
    public static final Block MOSSY_COBBLESTONE_LAYER = register("mossy_cobblestone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.MOSSY_COBBLESTONE))));
    public static final Block SMOOTH_STONE_LAYER = register("smooth_stone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.SMOOTH_STONE))));
    public static final Block POLISHED_STONE_LAYER = register("polished_stone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.SMOOTH_STONE))));
    public static final Block STONE_TILE_LAYER = register("stone_tile_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.STONE_BRICKS))));
    public static final Block STONE_BRICK_LAYER = register("stone_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.STONE_BRICKS))));
    public static final Block MOSSY_STONE_BRICK_LAYER = register("mossy_stone_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.MOSSY_STONE_BRICKS))));
    public static final Block GRANITE_LAYER = register("granite_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.GRANITE))));
    public static final Block POLISHED_GRANITE_LAYER = register("polished_granite_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.POLISHED_GRANITE))));
    public static final Block DIORITE_LAYER = register("diorite_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.DIORITE))));
    public static final Block POLISHED_DIORITE_LAYER = register("polished_diorite_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.POLISHED_DIORITE))));
    public static final Block ANDESITE_LAYER = register("andesite_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.ANDESITE))));
    public static final Block POLISHED_ANDESITE_LAYER = register("polished_andesite_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.POLISHED_ANDESITE))));
    public static final Block COBBLED_DEEPSLATE_LAYER = register("cobbled_deepslate_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.COBBLED_DEEPSLATE))));
    public static final Block POLISHED_DEEPSLATE_LAYER = register("polished_deepslate_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.POLISHED_DEEPSLATE))));
    public static final Block DEEPSLATE_BRICK_LAYER = register("deepslate_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.DEEPSLATE_BRICKS))));
    public static final Block DEEPSLATE_TILE_LAYER = register("deepslate_tile_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.DEEPSLATE_TILES))));
    public static final Block BRICK_LAYER = register("brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.BRICKS))));
    public static final Block MUD_BRICK_LAYER = register("mud_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.MUD_BRICKS))));
    public static final Block SANDSTONE_LAYER = register("sandstone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.SANDSTONE))));
    public static final Block SMOOTH_SANDSTONE_LAYER = register("smooth_sandstone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.SMOOTH_SANDSTONE))));
    public static final Block RED_SANDSTONE_LAYER = register("red_sandstone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.RED_SANDSTONE))));
    public static final Block SMOOTH_RED_SANDSTONE_LAYER = register("smooth_red_sandstone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.SMOOTH_RED_SANDSTONE))));
    public static final Block PRISMARINE_LAYER = register("prismarine_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.PRISMARINE))));
    public static final Block PRISMARINE_BRICK_LAYER = register("prismarine_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.PRISMARINE_BRICKS))));
    public static final Block DARK_PRISMARINE_LAYER = register("dark_prismarine_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.DARK_PRISMARINE))));
    public static final Block NETHER_BRICK_LAYER = register("nether_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.NETHER_BRICKS))));
    public static final Block RED_NETHER_BRICK_LAYER = register("red_nether_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.RED_NETHER_BRICKS))));
    public static final Block BLACKSTONE_LAYER = register("blackstone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.BLACKSTONE))));
    public static final Block POLISHED_BLACKSTONE_LAYER = register("polished_blackstone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.POLISHED_BLACKSTONE))));
    public static final Block POLISHED_BLACKSTONE_BRICK_LAYER = register("polished_blackstone_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.POLISHED_BLACKSTONE_BRICKS))));
    public static final Block END_STONE_BRICK_LAYER = register("end_stone_brick_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.END_STONE_BRICKS))));
    public static final Block PURPUR_LAYER = register("purpur_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.PURPUR_BLOCK))));
    public static final Block QUARTZ_LAYER = register("quartz_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.QUARTZ_BLOCK))));
    public static final Block CUT_COPPER_LAYER = register("cut_copper_layer", new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.UNAFFECTED, FabricBlockSettings.copy((Blocks.CUT_COPPER))));
    public static final Block EXPOSED_CUT_COPPER_LAYER = register("exposed_cut_copper_layer", new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.EXPOSED, FabricBlockSettings.copy((Blocks.EXPOSED_CUT_COPPER))));
    public static final Block WEATHERED_CUT_COPPER_LAYER = register("weathered_cut_copper_layer", new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.WEATHERED, FabricBlockSettings.copy((Blocks.WEATHERED_CUT_COPPER))));
    public static final Block OXIDIZED_CUT_COPPER_LAYER = register("oxidized_cut_copper_layer", new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.OXIDIZED, FabricBlockSettings.copy((Blocks.OXIDIZED_CUT_COPPER))));
    public static final Block WAXED_CUT_COPPER_LAYER = register("waxed_cut_copper_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.WAXED_CUT_COPPER))));
    public static final Block WAXED_EXPOSED_CUT_COPPER_LAYER = register("waxed_exposed_cut_copper_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.WAXED_EXPOSED_CUT_COPPER))));
    public static final Block WAXED_WEATHERED_CUT_COPPER_LAYER = register("waxed_weathered_cut_copper_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.WAXED_WEATHERED_CUT_COPPER))));
    public static final Block WAXED_OXIDIZED_CUT_COPPER_LAYER = register("waxed_oxidized_cut_copper_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.WAXED_OXIDIZED_CUT_COPPER))));
    // endregion

    // region PALLETS
    public static final Block OAK_PALLET = register("oak_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));
    public static final Block SPRUCE_PALLET = register("spruce_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS)).noOcclusion()));
    public static final Block BIRCH_PALLET = register("birch_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS)).noOcclusion()));
    public static final Block JUNGLE_PALLET = register("jungle_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS)).noOcclusion()));
    public static final Block ACACIA_PALLET = register("acacia_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS)).noOcclusion()));
    public static final Block DARK_OAK_PALLET = register("dark_oak_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS)).noOcclusion()));
    public static final Block MANGROVE_PALLET = register("mangrove_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS)).noOcclusion()));
    public static final Block CHERRY_PALLET = register("cherry_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS)).noOcclusion()));
    public static final Block BAMBOO_PALLET = register("bamboo_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS)).noOcclusion()));
    public static final Block CRIMSON_PALLET = register("crimson_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS)).noOcclusion()));
    public static final Block WARPED_PALLET = register("warped_pallet", new PalletBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS)).noOcclusion()));
    // endregion

    // region FRAMES
    public static final Block OAK_FRAME = register("oak_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion().noCollission()));
    public static final Block SPRUCE_FRAME = register("spruce_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS)).noOcclusion().noCollission()));
    public static final Block BIRCH_FRAME = register("birch_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS)).noOcclusion().noCollission()));
    public static final Block JUNGLE_FRAME = register("jungle_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS)).noOcclusion().noCollission()));
    public static final Block ACACIA_FRAME = register("acacia_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS)).noOcclusion().noCollission()));
    public static final Block DARK_OAK_FRAME = register("dark_oak_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS)).noOcclusion().noCollission()));
    public static final Block MANGROVE_FRAME = register("mangrove_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS)).noOcclusion().noCollission()));
    public static final Block CHERRY_FRAME = register("cherry_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS)).noOcclusion().noCollission()));
    public static final Block BAMBOO_FRAME = register("bamboo_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS)).noOcclusion().noCollission()));
    public static final Block CRIMSON_FRAME = register("crimson_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS)).noOcclusion().noCollission()));
    public static final Block WARPED_FRAME = register("warped_frame", new FrameBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS)).noOcclusion().noCollission()));
    // endregion

    // region WOODEN LANTERNS
    public static final Block OAK_LANTERN = register("oak_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block SPRUCE_LANTERN = register("spruce_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block BIRCH_LANTERN = register("birch_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block JUNGLE_LANTERN = register("jungle_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block ACACIA_LANTERN = register("acacia_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block DARK_OAK_LANTERN = register("dark_oak_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block MANGROVE_LANTERN = register("mangrove_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block CHERRY_LANTERN = register("cherry_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block BAMBOO_LANTERN = register("bamboo_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block CRIMSON_LANTERN = register("crimson_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block WARPED_LANTERN = register("warped_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    // endregion

    // region TRIMS
    public static final Block OAK_TRIM = register("oak_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));
    public static final Block SPRUCE_TRIM = register("spruce_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS))));
    public static final Block BIRCH_TRIM = register("birch_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS))));
    public static final Block JUNGLE_TRIM = register("jungle_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS))));
    public static final Block ACACIA_TRIM = register("acacia_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS))));
    public static final Block DARK_OAK_TRIM = register("dark_oak_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS))));
    public static final Block MANGROVE_TRIM = register("mangrove_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS))));
    public static final Block CHERRY_TRIM = register("cherry_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS))));
    public static final Block BAMBOO_TRIM = register("bamboo_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS))));
    public static final Block CRIMSON_TRIM = register("crimson_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS))));
    public static final Block WARPED_TRIM = register("warped_trim", new FacingConnectingBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS))));
    // endregion




    // public static final Block PLASTER = register("plaster", new Block(FabricBlockSettings.copy((Blocks.GRAVEL))));

    public static final Block POLISHED_STONE = register("polished_stone", new Block(FabricBlockSettings.copy((Blocks.SMOOTH_STONE))));
    public static final Block POLISHED_STONE_STAIRS = register("polished_stone_stairs", new StairBlock((Blocks.SMOOTH_STONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final Block POLISHED_STONE_SLAB = register("polished_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final Block STONE_TILES = register("stone_tiles", new Block(FabricBlockSettings.copy((Blocks.STONE_BRICKS))));
    public static final Block STONE_TILE_STAIRS = register("stone_tile_stairs", new StairBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final Block STONE_TILE_SLAB = register("stone_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));




    public static final Block BRAZIER = register("brazier", new BrazierBlock(FabricBlockSettings.copy((Blocks.IRON_BLOCK)).lightLevel(litBlockEmission(15)).noOcclusion().pushReaction(PushReaction.DESTROY).strength(1.0F, 1.5F)));
    public static final Block SOUL_BRAZIER = register("soul_brazier", new BrazierBlock(FabricBlockSettings.copy((Blocks.IRON_BLOCK)).lightLevel(litBlockEmission(10)).noOcclusion().pushReaction(PushReaction.DESTROY).strength(1.0F, 1.5F)));

    // public static final Block ROOFING = register("roofing", new StairBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).noOcclusion()));


    // public static final Block ROPE = register("rope", new ChainBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).forceSolidOn().strength(0.1F).sound(SoundType.WOOL).noOcclusion()));





    public static final Block IRON_FENCE = register("iron_fence", new IronFenceBlock(FabricBlockSettings.copy((Blocks.IRON_BARS)).noOcclusion()));

    //public static final Block TALL_OAK_DOOR = register("tall_oak_door", new TallDoorBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion(), BlockSetType.OAK));

    // public static final Block BIG_DOOR = register("big_door", new BigDoorBlock(FabricBlockSettings.copy((Blocks.OAK_DOOR)).noOcclusion()));


    private static Block register(String id, Block block) {
        System.out.println(Foundation.MOD_ID + ":" + id);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Foundation.MOD_ID, id), block);
    }
}
