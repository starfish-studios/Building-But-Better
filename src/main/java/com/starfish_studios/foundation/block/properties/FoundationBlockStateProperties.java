package com.starfish_studios.foundation.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class FoundationBlockStateProperties {
    // public static final EnumProperty<WoodStyle> STYLE = EnumProperty.create("style", WoodStyle.class);
    public static final IntegerProperty STYLE = IntegerProperty.create("style", 1, 10);
    public static final EnumProperty<FrameStickDirection> FRAME_CENTER = EnumProperty.create("center", FrameStickDirection.class);
    public static final EnumProperty<ColumnType> COLUMN_TYPE = EnumProperty.create("type", ColumnType.class);
    public static final EnumProperty<TallDoorHalf> HALVES = EnumProperty.create("type", TallDoorHalf.class);
    public static final EnumProperty<LayerNumber> LAYERS = EnumProperty.create("layer", LayerNumber.class);
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");
    public static final BooleanProperty LAYER_ONE = BooleanProperty.create("layer_one");
    public static final BooleanProperty LAYER_TWO = BooleanProperty.create("layer_two");
    public static final BooleanProperty LAYER_THREE = BooleanProperty.create("layer_three");
    public static final BooleanProperty LAYER_FOUR = BooleanProperty.create("layer_four");
}