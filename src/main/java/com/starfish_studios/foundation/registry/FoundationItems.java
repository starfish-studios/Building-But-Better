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
    public static final Item FOUNDATION = register("foundation", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item COBBLESTONE_LAYER = register("cobblestone_layer", new BlockItem(FoundationBlocks.COBBLESTONE_LAYER, new FabricItemSettings()));

    public static final Item IRON_FENCE = register("iron_fence", new BlockItem(FoundationBlocks.IRON_FENCE, new FabricItemSettings()));


    public static final Item OAK_SUPPORT = register("oak_support", new BlockItem(FoundationBlocks.OAK_SUPPORT, new FabricItemSettings()));
    public static final Item OAK_BEAM = register("oak_beam", new BlockItem(FoundationBlocks.OAK_BEAM, new FabricItemSettings()));


    public static final Item OAK_BALUSTRADE = register("oak_balustrade", new BlockItem(FoundationBlocks.OAK_BALUSTRADE, new FabricItemSettings()));
    public static final Item SPRUCE_BALUSTRADE = register("spruce_balustrade", new BlockItem(FoundationBlocks.SPRUCE_BALUSTRADE, new FabricItemSettings()));
    public static final Item BIRCH_BALUSTRADE = register("birch_balustrade", new BlockItem(FoundationBlocks.BIRCH_BALUSTRADE, new FabricItemSettings()));
    public static final Item JUNGLE_BALUSTRADE = register("jungle_balustrade", new BlockItem(FoundationBlocks.JUNGLE_BALUSTRADE, new FabricItemSettings()));
    public static final Item ACACIA_BALUSTRADE = register("acacia_balustrade", new BlockItem(FoundationBlocks.ACACIA_BALUSTRADE, new FabricItemSettings()));
    public static final Item DARK_OAK_BALUSTRADE = register("dark_oak_balustrade", new BlockItem(FoundationBlocks.DARK_OAK_BALUSTRADE, new FabricItemSettings()));
    public static final Item CRIMSON_BALUSTRADE = register("crimson_balustrade", new BlockItem(FoundationBlocks.CRIMSON_BALUSTRADE, new FabricItemSettings()));
    public static final Item WARPED_BALUSTRADE = register("warped_balustrade", new BlockItem(FoundationBlocks.WARPED_BALUSTRADE, new FabricItemSettings()));


    public static final Item STONE_BALUSTRADE = register("stone_balustrade", new BlockItem(FoundationBlocks.STONE_BALUSTRADE, new FabricItemSettings()));
    public static final Item STONE_MOULDING = register("stone_moulding", new BlockItem(FoundationBlocks.STONE_MOULDING, new FabricItemSettings()));

    public static final Item WRENCH = register("wrench", new WrenchItem(new FabricItemSettings().maxCount(1)));

    public static final Item BIG_OAK_DOOR = register("big_oak_door", new BigDoorItem(FoundationBlocks.BIG_OAK_DOOR, new FabricItemSettings()));


    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Foundation.MOD_ID, id), item);
    }
}
