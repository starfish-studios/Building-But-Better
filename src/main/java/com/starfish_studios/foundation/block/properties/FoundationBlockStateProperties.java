package com.starfish_studios.foundation.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class FoundationBlockStateProperties {
    public static final EnumProperty<ColumnType> COLUMN_TYPE = EnumProperty.create("type", ColumnType.class);
    public static final EnumProperty<BigDoorHalf> HALVES = EnumProperty.create("type", BigDoorHalf.class);
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");
}