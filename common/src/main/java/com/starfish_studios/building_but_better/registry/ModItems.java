package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.item.HammerItem;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems {

    public static final Supplier<Item> CORNERSTONE = ModRegistry.registerItem("bbb", () -> new Item(new Item.Properties()));//(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON).fireproof()));
    public static final Supplier<Item> HAMMER = ModRegistry.registerItem("hammer", () -> new HammerItem(new Item.Properties().stacksTo(1).durability(256)));
    public static final Supplier<Item> CHISEL = ModRegistry.registerItem("chisel", () -> new Item(new Item.Properties().stacksTo(1).durability(256)));


    public static void init() {}
}
