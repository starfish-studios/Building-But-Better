package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.block.properties.FoundationBlockStateProperties;
import com.starfish_studios.foundation.registry.FoundationItems;
import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FrameBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty SIDES = BooleanProperty.create("sides");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty TOP = FoundationBlockStateProperties.TOP;
    public static final BooleanProperty BOTTOM = FoundationBlockStateProperties.BOTTOM;
    public static final BooleanProperty LEFT = FoundationBlockStateProperties.LEFT;
    public static final BooleanProperty RIGHT = FoundationBlockStateProperties.RIGHT;
    private static final VoxelShape NORTH = Block.box(0, 0, 8, 16, 16, 16);
    private static final VoxelShape EAST = Block.box(0, 0, 0, 8, 16, 16);
    private static final VoxelShape SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    private static final VoxelShape WEST = Block.box(8, 0, 0, 16, 16, 16);
    private static final VoxelShape TOP_NORTH_AABB = Block.box(0, 15, 13, 16, 16, 16);
    private static final VoxelShape TOP_EAST_AABB = Block.box(0, 15, 0, 3, 16, 16);
    private static final VoxelShape TOP_SOUTH_AABB = Block.box(0, 15, 0, 16, 16, 3);
    private static final VoxelShape TOP_WEST_AABB = Block.box(13, 15, 0, 16, 16, 16);
    private static final VoxelShape BOTTOM_NORTH_AABB = Block.box(0, -1, 13, 16, 0, 16);
    private static final VoxelShape BOTTOM_EAST_AABB = Block.box(0, -1, 0, 3, 0, 16);
    private static final VoxelShape BOTTOM_SOUTH_AABB = Block.box(0, -1, 0, 16, 0, 3);
    private static final VoxelShape BOTTOM_WEST_AABB = Block.box(13, -1, 0, 16, 0, 16);

    public FrameBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(TOP, true)
                .setValue(BOTTOM, true)
                .setValue(LEFT, true)
                .setValue(RIGHT, true)
                .setValue(SIDES, true)
                .setValue(MIDDLE, false));
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case EAST -> EAST;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            default -> NORTH;
        };
    }

    // TODO: For some reason, this is causing a crash when blocks are broken "too fast". It doesn't crash when the blocks are broken slowly.
    /** "No bounds for empty shape" **/
    /*
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (collisionContext.isHoldingItem(FoundationItems.OAK_FRAME.asItem())) {
            return switch (blockState.getValue(FACING)) {
                case EAST -> EAST;
                case SOUTH -> SOUTH;
                case WEST -> WEST;
                default -> NORTH;
            };
        } else return Shapes.empty();
    } */

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case NORTH -> Shapes.or(blockState.getValue(TOP) ? TOP_NORTH_AABB : Shapes.empty(), blockState.getValue(BOTTOM) ? BOTTOM_NORTH_AABB : Shapes.empty());
            case EAST -> Shapes.or(blockState.getValue(TOP) ? TOP_EAST_AABB : Shapes.empty(), blockState.getValue(BOTTOM) ? BOTTOM_EAST_AABB : Shapes.empty());
            case SOUTH -> Shapes.or(blockState.getValue(TOP) ? TOP_SOUTH_AABB : Shapes.empty(), blockState.getValue(BOTTOM) ? BOTTOM_SOUTH_AABB : Shapes.empty());
            case WEST -> Shapes.or(blockState.getValue(TOP) ? TOP_WEST_AABB : Shapes.empty(), blockState.getValue(BOTTOM) ? BOTTOM_WEST_AABB : Shapes.empty());
            default -> Shapes.empty();
        };
    }

    public boolean propagatesSkylightDown(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return getConnections(state, level, currentPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, TOP, BOTTOM, LEFT, RIGHT, SIDES, MIDDLE);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    public BlockState getConnections(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean n = validConnection(level.getBlockState(pos.north()));
        boolean e = validConnection(level.getBlockState(pos.east()));
        boolean s = validConnection(level.getBlockState(pos.south()));
        boolean w = validConnection(level.getBlockState(pos.west()));
        boolean t = validConnection(level.getBlockState(pos.above()));
        boolean b = validConnection(level.getBlockState(pos.below()));
        if (state.getValue(FACING) == Direction.NORTH) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()));
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()));
            boolean left = !e || !validConnection(level.getBlockState(pos.east()));
            boolean right = !w || !validConnection(level.getBlockState(pos.west()));
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.EAST) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()));
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()));
            boolean left = !s || !validConnection(level.getBlockState(pos.south()));
            boolean right = !n || !validConnection(level.getBlockState(pos.north()));
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.SOUTH) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()));
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()));
            boolean left = !w || !validConnection(level.getBlockState(pos.west()));
            boolean right = !e || !validConnection(level.getBlockState(pos.east()));
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.WEST) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()));
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()));
            boolean left = !n || !validConnection(level.getBlockState(pos.north()));
            boolean right = !s || !validConnection(level.getBlockState(pos.south()));
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        }
        return state;
    }

    public boolean validConnection(BlockState state) {
        if (state.isFaceSturdy(null, null, Direction.UP)
            || state.isFaceSturdy(null, null, Direction.DOWN)) {
            return true;
        }
        return state.is(FoundationTags.FoundationBlockTags.FRAMES);
    }
}
