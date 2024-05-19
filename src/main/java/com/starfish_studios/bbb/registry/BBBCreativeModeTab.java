package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.ACACIA_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.ANDESITE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_MOSAIC_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.BAMBOO_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.BIRCH_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.BLACKSTONE_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.BLACKSTONE_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.BLACKSTONE_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.BLACKSTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.BLACKSTONE_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.BLACKSTONE_URN;
import static com.starfish_studios.bbb.registry.BBBItems.BRAZIER;
import static com.starfish_studios.bbb.registry.BBBItems.BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.CHERRY_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.COBBLED_DEEPSLATE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.COBBLESTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.CORNERSTONE;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.CRIMSON_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_OAK_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.DARK_PRISMARINE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_TILE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.DEEPSLATE_URN;
import static com.starfish_studios.bbb.registry.BBBItems.DIORITE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.END_STONE_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.EXPOSED_CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.GRANITE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.HAMMER;
import static com.starfish_studios.bbb.registry.BBBItems.IRON_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.JUNGLE_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.MANGROVE_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.MOSSY_COBBLESTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.MOSSY_STONE_BRICK_LAYER;
//import static com.starfish_studios.bbb.registry.BBBItems.MOSS_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.MUD_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.NETHER_BRICK_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.NETHER_BRICK_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.NETHER_BRICK_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.NETHER_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.NETHER_BRICK_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.NETHER_BRICK_URN;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.OAK_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.OXIDIZED_CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_ANDESITE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_BLACKSTONE_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_BLACKSTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_DEEPSLATE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_DIORITE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_GRANITE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_STONE;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_STONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_STONE_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.POLISHED_STONE_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.PRISMARINE_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.PRISMARINE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.PURPUR_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.QUARTZ_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.QUARTZ_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.QUARTZ_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.QUARTZ_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.QUARTZ_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.QUARTZ_URN;
import static com.starfish_studios.bbb.registry.BBBItems.RED_NETHER_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.RED_SANDSTONE_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.RED_SANDSTONE_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.RED_SANDSTONE_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.RED_SANDSTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.RED_SANDSTONE_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.RED_SANDSTONE_URN;
import static com.starfish_studios.bbb.registry.BBBItems.ROPE;
import static com.starfish_studios.bbb.registry.BBBItems.SANDSTONE_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.SANDSTONE_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.SANDSTONE_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.SANDSTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.SANDSTONE_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.SANDSTONE_URN;
import static com.starfish_studios.bbb.registry.BBBItems.SMOOTH_RED_SANDSTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.SMOOTH_SANDSTONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.SMOOTH_STONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.SOUL_BRAZIER;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.SPRUCE_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_BLOCK;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_BRICK_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_COLUMN;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_FENCE;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_MOULDING;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_TILES;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_TILE_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_TILE_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_TILE_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.STONE_URN;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_BEAM;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_BEAM_SLAB;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_BEAM_STAIRS;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_FRAME;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_LADDER;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_LANTERN;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_PALLET;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_SUPPORT;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_TRIM;
import static com.starfish_studios.bbb.registry.BBBItems.WARPED_WALL;
import static com.starfish_studios.bbb.registry.BBBItems.WAXED_CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.WAXED_EXPOSED_CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.WAXED_OXIDIZED_CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.WAXED_WEATHERED_CUT_COPPER_LAYER;
import static com.starfish_studios.bbb.registry.BBBItems.WEATHERED_CUT_COPPER_LAYER;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BBBCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuildingButBetter.MOD_ID);

    @SuppressWarnings("unused") 
    public static final RegistryObject<CreativeModeTab> ITEM_GROUP = CREATIVE_MODE_TABS.register("item_group", () -> CreativeModeTab.builder().icon(CORNERSTONE.get()::getDefaultInstance).title(Component.translatable("itemGroup.bbb.tab")).displayItems((featureFlagSet, output) -> {

        output.accept(HAMMER.get());
        output.accept(ROPE.get());

        // output.accept(PLASTER.get());

        // output.accept(COPPER_GATEWAY.get());

        output.accept(BRAZIER.get());
        output.accept(SOUL_BRAZIER.get());
        output.accept(IRON_FENCE.get());

        output.accept(POLISHED_STONE.get());
        output.accept(POLISHED_STONE_STAIRS.get());
        output.accept(POLISHED_STONE_SLAB.get());
        output.accept(STONE_TILES.get());
        output.accept(STONE_TILE_STAIRS.get());
        output.accept(STONE_TILE_SLAB.get());
        output.accept(STONE_COLUMN.get());
        output.accept(STONE_URN.get());
        output.accept(STONE_FENCE.get());
        output.accept(STONE_MOULDING.get());
        output.accept(STONE_BLOCK.get());

        output.accept(BLACKSTONE_COLUMN.get());
        output.accept(BLACKSTONE_URN.get());
        output.accept(BLACKSTONE_FENCE.get());
        output.accept(BLACKSTONE_MOULDING.get());
        output.accept(BLACKSTONE_BLOCK.get());

        output.accept(SANDSTONE_COLUMN.get());
        output.accept(SANDSTONE_URN.get());
        output.accept(SANDSTONE_FENCE.get());
        output.accept(SANDSTONE_MOULDING.get());
        output.accept(SANDSTONE_BLOCK.get());

        output.accept(RED_SANDSTONE_COLUMN.get());
        output.accept(RED_SANDSTONE_URN.get());
        output.accept(RED_SANDSTONE_FENCE.get());
        output.accept(RED_SANDSTONE_MOULDING.get());
        output.accept(RED_SANDSTONE_BLOCK.get());

        output.accept(QUARTZ_COLUMN.get());
        output.accept(QUARTZ_URN.get());
        output.accept(QUARTZ_FENCE.get());
        output.accept(QUARTZ_MOULDING.get());
        output.accept(QUARTZ_BLOCK.get());

        output.accept(DEEPSLATE_COLUMN.get());
        output.accept(DEEPSLATE_URN.get());
        output.accept(DEEPSLATE_FENCE.get());
        output.accept(DEEPSLATE_MOULDING.get());
        output.accept(DEEPSLATE_BLOCK.get());

        output.accept(NETHER_BRICK_COLUMN.get());
        output.accept(NETHER_BRICK_URN.get());
        output.accept(NETHER_BRICK_FENCE.get());
        output.accept(NETHER_BRICK_MOULDING.get());
        output.accept(NETHER_BRICK_BLOCK.get());


        // output.accept(BIG_DOOR.get());


        output.accept(OAK_TRIM.get());
        output.accept(OAK_BEAM.get());
        output.accept(OAK_BEAM_STAIRS.get());
        output.accept(OAK_BEAM_SLAB.get());
        output.accept(OAK_SUPPORT.get());
        output.accept(OAK_FRAME.get());
        output.accept(OAK_PALLET.get());
        output.accept(OAK_WALL.get());
        output.accept(OAK_LANTERN.get());
        output.accept(OAK_LADDER.get());

        output.accept(SPRUCE_TRIM.get());
        output.accept(SPRUCE_BEAM.get());
        output.accept(SPRUCE_BEAM_STAIRS.get());
        output.accept(SPRUCE_BEAM_SLAB.get());
        output.accept(SPRUCE_SUPPORT.get());
        output.accept(SPRUCE_FRAME.get());
        output.accept(SPRUCE_WALL.get());
        output.accept(SPRUCE_LANTERN.get());
        output.accept(SPRUCE_PALLET.get());
        output.accept(SPRUCE_LADDER.get());

        output.accept(BIRCH_TRIM.get());
        output.accept(BIRCH_BEAM.get());
        output.accept(BIRCH_BEAM_STAIRS.get());
        output.accept(BIRCH_BEAM_SLAB.get());
        output.accept(BIRCH_SUPPORT.get());
        output.accept(BIRCH_FRAME.get());
        output.accept(BIRCH_WALL.get());
        output.accept(BIRCH_LANTERN.get());
        output.accept(BIRCH_PALLET.get());
        output.accept(BIRCH_LADDER.get());

        output.accept(JUNGLE_TRIM.get());
        output.accept(JUNGLE_BEAM.get());
        output.accept(JUNGLE_BEAM_STAIRS.get());
        output.accept(JUNGLE_BEAM_SLAB.get());
        output.accept(JUNGLE_SUPPORT.get());
        output.accept(JUNGLE_FRAME.get());
        output.accept(JUNGLE_WALL.get());
        output.accept(JUNGLE_LANTERN.get());
        output.accept(JUNGLE_PALLET.get());
        output.accept(JUNGLE_LADDER.get());

        output.accept(ACACIA_TRIM.get());
        output.accept(ACACIA_BEAM.get());
        output.accept(ACACIA_BEAM_STAIRS.get());
        output.accept(ACACIA_BEAM_SLAB.get());
        output.accept(ACACIA_SUPPORT.get());
        output.accept(ACACIA_FRAME.get());
        output.accept(ACACIA_WALL.get());
        output.accept(ACACIA_LANTERN.get());
        output.accept(ACACIA_PALLET.get());
        output.accept(ACACIA_LADDER.get());

        output.accept(DARK_OAK_TRIM.get());
        output.accept(DARK_OAK_BEAM.get());
        output.accept(DARK_OAK_BEAM_STAIRS.get());
        output.accept(DARK_OAK_BEAM_SLAB.get());
        output.accept(DARK_OAK_SUPPORT.get());
        output.accept(DARK_OAK_FRAME.get());
        output.accept(DARK_OAK_WALL.get());
        output.accept(DARK_OAK_LANTERN.get());
        output.accept(DARK_OAK_PALLET.get());
        output.accept(DARK_OAK_LADDER.get());

        output.accept(CRIMSON_TRIM.get());
        output.accept(CRIMSON_BEAM.get());
        output.accept(CRIMSON_BEAM_STAIRS.get());
        output.accept(CRIMSON_BEAM_SLAB.get());
        output.accept(CRIMSON_SUPPORT.get());
        output.accept(CRIMSON_FRAME.get());
        output.accept(CRIMSON_WALL.get());
        output.accept(CRIMSON_LANTERN.get());
        output.accept(CRIMSON_PALLET.get());
        output.accept(CRIMSON_LADDER.get());

        output.accept(WARPED_TRIM.get());
        output.accept(WARPED_BEAM.get());
        output.accept(WARPED_BEAM_STAIRS.get());
        output.accept(WARPED_BEAM_SLAB.get());
        output.accept(WARPED_SUPPORT.get());
        output.accept(WARPED_FRAME.get());
        output.accept(WARPED_WALL.get());
        output.accept(WARPED_LANTERN.get());
        output.accept(WARPED_PALLET.get());
        output.accept(WARPED_LADDER.get());

        output.accept(MANGROVE_TRIM.get());
        output.accept(MANGROVE_BEAM.get());
        output.accept(MANGROVE_BEAM_STAIRS.get());
        output.accept(MANGROVE_BEAM_SLAB.get());
        output.accept(MANGROVE_SUPPORT.get());
        output.accept(MANGROVE_FRAME.get());
        output.accept(MANGROVE_WALL.get());
        output.accept(MANGROVE_LANTERN.get());
        output.accept(MANGROVE_PALLET.get());
        output.accept(MANGROVE_LADDER.get());

        output.accept(BAMBOO_TRIM.get());
        output.accept(BAMBOO_BEAM.get());
        output.accept(BAMBOO_BEAM_STAIRS.get());
        output.accept(BAMBOO_BEAM_SLAB.get());
        output.accept(BAMBOO_SUPPORT.get());
        output.accept(BAMBOO_FRAME.get());
        output.accept(BAMBOO_WALL.get());
        output.accept(BAMBOO_LANTERN.get());
        output.accept(BAMBOO_PALLET.get());
        output.accept(BAMBOO_LADDER.get());

        output.accept(CHERRY_TRIM.get());
        output.accept(CHERRY_BEAM.get());
        output.accept(CHERRY_BEAM_STAIRS.get());
        output.accept(CHERRY_BEAM_SLAB.get());
        output.accept(CHERRY_SUPPORT.get());
        output.accept(CHERRY_FRAME.get());
        output.accept(CHERRY_WALL.get());
        output.accept(CHERRY_LANTERN.get());
        output.accept(CHERRY_PALLET.get());
        output.accept(CHERRY_LADDER.get());


        // region LAYERS
        output.accept(OAK_LAYER.get());
        output.accept(SPRUCE_LAYER.get());
        output.accept(BIRCH_LAYER.get());
        output.accept(JUNGLE_LAYER.get());
        output.accept(ACACIA_LAYER.get());
        output.accept(DARK_OAK_LAYER.get());
        output.accept(CRIMSON_LAYER.get());
        output.accept(WARPED_LAYER.get());
        output.accept(MANGROVE_LAYER.get());
        output.accept(BAMBOO_LAYER.get());
        output.accept(BAMBOO_MOSAIC_LAYER.get());
        output.accept(CHERRY_LAYER.get());
//        output.accept(MOSS_LAYER.get());
        output.accept(STONE_LAYER.get());
        output.accept(COBBLESTONE_LAYER.get());
        output.accept(MOSSY_COBBLESTONE_LAYER.get());
        output.accept(SMOOTH_STONE_LAYER.get());
        output.accept(POLISHED_STONE_LAYER.get());
        output.accept(STONE_TILE_LAYER.get());
        output.accept(STONE_BRICK_LAYER.get());
        output.accept(MOSSY_STONE_BRICK_LAYER.get());
        output.accept(GRANITE_LAYER.get());
        output.accept(POLISHED_GRANITE_LAYER.get());
        output.accept(DIORITE_LAYER.get());
        output.accept(POLISHED_DIORITE_LAYER.get());
        output.accept(ANDESITE_LAYER.get());
        output.accept(POLISHED_ANDESITE_LAYER.get());
        output.accept(COBBLED_DEEPSLATE_LAYER.get());
        output.accept(POLISHED_DEEPSLATE_LAYER.get());
        output.accept(DEEPSLATE_BRICK_LAYER.get());
        output.accept(DEEPSLATE_TILE_LAYER.get());
        output.accept(BRICK_LAYER.get());
        output.accept(MUD_BRICK_LAYER.get());
        output.accept(SANDSTONE_LAYER.get());
        output.accept(SMOOTH_SANDSTONE_LAYER.get());
        output.accept(RED_SANDSTONE_LAYER.get());
        output.accept(SMOOTH_RED_SANDSTONE_LAYER.get());
        output.accept(PRISMARINE_LAYER.get());
        output.accept(PRISMARINE_BRICK_LAYER.get());
        output.accept(DARK_PRISMARINE_LAYER.get());
        output.accept(NETHER_BRICK_LAYER.get());
        output.accept(RED_NETHER_BRICK_LAYER.get());
        output.accept(BLACKSTONE_LAYER.get());
        output.accept(POLISHED_BLACKSTONE_LAYER.get());
        output.accept(POLISHED_BLACKSTONE_BRICK_LAYER.get());
        output.accept(END_STONE_BRICK_LAYER.get());
        output.accept(PURPUR_LAYER.get());
        output.accept(QUARTZ_LAYER.get());
        output.accept(CUT_COPPER_LAYER.get());
        output.accept(EXPOSED_CUT_COPPER_LAYER.get());
        output.accept(WEATHERED_CUT_COPPER_LAYER.get());
        output.accept(OXIDIZED_CUT_COPPER_LAYER.get());
        output.accept(WAXED_CUT_COPPER_LAYER.get());
        output.accept(WAXED_EXPOSED_CUT_COPPER_LAYER.get());
        output.accept(WAXED_WEATHERED_CUT_COPPER_LAYER.get());
        output.accept(WAXED_OXIDIZED_CUT_COPPER_LAYER.get());
        // endregion

        // output.accept(WRENCH.get());

        }).build()
    );

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(BuildingButBetter.MOD_ID, id), tab);
    }
}
