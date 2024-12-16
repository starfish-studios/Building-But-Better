package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModBlocks {

    public static class Properties {
        public static BlockBehaviour.Properties wood = Block.Properties.of().strength(0.01F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS);
    }

    // Stone, Blackstone, Deepslate, Nether Brick, Sandstone, Red Sandstone, Quartz

    // Write a list of every wood block.
    // Trim, Beam, Beam Stairs, Beam Slab, Pallets, Supports, Balustrades, Walls, Frames, Lanterns, Ladders, Lattices


    // region BALUSTRADES
    public static final Supplier<Block> OAK_BALUSTRADE = registerBlockItem("oak_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_BALUSTRADE = registerBlockItem("spruce_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_BALUSTRADE = registerBlockItem("birch_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_BALUSTRADE = registerBlockItem("jungle_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_BALUSTRADE = registerBlockItem("acacia_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_BALUSTRADE = registerBlockItem("dark_oak_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_BALUSTRADE = registerBlockItem("crimson_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_BALUSTRADE = registerBlockItem("warped_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_BALUSTRADE = registerBlockItem("mangrove_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_BALUSTRADE = registerBlockItem("bamboo_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_BALUSTRADE = registerBlockItem("cherry_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    // endregion

    // region LATTICES
    public static final Supplier<Block> OAK_LATTICE = registerBlockItem("oak_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> SPRUCE_LATTICE = registerBlockItem("spruce_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> BIRCH_LATTICE = registerBlockItem("birch_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> JUNGLE_LATTICE = registerBlockItem("jungle_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> ACACIA_LATTICE = registerBlockItem("acacia_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> DARK_OAK_LATTICE = registerBlockItem("dark_oak_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CRIMSON_LATTICE = registerBlockItem("crimson_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WARPED_LATTICE = registerBlockItem("warped_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> MANGROVE_LATTICE = registerBlockItem("mangrove_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> BAMBOO_LATTICE = registerBlockItem("bamboo_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CHERRY_LATTICE = registerBlockItem("cherry_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    // endregion


    // region WALLS
    public static final Supplier<Block> OAK_WALL = registerBlockItem("oak_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_WALL = registerBlockItem("spruce_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_WALL = registerBlockItem("birch_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_WALL = registerBlockItem("jungle_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_WALL = registerBlockItem("acacia_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_WALL = registerBlockItem("dark_oak_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> CRIMSON_WALL = registerBlockItem("crimson_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_WALL = registerBlockItem("warped_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> MANGROVE_WALL = registerBlockItem("mangrove_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> BAMBOO_WALL = registerBlockItem("bamboo_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final Supplier<Block> CHERRY_WALL = registerBlockItem("cherry_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    // endregion

    // region BLOCKS
    public static final Supplier<Block> STONE_BLOCK = registerBlockItem("stone_block", () -> new BlockBlock(BlockBlock.Types.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_STONE_BLOCK = registerBlockItem("wall_stone_block", () -> new WallBlockBlock(BlockBlock.Types.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).pushReaction(PushReaction.DESTROY).dropsLike(STONE_BLOCK.get())));
    public static final Supplier<Block> BLACKSTONE_BLOCK = registerBlockItem("blackstone_block", () -> new BlockBlock(BlockBlock.Types.BLACKSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_BLACKSTONE_BLOCK = registerBlockItem("wall_blackstone_block", () -> new WallBlockBlock(BlockBlock.Types.BLACKSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).pushReaction(PushReaction.DESTROY).dropsLike(BLACKSTONE_BLOCK.get())));
    public static final Supplier<Block> DEEPSLATE_BLOCK = registerBlockItem("deepslate_block", () -> new BlockBlock(BlockBlock.Types.DEEPSLATE, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_DEEPSLATE_BLOCK = registerBlockItem("wall_deepslate_block", () -> new WallBlockBlock(BlockBlock.Types.DEEPSLATE, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).pushReaction(PushReaction.DESTROY).dropsLike(DEEPSLATE_BLOCK.get())));
    public static final Supplier<Block> NETHER_BRICK_BLOCK = registerBlockItem("nether_brick_block", () -> new BlockBlock(BlockBlock.Types.NETHER_BRICK, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_NETHER_BRICK_BLOCK = registerBlockItem("wall_nether_brick_block", () -> new WallBlockBlock(BlockBlock.Types.NETHER_BRICK, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).pushReaction(PushReaction.DESTROY).dropsLike(NETHER_BRICK_BLOCK.get())));
    public static final Supplier<Block> SANDSTONE_BLOCK = registerBlockItem("sandstone_block", () -> new BlockBlock(BlockBlock.Types.SANDSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_SANDSTONE_BLOCK = registerBlockItem("wall_sandstone_block", () -> new WallBlockBlock(BlockBlock.Types.SANDSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).pushReaction(PushReaction.DESTROY).dropsLike(SANDSTONE_BLOCK.get())));
    public static final Supplier<Block> RED_SANDSTONE_BLOCK = registerBlockItem("red_sandstone_block", () -> new BlockBlock(BlockBlock.Types.RED_SANDSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_RED_SANDSTONE_BLOCK = registerBlockItem("wall_red_sandstone_block", () -> new WallBlockBlock(BlockBlock.Types.RED_SANDSTONE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).pushReaction(PushReaction.DESTROY).dropsLike(RED_SANDSTONE_BLOCK.get())));
    public static final Supplier<Block> QUARTZ_BLOCK = registerBlockItem("quartz_block", () -> new BlockBlock(BlockBlock.Types.QUARTZ, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WALL_QUARTZ_BLOCK = registerBlockItem("wall_quartz_block", () -> new WallBlockBlock(BlockBlock.Types.QUARTZ, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).pushReaction(PushReaction.DESTROY).dropsLike(QUARTZ_BLOCK.get())));
    // endregion

    // region COLUMNS
    public static final Supplier<Block> STONE_COLUMN = registerBlockItem("stone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final Supplier<Block> BLACKSTONE_COLUMN = registerBlockItem("blackstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()));
    public static final Supplier<Block> DEEPSLATE_COLUMN = registerBlockItem("deepslate_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));
    public static final Supplier<Block> NETHER_BRICK_COLUMN = registerBlockItem("nether_brick_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
    public static final Supplier<Block> SANDSTONE_COLUMN = registerBlockItem("sandstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
    public static final Supplier<Block> RED_SANDSTONE_COLUMN = registerBlockItem("red_sandstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion()));
    public static final Supplier<Block> QUARTZ_COLUMN = registerBlockItem("quartz_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    // endregion

    // region URNS
    public static final Supplier<Block> STONE_URN = registerBlockItem("stone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> BLACKSTONE_URN = registerBlockItem("blackstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> DEEPSLATE_URN = registerBlockItem("deepslate_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> NETHER_BRICK_URN = registerBlockItem("nether_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> SANDSTONE_URN = registerBlockItem("sandstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> RED_SANDSTONE_URN = registerBlockItem("red_sandstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> QUARTZ_URN = registerBlockItem("quartz_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion().pushReaction(PushReaction.DESTROY)));
    // endregion

    // region MOULDINGS
    public static final Supplier<Block> STONE_MOULDING = registerBlockItem("stone_moulding", () -> new MouldingBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final Supplier<Block> BLACKSTONE_MOULDING = registerBlockItem("blackstone_moulding", () -> new MouldingBlock((Blocks.BLACKSTONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()));
    public static final Supplier<Block> DEEPSLATE_MOULDING = registerBlockItem("deepslate_moulding", () -> new MouldingBlock((Blocks.DEEPSLATE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));
    public static final Supplier<Block> NETHER_BRICK_MOULDING = registerBlockItem("nether_brick_moulding", () -> new MouldingBlock((Blocks.NETHER_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
    public static final Supplier<Block> SANDSTONE_MOULDING = registerBlockItem("sandstone_moulding", () -> new MouldingBlock((Blocks.SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
    public static final Supplier<Block> RED_SANDSTONE_MOULDING = registerBlockItem("red_sandstone_moulding", () -> new MouldingBlock((Blocks.RED_SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion()));
    public static final Supplier<Block> QUARTZ_MOULDING = registerBlockItem("quartz_moulding", () -> new MouldingBlock((Blocks.QUARTZ_BLOCK.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    // endregion

    // region STONE FENCES
    public static final Supplier<Block> STONE_FENCE = registerBlockItem("stone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final Supplier<Block> BLACKSTONE_FENCE = registerBlockItem("blackstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()));
    public static final Supplier<Block> DEEPSLATE_FENCE = registerBlockItem("deepslate_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));
    public static final Supplier<Block> NETHER_BRICK_FENCE = registerBlockItem("nether_brick_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
    public static final Supplier<Block> SANDSTONE_FENCE = registerBlockItem("sandstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
    public static final Supplier<Block> RED_SANDSTONE_FENCE = registerBlockItem("red_sandstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion()));
    public static final Supplier<Block> QUARTZ_FENCE = registerBlockItem("quartz_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    // endregion

    // region BEAMS
    public static final Supplier<Block> OAK_BEAM = registerBlockItem("oak_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final Supplier<Block> OAK_BEAM_STAIRS = registerBlockItem("oak_beam_stairs", () -> new ModStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OAK_BEAM_SLAB = registerBlockItem("oak_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_BEAM = registerBlockItem("spruce_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final Supplier<Block> SPRUCE_BEAM_STAIRS = registerBlockItem("spruce_beam_stairs", () -> new ModStairBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> SPRUCE_BEAM_SLAB = registerBlockItem("spruce_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_BEAM = registerBlockItem("birch_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final Supplier<Block> BIRCH_BEAM_STAIRS = registerBlockItem("birch_beam_stairs", () -> new ModStairBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> BIRCH_BEAM_SLAB = registerBlockItem("birch_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_BEAM = registerBlockItem("jungle_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final Supplier<Block> JUNGLE_BEAM_STAIRS = registerBlockItem("jungle_beam_stairs", () -> new ModStairBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> JUNGLE_BEAM_SLAB = registerBlockItem("jungle_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_BEAM = registerBlockItem("acacia_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)));
    public static final Supplier<Block> ACACIA_BEAM_STAIRS = registerBlockItem("acacia_beam_stairs", () -> new ModStairBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> ACACIA_BEAM_SLAB = registerBlockItem("acacia_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_BEAM = registerBlockItem("dark_oak_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final Supplier<Block> DARK_OAK_BEAM_STAIRS = registerBlockItem("dark_oak_beam_stairs", () -> new ModStairBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> DARK_OAK_BEAM_SLAB = registerBlockItem("dark_oak_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> CRIMSON_BEAM = registerBlockItem("crimson_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final Supplier<Block> CRIMSON_BEAM_STAIRS = registerBlockItem("crimson_beam_stairs", () -> new ModStairBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> CRIMSON_BEAM_SLAB = registerBlockItem("crimson_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_BEAM = registerBlockItem("warped_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final Supplier<Block> WARPED_BEAM_STAIRS = registerBlockItem("warped_beam_stairs", () -> new ModStairBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> WARPED_BEAM_SLAB = registerBlockItem("warped_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> MANGROVE_BEAM = registerBlockItem("mangrove_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_LOG)));
    public static final Supplier<Block> MANGROVE_BEAM_STAIRS = registerBlockItem("mangrove_beam_stairs", () -> new ModStairBlock((Blocks.MANGROVE_PLANKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> MANGROVE_BEAM_SLAB = registerBlockItem("mangrove_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> BAMBOO_BEAM = registerBlockItem("bamboo_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final Supplier<Block> BAMBOO_BEAM_STAIRS = registerBlockItem("bamboo_beam_stairs", () -> new ModStairBlock((Blocks.BAMBOO_PLANKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final Supplier<Block> BAMBOO_BEAM_SLAB = registerBlockItem("bamboo_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final Supplier<Block> CHERRY_BEAM = registerBlockItem("cherry_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Supplier<Block> CHERRY_BEAM_STAIRS = registerBlockItem("cherry_beam_stairs", () -> new ModStairBlock((Blocks.CHERRY_PLANKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CHERRY_BEAM_SLAB = registerBlockItem("cherry_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    // endregion

    // region SUPPORTS
    public static final Supplier<Block> OAK_SUPPORT = registerBlockItem("oak_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_SUPPORT = registerBlockItem("spruce_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_SUPPORT = registerBlockItem("birch_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_SUPPORT = registerBlockItem("jungle_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_SUPPORT = registerBlockItem("acacia_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_SUPPORT = registerBlockItem("dark_oak_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_SUPPORT = registerBlockItem("crimson_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_SUPPORT = registerBlockItem("warped_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_SUPPORT = registerBlockItem("mangrove_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_SUPPORT = registerBlockItem("cherry_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_SUPPORT = registerBlockItem("bamboo_support", () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    // endregion

    //region LADDERS
    public static final Supplier<Block> OAK_LADDER = registerBlockItem("oak_ladder", () -> new BBBLadderBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> SPRUCE_LADDER = registerBlockItem("spruce_ladder", () -> new BBBLadderBlock(2, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> BIRCH_LADDER = registerBlockItem("birch_ladder", () -> new BBBLadderBlock(3, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> JUNGLE_LADDER = registerBlockItem("jungle_ladder", () -> new BBBLadderBlock(4, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> ACACIA_LADDER = registerBlockItem("acacia_ladder", () -> new BBBLadderBlock(5, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> DARK_OAK_LADDER = registerBlockItem("dark_oak_ladder", () -> new BBBLadderBlock(6, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> CRIMSON_LADDER = registerBlockItem("crimson_ladder", () -> new BBBLadderBlock(7, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> WARPED_LADDER = registerBlockItem("warped_ladder", () -> new BBBLadderBlock(8, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> MANGROVE_LADDER = registerBlockItem("mangrove_ladder", () -> new BBBLadderBlock(9, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> BAMBOO_LADDER = registerBlockItem("bamboo_ladder", () -> new ModLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> CHERRY_LADDER = registerBlockItem("cherry_ladder", () -> new BBBLadderBlock(10, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    //endregion

    // region LAYERS
    public static final Supplier<Block> OAK_LAYER = registerBlockItem("oak_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_LAYER = registerBlockItem("spruce_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_LAYER = registerBlockItem("birch_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_LAYER = registerBlockItem("jungle_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_LAYER = registerBlockItem("acacia_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_LAYER = registerBlockItem("dark_oak_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> CRIMSON_LAYER = registerBlockItem("crimson_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_LAYER = registerBlockItem("warped_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> MANGROVE_LAYER = registerBlockItem("mangrove_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> BAMBOO_LAYER = registerBlockItem("bamboo_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final Supplier<Block> BAMBOO_MOSAIC_LAYER = registerBlockItem("bamboo_mosaic_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_MOSAIC)));
    public static final Supplier<Block> CHERRY_LAYER = registerBlockItem("cherry_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> MOSS_LAYER = registerBlockItem("moss_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK)));
    public static final Supplier<Block> STONE_LAYER = registerBlockItem("stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> COBBLESTONE_LAYER = registerBlockItem("cobblestone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final Supplier<Block> MOSSY_COBBLESTONE_LAYER = registerBlockItem("mossy_cobblestone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final Supplier<Block> SMOOTH_STONE_LAYER = registerBlockItem("smooth_stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final Supplier<Block> POLISHED_STONE_LAYER = registerBlockItem("polished_stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final Supplier<Block> STONE_TILE_LAYER = registerBlockItem("stone_tile_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final Supplier<Block> STONE_BRICK_LAYER = registerBlockItem("stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final Supplier<Block> MOSSY_STONE_BRICK_LAYER = registerBlockItem("mossy_stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Supplier<Block> GRANITE_LAYER = registerBlockItem("granite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> POLISHED_GRANITE_LAYER = registerBlockItem("polished_granite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE)));
    public static final Supplier<Block> DIORITE_LAYER = registerBlockItem("diorite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> POLISHED_DIORITE_LAYER = registerBlockItem("polished_diorite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE)));
    public static final Supplier<Block> ANDESITE_LAYER = registerBlockItem("andesite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> POLISHED_ANDESITE_LAYER = registerBlockItem("polished_andesite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)));
    public static final Supplier<Block> COBBLED_DEEPSLATE_LAYER = registerBlockItem("cobbled_deepslate_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)));
    public static final Supplier<Block> POLISHED_DEEPSLATE_LAYER = registerBlockItem("polished_deepslate_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE)));
    public static final Supplier<Block> DEEPSLATE_BRICK_LAYER = registerBlockItem("deepslate_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)));
    public static final Supplier<Block> DEEPSLATE_TILE_LAYER = registerBlockItem("deepslate_tile_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_TILES)));
    public static final Supplier<Block> BRICK_LAYER = registerBlockItem("brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final Supplier<Block> MUD_BRICK_LAYER = registerBlockItem("mud_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final Supplier<Block> SANDSTONE_LAYER = registerBlockItem("sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final Supplier<Block> SMOOTH_SANDSTONE_LAYER = registerBlockItem("smooth_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
    public static final Supplier<Block> RED_SANDSTONE_LAYER = registerBlockItem("red_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final Supplier<Block> SMOOTH_RED_SANDSTONE_LAYER = registerBlockItem("smooth_red_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_RED_SANDSTONE)));
    public static final Supplier<Block> PRISMARINE_LAYER = registerBlockItem("prismarine_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final Supplier<Block> PRISMARINE_BRICK_LAYER = registerBlockItem("prismarine_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
    public static final Supplier<Block> DARK_PRISMARINE_LAYER = registerBlockItem("dark_prismarine_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final Supplier<Block> NETHER_BRICK_LAYER = registerBlockItem("nether_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final Supplier<Block> RED_NETHER_BRICK_LAYER = registerBlockItem("red_nether_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final Supplier<Block> BLACKSTONE_LAYER = registerBlockItem("blackstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> POLISHED_BLACKSTONE_LAYER = registerBlockItem("polished_blackstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE)));
    public static final Supplier<Block> POLISHED_BLACKSTONE_BRICK_LAYER = registerBlockItem("polished_blackstone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
    public static final Supplier<Block> END_STONE_BRICK_LAYER = registerBlockItem("end_stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));
    public static final Supplier<Block> PURPUR_LAYER = registerBlockItem("purpur_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final Supplier<Block> QUARTZ_LAYER = registerBlockItem("quartz_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final Supplier<Block> CUT_COPPER_LAYER = registerBlockItem("cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER)));
    public static final Supplier<Block> EXPOSED_CUT_COPPER_LAYER = registerBlockItem("exposed_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_CUT_COPPER)));
    public static final Supplier<Block> WEATHERED_CUT_COPPER_LAYER = registerBlockItem("weathered_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_CUT_COPPER)));
    public static final Supplier<Block> OXIDIZED_CUT_COPPER_LAYER = registerBlockItem("oxidized_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_CUT_COPPER)));
    public static final Supplier<Block> WAXED_CUT_COPPER_LAYER = registerBlockItem("waxed_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_CUT_COPPER)));
    public static final Supplier<Block> WAXED_EXPOSED_CUT_COPPER_LAYER = registerBlockItem("waxed_exposed_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_EXPOSED_CUT_COPPER)));
    public static final Supplier<Block> WAXED_WEATHERED_CUT_COPPER_LAYER = registerBlockItem("waxed_weathered_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_WEATHERED_CUT_COPPER)));
    public static final Supplier<Block> WAXED_OXIDIZED_CUT_COPPER_LAYER = registerBlockItem("waxed_oxidized_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_OXIDIZED_CUT_COPPER)));
    // endregion

    // region PALLETS
    public static final Supplier<Block> OAK_PALLET = registerBlockItem("oak_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_PALLET = registerBlockItem("spruce_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_PALLET = registerBlockItem("birch_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_PALLET = registerBlockItem("jungle_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_PALLET = registerBlockItem("acacia_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_PALLET = registerBlockItem("dark_oak_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_PALLET = registerBlockItem("mangrove_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_PALLET = registerBlockItem("cherry_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_PALLET = registerBlockItem("bamboo_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_PALLET = registerBlockItem("crimson_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_PALLET = registerBlockItem("warped_pallet", () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    // endregion

    // region FRAMES
    public static final Supplier<Block> OAK_FRAME = registerBlockItem("oak_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> SPRUCE_FRAME = registerBlockItem("spruce_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> BIRCH_FRAME = registerBlockItem("birch_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> JUNGLE_FRAME = registerBlockItem("jungle_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> ACACIA_FRAME = registerBlockItem("acacia_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> DARK_OAK_FRAME = registerBlockItem("dark_oak_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> MANGROVE_FRAME = registerBlockItem("mangrove_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CHERRY_FRAME = registerBlockItem("cherry_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> BAMBOO_FRAME = registerBlockItem("bamboo_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CRIMSON_FRAME = registerBlockItem("crimson_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> WARPED_FRAME = registerBlockItem("warped_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> STONE_FRAME = registerBlockItem("stone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> BLACKSTONE_FRAME = registerBlockItem("blackstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> DEEPSLATE_FRAME = registerBlockItem("deepslate_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> NETHER_BRICK_FRAME = registerBlockItem("nether_brick_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> SANDSTONE_FRAME = registerBlockItem("sandstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> RED_SANDSTONE_FRAME = registerBlockItem("red_sandstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> QUARTZ_FRAME = registerBlockItem("quartz_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    // endregion

    // region WOODEN LANTERNS
    public static final Supplier<Block> OAK_LANTERN = registerBlockItem("oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> SPRUCE_LANTERN = registerBlockItem("spruce_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> BIRCH_LANTERN = registerBlockItem("birch_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> JUNGLE_LANTERN = registerBlockItem("jungle_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> ACACIA_LANTERN = registerBlockItem("acacia_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> DARK_OAK_LANTERN = registerBlockItem("dark_oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> MANGROVE_LANTERN = registerBlockItem("mangrove_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> CHERRY_LANTERN = registerBlockItem("cherry_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> BAMBOO_LANTERN = registerBlockItem("bamboo_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> CRIMSON_LANTERN = registerBlockItem("crimson_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Supplier<Block> WARPED_LANTERN = registerBlockItem("warped_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    // endregion

    // region TRIMS
    public static final Supplier<Block> OAK_TRIM = registerBlockItem("oak_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_TRIM = registerBlockItem("spruce_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_TRIM = registerBlockItem("birch_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_TRIM = registerBlockItem("jungle_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_TRIM = registerBlockItem("acacia_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_TRIM = registerBlockItem("dark_oak_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_TRIM = registerBlockItem("mangrove_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_TRIM = registerBlockItem("cherry_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> BAMBOO_TRIM = registerBlockItem("bamboo_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final Supplier<Block> CRIMSON_TRIM = registerBlockItem("crimson_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_TRIM = registerBlockItem("warped_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    // endregion

    public static final Supplier<Block> POLISHED_STONE = registerBlockItem("polished_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final Supplier<Block> POLISHED_STONE_STAIRS = registerBlockItem("polished_stone_stairs", () -> new ModStairBlock(Blocks.SMOOTH_STONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final Supplier<Block> POLISHED_STONE_SLAB = registerBlockItem("polished_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final Supplier<Block> STONE_TILES = registerBlockItem("stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final Supplier<Block> STONE_TILE_STAIRS = registerBlockItem("stone_tile_stairs", () -> new ModStairBlock(Blocks.STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final Supplier<Block> STONE_TILE_SLAB = registerBlockItem("stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));


    public static final Supplier<Block> BRAZIER = registerBlockItem("brazier", () -> new BrazierBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).lightLevel((e) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(1.0F, 1.5F)));
    public static final Supplier<Block> SOUL_BRAZIER = registerBlockItem("soul_brazier", () -> new BrazierBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).lightLevel((e) -> 10).noOcclusion().pushReaction(PushReaction.DESTROY).strength(1.0F, 1.5F)));


    public static final Supplier<Block> ROPE = registerBlockItem("rope", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).forceSolidOn().strength(0.1F).sound(SoundType.WOOL).noOcclusion()));

    public static final Supplier<Block> IRON_FENCE = registerBlockItem("iron_fence", () -> new IronFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS).noOcclusion()));

//    public static final Supplier<Block> XENO_ARTIFACT = registerBlockItem("xeno_artifact",
//            () -> new XenoArtifactBlock(BlockBehaviour.Properties.of().strength(5.0F, 1200.0F)),
//            new Item.Properties().component(ModDataComponents.XENO_ARTIFACT_GENERATOR.get(), new XenoArtifactDataGenerator(3, 8, 3)));



    public static <T extends Block> Supplier<T> registerBlockItem(String name, Supplier<T> block, Item.Properties properties) {
        Supplier<T> supplier = ModRegistry.registerBlock(name, block);
        ModRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()), "tab");

        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockItem(String name, Supplier<T> block) {
        Supplier<T> supplier = ModRegistry.registerBlock(name, block);
        ModRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()), "tab");

        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockHidden(String name, Supplier<T> block) {
        Supplier<T> supplier = ModRegistry.registerBlock(name, block);
        ModRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()), null);
        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockOnly(String name, Supplier<T> block) {
        return ModRegistry.registerBlock(name, block);
    }

    public static void init() {}
}