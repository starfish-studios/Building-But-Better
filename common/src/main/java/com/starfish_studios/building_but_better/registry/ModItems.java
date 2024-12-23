package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.item.HammerItem;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public class ModItems {

    public static final Supplier<Item> STONE_BLOCK = ModRegistry.registerItem("stone_block", () -> new StandingAndWallBlockItem(ModBlocks.STONE_BLOCK.get(), ModBlocks.WALL_STONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> BLACKSTONE_BLOCK = ModRegistry.registerItem("blackstone_block", () -> new StandingAndWallBlockItem(ModBlocks.BLACKSTONE_BLOCK.get(), ModBlocks.WALL_BLACKSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> DEEPSLATE_BLOCK = ModRegistry.registerItem("deepslate_block", () -> new StandingAndWallBlockItem(ModBlocks.DEEPSLATE_BLOCK.get(), ModBlocks.WALL_DEEPSLATE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> NETHER_BRICK_BLOCK = ModRegistry.registerItem("nether_brick_block", () -> new StandingAndWallBlockItem(ModBlocks.NETHER_BRICK_BLOCK.get(), ModBlocks.WALL_NETHER_BRICK_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> SANDSTONE_BLOCK = ModRegistry.registerItem("sandstone_block", () -> new StandingAndWallBlockItem(ModBlocks.SANDSTONE_BLOCK.get(), ModBlocks.WALL_SANDSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> RED_SANDSTONE_BLOCK = ModRegistry.registerItem("red_sandstone_block", () -> new StandingAndWallBlockItem(ModBlocks.RED_SANDSTONE_BLOCK.get(), ModBlocks.WALL_RED_SANDSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> QUARTZ_BLOCK = ModRegistry.registerItem("quartz_block", () -> new StandingAndWallBlockItem(ModBlocks.QUARTZ_BLOCK.get(), ModBlocks.WALL_QUARTZ_BLOCK.get(), new Item.Properties(), Direction.DOWN));


    public static final Supplier<Item> CORNERSTONE = ModRegistry.registerItem("bbb", () -> new Item(new Item.Properties()), null);
    public static final Supplier<Item> HAMMER = ModRegistry.registerItem("hammer", () -> new HammerItem(new Item.Properties().stacksTo(1).durability(256)));
    public static final Supplier<Item> CHISEL = ModRegistry.registerItem("chisel", () -> new Item(new Item.Properties().stacksTo(1).durability(256)));


    public static void init() {}
}
