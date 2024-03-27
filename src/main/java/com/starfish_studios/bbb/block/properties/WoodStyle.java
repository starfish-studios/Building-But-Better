package com.starfish_studios.bbb.block.properties;

import net.minecraft.util.StringRepresentable;

public enum WoodStyle implements StringRepresentable {
    OAK("oak"),
    SPRUCE("spruce"),
    BIRCH("birch"),
    JUNGLE("jungle"),
    ACACIA("acacia"),
    DARK_OAK("dark_oak"),
    MANGROVE("mangrove"),
    CHERRY("cherry"),
    CRIMSON("crimson"),
    WARPED("warped");

    private final String name;

    private WoodStyle(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}