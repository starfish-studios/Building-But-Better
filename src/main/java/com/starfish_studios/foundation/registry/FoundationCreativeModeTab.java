package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import static com.starfish_studios.foundation.registry.FoundationItems.*;

public class FoundationCreativeModeTab {


    @SuppressWarnings("unused")
    public static final CreativeModeTab ITEM_GROUP = register("item_group", FabricItemGroup.builder().icon(FOUNDATION::getDefaultInstance).title(Component.translatable("itemGroup.foundation.tab")).displayItems((featureFlagSet, output) -> {

        // output.accept(STONE_LAYER);

        output.accept(POLISHED_STONE);
        output.accept(POLISHED_STONE_STAIRS);
        output.accept(POLISHED_STONE_SLAB);
        output.accept(POLISHED_STONE_COLUMN);

        output.accept(STONE_TILES);
        output.accept(STONE_TILE_STAIRS);
        output.accept(STONE_TILE_SLAB);

        output.accept(STONE_FENCE);
        output.accept(STONE_MOULDING);
        output.accept(URN);

        output.accept(BRAZIER);

        output.accept(IRON_FENCE);

        output.accept(BIG_DOOR);


        output.accept(OAK_TRIM);
        output.accept(OAK_PALLET);
        output.accept(OAK_FRAME);
        output.accept(OAK_LANTERN);

        output.accept(SPRUCE_TRIM);
        output.accept(SPRUCE_PALLET);
        output.accept(SPRUCE_FRAME);
        output.accept(SPRUCE_LANTERN);

        output.accept(BIRCH_TRIM);
        output.accept(BIRCH_PALLET);
        output.accept(BIRCH_FRAME);
        output.accept(BIRCH_LANTERN);

        output.accept(JUNGLE_TRIM);
        output.accept(JUNGLE_PALLET);
        output.accept(JUNGLE_FRAME);
        output.accept(JUNGLE_LANTERN);

        output.accept(ACACIA_TRIM);
        output.accept(ACACIA_PALLET);
        output.accept(ACACIA_FRAME);
        output.accept(ACACIA_LANTERN);

        output.accept(DARK_OAK_TRIM);
        output.accept(DARK_OAK_PALLET);
        output.accept(DARK_OAK_FRAME);
        output.accept(DARK_OAK_LANTERN);

        output.accept(MANGROVE_TRIM);
        output.accept(MANGROVE_PALLET);
        output.accept(MANGROVE_FRAME);
        output.accept(MANGROVE_LANTERN);

        output.accept(BAMBOO_TRIM);
        output.accept(BAMBOO_PALLET);
        output.accept(BAMBOO_FRAME);
        output.accept(BAMBOO_LANTERN);

        output.accept(CHERRY_TRIM);
        output.accept(CHERRY_PALLET);
        output.accept(CHERRY_FRAME);
        output.accept(CHERRY_LANTERN);

        output.accept(CRIMSON_TRIM);
        output.accept(CRIMSON_PALLET);
        output.accept(CRIMSON_FRAME);
        output.accept(CRIMSON_LANTERN);

        output.accept(WARPED_TRIM);
        output.accept(WARPED_PALLET);
        output.accept(WARPED_FRAME);
        output.accept(WARPED_LANTERN);

        // output.accept(WRENCH);

        }).build()
    );

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Foundation.MOD_ID, id), tab);
    }
}
