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

        output.accept(COBBLESTONE_LAYER);
        output.accept(WRENCH);
        output.accept(IRON_FENCE);
        output.accept(STONE_BALUSTRADE);
        output.accept(STONE_MOULDING);


        output.accept(OAK_SUPPORT);
        output.accept(OAK_BEAM);

        output.accept(OAK_BALUSTRADE);
        output.accept(SPRUCE_BALUSTRADE);
        output.accept(BIRCH_BALUSTRADE);
        output.accept(JUNGLE_BALUSTRADE);
        output.accept(ACACIA_BALUSTRADE);
        output.accept(DARK_OAK_BALUSTRADE);
        output.accept(CRIMSON_BALUSTRADE);
        output.accept(WARPED_BALUSTRADE);

        }).build()
    );

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Foundation.MOD_ID, id), tab);
    }
}
