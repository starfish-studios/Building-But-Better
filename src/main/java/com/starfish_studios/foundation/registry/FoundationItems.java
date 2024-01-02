package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
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

    public static final Item STONE_BALUSTRADE = register("stone_balustrade", new BlockItem(FoundationBlocks.STONE_BALUSTRADE, new FabricItemSettings()));

    public static final Item WRENCH = register("wrench", new WrenchItem(new FabricItemSettings().maxCount(1)));



    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Foundation.MOD_ID, id), item);
    }
}
