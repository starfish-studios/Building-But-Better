package com.starfish_studios.bbb.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BBBBlockStateProperties {
    // public static final EnumProperty<WoodStyle> STYLE = EnumProperty.create("style", WoodStyle.class);

    public static final EnumProperty<LatticeType> LATTICE_TYPE = EnumProperty.create("type", LatticeType.class);
    public static final EnumProperty<LatticePlantType> PLANT_TYPE = EnumProperty.create("plant_type", LatticePlantType.class);

    public static final IntegerProperty STYLE = IntegerProperty.create("style", 1, 10);
    public static final EnumProperty<FrameStickDirection> FRAME_CENTER = EnumProperty.create("center", FrameStickDirection.class);
    public static final EnumProperty<ColumnType> COLUMN_TYPE = EnumProperty.create("type", ColumnType.class);
    public static final EnumProperty<TallDoorHalf> HALVES = EnumProperty.create("type", TallDoorHalf.class);
    public static final EnumProperty<LayerNumber> LAYERS = EnumProperty.create("layer", LayerNumber.class);


    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");
    public static final BooleanProperty LAYER_1 = BooleanProperty.create("layer_1");
    public static final BooleanProperty LAYER_2 = BooleanProperty.create("layer_2");
    public static final BooleanProperty LAYER_3 = BooleanProperty.create("layer_3");
    public static final BooleanProperty LAYER_4 = BooleanProperty.create("layer_4");
}