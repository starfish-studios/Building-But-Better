package com.starfish_studios.building_but_better.block.properties;

import net.minecraft.util.StringRepresentable;

public enum LatticePlantType implements StringRepresentable {
    NONE("none"),
    VINES("vines"),
    OAK_LEAVES("oak_leaves"),
    SPRUCE_LEAVES("spruce_leaves"),
    BIRCH_LEAVES("birch_leaves"),
    JUNGLE_LEAVES("jungle_leaves"),
    ACACIA_LEAVES("acacia_leaves"),
    DARK_OAK_LEAVES("dark_oak_leaves"),
    AZALEA_LEAVES("azalea_leaves"),
    FLOWERING_AZALEA_LEAVES("flowering_azalea_leaves"),
    MANGROVE_LEAVES("mangrove_leaves"),
    CHERRY_LEAVES("cherry_leaves"),
//    ROSE_BUSH("rose_bush"),
    GLOW_LICHEN("glow_lichen"),
    CAVE_VINES("cave_vines");


    private final String name;

    private LatticePlantType(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
