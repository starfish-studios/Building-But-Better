package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.item.DescriptionBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class BBBItems {

    public static final Item CORNERSTONE = register("bbb", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON).fireproof()));
    public static final Item HAMMER = register("hammer", new Item(new FabricItemSettings().maxCount(1).durability(256)));

    // Stone, Blackstone, Deepslate, Nether Brick, Sandstone, Red Sandstone, Quartz
    public static final Item STONE_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.STONE_BLOCK, BBBBlocks.WALL_STONE_BLOCK, new Item.Properties(), Direction.DOWN));
    public static final Item BLACKSTONE_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.BLACKSTONE_BLOCK, BBBBlocks.WALL_BLACKSTONE_BLOCK, new Item.Properties(), Direction.DOWN));
    public static final Item DEEPSLATE_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.DEEPSLATE_BLOCK, BBBBlocks.WALL_DEEPSLATE_BLOCK, new Item.Properties(), Direction.DOWN));
    public static final Item NETHER_BRICK_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.NETHER_BRICK_BLOCK, BBBBlocks.WALL_NETHER_BRICK_BLOCK, new Item.Properties(), Direction.DOWN));
    public static final Item SANDSTONE_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.SANDSTONE_BLOCK, BBBBlocks.WALL_SANDSTONE_BLOCK, new Item.Properties(), Direction.DOWN));
    public static final Item RED_SANDSTONE_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.RED_SANDSTONE_BLOCK, BBBBlocks.WALL_RED_SANDSTONE_BLOCK, new Item.Properties(), Direction.DOWN));
    public static final Item QUARTZ_BLOCK = Items.registerBlock(new StandingAndWallBlockItem(BBBBlocks.QUARTZ_BLOCK, BBBBlocks.WALL_QUARTZ_BLOCK, new Item.Properties(), Direction.DOWN));




    // public static final Item PLASTER = register("plaster", new BlockItem(BBBBlocks.PLASTER, new FabricItemSettings()));
    // public static final Item OAK_WALL = register("oak_wall", new BlockItem(BBBBlocks.OAK_WALL, new FabricItemSettings()));


    public static final Item STONE_URN = register("stone_urn", new DescriptionBlockItem(BBBBlocks.STONE_URN, new FabricItemSettings()));
    public static final Item BLACKSTONE_URN = register("blackstone_urn", new DescriptionBlockItem(BBBBlocks.BLACKSTONE_URN, new FabricItemSettings()));
    public static final Item DEEPSLATE_URN = register("deepslate_urn", new DescriptionBlockItem(BBBBlocks.DEEPSLATE_URN, new FabricItemSettings()));
    public static final Item NETHER_BRICK_URN = register("nether_brick_urn", new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_URN, new FabricItemSettings()));
    public static final Item SANDSTONE_URN = register("sandstone_urn", new DescriptionBlockItem(BBBBlocks.SANDSTONE_URN, new FabricItemSettings()));
    public static final Item RED_SANDSTONE_URN = register("red_sandstone_urn", new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_URN, new FabricItemSettings()));
    public static final Item QUARTZ_URN = register("quartz_urn", new DescriptionBlockItem(BBBBlocks.QUARTZ_URN, new FabricItemSettings()));


    public static final Item STONE_MOULDING = register("stone_moulding", new DescriptionBlockItem(BBBBlocks.STONE_MOULDING, new FabricItemSettings()));
    public static final Item BLACKSTONE_MOULDING = register("blackstone_moulding", new DescriptionBlockItem(BBBBlocks.BLACKSTONE_MOULDING, new FabricItemSettings()));
    public static final Item DEEPSLATE_MOULDING = register("deepslate_moulding", new DescriptionBlockItem(BBBBlocks.DEEPSLATE_MOULDING, new FabricItemSettings()));
    public static final Item NETHER_BRICK_MOULDING = register("nether_brick_moulding", new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_MOULDING, new FabricItemSettings()));
    public static final Item SANDSTONE_MOULDING = register("sandstone_moulding", new DescriptionBlockItem(BBBBlocks.SANDSTONE_MOULDING, new FabricItemSettings()));
    public static final Item RED_SANDSTONE_MOULDING = register("red_sandstone_moulding", new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_MOULDING, new FabricItemSettings()));
    public static final Item QUARTZ_MOULDING = register("quartz_moulding", new DescriptionBlockItem(BBBBlocks.QUARTZ_MOULDING, new FabricItemSettings()));


    public static final Item STONE_COLUMN = register("stone_column", new DescriptionBlockItem(BBBBlocks.STONE_COLUMN, new FabricItemSettings()));
    public static final Item DEEPSLATE_COLUMN = register("deepslate_column", new DescriptionBlockItem(BBBBlocks.DEEPSLATE_COLUMN, new FabricItemSettings()));
    public static final Item SANDSTONE_COLUMN = register("sandstone_column", new DescriptionBlockItem(BBBBlocks.SANDSTONE_COLUMN, new FabricItemSettings()));
    public static final Item RED_SANDSTONE_COLUMN = register("red_sandstone_column", new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_COLUMN, new FabricItemSettings()));
    public static final Item NETHER_BRICK_COLUMN = register("nether_brick_column", new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_COLUMN, new FabricItemSettings()));
    public static final Item BLACKSTONE_COLUMN = register("blackstone_column", new DescriptionBlockItem(BBBBlocks.BLACKSTONE_COLUMN, new FabricItemSettings()));
    public static final Item QUARTZ_COLUMN = register("quartz_column", new DescriptionBlockItem(BBBBlocks.QUARTZ_COLUMN, new FabricItemSettings()));



    public static final Item STONE_FENCE = register("stone_fence", new DescriptionBlockItem(BBBBlocks.STONE_FENCE, new FabricItemSettings()));
    public static final Item BLACKSTONE_FENCE = register("blackstone_fence", new DescriptionBlockItem(BBBBlocks.BLACKSTONE_FENCE, new FabricItemSettings()));
    public static final Item DEEPSLATE_FENCE = register("deepslate_fence", new DescriptionBlockItem(BBBBlocks.DEEPSLATE_FENCE, new FabricItemSettings()));
    public static final Item NETHER_BRICK_FENCE = register("nether_brick_fence", new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_FENCE, new FabricItemSettings()));
    public static final Item SANDSTONE_FENCE = register("sandstone_fence", new DescriptionBlockItem(BBBBlocks.SANDSTONE_FENCE, new FabricItemSettings()));
    public static final Item RED_SANDSTONE_FENCE = register("red_sandstone_fence", new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_FENCE, new FabricItemSettings()));
    public static final Item QUARTZ_FENCE = register("quartz_fence", new DescriptionBlockItem(BBBBlocks.QUARTZ_FENCE, new FabricItemSettings()));



    // region BEAMS
    public static final Item OAK_BEAM = register("oak_beam", new BlockItem(BBBBlocks.OAK_BEAM, new FabricItemSettings()));
    public static final Item OAK_BEAM_STAIRS = register("oak_beam_stairs", new BlockItem(BBBBlocks.OAK_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item OAK_BEAM_SLAB = register("oak_beam_slab", new BlockItem(BBBBlocks.OAK_BEAM_SLAB, new FabricItemSettings()));
    public static final Item SPRUCE_BEAM = register("spruce_beam", new BlockItem(BBBBlocks.SPRUCE_BEAM, new FabricItemSettings()));
    public static final Item SPRUCE_BEAM_STAIRS = register("spruce_beam_stairs", new BlockItem(BBBBlocks.SPRUCE_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item SPRUCE_BEAM_SLAB = register("spruce_beam_slab", new BlockItem(BBBBlocks.SPRUCE_BEAM_SLAB, new FabricItemSettings()));
    public static final Item BIRCH_BEAM = register("birch_beam", new BlockItem(BBBBlocks.BIRCH_BEAM, new FabricItemSettings()));
    public static final Item BIRCH_BEAM_STAIRS = register("birch_beam_stairs", new BlockItem(BBBBlocks.BIRCH_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item BIRCH_BEAM_SLAB = register("birch_beam_slab", new BlockItem(BBBBlocks.BIRCH_BEAM_SLAB, new FabricItemSettings()));
    public static final Item JUNGLE_BEAM = register("jungle_beam", new BlockItem(BBBBlocks.JUNGLE_BEAM, new FabricItemSettings()));
    public static final Item JUNGLE_BEAM_STAIRS = register("jungle_beam_stairs", new BlockItem(BBBBlocks.JUNGLE_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item JUNGLE_BEAM_SLAB = register("jungle_beam_slab", new BlockItem(BBBBlocks.JUNGLE_BEAM_SLAB, new FabricItemSettings()));
    public static final Item ACACIA_BEAM = register("acacia_beam", new BlockItem(BBBBlocks.ACACIA_BEAM, new FabricItemSettings()));
    public static final Item ACACIA_BEAM_STAIRS = register("acacia_beam_stairs", new BlockItem(BBBBlocks.ACACIA_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item ACACIA_BEAM_SLAB = register("acacia_beam_slab", new BlockItem(BBBBlocks.ACACIA_BEAM_SLAB, new FabricItemSettings()));
    public static final Item DARK_OAK_BEAM = register("dark_oak_beam", new BlockItem(BBBBlocks.DARK_OAK_BEAM, new FabricItemSettings()));
    public static final Item DARK_OAK_BEAM_STAIRS = register("dark_oak_beam_stairs", new BlockItem(BBBBlocks.DARK_OAK_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item DARK_OAK_BEAM_SLAB = register("dark_oak_beam_slab", new BlockItem(BBBBlocks.DARK_OAK_BEAM_SLAB, new FabricItemSettings()));
    public static final Item CRIMSON_BEAM = register("crimson_beam", new BlockItem(BBBBlocks.CRIMSON_BEAM, new FabricItemSettings()));
    public static final Item CRIMSON_BEAM_STAIRS = register("crimson_beam_stairs", new BlockItem(BBBBlocks.CRIMSON_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item CRIMSON_BEAM_SLAB = register("crimson_beam_slab", new BlockItem(BBBBlocks.CRIMSON_BEAM_SLAB, new FabricItemSettings()));
    public static final Item WARPED_BEAM = register("warped_beam", new BlockItem(BBBBlocks.WARPED_BEAM, new FabricItemSettings()));
    public static final Item WARPED_BEAM_STAIRS = register("warped_beam_stairs", new BlockItem(BBBBlocks.WARPED_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item WARPED_BEAM_SLAB = register("warped_beam_slab", new BlockItem(BBBBlocks.WARPED_BEAM_SLAB, new FabricItemSettings()));
    public static final Item MANGROVE_BEAM = register("mangrove_beam", new BlockItem(BBBBlocks.MANGROVE_BEAM, new FabricItemSettings()));
    public static final Item MANGROVE_BEAM_STAIRS = register("mangrove_beam_stairs", new BlockItem(BBBBlocks.MANGROVE_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item MANGROVE_BEAM_SLAB = register("mangrove_beam_slab", new BlockItem(BBBBlocks.MANGROVE_BEAM_SLAB, new FabricItemSettings()));
    public static final Item BAMBOO_BEAM = register("bamboo_beam", new BlockItem(BBBBlocks.BAMBOO_BEAM, new FabricItemSettings()));
    public static final Item BAMBOO_BEAM_STAIRS = register("bamboo_beam_stairs", new BlockItem(BBBBlocks.BAMBOO_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item BAMBOO_BEAM_SLAB = register("bamboo_beam_slab", new BlockItem(BBBBlocks.BAMBOO_BEAM_SLAB, new FabricItemSettings()));
    public static final Item CHERRY_BEAM = register("cherry_beam", new BlockItem(BBBBlocks.CHERRY_BEAM, new FabricItemSettings()));
    public static final Item CHERRY_BEAM_STAIRS = register("cherry_beam_stairs", new BlockItem(BBBBlocks.CHERRY_BEAM_STAIRS, new FabricItemSettings()));
    public static final Item CHERRY_BEAM_SLAB = register("cherry_beam_slab", new BlockItem(BBBBlocks.CHERRY_BEAM_SLAB, new FabricItemSettings()));
    // endregion

    // region SUPPORTS
    public static final Item OAK_SUPPORT = register("oak_support", new DescriptionBlockItem(BBBBlocks.OAK_SUPPORT, new FabricItemSettings()));
    public static final Item SPRUCE_SUPPORT = register("spruce_support", new DescriptionBlockItem(BBBBlocks.SPRUCE_SUPPORT, new FabricItemSettings()));
    public static final Item BIRCH_SUPPORT = register("birch_support", new DescriptionBlockItem(BBBBlocks.BIRCH_SUPPORT, new FabricItemSettings()));
    public static final Item JUNGLE_SUPPORT = register("jungle_support", new DescriptionBlockItem(BBBBlocks.JUNGLE_SUPPORT, new FabricItemSettings()));
    public static final Item ACACIA_SUPPORT = register("acacia_support", new DescriptionBlockItem(BBBBlocks.ACACIA_SUPPORT, new FabricItemSettings()));
    public static final Item DARK_OAK_SUPPORT = register("dark_oak_support", new DescriptionBlockItem(BBBBlocks.DARK_OAK_SUPPORT, new FabricItemSettings()));
    public static final Item CRIMSON_SUPPORT = register("crimson_support", new DescriptionBlockItem(BBBBlocks.CRIMSON_SUPPORT, new FabricItemSettings()));
    public static final Item WARPED_SUPPORT = register("warped_support", new DescriptionBlockItem(BBBBlocks.WARPED_SUPPORT, new FabricItemSettings()));
    public static final Item MANGROVE_SUPPORT = register("mangrove_support", new DescriptionBlockItem(BBBBlocks.MANGROVE_SUPPORT, new FabricItemSettings()));
    public static final Item BAMBOO_SUPPORT = register("bamboo_support", new DescriptionBlockItem(BBBBlocks.BAMBOO_SUPPORT, new FabricItemSettings()));
    public static final Item CHERRY_SUPPORT = register("cherry_support", new DescriptionBlockItem(BBBBlocks.CHERRY_SUPPORT, new FabricItemSettings()));
    // endregion


    // region LADDERS
    public static final Item OAK_LADDER = register("oak_ladder", new DescriptionBlockItem(BBBBlocks.OAK_LADDER, new FabricItemSettings()));
    public static final Item SPRUCE_LADDER = register("spruce_ladder", new DescriptionBlockItem(BBBBlocks.SPRUCE_LADDER, new FabricItemSettings()));
    public static final Item BIRCH_LADDER = register("birch_ladder", new DescriptionBlockItem(BBBBlocks.BIRCH_LADDER, new FabricItemSettings()));
    public static final Item JUNGLE_LADDER = register("jungle_ladder", new DescriptionBlockItem(BBBBlocks.JUNGLE_LADDER, new FabricItemSettings()));
    public static final Item ACACIA_LADDER = register("acacia_ladder", new DescriptionBlockItem(BBBBlocks.ACACIA_LADDER, new FabricItemSettings()));
    public static final Item DARK_OAK_LADDER = register("dark_oak_ladder", new DescriptionBlockItem(BBBBlocks.DARK_OAK_LADDER, new FabricItemSettings()));
    public static final Item CRIMSON_LADDER = register("crimson_ladder", new DescriptionBlockItem(BBBBlocks.CRIMSON_LADDER, new FabricItemSettings()));
    public static final Item WARPED_LADDER = register("warped_ladder", new DescriptionBlockItem(BBBBlocks.WARPED_LADDER, new FabricItemSettings()));
    public static final Item MANGROVE_LADDER = register("mangrove_ladder", new DescriptionBlockItem(BBBBlocks.MANGROVE_LADDER, new FabricItemSettings()));
    public static final Item BAMBOO_LADDER = register("bamboo_ladder", new DescriptionBlockItem(BBBBlocks.BAMBOO_LADDER, new FabricItemSettings()));
    public static final Item CHERRY_LADDER = register("cherry_ladder", new DescriptionBlockItem(BBBBlocks.CHERRY_LADDER, new FabricItemSettings()));
    // endregion

    // region LAYERS
    public static final Item OAK_LAYER = register("oak_layer", new DescriptionBlockItem(BBBBlocks.OAK_LAYER, new FabricItemSettings()));
    public static final Item SPRUCE_LAYER = register("spruce_layer", new DescriptionBlockItem(BBBBlocks.SPRUCE_LAYER, new FabricItemSettings()));
    public static final Item BIRCH_LAYER = register("birch_layer", new DescriptionBlockItem(BBBBlocks.BIRCH_LAYER, new FabricItemSettings()));
    public static final Item JUNGLE_LAYER = register("jungle_layer", new DescriptionBlockItem(BBBBlocks.JUNGLE_LAYER, new FabricItemSettings()));
    public static final Item ACACIA_LAYER = register("acacia_layer", new DescriptionBlockItem(BBBBlocks.ACACIA_LAYER, new FabricItemSettings()));
    public static final Item DARK_OAK_LAYER = register("dark_oak_layer", new DescriptionBlockItem(BBBBlocks.DARK_OAK_LAYER, new FabricItemSettings()));
    public static final Item CRIMSON_LAYER = register("crimson_layer", new DescriptionBlockItem(BBBBlocks.CRIMSON_LAYER, new FabricItemSettings()));
    public static final Item WARPED_LAYER = register("warped_layer", new DescriptionBlockItem(BBBBlocks.WARPED_LAYER, new FabricItemSettings()));
    public static final Item MANGROVE_LAYER = register("mangrove_layer", new DescriptionBlockItem(BBBBlocks.MANGROVE_LAYER, new FabricItemSettings()));
    public static final Item BAMBOO_LAYER = register("bamboo_layer", new DescriptionBlockItem(BBBBlocks.BAMBOO_LAYER, new FabricItemSettings()));
    public static final Item BAMBOO_MOSAIC_LAYER = register("bamboo_mosaic_layer", new DescriptionBlockItem(BBBBlocks.BAMBOO_MOSAIC_LAYER, new FabricItemSettings()));
    public static final Item CHERRY_LAYER = register("cherry_layer", new DescriptionBlockItem(BBBBlocks.CHERRY_LAYER, new FabricItemSettings()));
    public static final Item STONE_LAYER = register("stone_layer", new DescriptionBlockItem(BBBBlocks.STONE_LAYER, new FabricItemSettings()));
    public static final Item COBBLESTONE_LAYER = register("cobblestone_layer", new DescriptionBlockItem(BBBBlocks.COBBLESTONE_LAYER, new FabricItemSettings()));
    public static final Item MOSSY_COBBLESTONE_LAYER = register("mossy_cobblestone_layer", new DescriptionBlockItem(BBBBlocks.MOSSY_COBBLESTONE_LAYER, new FabricItemSettings()));
    public static final Item SMOOTH_STONE_LAYER = register("smooth_stone_layer", new DescriptionBlockItem(BBBBlocks.SMOOTH_STONE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_STONE_LAYER = register("polished_stone_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_STONE_LAYER, new FabricItemSettings()));
    public static final Item STONE_TILE_LAYER = register("stone_tile_layer", new DescriptionBlockItem(BBBBlocks.STONE_TILE_LAYER, new FabricItemSettings()));
    public static final Item STONE_BRICK_LAYER = register("stone_brick_layer", new DescriptionBlockItem(BBBBlocks.STONE_BRICK_LAYER, new FabricItemSettings()));
    public static final Item MOSSY_STONE_BRICK_LAYER = register("mossy_stone_brick_layer", new DescriptionBlockItem(BBBBlocks.MOSSY_STONE_BRICK_LAYER, new FabricItemSettings()));
    public static final Item GRANITE_LAYER = register("granite_layer", new DescriptionBlockItem(BBBBlocks.GRANITE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_GRANITE_LAYER = register("polished_granite_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_GRANITE_LAYER, new FabricItemSettings()));
    public static final Item DIORITE_LAYER = register("diorite_layer", new DescriptionBlockItem(BBBBlocks.DIORITE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_DIORITE_LAYER = register("polished_diorite_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_DIORITE_LAYER, new FabricItemSettings()));
    public static final Item ANDESITE_LAYER = register("andesite_layer", new DescriptionBlockItem(BBBBlocks.ANDESITE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_ANDESITE_LAYER = register("polished_andesite_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_ANDESITE_LAYER, new FabricItemSettings()));
    public static final Item COBBLED_DEEPSLATE_LAYER = register("cobbled_deepslate_layer", new DescriptionBlockItem(BBBBlocks.COBBLED_DEEPSLATE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_DEEPSLATE_LAYER = register("polished_deepslate_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_DEEPSLATE_LAYER, new FabricItemSettings()));
    public static final Item DEEPSLATE_BRICK_LAYER = register("deepslate_brick_layer", new DescriptionBlockItem(BBBBlocks.DEEPSLATE_BRICK_LAYER, new FabricItemSettings()));
    public static final Item DEEPSLATE_TILE_LAYER = register("deepslate_tile_layer", new DescriptionBlockItem(BBBBlocks.DEEPSLATE_TILE_LAYER, new FabricItemSettings()));
    public static final Item BRICK_LAYER = register("brick_layer", new DescriptionBlockItem(BBBBlocks.BRICK_LAYER, new FabricItemSettings()));
    public static final Item MUD_BRICK_LAYER = register("mud_brick_layer", new DescriptionBlockItem(BBBBlocks.MUD_BRICK_LAYER, new FabricItemSettings()));
    public static final Item SANDSTONE_LAYER = register("sandstone_layer", new DescriptionBlockItem(BBBBlocks.SANDSTONE_LAYER, new FabricItemSettings()));
    public static final Item SMOOTH_SANDSTONE_LAYER = register("smooth_sandstone_layer", new DescriptionBlockItem(BBBBlocks.SMOOTH_SANDSTONE_LAYER, new FabricItemSettings()));
    public static final Item RED_SANDSTONE_LAYER = register("red_sandstone_layer", new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_LAYER, new FabricItemSettings()));
    public static final Item SMOOTH_RED_SANDSTONE_LAYER = register("smooth_red_sandstone_layer", new DescriptionBlockItem(BBBBlocks.SMOOTH_RED_SANDSTONE_LAYER, new FabricItemSettings()));
    public static final Item PRISMARINE_LAYER = register("prismarine_layer", new DescriptionBlockItem(BBBBlocks.PRISMARINE_LAYER, new FabricItemSettings()));
    public static final Item PRISMARINE_BRICK_LAYER = register("prismarine_brick_layer", new DescriptionBlockItem(BBBBlocks.PRISMARINE_BRICK_LAYER, new FabricItemSettings()));
    public static final Item DARK_PRISMARINE_LAYER = register("dark_prismarine_layer", new DescriptionBlockItem(BBBBlocks.DARK_PRISMARINE_LAYER, new FabricItemSettings()));
    public static final Item NETHER_BRICK_LAYER = register("nether_brick_layer", new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_LAYER, new FabricItemSettings()));
    public static final Item RED_NETHER_BRICK_LAYER = register("red_nether_brick_layer", new DescriptionBlockItem(BBBBlocks.RED_NETHER_BRICK_LAYER, new FabricItemSettings()));
    public static final Item BLACKSTONE_LAYER = register("blackstone_layer", new DescriptionBlockItem(BBBBlocks.BLACKSTONE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_BLACKSTONE_LAYER = register("polished_blackstone_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_BLACKSTONE_LAYER, new FabricItemSettings()));
    public static final Item POLISHED_BLACKSTONE_BRICK_LAYER = register("polished_blackstone_brick_layer", new DescriptionBlockItem(BBBBlocks.POLISHED_BLACKSTONE_BRICK_LAYER, new FabricItemSettings()));
    public static final Item END_STONE_BRICK_LAYER = register("end_stone_brick_layer", new DescriptionBlockItem(BBBBlocks.END_STONE_BRICK_LAYER, new FabricItemSettings()));
    public static final Item PURPUR_LAYER = register("purpur_layer", new DescriptionBlockItem(BBBBlocks.PURPUR_LAYER, new FabricItemSettings()));
    public static final Item QUARTZ_LAYER = register("quartz_layer", new DescriptionBlockItem(BBBBlocks.QUARTZ_LAYER, new FabricItemSettings()));
    public static final Item CUT_COPPER_LAYER = register("cut_copper_layer", new DescriptionBlockItem(BBBBlocks.CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item EXPOSED_CUT_COPPER_LAYER = register("exposed_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.EXPOSED_CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item WEATHERED_CUT_COPPER_LAYER = register("weathered_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.WEATHERED_CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item OXIDIZED_CUT_COPPER_LAYER = register("oxidized_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.OXIDIZED_CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item WAXED_CUT_COPPER_LAYER = register("waxed_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.WAXED_CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item WAXED_EXPOSED_CUT_COPPER_LAYER = register("waxed_exposed_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.WAXED_EXPOSED_CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item WAXED_WEATHERED_CUT_COPPER_LAYER = register("waxed_weathered_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.WAXED_WEATHERED_CUT_COPPER_LAYER, new FabricItemSettings()));
    public static final Item WAXED_OXIDIZED_CUT_COPPER_LAYER = register("waxed_oxidized_cut_copper_layer", new DescriptionBlockItem(BBBBlocks.WAXED_OXIDIZED_CUT_COPPER_LAYER, new FabricItemSettings()));

    // endregion
    

    public static final Item POLISHED_STONE = register("polished_stone", new BlockItem(BBBBlocks.POLISHED_STONE, new FabricItemSettings()));
    public static final Item POLISHED_STONE_STAIRS = register("polished_stone_stairs", new BlockItem(BBBBlocks.POLISHED_STONE_STAIRS, new FabricItemSettings()));
    public static final Item POLISHED_STONE_SLAB = register("polished_stone_slab", new BlockItem(BBBBlocks.POLISHED_STONE_SLAB, new FabricItemSettings()));

    public static final Item STONE_TILES = register("stone_tiles", new BlockItem(BBBBlocks.STONE_TILES, new FabricItemSettings()));
    public static final Item STONE_TILE_STAIRS = register("stone_tile_stairs", new BlockItem(BBBBlocks.STONE_TILE_STAIRS, new FabricItemSettings()));
    public static final Item STONE_TILE_SLAB = register("stone_tile_slab", new BlockItem(BBBBlocks.STONE_TILE_SLAB, new FabricItemSettings()));

    public static final Item BRAZIER = register("brazier", new BlockItem(BBBBlocks.BRAZIER, new FabricItemSettings()));
    public static final Item SOUL_BRAZIER = register("soul_brazier", new BlockItem(BBBBlocks.SOUL_BRAZIER, new FabricItemSettings()));


    // public static final Item ROOFING = register("roofing", new BlockItem(BBBBlocks.ROOFING, new FabricItemSettings()));


    // region PALLETS
    public static final Item OAK_PALLET = register("oak_pallet", new DescriptionBlockItem(BBBBlocks.OAK_PALLET, new FabricItemSettings()));
    public static final Item SPRUCE_PALLET = register("spruce_pallet", new DescriptionBlockItem(BBBBlocks.SPRUCE_PALLET, new FabricItemSettings()));
    public static final Item BIRCH_PALLET = register("birch_pallet", new DescriptionBlockItem(BBBBlocks.BIRCH_PALLET, new FabricItemSettings()));
    public static final Item JUNGLE_PALLET = register("jungle_pallet", new DescriptionBlockItem(BBBBlocks.JUNGLE_PALLET, new FabricItemSettings()));
    public static final Item ACACIA_PALLET = register("acacia_pallet", new DescriptionBlockItem(BBBBlocks.ACACIA_PALLET, new FabricItemSettings()));
    public static final Item DARK_OAK_PALLET = register("dark_oak_pallet", new DescriptionBlockItem(BBBBlocks.DARK_OAK_PALLET, new FabricItemSettings()));
    public static final Item MANGROVE_PALLET = register("mangrove_pallet", new DescriptionBlockItem(BBBBlocks.MANGROVE_PALLET, new FabricItemSettings()));
    public static final Item CHERRY_PALLET = register("cherry_pallet", new DescriptionBlockItem(BBBBlocks.CHERRY_PALLET, new FabricItemSettings()));
    public static final Item BAMBOO_PALLET = register("bamboo_pallet", new DescriptionBlockItem(BBBBlocks.BAMBOO_PALLET, new FabricItemSettings()));
    public static final Item CRIMSON_PALLET = register("crimson_pallet", new DescriptionBlockItem(BBBBlocks.CRIMSON_PALLET, new FabricItemSettings()));
    public static final Item WARPED_PALLET = register("warped_pallet", new DescriptionBlockItem(BBBBlocks.WARPED_PALLET, new FabricItemSettings()));
    // endregion

    // region FRAMES
    public static final Item OAK_FRAME = register("oak_frame", new DescriptionBlockItem(BBBBlocks.OAK_FRAME, new FabricItemSettings()));
    public static final Item SPRUCE_FRAME = register("spruce_frame", new DescriptionBlockItem(BBBBlocks.SPRUCE_FRAME, new FabricItemSettings()));
    public static final Item BIRCH_FRAME = register("birch_frame", new DescriptionBlockItem(BBBBlocks.BIRCH_FRAME, new FabricItemSettings()));
    public static final Item JUNGLE_FRAME = register("jungle_frame", new DescriptionBlockItem(BBBBlocks.JUNGLE_FRAME, new FabricItemSettings()));
    public static final Item ACACIA_FRAME = register("acacia_frame", new DescriptionBlockItem(BBBBlocks.ACACIA_FRAME, new FabricItemSettings()));
    public static final Item DARK_OAK_FRAME = register("dark_oak_frame", new DescriptionBlockItem(BBBBlocks.DARK_OAK_FRAME, new FabricItemSettings()));
    public static final Item MANGROVE_FRAME = register("mangrove_frame", new DescriptionBlockItem(BBBBlocks.MANGROVE_FRAME, new FabricItemSettings()));
    public static final Item CHERRY_FRAME = register("cherry_frame", new DescriptionBlockItem(BBBBlocks.CHERRY_FRAME, new FabricItemSettings()));
    public static final Item BAMBOO_FRAME = register("bamboo_frame", new DescriptionBlockItem(BBBBlocks.BAMBOO_FRAME, new FabricItemSettings()));
    public static final Item CRIMSON_FRAME = register("crimson_frame", new DescriptionBlockItem(BBBBlocks.CRIMSON_FRAME, new FabricItemSettings()));
    public static final Item WARPED_FRAME = register("warped_frame", new DescriptionBlockItem(BBBBlocks.WARPED_FRAME, new FabricItemSettings()));
    // endregion


    // public static final Item ROPE = register("rope", new BlockItem(BBBBlocks.ROPE, new FabricItemSettings()));

    // region WOODEN LANTERNS
    public static final Item OAK_LANTERN = register("oak_lantern", new BlockItem(BBBBlocks.OAK_LANTERN, new FabricItemSettings()));
    public static final Item SPRUCE_LANTERN = register("spruce_lantern", new BlockItem(BBBBlocks.SPRUCE_LANTERN, new FabricItemSettings()));
    public static final Item BIRCH_LANTERN = register("birch_lantern", new BlockItem(BBBBlocks.BIRCH_LANTERN, new FabricItemSettings()));
    public static final Item JUNGLE_LANTERN = register("jungle_lantern", new BlockItem(BBBBlocks.JUNGLE_LANTERN, new FabricItemSettings()));
    public static final Item ACACIA_LANTERN = register("acacia_lantern", new BlockItem(BBBBlocks.ACACIA_LANTERN, new FabricItemSettings()));
    public static final Item DARK_OAK_LANTERN = register("dark_oak_lantern", new BlockItem(BBBBlocks.DARK_OAK_LANTERN, new FabricItemSettings()));
    public static final Item MANGROVE_LANTERN = register("mangrove_lantern", new BlockItem(BBBBlocks.MANGROVE_LANTERN, new FabricItemSettings()));
    public static final Item CHERRY_LANTERN = register("cherry_lantern", new BlockItem(BBBBlocks.CHERRY_LANTERN, new FabricItemSettings()));
    public static final Item BAMBOO_LANTERN = register("bamboo_lantern", new BlockItem(BBBBlocks.BAMBOO_LANTERN, new FabricItemSettings()));
    public static final Item CRIMSON_LANTERN = register("crimson_lantern", new BlockItem(BBBBlocks.CRIMSON_LANTERN, new FabricItemSettings()));
    public static final Item WARPED_LANTERN = register("warped_lantern", new BlockItem(BBBBlocks.WARPED_LANTERN, new FabricItemSettings()));
    // endregion

    // region TRIMS

    public static final Item OAK_TRIM = register("oak_trim", new BlockItem(BBBBlocks.OAK_TRIM, new FabricItemSettings()));
    public static final Item SPRUCE_TRIM = register("spruce_trim", new BlockItem(BBBBlocks.SPRUCE_TRIM, new FabricItemSettings()));
    public static final Item BIRCH_TRIM = register("birch_trim", new BlockItem(BBBBlocks.BIRCH_TRIM, new FabricItemSettings()));
    public static final Item JUNGLE_TRIM = register("jungle_trim", new BlockItem(BBBBlocks.JUNGLE_TRIM, new FabricItemSettings()));
    public static final Item ACACIA_TRIM = register("acacia_trim", new BlockItem(BBBBlocks.ACACIA_TRIM, new FabricItemSettings()));
    public static final Item DARK_OAK_TRIM = register("dark_oak_trim", new BlockItem(BBBBlocks.DARK_OAK_TRIM, new FabricItemSettings()));
    public static final Item MANGROVE_TRIM = register("mangrove_trim", new BlockItem(BBBBlocks.MANGROVE_TRIM, new FabricItemSettings()));
    public static final Item CHERRY_TRIM = register("cherry_trim", new BlockItem(BBBBlocks.CHERRY_TRIM, new FabricItemSettings()));
    public static final Item BAMBOO_TRIM = register("bamboo_trim", new BlockItem(BBBBlocks.BAMBOO_TRIM, new FabricItemSettings()));
    public static final Item CRIMSON_TRIM = register("crimson_trim", new BlockItem(BBBBlocks.CRIMSON_TRIM, new FabricItemSettings()));
    public static final Item WARPED_TRIM = register("warped_trim", new BlockItem(BBBBlocks.WARPED_TRIM, new FabricItemSettings()));
    // endregion

    public static final Item IRON_FENCE = register("iron_fence", new BlockItem(BBBBlocks.IRON_FENCE, new FabricItemSettings()));


    //public static final Item TALL_OAK_DOOR = register("tall_oak_door", new TallDoorItem(BBBBlocks.TALL_OAK_DOOR, new FabricItemSettings()));

//    public static final Item COPPER_GATEWAY = register("copper_gateway", new BlockItem(BBBBlocks.COPPER_GATEWAY, new FabricItemSettings()));

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(BuildingButBetter.MOD_ID, id), item);
    }
}
