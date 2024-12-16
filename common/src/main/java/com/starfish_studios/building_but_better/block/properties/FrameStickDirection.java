package com.starfish_studios.building_but_better.block.properties;

import net.minecraft.util.StringRepresentable;

public enum FrameStickDirection implements StringRepresentable {
    LEFT("left"),
    VERTICAL("vertical"),
    HORIZONTAL("horizontal"),
    RIGHT("right"),
    NONE("none");

    private final String name;

    private FrameStickDirection(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}