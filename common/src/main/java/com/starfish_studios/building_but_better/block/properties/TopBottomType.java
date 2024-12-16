package com.starfish_studios.building_but_better.block.properties;

import net.minecraft.util.StringRepresentable;

public enum TopBottomType implements StringRepresentable {
    TOP("top"),
    BOTTOM("bottom");
    private final String name;

    TopBottomType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
