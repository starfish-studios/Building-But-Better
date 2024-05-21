package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.block.properties.FrameStickDirection;
import com.starfish_studios.bbb.registry.BBBItems;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FrameBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty SIDES = BooleanProperty.create("sides");
    public static final EnumProperty<FrameStickDirection> FRAME_CENTER = BBBBlockStateProperties.FRAME_CENTER;

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty TOP = BBBBlockStateProperties.TOP;
    public static final BooleanProperty BOTTOM = BBBBlockStateProperties.BOTTOM;
    public static final BooleanProperty LEFT = BBBBlockStateProperties.LEFT;
    public static final BooleanProperty RIGHT = BBBBlockStateProperties.RIGHT;
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
                .setValue(FRAME_CENTER, FrameStickDirection.NONE));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (blockState.getValue(FRAME_CENTER) == FrameStickDirection.NONE) {
                blockState = blockState.setValue(FRAME_CENTER, FrameStickDirection.VERTICAL);
            } else if (blockState.getValue(FRAME_CENTER) == FrameStickDirection.VERTICAL) {
                blockState = blockState.setValue(FRAME_CENTER, FrameStickDirection.RIGHT);
            } else if (blockState.getValue(FRAME_CENTER) == FrameStickDirection.RIGHT) {
                blockState = blockState.setValue(FRAME_CENTER, FrameStickDirection.HORIZONTAL);
            } else if (blockState.getValue(FRAME_CENTER) == FrameStickDirection.HORIZONTAL) {
                blockState = blockState.setValue(FRAME_CENTER, FrameStickDirection.LEFT);
            } else if (blockState.getValue(FRAME_CENTER) == FrameStickDirection.LEFT) {
                blockState = blockState.setValue(FRAME_CENTER, FrameStickDirection.VERTICAL);
            }
            level.setBlock(blockPos, blockState, 3);
            level.playSound(player, blockPos, Blocks.SCAFFOLDING.getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else return InteractionResult.PASS;
    }

    @Override
    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if (!level.isClientSide) {
            if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) {
                level.setBlock(blockPos, blockState.setValue(FRAME_CENTER, FrameStickDirection.NONE), 3);
                level.playSound(null, blockPos, Blocks.SCAFFOLDING.getSoundType(level.getBlockState(blockPos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case EAST -> EAST;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            default -> NORTH;
        };
    }

    @Override
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
        builder.add(FACING, WATERLOGGED, TOP, BOTTOM, LEFT, RIGHT, SIDES, FRAME_CENTER);
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
        if (state.isFaceSturdy(null, null, Direction.UP) ||
                state.isFaceSturdy(null, null, Direction.DOWN) ||
                state.isFaceSturdy(null, null, Direction.NORTH) ||
                state.isFaceSturdy(null, null, Direction.EAST) ||
                state.isFaceSturdy(null, null, Direction.SOUTH) ||
                state.isFaceSturdy(null, null, Direction.WEST)) {
            return true;
        }
        return state.is(BBBTags.BBBBlockTags.FRAMES);
    }
}
