package com.starfish_studios.building_but_better.registry.fabric;

import com.starfish_studios.building_but_better.BuildingButBetter;
import com.starfish_studios.building_but_better.registry.ModItems;
import com.starfish_studios.building_but_better.registry.ModRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabsImpl {
    public static final CreativeModeTab BBB_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            BuildingButBetter.res("tab"),
            FabricItemGroup.builder().title(Component.translatable("item_group." + BuildingButBetter.MOD_ID + ".tab"))
            .icon(() -> new ItemStack(ModItems.CORNERSTONE.get().asItem())).displayItems((parameters, output) -> {
                output.acceptAll(ModRegistry.getAllModItems());
            }).build());

    public static void register() {}
}
