package com.starfish_studios.foundation.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class FoundationBlockStateProperties {
    // public static final EnumProperty<WoodStyle> STYLE = EnumProperty.create("style", WoodStyle.class);
    public static final IntegerProperty STYLE = IntegerProperty.create("style", 1, 11);
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
    public static final BooleanProperty NORTH_TOP_LEFT = BooleanProperty.create("north_top_left");
    public static final BooleanProperty NORTH_TOP_RIGHT = BooleanProperty.create("north_top_right");
    public static final BooleanProperty NORTH_BOTTOM_LEFT = BooleanProperty.create("north_bottom_left");
    public static final BooleanProperty NORTH_BOTTOM_RIGHT = BooleanProperty.create("north_bottom_right");
    public static final BooleanProperty SOUTH_TOP_LEFT = BooleanProperty.create("south_top_left");
    public static final BooleanProperty SOUTH_TOP_RIGHT = BooleanProperty.create("south_top_right");
    public static final BooleanProperty SOUTH_BOTTOM_LEFT = BooleanProperty.create("south_bottom_left");
    public static final BooleanProperty SOUTH_BOTTOM_RIGHT = BooleanProperty.create("south_bottom_right");
}