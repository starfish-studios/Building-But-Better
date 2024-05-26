package com.starfish_studios.bbb.block.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum LatticeType implements StringRepresentable {
    LEFT("left"),
    MIDDLE("middle"),
    RIGHT("right");

    private final String name;

    private LatticeType(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }
}