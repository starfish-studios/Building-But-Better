package com.starfish_studios.foundation.block.properties;

import net.minecraft.util.StringRepresentable;

public enum BigDoorHalf implements StringRepresentable {
    UPPER("upper"),
    MIDDLE("middle"),
    LOWER("lower");

    private final String name;

    private BigDoorHalf(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}