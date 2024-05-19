package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.item.DescriptionBlockItem;
import com.starfish_studios.bbb.item.HammerItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BBBItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BuildingButBetter.MOD_ID);

    public static final RegistryObject<Item> CORNERSTONE = ITEMS.register("bbb", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final RegistryObject<Item> STONE_BLOCK = ITEMS.register("stone_block", () -> new StandingAndWallBlockItem(BBBBlocks.STONE_BLOCK.get(), BBBBlocks.WALL_STONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> BLACKSTONE_BLOCK = ITEMS.register("blackstone_block", () -> new StandingAndWallBlockItem(BBBBlocks.BLACKSTONE_BLOCK.get(), BBBBlocks.WALL_BLACKSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEEPSLATE_BLOCK = ITEMS.register("deepslate_block", () -> new StandingAndWallBlockItem(BBBBlocks.DEEPSLATE_BLOCK.get(), BBBBlocks.WALL_DEEPSLATE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> NETHER_BRICK_BLOCK = ITEMS.register("nether_brick_block", () -> new StandingAndWallBlockItem(BBBBlocks.NETHER_BRICK_BLOCK.get(), BBBBlocks.WALL_NETHER_BRICK_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> SANDSTONE_BLOCK = ITEMS.register("sandstone_block", () -> new StandingAndWallBlockItem(BBBBlocks.SANDSTONE_BLOCK.get(), BBBBlocks.WALL_SANDSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> RED_SANDSTONE_BLOCK = ITEMS.register("red_sandstone_block", () -> new StandingAndWallBlockItem(BBBBlocks.RED_SANDSTONE_BLOCK.get(), BBBBlocks.WALL_RED_SANDSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> QUARTZ_BLOCK = ITEMS.register("quartz_block", () -> new StandingAndWallBlockItem(BBBBlocks.QUARTZ_BLOCK.get(), BBBBlocks.WALL_QUARTZ_BLOCK.get(), new Item.Properties(), Direction.DOWN));


    public static final RegistryObject<Item> OAK_WALL = ITEMS.register("oak_wall", () -> new BlockItem(BBBBlocks.OAK_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_WALL = ITEMS.register("spruce_wall", () -> new BlockItem(BBBBlocks.SPRUCE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_WALL = ITEMS.register("birch_wall", () -> new BlockItem(BBBBlocks.BIRCH_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_WALL = ITEMS.register("jungle_wall", () -> new BlockItem(BBBBlocks.JUNGLE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_WALL = ITEMS.register("acacia_wall", () -> new BlockItem(BBBBlocks.ACACIA_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_WALL = ITEMS.register("dark_oak_wall", () -> new BlockItem(BBBBlocks.DARK_OAK_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_WALL = ITEMS.register("crimson_wall", () -> new BlockItem(BBBBlocks.CRIMSON_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_WALL = ITEMS.register("warped_wall", () -> new BlockItem(BBBBlocks.WARPED_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_WALL = ITEMS.register("mangrove_wall", () -> new BlockItem(BBBBlocks.MANGROVE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_WALL = ITEMS.register("bamboo_wall", () -> new BlockItem(BBBBlocks.BAMBOO_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_WALL = ITEMS.register("cherry_wall", () -> new BlockItem(BBBBlocks.CHERRY_WALL.get(), new Item.Properties()));


    public static final RegistryObject<Item> STONE_URN = ITEMS.register("stone_urn", () -> new DescriptionBlockItem(BBBBlocks.STONE_URN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_URN = ITEMS.register("blackstone_urn", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_URN.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_URN = ITEMS.register("deepslate_urn", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_URN.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_BRICK_URN = ITEMS.register("nether_brick_urn", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_URN.get(), new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_URN = ITEMS.register("sandstone_urn", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_URN.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_SANDSTONE_URN = ITEMS.register("red_sandstone_urn", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_URN.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_URN = ITEMS.register("quartz_urn", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_URN.get(), new Item.Properties()));


    public static final RegistryObject<Item> STONE_MOULDING = ITEMS.register("stone_moulding", () -> new DescriptionBlockItem(BBBBlocks.STONE_MOULDING.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_MOULDING = ITEMS.register("blackstone_moulding", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_MOULDING.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_MOULDING = ITEMS.register("deepslate_moulding", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_MOULDING.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_BRICK_MOULDING = ITEMS.register("nether_brick_moulding", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_MOULDING.get(), new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_MOULDING = ITEMS.register("sandstone_moulding", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_MOULDING.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_SANDSTONE_MOULDING = ITEMS.register("red_sandstone_moulding", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_MOULDING.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_MOULDING = ITEMS.register("quartz_moulding", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_MOULDING.get(), new Item.Properties()));


    public static final RegistryObject<Item> STONE_COLUMN = ITEMS.register("stone_column", () -> new DescriptionBlockItem(BBBBlocks.STONE_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_COLUMN = ITEMS.register("deepslate_column", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_COLUMN = ITEMS.register("sandstone_column", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_SANDSTONE_COLUMN = ITEMS.register("red_sandstone_column", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_BRICK_COLUMN = ITEMS.register("nether_brick_column", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_COLUMN = ITEMS.register("blackstone_column", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_COLUMN = ITEMS.register("quartz_column", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_COLUMN.get(), new Item.Properties()));



    public static final RegistryObject<Item> STONE_FENCE = ITEMS.register("stone_fence", () -> new DescriptionBlockItem(BBBBlocks.STONE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_FENCE = ITEMS.register("blackstone_fence", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_FENCE = ITEMS.register("deepslate_fence", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_BRICK_FENCE = ITEMS.register("nether_brick_fence", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_FENCE = ITEMS.register("sandstone_fence", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_SANDSTONE_FENCE = ITEMS.register("red_sandstone_fence", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_FENCE = ITEMS.register("quartz_fence", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_FENCE.get(), new Item.Properties()));



    // region BEAMS
    public static final RegistryObject<Item> OAK_BEAM = ITEMS.register("oak_beam", () -> new BlockItem(BBBBlocks.OAK_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> OAK_BEAM_STAIRS = ITEMS.register("oak_beam_stairs", () -> new BlockItem(BBBBlocks.OAK_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> OAK_BEAM_SLAB = ITEMS.register("oak_beam_slab", () -> new BlockItem(BBBBlocks.OAK_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_BEAM = ITEMS.register("spruce_beam", () -> new BlockItem(BBBBlocks.SPRUCE_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_BEAM_STAIRS = ITEMS.register("spruce_beam_stairs", () -> new BlockItem(BBBBlocks.SPRUCE_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_BEAM_SLAB = ITEMS.register("spruce_beam_slab", () -> new BlockItem(BBBBlocks.SPRUCE_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_BEAM = ITEMS.register("birch_beam", () -> new BlockItem(BBBBlocks.BIRCH_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_BEAM_STAIRS = ITEMS.register("birch_beam_stairs", () -> new BlockItem(BBBBlocks.BIRCH_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_BEAM_SLAB = ITEMS.register("birch_beam_slab", () -> new BlockItem(BBBBlocks.BIRCH_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_BEAM = ITEMS.register("jungle_beam", () -> new BlockItem(BBBBlocks.JUNGLE_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_BEAM_STAIRS = ITEMS.register("jungle_beam_stairs", () -> new BlockItem(BBBBlocks.JUNGLE_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_BEAM_SLAB = ITEMS.register("jungle_beam_slab", () -> new BlockItem(BBBBlocks.JUNGLE_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_BEAM = ITEMS.register("acacia_beam", () -> new BlockItem(BBBBlocks.ACACIA_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_BEAM_STAIRS = ITEMS.register("acacia_beam_stairs", () -> new BlockItem(BBBBlocks.ACACIA_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_BEAM_SLAB = ITEMS.register("acacia_beam_slab", () -> new BlockItem(BBBBlocks.ACACIA_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_BEAM = ITEMS.register("dark_oak_beam", () -> new BlockItem(BBBBlocks.DARK_OAK_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_BEAM_STAIRS = ITEMS.register("dark_oak_beam_stairs", () -> new BlockItem(BBBBlocks.DARK_OAK_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_BEAM_SLAB = ITEMS.register("dark_oak_beam_slab", () -> new BlockItem(BBBBlocks.DARK_OAK_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_BEAM = ITEMS.register("crimson_beam", () -> new BlockItem(BBBBlocks.CRIMSON_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_BEAM_STAIRS = ITEMS.register("crimson_beam_stairs", () -> new BlockItem(BBBBlocks.CRIMSON_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_BEAM_SLAB = ITEMS.register("crimson_beam_slab", () -> new BlockItem(BBBBlocks.CRIMSON_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_BEAM = ITEMS.register("warped_beam", () -> new BlockItem(BBBBlocks.WARPED_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_BEAM_STAIRS = ITEMS.register("warped_beam_stairs", () -> new BlockItem(BBBBlocks.WARPED_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_BEAM_SLAB = ITEMS.register("warped_beam_slab", () -> new BlockItem(BBBBlocks.WARPED_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_BEAM = ITEMS.register("mangrove_beam", () -> new BlockItem(BBBBlocks.MANGROVE_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_BEAM_STAIRS = ITEMS.register("mangrove_beam_stairs", () -> new BlockItem(BBBBlocks.MANGROVE_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_BEAM_SLAB = ITEMS.register("mangrove_beam_slab", () -> new BlockItem(BBBBlocks.MANGROVE_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_BEAM = ITEMS.register("bamboo_beam", () -> new BlockItem(BBBBlocks.BAMBOO_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_BEAM_STAIRS = ITEMS.register("bamboo_beam_stairs", () -> new BlockItem(BBBBlocks.BAMBOO_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_BEAM_SLAB = ITEMS.register("bamboo_beam_slab", () -> new BlockItem(BBBBlocks.BAMBOO_BEAM_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_BEAM = ITEMS.register("cherry_beam", () -> new BlockItem(BBBBlocks.CHERRY_BEAM.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_BEAM_STAIRS = ITEMS.register("cherry_beam_stairs", () -> new BlockItem(BBBBlocks.CHERRY_BEAM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_BEAM_SLAB = ITEMS.register("cherry_beam_slab", () -> new BlockItem(BBBBlocks.CHERRY_BEAM_SLAB.get(), new Item.Properties()));
    // endregion

    // region SUPPORTS
    public static final RegistryObject<Item> OAK_SUPPORT = ITEMS.register("oak_support", () -> new DescriptionBlockItem(BBBBlocks.OAK_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_SUPPORT = ITEMS.register("spruce_support", () -> new DescriptionBlockItem(BBBBlocks.SPRUCE_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_SUPPORT = ITEMS.register("birch_support", () -> new DescriptionBlockItem(BBBBlocks.BIRCH_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_SUPPORT = ITEMS.register("jungle_support", () -> new DescriptionBlockItem(BBBBlocks.JUNGLE_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_SUPPORT = ITEMS.register("acacia_support", () -> new DescriptionBlockItem(BBBBlocks.ACACIA_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_SUPPORT = ITEMS.register("dark_oak_support", () -> new DescriptionBlockItem(BBBBlocks.DARK_OAK_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_SUPPORT = ITEMS.register("crimson_support", () -> new DescriptionBlockItem(BBBBlocks.CRIMSON_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_SUPPORT = ITEMS.register("warped_support", () -> new DescriptionBlockItem(BBBBlocks.WARPED_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_SUPPORT = ITEMS.register("mangrove_support", () -> new DescriptionBlockItem(BBBBlocks.MANGROVE_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_SUPPORT = ITEMS.register("bamboo_support", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_SUPPORT.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_SUPPORT = ITEMS.register("cherry_support", () -> new DescriptionBlockItem(BBBBlocks.CHERRY_SUPPORT.get(), new Item.Properties()));
    // endregion


    // region LADDERS
    public static final RegistryObject<Item> OAK_LADDER = ITEMS.register("oak_ladder", () -> new DescriptionBlockItem(BBBBlocks.OAK_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_LADDER = ITEMS.register("spruce_ladder", () -> new DescriptionBlockItem(BBBBlocks.SPRUCE_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_LADDER = ITEMS.register("birch_ladder", () -> new DescriptionBlockItem(BBBBlocks.BIRCH_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_LADDER = ITEMS.register("jungle_ladder", () -> new DescriptionBlockItem(BBBBlocks.JUNGLE_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_LADDER = ITEMS.register("acacia_ladder", () -> new DescriptionBlockItem(BBBBlocks.ACACIA_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_LADDER = ITEMS.register("dark_oak_ladder", () -> new DescriptionBlockItem(BBBBlocks.DARK_OAK_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_LADDER = ITEMS.register("crimson_ladder", () -> new DescriptionBlockItem(BBBBlocks.CRIMSON_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_LADDER = ITEMS.register("warped_ladder", () -> new DescriptionBlockItem(BBBBlocks.WARPED_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_LADDER = ITEMS.register("mangrove_ladder", () -> new DescriptionBlockItem(BBBBlocks.MANGROVE_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_LADDER = ITEMS.register("bamboo_ladder", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_LADDER = ITEMS.register("cherry_ladder", () -> new DescriptionBlockItem(BBBBlocks.CHERRY_LADDER.get(), new Item.Properties()));
    // endregion

    // region LAYERS
    public static final RegistryObject<Item> OAK_LAYER = ITEMS.register("oak_layer", () -> new DescriptionBlockItem(BBBBlocks.OAK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_LAYER = ITEMS.register("spruce_layer", () -> new DescriptionBlockItem(BBBBlocks.SPRUCE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_LAYER = ITEMS.register("birch_layer", () -> new DescriptionBlockItem(BBBBlocks.BIRCH_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_LAYER = ITEMS.register("jungle_layer", () -> new DescriptionBlockItem(BBBBlocks.JUNGLE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_LAYER = ITEMS.register("acacia_layer", () -> new DescriptionBlockItem(BBBBlocks.ACACIA_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_LAYER = ITEMS.register("dark_oak_layer", () -> new DescriptionBlockItem(BBBBlocks.DARK_OAK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_LAYER = ITEMS.register("crimson_layer", () -> new DescriptionBlockItem(BBBBlocks.CRIMSON_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_LAYER = ITEMS.register("warped_layer", () -> new DescriptionBlockItem(BBBBlocks.WARPED_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_LAYER = ITEMS.register("mangrove_layer", () -> new DescriptionBlockItem(BBBBlocks.MANGROVE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_LAYER = ITEMS.register("bamboo_layer", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_MOSAIC_LAYER = ITEMS.register("bamboo_mosaic_layer", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_MOSAIC_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_LAYER = ITEMS.register("cherry_layer", () -> new DescriptionBlockItem(BBBBlocks.CHERRY_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> MOSS_LAYER = ITEMS.register("moss_layer", () -> new DescriptionBlockItem(BBBBlocks.MOSS_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_LAYER = ITEMS.register("stone_layer", () -> new DescriptionBlockItem(BBBBlocks.STONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> COBBLESTONE_LAYER = ITEMS.register("cobblestone_layer", () -> new DescriptionBlockItem(BBBBlocks.COBBLESTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> MOSSY_COBBLESTONE_LAYER = ITEMS.register("mossy_cobblestone_layer", () -> new DescriptionBlockItem(BBBBlocks.MOSSY_COBBLESTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_STONE_LAYER = ITEMS.register("smooth_stone_layer", () -> new DescriptionBlockItem(BBBBlocks.SMOOTH_STONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_STONE_LAYER = ITEMS.register("polished_stone_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_STONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_TILE_LAYER = ITEMS.register("stone_tile_layer", () -> new DescriptionBlockItem(BBBBlocks.STONE_TILE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_BRICK_LAYER = ITEMS.register("stone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.STONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> MOSSY_STONE_BRICK_LAYER = ITEMS.register("mossy_stone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.MOSSY_STONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> GRANITE_LAYER = ITEMS.register("granite_layer", () -> new DescriptionBlockItem(BBBBlocks.GRANITE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_GRANITE_LAYER = ITEMS.register("polished_granite_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_GRANITE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DIORITE_LAYER = ITEMS.register("diorite_layer", () -> new DescriptionBlockItem(BBBBlocks.DIORITE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_DIORITE_LAYER = ITEMS.register("polished_diorite_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_DIORITE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANDESITE_LAYER = ITEMS.register("andesite_layer", () -> new DescriptionBlockItem(BBBBlocks.ANDESITE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_ANDESITE_LAYER = ITEMS.register("polished_andesite_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_ANDESITE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> COBBLED_DEEPSLATE_LAYER = ITEMS.register("cobbled_deepslate_layer", () -> new DescriptionBlockItem(BBBBlocks.COBBLED_DEEPSLATE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_DEEPSLATE_LAYER = ITEMS.register("polished_deepslate_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_DEEPSLATE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_BRICK_LAYER = ITEMS.register("deepslate_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_TILE_LAYER = ITEMS.register("deepslate_tile_layer", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_TILE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BRICK_LAYER = ITEMS.register("brick_layer", () -> new DescriptionBlockItem(BBBBlocks.BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> MUD_BRICK_LAYER = ITEMS.register("mud_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.MUD_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_LAYER = ITEMS.register("sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_SANDSTONE_LAYER = ITEMS.register("smooth_sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.SMOOTH_SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_SANDSTONE_LAYER = ITEMS.register("red_sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_RED_SANDSTONE_LAYER = ITEMS.register("smooth_red_sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.SMOOTH_RED_SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> PRISMARINE_LAYER = ITEMS.register("prismarine_layer", () -> new DescriptionBlockItem(BBBBlocks.PRISMARINE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> PRISMARINE_BRICK_LAYER = ITEMS.register("prismarine_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.PRISMARINE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_PRISMARINE_LAYER = ITEMS.register("dark_prismarine_layer", () -> new DescriptionBlockItem(BBBBlocks.DARK_PRISMARINE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_BRICK_LAYER = ITEMS.register("nether_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_NETHER_BRICK_LAYER = ITEMS.register("red_nether_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.RED_NETHER_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_LAYER = ITEMS.register("blackstone_layer", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_BLACKSTONE_LAYER = ITEMS.register("polished_blackstone_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_BLACKSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_BLACKSTONE_BRICK_LAYER = ITEMS.register("polished_blackstone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_BLACKSTONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> END_STONE_BRICK_LAYER = ITEMS.register("end_stone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.END_STONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> PURPUR_LAYER = ITEMS.register("purpur_layer", () -> new DescriptionBlockItem(BBBBlocks.PURPUR_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_LAYER = ITEMS.register("quartz_layer", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> CUT_COPPER_LAYER = ITEMS.register("cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> EXPOSED_CUT_COPPER_LAYER = ITEMS.register("exposed_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_CUT_COPPER_LAYER = ITEMS.register("weathered_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> OXIDIZED_CUT_COPPER_LAYER = ITEMS.register("oxidized_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.OXIDIZED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_CUT_COPPER_LAYER = ITEMS.register("waxed_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_EXPOSED_CUT_COPPER_LAYER = ITEMS.register("waxed_exposed_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_EXPOSED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_WEATHERED_CUT_COPPER_LAYER = ITEMS.register("waxed_weathered_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_WEATHERED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_OXIDIZED_CUT_COPPER_LAYER = ITEMS.register("waxed_oxidized_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_OXIDIZED_CUT_COPPER_LAYER.get(), new Item.Properties()));

    // endregion
    

    public static final RegistryObject<Item> POLISHED_STONE = ITEMS.register("polished_stone", () -> new BlockItem(BBBBlocks.POLISHED_STONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_STONE_STAIRS = ITEMS.register("polished_stone_stairs", () -> new BlockItem(BBBBlocks.POLISHED_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_STONE_SLAB = ITEMS.register("polished_stone_slab", () -> new BlockItem(BBBBlocks.POLISHED_STONE_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<Item> STONE_TILES = ITEMS.register("stone_tiles", () -> new BlockItem(BBBBlocks.STONE_TILES.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_TILE_STAIRS = ITEMS.register("stone_tile_stairs", () -> new BlockItem(BBBBlocks.STONE_TILE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_TILE_SLAB = ITEMS.register("stone_tile_slab", () -> new BlockItem(BBBBlocks.STONE_TILE_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<Item> BRAZIER = ITEMS.register("brazier", () -> new BlockItem(BBBBlocks.BRAZIER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_BRAZIER = ITEMS.register("soul_brazier", () -> new BlockItem(BBBBlocks.SOUL_BRAZIER.get(), new Item.Properties()));


    // public static final RegistryObject<Item> ROOFING = ITEMS.register("roofing", () -> new BlockItem(BBBBlocks.ROOFING.get(), new Item.Properties()));


    // region PALLETS
    public static final RegistryObject<Item> OAK_PALLET = ITEMS.register("oak_pallet", () -> new DescriptionBlockItem(BBBBlocks.OAK_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_PALLET = ITEMS.register("spruce_pallet", () -> new DescriptionBlockItem(BBBBlocks.SPRUCE_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_PALLET = ITEMS.register("birch_pallet", () -> new DescriptionBlockItem(BBBBlocks.BIRCH_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_PALLET = ITEMS.register("jungle_pallet", () -> new DescriptionBlockItem(BBBBlocks.JUNGLE_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_PALLET = ITEMS.register("acacia_pallet", () -> new DescriptionBlockItem(BBBBlocks.ACACIA_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_PALLET = ITEMS.register("dark_oak_pallet", () -> new DescriptionBlockItem(BBBBlocks.DARK_OAK_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_PALLET = ITEMS.register("mangrove_pallet", () -> new DescriptionBlockItem(BBBBlocks.MANGROVE_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_PALLET = ITEMS.register("cherry_pallet", () -> new DescriptionBlockItem(BBBBlocks.CHERRY_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_PALLET = ITEMS.register("bamboo_pallet", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_PALLET = ITEMS.register("crimson_pallet", () -> new DescriptionBlockItem(BBBBlocks.CRIMSON_PALLET.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_PALLET = ITEMS.register("warped_pallet", () -> new DescriptionBlockItem(BBBBlocks.WARPED_PALLET.get(), new Item.Properties()));
    // endregion

    // region FRAMES
    public static final RegistryObject<Item> OAK_FRAME = ITEMS.register("oak_frame", () -> new DescriptionBlockItem(BBBBlocks.OAK_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_FRAME = ITEMS.register("spruce_frame", () -> new DescriptionBlockItem(BBBBlocks.SPRUCE_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_FRAME = ITEMS.register("birch_frame", () -> new DescriptionBlockItem(BBBBlocks.BIRCH_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_FRAME = ITEMS.register("jungle_frame", () -> new DescriptionBlockItem(BBBBlocks.JUNGLE_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_FRAME = ITEMS.register("acacia_frame", () -> new DescriptionBlockItem(BBBBlocks.ACACIA_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_FRAME = ITEMS.register("dark_oak_frame", () -> new DescriptionBlockItem(BBBBlocks.DARK_OAK_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_FRAME = ITEMS.register("mangrove_frame", () -> new DescriptionBlockItem(BBBBlocks.MANGROVE_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_FRAME = ITEMS.register("cherry_frame", () -> new DescriptionBlockItem(BBBBlocks.CHERRY_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_FRAME = ITEMS.register("bamboo_frame", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_FRAME = ITEMS.register("crimson_frame", () -> new DescriptionBlockItem(BBBBlocks.CRIMSON_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_FRAME = ITEMS.register("warped_frame", () -> new DescriptionBlockItem(BBBBlocks.WARPED_FRAME.get(), new Item.Properties()));
    // endregion


     public static final RegistryObject<Item> ROPE = ITEMS.register("rope", () -> new BlockItem(BBBBlocks.ROPE.get(), new Item.Properties()));

    // region WOODEN LANTERNS
    public static final RegistryObject<Item> OAK_LANTERN = ITEMS.register("oak_lantern", () -> new DescriptionBlockItem(BBBBlocks.OAK_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_LANTERN = ITEMS.register("spruce_lantern", () -> new DescriptionBlockItem(BBBBlocks.SPRUCE_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_LANTERN = ITEMS.register("birch_lantern", () -> new DescriptionBlockItem(BBBBlocks.BIRCH_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_LANTERN = ITEMS.register("jungle_lantern", () -> new DescriptionBlockItem(BBBBlocks.JUNGLE_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_LANTERN = ITEMS.register("acacia_lantern", () -> new DescriptionBlockItem(BBBBlocks.ACACIA_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_LANTERN = ITEMS.register("dark_oak_lantern", () -> new DescriptionBlockItem(BBBBlocks.DARK_OAK_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_LANTERN = ITEMS.register("mangrove_lantern", () -> new DescriptionBlockItem(BBBBlocks.MANGROVE_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_LANTERN = ITEMS.register("cherry_lantern", () -> new DescriptionBlockItem(BBBBlocks.CHERRY_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_LANTERN = ITEMS.register("bamboo_lantern", () -> new DescriptionBlockItem(BBBBlocks.BAMBOO_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_LANTERN = ITEMS.register("crimson_lantern", () -> new DescriptionBlockItem(BBBBlocks.CRIMSON_LANTERN.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_LANTERN = ITEMS.register("warped_lantern", () -> new DescriptionBlockItem(BBBBlocks.WARPED_LANTERN.get(), new Item.Properties()));
    // endregion

    // region TRIMS

    public static final RegistryObject<Item> OAK_TRIM = ITEMS.register("oak_trim", () -> new BlockItem(BBBBlocks.OAK_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_TRIM = ITEMS.register("spruce_trim", () -> new BlockItem(BBBBlocks.SPRUCE_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_TRIM = ITEMS.register("birch_trim", () -> new BlockItem(BBBBlocks.BIRCH_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_TRIM = ITEMS.register("jungle_trim", () -> new BlockItem(BBBBlocks.JUNGLE_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_TRIM = ITEMS.register("acacia_trim", () -> new BlockItem(BBBBlocks.ACACIA_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_TRIM = ITEMS.register("dark_oak_trim", () -> new BlockItem(BBBBlocks.DARK_OAK_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_TRIM = ITEMS.register("mangrove_trim", () -> new BlockItem(BBBBlocks.MANGROVE_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_TRIM = ITEMS.register("cherry_trim", () -> new BlockItem(BBBBlocks.CHERRY_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_TRIM = ITEMS.register("bamboo_trim", () -> new BlockItem(BBBBlocks.BAMBOO_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_TRIM = ITEMS.register("crimson_trim", () -> new BlockItem(BBBBlocks.CRIMSON_TRIM.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_TRIM = ITEMS.register("warped_trim", () -> new BlockItem(BBBBlocks.WARPED_TRIM.get(), new Item.Properties()));
    // endregion

    public static final RegistryObject<Item> IRON_FENCE = ITEMS.register("iron_fence", () -> new BlockItem(BBBBlocks.IRON_FENCE.get(), new Item.Properties()));


    //public static final RegistryObject<Item> TALL_OAK_DOOR = ITEMS.register("tall_oak_door", () -> new TallDoorItem(BBBBlocks.TALL_OAK_DOOR.get(), new Item.Properties()));

//    public static final RegistryObject<Item> COPPER_GATEWAY = ITEMS.register("copper_gateway", () -> new BlockItem(BBBBlocks.COPPER_GATEWAY.get(), new Item.Properties()));

}
