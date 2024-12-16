package com.starfish_studios.building_but_better.block.properties;

import net.minecraft.util.StringRepresentable;

public enum TallDoorHalf implements StringRepresentable {
    UPPER("upper"),
    MIDDLE("middle"),
    LOWER("lower");

    private final String name;

    private TallDoorHalf(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}