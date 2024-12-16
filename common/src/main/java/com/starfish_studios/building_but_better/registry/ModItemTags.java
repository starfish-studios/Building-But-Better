package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.BuildingButBetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> BALUSTRADES = itemTag("balustrades");
    public static final TagKey<Item> URNS = itemTag("urns");
    public static final TagKey<Item> LATTICES = itemTag("lattices");
    public static final TagKey<Item> CHISEL_STONE = itemTag("chisel/stone");
    public static final TagKey<Item> LANTERNS = itemTag("lanterns");
    public static final TagKey<Item> MOULDINGS = itemTag("mouldings");
    public static final TagKey<Item> FRAMES = itemTag("frames");
    public static final TagKey<Item> STONE_FRAMES = itemTag("stone_frames");
    public static final TagKey<Item> SUPPORTS = itemTag("supports");
    public static final TagKey<Item> PALLETS = itemTag("pallets");
    public static final TagKey<Item> COLUMNS = itemTag("columns");
    public static final TagKey<Item> LAYERS = itemTag("layers");
    public static final TagKey<Item> LADDERS = itemTag("ladders");
    public static final TagKey<Item> HAMMERS = itemTag("hammers");
    public static final TagKey<Item> STONE_FENCES = itemTag("stone_fences");
    
    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registries.ITEM, BuildingButBetter.res(name));
    }

    public static void init() {}
}
