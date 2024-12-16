package com.starfish_studios.building_but_better.registry.neoforge;

import com.starfish_studios.building_but_better.BuildingButBetter;
import com.starfish_studios.building_but_better.registry.ModItems;
import com.starfish_studios.building_but_better.registry.ModRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;

import java.util.function.Supplier;

public class ModTabsImpl {
    public static final Supplier<CreativeModeTab> BBB_TAB = ModRegistryImpl.MOD_TABS.register(BuildingButBetter.MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CORNERSTONE.get().asItem()))
            .title(Component.translatable("item_group." + BuildingButBetter.MOD_ID + ".tab"))
            .displayItems(((parameters, output) -> {
                output.acceptAll(ModRegistry.getAllModItems());
            })).build());

    public static void register(IEventBus eventBus) {
        ModRegistryImpl.MOD_TABS.register(eventBus);
    }
}
