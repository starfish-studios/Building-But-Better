package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.BuildingButBetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> CHISEL_STONE = blockTag("chisel_stone");
    public static final TagKey<Block> URNS = blockTag("urns");
    public static final TagKey<Block> BALUSTRADES = blockTag("balustrades");
    public static final TagKey<Block> METAL_FENCES = blockTag("metal_fences");
    public static final TagKey<Block> MOULDINGS = blockTag("mouldings");
    public static final TagKey<Block> HEDGES = blockTag("hedges");
    public static final TagKey<Block> STONE_BALUSTRADES = blockTag("stone_balustrades");
    public static final TagKey<Block> STONE_FENCES = blockTag("stone_fences");
    public static final TagKey<Block> FRAMES = blockTag("frames");
    public static final TagKey<Block> STONE_FRAMES = blockTag("stone_frames");
    public static final TagKey<Block> SUPPORTS = blockTag("supports");
    public static final TagKey<Block> PALLETS = blockTag("pallets");
    public static final TagKey<Block> COLUMNS = blockTag("columns");
    public static final TagKey<Block> LAYERS = blockTag("layers");

    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registries.BLOCK, BuildingButBetter.res(name));
    }

    public static void init() {}
}
