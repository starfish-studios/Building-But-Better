package com.starfish_studios.foundation.block.properties;

import net.minecraft.util.StringRepresentable;

public enum LayerNumber implements StringRepresentable {
    ONE("one"),
    TWO("two"),
    THREE("three"),
    FOUR("four"),
    FIVE("five"),
    SIX("six"),
    SEVEN("seven"),
    EIGHT("eight");

    private final String name;

    private LayerNumber(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}