package com.starfish_studios.bbb.forge;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.registry.BBBFuels;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class BBBFuelEventsForge {

    private static Map<Item, Integer> woodFuelMap;

    private static Map<Item, Integer> getWoodFuelMap() {
        if (woodFuelMap == null) {
            woodFuelMap = new HashMap<>();
            BBBFuels.registerWoodFuels(woodFuelMap::put);
        }
        return woodFuelMap;
    }

    @SubscribeEvent
    public static void onFurnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.isEmpty()) return;
        Integer burnTime = getWoodFuelMap().get(stack.getItem());
        if (burnTime != null) {
            event.setBurnTime(burnTime);
        }
    }
}
