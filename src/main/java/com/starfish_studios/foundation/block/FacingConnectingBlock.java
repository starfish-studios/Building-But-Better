package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.block.properties.ColumnType;
import com.starfish_studios.foundation.block.properties.FoundationBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class FacingConnectingBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<ColumnType> TYPE = FoundationBlockStateProperties.COLUMN_TYPE;

    public FacingConnectingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TYPE, ColumnType.NONE));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction.Axis axis = context.getClickedFace().getAxis();

        BlockState state = this.defaultBlockState().setValue(AXIS, axis);
        state = state.setValue(TYPE, getType(state, getRelativeTop(level, pos, axis), getRelativeBottom(level, pos, axis)));
        return state;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        Direction.Axis axis = state.getValue(AXIS);
        ColumnType type = getType(state, getRelativeTop(level, pos, axis), getRelativeBottom(level, pos, axis));
        if (state.getValue(TYPE) == type) return;

        state = state.setValue(TYPE, type);
        level.setBlock(pos, state, 3);
    }

    public BlockState getRelativeTop(Level level, BlockPos pos, Direction.Axis axis) {
        return level.getBlockState(pos.relative(Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE)));
    }

    public BlockState getRelativeBottom(Level level, BlockPos pos, Direction.Axis axis) {
        return level.getBlockState(pos.relative(Direction.fromAxisAndDirection(axis, Direction.AxisDirection.NEGATIVE)));
    }

    public ColumnType getType(BlockState state, BlockState above, BlockState below) {
        boolean shape_above_same = above.is(state.getBlock()) && state.getValue(AXIS) == above.getValue(AXIS);
        boolean shape_below_same = below.is(state.getBlock()) && state.getValue(AXIS) == below.getValue(AXIS);

        if (shape_above_same && !shape_below_same) return ColumnType.BOTTOM;
        else if (!shape_above_same && shape_below_same) return ColumnType.TOP;
        else if (shape_above_same) return ColumnType.MIDDLE;
        return ColumnType.NONE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, AXIS);
    }
}
