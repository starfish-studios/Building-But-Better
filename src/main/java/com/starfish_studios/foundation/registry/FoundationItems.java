package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.BigDoorBlock;
import com.starfish_studios.foundation.item.BigDoorItem;
import com.starfish_studios.foundation.item.WrenchItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class FoundationItems {

    public static final Item POLISHED_STONE = register("polished_stone", new BlockItem(FoundationBlocks.POLISHED_STONE, new FabricItemSettings()));
    public static final Item POLISHED_STONE_STAIRS = register("polished_stone_stairs", new BlockItem(FoundationBlocks.POLISHED_STONE_STAIRS, new FabricItemSettings()));
    public static final Item POLISHED_STONE_SLAB = register("polished_stone_slab", new BlockItem(FoundationBlocks.POLISHED_STONE_SLAB, new FabricItemSettings()));
    public static final Item STONE_TILES = register("stone_tiles", new BlockItem(FoundationBlocks.STONE_TILES, new FabricItemSettings()));
    public static final Item STONE_TILE_STAIRS = register("stone_tile_stairs", new BlockItem(FoundationBlocks.STONE_TILE_STAIRS, new FabricItemSettings()));
    public static final Item STONE_TILE_SLAB = register("stone_tile_slab", new BlockItem(FoundationBlocks.STONE_TILE_SLAB, new FabricItemSettings()));
    public static final Item STONE_FENCE = register("stone_fence", new BlockItem(FoundationBlocks.STONE_FENCE, new FabricItemSettings()));

    public static final Item BRAZIER = register("brazier", new BlockItem(FoundationBlocks.BRAZIER, new FabricItemSettings()));
    public static final Item URN = register("urn", new BlockItem(FoundationBlocks.URN, new FabricItemSettings()));


    public static final Item OAK_PLATFORM = register("oak_platform", new BlockItem(FoundationBlocks.OAK_PLATFORM, new FabricItemSettings()));


    public static final Item ROPE = register("rope", new BlockItem(FoundationBlocks.ROPE, new FabricItemSettings()));

    // region WOODEN LANTERNS
    public static final Item OAK_LANTERN = register("oak_lantern", new BlockItem(FoundationBlocks.OAK_LANTERN, new FabricItemSettings()));
    public static final Item SPRUCE_LANTERN = register("spruce_lantern", new BlockItem(FoundationBlocks.SPRUCE_LANTERN, new FabricItemSettings()));
    public static final Item BIRCH_LANTERN = register("birch_lantern", new BlockItem(FoundationBlocks.BIRCH_LANTERN, new FabricItemSettings()));
    public static final Item JUNGLE_LANTERN = register("jungle_lantern", new BlockItem(FoundationBlocks.JUNGLE_LANTERN, new FabricItemSettings()));
    public static final Item ACACIA_LANTERN = register("acacia_lantern", new BlockItem(FoundationBlocks.ACACIA_LANTERN, new FabricItemSettings()));
    public static final Item DARK_OAK_LANTERN = register("dark_oak_lantern", new BlockItem(FoundationBlocks.DARK_OAK_LANTERN, new FabricItemSettings()));
    public static final Item MANGROVE_LANTERN = register("mangrove_lantern", new BlockItem(FoundationBlocks.MANGROVE_LANTERN, new FabricItemSettings()));
    public static final Item CHERRY_LANTERN = register("cherry_lantern", new BlockItem(FoundationBlocks.CHERRY_LANTERN, new FabricItemSettings()));
    public static final Item BAMBOO_LANTERN = register("bamboo_lantern", new BlockItem(FoundationBlocks.BAMBOO_LANTERN, new FabricItemSettings()));
    public static final Item CRIMSON_LANTERN = register("crimson_lantern", new BlockItem(FoundationBlocks.CRIMSON_LANTERN, new FabricItemSettings()));
    public static final Item WARPED_LANTERN = register("warped_lantern", new BlockItem(FoundationBlocks.WARPED_LANTERN, new FabricItemSettings()));
    // endregion

    // region TRIMS

    public static final Item OAK_TRIM = register("oak_trim", new BlockItem(FoundationBlocks.OAK_TRIM, new FabricItemSettings()));
    public static final Item SPRUCE_TRIM = register("spruce_trim", new BlockItem(FoundationBlocks.SPRUCE_TRIM, new FabricItemSettings()));
    public static final Item BIRCH_TRIM = register("birch_trim", new BlockItem(FoundationBlocks.BIRCH_TRIM, new FabricItemSettings()));
    public static final Item JUNGLE_TRIM = register("jungle_trim", new BlockItem(FoundationBlocks.JUNGLE_TRIM, new FabricItemSettings()));
    public static final Item ACACIA_TRIM = register("acacia_trim", new BlockItem(FoundationBlocks.ACACIA_TRIM, new FabricItemSettings()));
    public static final Item DARK_OAK_TRIM = register("dark_oak_trim", new BlockItem(FoundationBlocks.DARK_OAK_TRIM, new FabricItemSettings()));
    public static final Item MANGROVE_TRIM = register("mangrove_trim", new BlockItem(FoundationBlocks.MANGROVE_TRIM, new FabricItemSettings()));
    public static final Item CHERRY_TRIM = register("cherry_trim", new BlockItem(FoundationBlocks.CHERRY_TRIM, new FabricItemSettings()));
    public static final Item BAMBOO_TRIM = register("bamboo_trim", new BlockItem(FoundationBlocks.BAMBOO_TRIM, new FabricItemSettings()));
    public static final Item CRIMSON_TRIM = register("crimson_trim", new BlockItem(FoundationBlocks.CRIMSON_TRIM, new FabricItemSettings()));
    public static final Item WARPED_TRIM = register("warped_trim", new BlockItem(FoundationBlocks.WARPED_TRIM, new FabricItemSettings()));
    // endregion

    public static final Item FOUNDATION = register("foundation", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    // public static final Item COBBLESTONE_LAYER = register("cobblestone_layer", new BlockItem(FoundationBlocks.COBBLESTONE_LAYER, new FabricItemSettings()));

    public static final Item IRON_FENCE = register("iron_fence", new BlockItem(FoundationBlocks.IRON_FENCE, new FabricItemSettings()));

    public static final Item STONE_MOULDING = register("stone_moulding", new BlockItem(FoundationBlocks.STONE_MOULDING, new FabricItemSettings()));

    public static final Item WRENCH = register("wrench", new WrenchItem(new FabricItemSettings().maxCount(1)));

    public static final Item BIG_OAK_DOOR = register("big_oak_door", new BigDoorItem(FoundationBlocks.BIG_OAK_DOOR, new FabricItemSettings()));


    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Foundation.MOD_ID, id), item);
    }
}
