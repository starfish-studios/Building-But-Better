package com.starfish_studios.bbb.event;

import com.google.common.collect.Lists;
import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.client.model.BBBModelLayers;
import com.starfish_studios.bbb.client.model.BlockModel;
import com.starfish_studios.bbb.client.renderer.blockentity.BlockBlockRenderer;
import com.starfish_studios.bbb.registry.BBBBlockEntityType;
import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.IRON_FENCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.ROPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.BRAZIER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.SOUL_BRAZIER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.STONE_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.BLACKSTONE_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.DEEPSLATE_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.NETHER_BRICK_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.SANDSTONE_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.RED_SANDSTONE_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.QUARTZ_URN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.OAK_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.SPRUCE_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.BIRCH_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.JUNGLE_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.ACACIA_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.DARK_OAK_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.CRIMSON_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.WARPED_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.MANGROVE_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.BAMBOO_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBBlocks.CHERRY_LADDER.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BBBBlockEntityType.BLOCK.get(), context -> new BlockBlockRenderer());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BBBModelLayers.STONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BBBModelLayers.BLACKSTONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BBBModelLayers.DEEPSLATE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BBBModelLayers.NETHER_BRICK_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BBBModelLayers.SANDSTONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BBBModelLayers.RED_SANDSTONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BBBModelLayers.QUARTZ_BLOCK, BlockModel::createBlockModel);
    }

    private static void addAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike after, ItemLike... block) {
        List<ItemLike> stream = Lists.newArrayList(Arrays.stream(block).toList());
        Collections.reverse(stream);
        stream.forEach(blk -> addAfter(map, after, blk));
    }

    private static void addBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike before, ItemLike... block) {
        List<ItemLike> stream = Lists.newArrayList(Arrays.stream(block).toList());
        Collections.reverse(stream);
        stream.forEach(blk -> addBefore(map, before, blk));
    }

    private static void addAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike after, ItemLike block) {
        map.putAfter(FUNCTION.apply(after), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void addBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike before, ItemLike block) {
        map.putBefore(FUNCTION.apply(before), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @SubscribeEvent
    public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey.equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            addAfter(entries, Items.SOUL_CAMPFIRE, BBBItems.BRAZIER.get());
            addAfter(entries, BBBItems.BRAZIER.get(), BBBItems.SOUL_BRAZIER.get());
        }
        if (tabKey.equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            addAfter(entries, Items.SMOOTH_STONE_SLAB, BBBItems.POLISHED_STONE.get());
            addAfter(entries, BBBItems.POLISHED_STONE.get(), BBBItems.POLISHED_STONE_STAIRS.get());
            addAfter(entries, BBBItems.POLISHED_STONE_STAIRS.get(), BBBItems.POLISHED_STONE_SLAB.get());
            addAfter(entries, BBBItems.POLISHED_STONE_SLAB.get(), BBBItems.STONE_TILES.get());
            addAfter(entries, BBBItems.STONE_TILES.get(), BBBItems.STONE_TILE_STAIRS.get());
            addAfter(entries, BBBItems.STONE_TILE_STAIRS.get(), BBBItems.STONE_TILE_SLAB.get());

            addAfter(entries, Items.CHISELED_STONE_BRICKS, BBBItems.STONE_COLUMN.get());
            addAfter(entries, BBBItems.STONE_COLUMN.get(), BBBItems.STONE_URN.get());
            addAfter(entries, BBBItems.STONE_URN.get(), BBBItems.STONE_FENCE.get());
            addAfter(entries, BBBItems.STONE_FENCE.get(), BBBItems.STONE_MOULDING.get());
            addAfter(entries, BBBItems.STONE_MOULDING.get(), BBBItems.STONE_BLOCK.get());

            addAfter(entries, Items.CHISELED_POLISHED_BLACKSTONE, BBBItems.BLACKSTONE_COLUMN.get());
            addAfter(entries, BBBItems.BLACKSTONE_COLUMN.get(), BBBItems.BLACKSTONE_URN.get());
            addAfter(entries, BBBItems.BLACKSTONE_URN.get(), BBBItems.BLACKSTONE_FENCE.get());
            addAfter(entries, BBBItems.BLACKSTONE_FENCE.get(), BBBItems.BLACKSTONE_MOULDING.get());
            addAfter(entries, BBBItems.BLACKSTONE_MOULDING.get(), BBBItems.BLACKSTONE_BLOCK.get());

            addAfter(entries, Items.CHISELED_DEEPSLATE, BBBItems.DEEPSLATE_COLUMN.get());
            addAfter(entries, BBBItems.DEEPSLATE_COLUMN.get(), BBBItems.DEEPSLATE_URN.get());
            addAfter(entries, BBBItems.DEEPSLATE_URN.get(), BBBItems.DEEPSLATE_FENCE.get());
            addAfter(entries, BBBItems.DEEPSLATE_FENCE.get(), BBBItems.DEEPSLATE_MOULDING.get());
            addAfter(entries, BBBItems.DEEPSLATE_MOULDING.get(), BBBItems.DEEPSLATE_BLOCK.get());

            addAfter(entries, Items.CHISELED_NETHER_BRICKS, BBBItems.NETHER_BRICK_COLUMN.get());
            addAfter(entries, BBBItems.NETHER_BRICK_COLUMN.get(), BBBItems.NETHER_BRICK_URN.get());
            addAfter(entries, BBBItems.NETHER_BRICK_URN.get(), BBBItems.NETHER_BRICK_FENCE.get());
            addAfter(entries, BBBItems.NETHER_BRICK_FENCE.get(), BBBItems.NETHER_BRICK_MOULDING.get());
            addAfter(entries, BBBItems.NETHER_BRICK_MOULDING.get(), BBBItems.NETHER_BRICK_BLOCK.get());

            addAfter(entries, Items.CHISELED_SANDSTONE, BBBItems.SANDSTONE_COLUMN.get());
            addAfter(entries, BBBItems.SANDSTONE_COLUMN.get(), BBBItems.SANDSTONE_URN.get());
            addAfter(entries, BBBItems.SANDSTONE_URN.get(), BBBItems.SANDSTONE_FENCE.get());
            addAfter(entries, BBBItems.SANDSTONE_FENCE.get(), BBBItems.SANDSTONE_MOULDING.get());
            addAfter(entries, BBBItems.SANDSTONE_MOULDING.get(), BBBItems.SANDSTONE_BLOCK.get());

            addAfter(entries, Items.CHISELED_RED_SANDSTONE, BBBItems.RED_SANDSTONE_COLUMN.get());
            addAfter(entries, BBBItems.RED_SANDSTONE_COLUMN.get(), BBBItems.RED_SANDSTONE_URN.get());
            addAfter(entries, BBBItems.RED_SANDSTONE_URN.get(), BBBItems.RED_SANDSTONE_FENCE.get());
            addAfter(entries, BBBItems.RED_SANDSTONE_FENCE.get(), BBBItems.RED_SANDSTONE_MOULDING.get());
            addAfter(entries, BBBItems.RED_SANDSTONE_MOULDING.get(), BBBItems.RED_SANDSTONE_BLOCK.get());

            addAfter(entries, Items.CHISELED_QUARTZ_BLOCK, BBBItems.QUARTZ_COLUMN.get());
            addAfter(entries, BBBItems.QUARTZ_COLUMN.get(), BBBItems.QUARTZ_URN.get());
            addAfter(entries, BBBItems.QUARTZ_URN.get(), BBBItems.QUARTZ_FENCE.get());
            addAfter(entries, BBBItems.QUARTZ_FENCE.get(), BBBItems.QUARTZ_MOULDING.get());
            addAfter(entries, BBBItems.QUARTZ_MOULDING.get(), BBBItems.QUARTZ_BLOCK.get());

            //region WOODEN INJECTIONS
            addAfter(entries, Items.OAK_SLAB, BBBItems.OAK_LAYER.get());
            addAfter(entries, BBBItems.OAK_LAYER.get(), BBBItems.OAK_TRIM.get());
            addAfter(entries, BBBItems.OAK_TRIM.get(), BBBItems.OAK_BEAM.get());
            addAfter(entries, BBBItems.OAK_BEAM.get(), BBBItems.OAK_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.OAK_BEAM_STAIRS.get(), BBBItems.OAK_BEAM_SLAB.get());
            addAfter(entries, Items.OAK_BUTTON, BBBItems.OAK_SUPPORT.get());
            addAfter(entries, BBBItems.OAK_SUPPORT.get(), BBBItems.OAK_FRAME.get());
            addAfter(entries, BBBItems.OAK_FRAME.get(), BBBItems.OAK_PALLET.get());
            addAfter(entries, BBBItems.OAK_PALLET.get(), BBBItems.OAK_LANTERN.get());
            addAfter(entries, BBBItems.OAK_LANTERN.get(), BBBItems.OAK_LADDER.get());

            addAfter(entries, Items.SPRUCE_SLAB, BBBItems.SPRUCE_LAYER.get());
            addAfter(entries, BBBItems.SPRUCE_LAYER.get(), BBBItems.SPRUCE_TRIM.get());
            addAfter(entries, BBBItems.SPRUCE_TRIM.get(), BBBItems.SPRUCE_BEAM.get());
            addAfter(entries, BBBItems.SPRUCE_BEAM.get(), BBBItems.SPRUCE_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.SPRUCE_BEAM_STAIRS.get(), BBBItems.SPRUCE_BEAM_SLAB.get());
            addAfter(entries, Items.SPRUCE_BUTTON, BBBItems.SPRUCE_SUPPORT.get());
            addAfter(entries, BBBItems.SPRUCE_SUPPORT.get(), BBBItems.SPRUCE_FRAME.get());
            addAfter(entries, BBBItems.SPRUCE_FRAME.get(), BBBItems.SPRUCE_PALLET.get());
            addAfter(entries, BBBItems.SPRUCE_PALLET.get(), BBBItems.SPRUCE_LANTERN.get());
            addAfter(entries, BBBItems.SPRUCE_LANTERN.get(), BBBItems.SPRUCE_LADDER.get());

            addAfter(entries, Items.BIRCH_SLAB, BBBItems.BIRCH_LAYER.get());
            addAfter(entries, BBBItems.BIRCH_LAYER.get(), BBBItems.BIRCH_TRIM.get());
            addAfter(entries, BBBItems.BIRCH_TRIM.get(), BBBItems.BIRCH_BEAM.get());
            addAfter(entries, BBBItems.BIRCH_BEAM.get(), BBBItems.BIRCH_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.BIRCH_BEAM_STAIRS.get(), BBBItems.BIRCH_BEAM_SLAB.get());
            addAfter(entries, Items.BIRCH_BUTTON, BBBItems.BIRCH_SUPPORT.get());
            addAfter(entries, BBBItems.BIRCH_SUPPORT.get(), BBBItems.BIRCH_FRAME.get());
            addAfter(entries, BBBItems.BIRCH_FRAME.get(), BBBItems.BIRCH_PALLET.get());
            addAfter(entries, BBBItems.BIRCH_PALLET.get(), BBBItems.BIRCH_LANTERN.get());
            addAfter(entries, BBBItems.BIRCH_LANTERN.get(), BBBItems.BIRCH_LADDER.get());

            addAfter(entries, Items.JUNGLE_SLAB, BBBItems.JUNGLE_LAYER.get());
            addAfter(entries, BBBItems.JUNGLE_LAYER.get(), BBBItems.JUNGLE_TRIM.get());
            addAfter(entries, BBBItems.JUNGLE_TRIM.get(), BBBItems.JUNGLE_BEAM.get());
            addAfter(entries, BBBItems.JUNGLE_BEAM.get(), BBBItems.JUNGLE_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.JUNGLE_BEAM_STAIRS.get(), BBBItems.JUNGLE_BEAM_SLAB.get());
            addAfter(entries, Items.JUNGLE_BUTTON, BBBItems.JUNGLE_SUPPORT.get());
            addAfter(entries, BBBItems.JUNGLE_SUPPORT.get(), BBBItems.JUNGLE_FRAME.get());
            addAfter(entries, BBBItems.JUNGLE_FRAME.get(), BBBItems.JUNGLE_PALLET.get());
            addAfter(entries, BBBItems.JUNGLE_PALLET.get(), BBBItems.JUNGLE_LANTERN.get());
            addAfter(entries, BBBItems.JUNGLE_LANTERN.get(), BBBItems.JUNGLE_LADDER.get());

            addAfter(entries, Items.ACACIA_SLAB, BBBItems.ACACIA_LAYER.get());
            addAfter(entries, BBBItems.ACACIA_LAYER.get(), BBBItems.ACACIA_TRIM.get());
            addAfter(entries, BBBItems.ACACIA_TRIM.get(), BBBItems.ACACIA_BEAM.get());
            addAfter(entries, BBBItems.ACACIA_BEAM.get(), BBBItems.ACACIA_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.ACACIA_BEAM_STAIRS.get(), BBBItems.ACACIA_BEAM_SLAB.get());
            addAfter(entries, Items.ACACIA_BUTTON, BBBItems.ACACIA_SUPPORT.get());
            addAfter(entries, BBBItems.ACACIA_SUPPORT.get(), BBBItems.ACACIA_FRAME.get());
            addAfter(entries, BBBItems.ACACIA_FRAME.get(), BBBItems.ACACIA_PALLET.get());
            addAfter(entries, BBBItems.ACACIA_PALLET.get(), BBBItems.ACACIA_LANTERN.get());
            addAfter(entries, BBBItems.ACACIA_LANTERN.get(), BBBItems.ACACIA_LADDER.get());

            addAfter(entries, Items.DARK_OAK_SLAB, BBBItems.DARK_OAK_LAYER.get());
            addAfter(entries, BBBItems.DARK_OAK_LAYER.get(), BBBItems.DARK_OAK_TRIM.get());
            addAfter(entries, BBBItems.DARK_OAK_TRIM.get(), BBBItems.DARK_OAK_BEAM.get());
            addAfter(entries, BBBItems.DARK_OAK_BEAM.get(), BBBItems.DARK_OAK_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.DARK_OAK_BEAM_STAIRS.get(), BBBItems.DARK_OAK_BEAM_SLAB.get());
            addAfter(entries, Items.DARK_OAK_BUTTON, BBBItems.DARK_OAK_SUPPORT.get());
            addAfter(entries, BBBItems.DARK_OAK_SUPPORT.get(), BBBItems.DARK_OAK_FRAME.get());
            addAfter(entries, BBBItems.DARK_OAK_FRAME.get(), BBBItems.DARK_OAK_PALLET.get());
            addAfter(entries, BBBItems.DARK_OAK_PALLET.get(), BBBItems.DARK_OAK_LANTERN.get());
            addAfter(entries, BBBItems.DARK_OAK_LANTERN.get(), BBBItems.DARK_OAK_LADDER.get());

            addAfter(entries, Items.CRIMSON_SLAB, BBBItems.CRIMSON_LAYER.get());
            addAfter(entries, BBBItems.CRIMSON_LAYER.get(), BBBItems.CRIMSON_TRIM.get());
            addAfter(entries, BBBItems.CRIMSON_TRIM.get(), BBBItems.CRIMSON_BEAM.get());
            addAfter(entries, BBBItems.CRIMSON_BEAM.get(), BBBItems.CRIMSON_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.CRIMSON_BEAM_STAIRS.get(), BBBItems.CRIMSON_BEAM_SLAB.get());
            addAfter(entries, Items.CRIMSON_BUTTON, BBBItems.CRIMSON_SUPPORT.get());
            addAfter(entries, BBBItems.CRIMSON_SUPPORT.get(), BBBItems.CRIMSON_FRAME.get());
            addAfter(entries, BBBItems.CRIMSON_FRAME.get(), BBBItems.CRIMSON_PALLET.get());
            addAfter(entries, BBBItems.CRIMSON_PALLET.get(), BBBItems.CRIMSON_LANTERN.get());
            addAfter(entries, BBBItems.CRIMSON_LANTERN.get(), BBBItems.CRIMSON_LADDER.get());

            addAfter(entries, Items.WARPED_SLAB, BBBItems.WARPED_LAYER.get());
            addAfter(entries, BBBItems.WARPED_LAYER.get(), BBBItems.WARPED_TRIM.get());
            addAfter(entries, BBBItems.WARPED_TRIM.get(), BBBItems.WARPED_BEAM.get());
            addAfter(entries, BBBItems.WARPED_BEAM.get(), BBBItems.WARPED_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.WARPED_BEAM_STAIRS.get(), BBBItems.WARPED_BEAM_SLAB.get());
            addAfter(entries, Items.WARPED_BUTTON, BBBItems.WARPED_SUPPORT.get());
            addAfter(entries, BBBItems.WARPED_SUPPORT.get(), BBBItems.WARPED_FRAME.get());
            addAfter(entries, BBBItems.WARPED_FRAME.get(), BBBItems.WARPED_PALLET.get());
            addAfter(entries, BBBItems.WARPED_PALLET.get(), BBBItems.WARPED_LANTERN.get());
            addAfter(entries, BBBItems.WARPED_LANTERN.get(), BBBItems.WARPED_LADDER.get());

            addAfter(entries, Items.MANGROVE_SLAB, BBBItems.MANGROVE_LAYER.get());
            addAfter(entries, BBBItems.MANGROVE_LAYER.get(), BBBItems.MANGROVE_TRIM.get());
            addAfter(entries, BBBItems.MANGROVE_TRIM.get(), BBBItems.MANGROVE_BEAM.get());
            addAfter(entries, BBBItems.MANGROVE_BEAM.get(), BBBItems.MANGROVE_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.MANGROVE_BEAM_STAIRS.get(), BBBItems.MANGROVE_BEAM_SLAB.get());
            addAfter(entries, Items.MANGROVE_BUTTON, BBBItems.MANGROVE_SUPPORT.get());
            addAfter(entries, BBBItems.MANGROVE_SUPPORT.get(), BBBItems.MANGROVE_FRAME.get());
            addAfter(entries, BBBItems.MANGROVE_FRAME.get(), BBBItems.MANGROVE_PALLET.get());
            addAfter(entries, BBBItems.MANGROVE_PALLET.get(), BBBItems.MANGROVE_LANTERN.get());
            addAfter(entries, BBBItems.MANGROVE_LANTERN.get(), BBBItems.MANGROVE_LADDER.get());

            addAfter(entries, Items.BAMBOO_SLAB, BBBItems.BAMBOO_LAYER.get());
            addAfter(entries, BBBItems.BAMBOO_LAYER.get(), BBBItems.BAMBOO_TRIM.get());
            addAfter(entries, BBBItems.BAMBOO_TRIM.get(), BBBItems.BAMBOO_BEAM.get());
            addAfter(entries, BBBItems.BAMBOO_BEAM.get(), BBBItems.BAMBOO_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.BAMBOO_BEAM_STAIRS.get(), BBBItems.BAMBOO_BEAM_SLAB.get());
            addAfter(entries, Items.BAMBOO_BUTTON, BBBItems.BAMBOO_SUPPORT.get());
            addAfter(entries, BBBItems.BAMBOO_SUPPORT.get(), BBBItems.BAMBOO_FRAME.get());
            addAfter(entries, BBBItems.BAMBOO_FRAME.get(), BBBItems.BAMBOO_PALLET.get());
            addAfter(entries, BBBItems.BAMBOO_PALLET.get(), BBBItems.BAMBOO_LANTERN.get());
            addAfter(entries, BBBItems.BAMBOO_LANTERN.get(), BBBItems.BAMBOO_LADDER.get());

            addAfter(entries, Items.CHERRY_SLAB, BBBItems.CHERRY_LAYER.get());
            addAfter(entries, BBBItems.CHERRY_LAYER.get(), BBBItems.CHERRY_TRIM.get());
            addAfter(entries, BBBItems.CHERRY_TRIM.get(), BBBItems.CHERRY_BEAM.get());
            addAfter(entries, BBBItems.CHERRY_BEAM.get(), BBBItems.CHERRY_BEAM_STAIRS.get());
            addAfter(entries, BBBItems.CHERRY_BEAM_STAIRS.get(), BBBItems.CHERRY_BEAM_SLAB.get());
            addAfter(entries, Items.CHERRY_BUTTON, BBBItems.CHERRY_SUPPORT.get());
            addAfter(entries, BBBItems.CHERRY_SUPPORT.get(), BBBItems.CHERRY_FRAME.get());
            addAfter(entries, BBBItems.CHERRY_FRAME.get(), BBBItems.CHERRY_PALLET.get());
            addAfter(entries, BBBItems.CHERRY_PALLET.get(), BBBItems.CHERRY_LANTERN.get());
            addAfter(entries, BBBItems.CHERRY_LANTERN.get(), BBBItems.CHERRY_LADDER.get());

            //endregion

            //region LAYER INJECTIONS

            addAfter(entries, Items.STONE_SLAB, BBBItems.STONE_LAYER.get());
            addAfter(entries, Items.COBBLESTONE_SLAB, BBBItems.COBBLESTONE_LAYER.get());
            addAfter(entries, Items.MOSSY_COBBLESTONE_SLAB, BBBItems.MOSSY_COBBLESTONE_LAYER.get());
            addAfter(entries, Items.SMOOTH_STONE_SLAB, BBBItems.SMOOTH_STONE_LAYER.get());
            addAfter(entries, Items.STONE_BRICK_SLAB, BBBItems.STONE_BRICK_LAYER.get());
            addAfter(entries, Items.MOSSY_STONE_BRICK_SLAB, BBBItems.MOSSY_STONE_BRICK_LAYER.get());

            addAfter(entries, Items.GRANITE_SLAB, BBBItems.GRANITE_LAYER.get());
            addAfter(entries, Items.POLISHED_GRANITE_SLAB, BBBItems.POLISHED_GRANITE_LAYER.get());
            addAfter(entries, Items.DIORITE_SLAB, BBBItems.DIORITE_LAYER.get());
            addAfter(entries, Items.POLISHED_DIORITE_SLAB, BBBItems.POLISHED_DIORITE_LAYER.get());
            addAfter(entries, Items.ANDESITE_SLAB, BBBItems.ANDESITE_LAYER.get());
            addAfter(entries, Items.POLISHED_ANDESITE_SLAB, BBBItems.POLISHED_ANDESITE_LAYER.get());
            addAfter(entries, Items.COBBLED_DEEPSLATE_SLAB, BBBItems.COBBLED_DEEPSLATE_LAYER.get());
            addAfter(entries, Items.POLISHED_DEEPSLATE_SLAB, BBBItems.POLISHED_DEEPSLATE_LAYER.get());
            addAfter(entries, Items.DEEPSLATE_BRICK_SLAB, BBBItems.DEEPSLATE_BRICK_LAYER.get());
            addAfter(entries, Items.DEEPSLATE_TILE_SLAB, BBBItems.DEEPSLATE_TILE_LAYER.get());

            addAfter(entries, Items.BRICK_SLAB, BBBItems.BRICK_LAYER.get());
            addAfter(entries, Items.MUD_BRICK_SLAB, BBBItems.MUD_BRICK_LAYER.get());
            addAfter(entries, Items.SANDSTONE_SLAB, BBBItems.SANDSTONE_LAYER.get());
            addAfter(entries, Items.SMOOTH_SANDSTONE_SLAB, BBBItems.SMOOTH_SANDSTONE_LAYER.get());
            addAfter(entries, Items.RED_SANDSTONE_SLAB, BBBItems.RED_SANDSTONE_LAYER.get());
            addAfter(entries, Items.SMOOTH_RED_SANDSTONE_SLAB, BBBItems.SMOOTH_RED_SANDSTONE_LAYER.get());
            addAfter(entries, Items.PRISMARINE_SLAB, BBBItems.PRISMARINE_LAYER.get());
            addAfter(entries, Items.PRISMARINE_BRICK_SLAB, BBBItems.PRISMARINE_BRICK_LAYER.get());
            addAfter(entries, Items.DARK_PRISMARINE_SLAB, BBBItems.DARK_PRISMARINE_LAYER.get());
            addAfter(entries, Items.NETHER_BRICK_SLAB, BBBItems.NETHER_BRICK_LAYER.get());
            addAfter(entries, Items.RED_NETHER_BRICK_SLAB, BBBItems.RED_NETHER_BRICK_LAYER.get());

            addAfter(entries, Items.BLACKSTONE_SLAB, BBBItems.BLACKSTONE_LAYER.get());
            addAfter(entries, Items.POLISHED_BLACKSTONE_SLAB, BBBItems.POLISHED_BLACKSTONE_LAYER.get());
            addAfter(entries, Items.POLISHED_BLACKSTONE_BRICK_SLAB, BBBItems.POLISHED_BLACKSTONE_BRICK_LAYER.get());
            addAfter(entries, Items.END_STONE_BRICK_SLAB, BBBItems.END_STONE_BRICK_LAYER.get());
            addAfter(entries, Items.PURPUR_SLAB, BBBItems.PURPUR_LAYER.get());
            addAfter(entries, Items.QUARTZ_SLAB, BBBItems.QUARTZ_LAYER.get());

            addAfter(entries, Items.CUT_COPPER_SLAB, BBBItems.CUT_COPPER_LAYER.get());
            addAfter(entries, Items.EXPOSED_CUT_COPPER_SLAB, BBBItems.EXPOSED_CUT_COPPER_LAYER.get());
            addAfter(entries, Items.WEATHERED_CUT_COPPER_SLAB, BBBItems.WEATHERED_CUT_COPPER_LAYER.get());
            addAfter(entries, Items.OXIDIZED_CUT_COPPER_SLAB, BBBItems.OXIDIZED_CUT_COPPER_LAYER.get());
            addAfter(entries, Items.WAXED_CUT_COPPER_SLAB, BBBItems.WAXED_CUT_COPPER_LAYER.get());
            addAfter(entries, Items.WAXED_EXPOSED_CUT_COPPER_SLAB, BBBItems.WAXED_EXPOSED_CUT_COPPER_LAYER.get());
            addAfter(entries, Items.WAXED_WEATHERED_CUT_COPPER_SLAB, BBBItems.WAXED_WEATHERED_CUT_COPPER_LAYER.get());
            addAfter(entries, Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, BBBItems.WAXED_OXIDIZED_CUT_COPPER_LAYER.get());
        }
    }

}
