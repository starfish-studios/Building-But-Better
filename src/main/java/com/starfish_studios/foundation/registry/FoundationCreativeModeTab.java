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


        output.accept(BRAZIER);
        output.accept(STONE_FENCE);
        output.accept(STONE_TILES);
        output.accept(OAK_BRANCH);
        output.accept(URN);
        output.accept(ROPE);

        output.accept(TIKI_TORCH);
        output.accept(OAK_LANTERN);
        output.accept(SPRUCE_LANTERN);
        output.accept(BIRCH_LANTERN);
        output.accept(JUNGLE_LANTERN);
        output.accept(ACACIA_LANTERN);
        output.accept(DARK_OAK_LANTERN);
        output.accept(MANGROVE_LANTERN);
        output.accept(CHERRY_LANTERN);
        output.accept(BAMBOO_LANTERN);
        output.accept(CRIMSON_LANTERN);
        output.accept(WARPED_LANTERN);

        output.accept(OAK_TRIM);
        output.accept(SPRUCE_TRIM);
        output.accept(BIRCH_TRIM);
        output.accept(JUNGLE_TRIM);
        output.accept(ACACIA_TRIM);
        output.accept(DARK_OAK_TRIM);
        output.accept(MANGROVE_TRIM);
        output.accept(CHERRY_TRIM);
        output.accept(BAMBOO_TRIM);
        output.accept(CRIMSON_TRIM);
        output.accept(WARPED_TRIM);

        // output.accept(COBBLESTONE_LAYER);
        output.accept(WRENCH);
        output.accept(IRON_FENCE);
        output.accept(STONE_BALUSTRADE);
        output.accept(STONE_MOULDING);


        // output.accept(OAK_SUPPORT);
        // output.accept(OAK_BEAM);

        output.accept(OAK_BALUSTRADE);
        output.accept(SPRUCE_BALUSTRADE);
        output.accept(BIRCH_BALUSTRADE);
        output.accept(JUNGLE_BALUSTRADE);
        output.accept(ACACIA_BALUSTRADE);
        output.accept(DARK_OAK_BALUSTRADE);
        output.accept(MANGROVE_BALUSTRADE);
        output.accept(CHERRY_BALUSTRADE);
        output.accept(BAMBOO_BALUSTRADE);
        output.accept(CRIMSON_BALUSTRADE);
        output.accept(WARPED_BALUSTRADE);

        output.accept(BIG_OAK_DOOR);

        }).build()
    );

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Foundation.MOD_ID, id), tab);
    }
}
