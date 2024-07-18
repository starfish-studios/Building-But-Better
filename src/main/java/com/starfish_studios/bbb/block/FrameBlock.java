package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.BBBConfig;
import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.block.properties.FrameStickDirection;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FrameBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty CORNERS = BooleanProperty.create("corners");
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


    private static final VoxelShape NORTH_RIGHT_AABB = Block.box(0, 0, 13, 1, 16, 16);
    private static final VoxelShape NORTH_LEFT_AABB = Block.box(15, 0, 13, 16, 16, 16);
    private static final VoxelShape NORTH_TOP_AABB = Block.box(0, 15, 13, 16, 16, 16);
    private static final VoxelShape NORTH_BOTTOM_AABB = Block.box(0, -1, 13, 16, 0, 16);
    private static final VoxelShape NORTH_CENTER_AABB = Block.box(4, 0, 13, 12, 16, 16);

    private static final VoxelShape WEST_LEFT_AABB = Block.box(13, 0, 0, 16, 16, 1);
    private static final VoxelShape WEST_RIGHT_AABB = Block.box(13, 0, 15, 16, 16, 16);
    private static final VoxelShape WEST_TOP_AABB = Block.box(13, 15, 0, 16, 16, 16);
    private static final VoxelShape WEST_BOTTOM_AABB = Block.box(13, -1, 0, 16, 0, 16);
    private static final VoxelShape WEST_CENTER_AABB = Block.box(13, 0, 4, 16, 16, 12);

    private static final VoxelShape SOUTH_LEFT_AABB = Block.box(0, 0, 0, 3, 16, 3);
    private static final VoxelShape SOUTH_RIGHT_AABB = Block.box(13, 0, 0, 16, 16, 3);
    private static final VoxelShape SOUTH_TOP_AABB = Block.box(0, 15, 0, 16, 16, 3);
    private static final VoxelShape SOUTH_BOTTOM_AABB = Block.box(0, -1, 0, 16, 0, 3);
    private static final VoxelShape SOUTH_CENTER_AABB = Block.box(4, 0, 0, 12, 16, 3);


    private static final VoxelShape EAST_LEFT_AABB = Block.box(0, 0, 15, 3, 16, 16);
    private static final VoxelShape EAST_RIGHT_AABB = Block.box(0, 0, 0, 3, 16, 1);
    private static final VoxelShape EAST_TOP_AABB = Block.box(0, 15, 0, 3, 16, 16);
    private static final VoxelShape EAST_BOTTOM_AABB = Block.box(0, -1, 0, 3, 0, 16);
    private static final VoxelShape EAST_CENTER_AABB = Block.box(0, 0, 4, 3, 16, 12);



    public FrameBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(TOP, true)
                .setValue(BOTTOM, true)
                .setValue(LEFT, true)
                .setValue(RIGHT, true)
                .setValue(CORNERS, true)
                .setValue(FRAME_CENTER, FrameStickDirection.NONE));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(BBBTags.BBBItemTags.HAMMERS)) {
            // TODO: This cycles through the frame center options, rotating it sort of like an Item Frame
            // region FRAME CENTER CYCLING
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
            // endregion
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
    // TODO: Make these use tags instead of direct items.
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext entityContext && entityContext.getEntity() instanceof Player player && player.isHolding(stack ->
        stack.is(BBBTags.BBBItemTags.FRAMES) ||
        stack.is(BBBTags.BBBItemTags.HAMMERS) || player.isShiftKeyDown() && !BBBConfig.disableFrameCrouchHitbox) || BBBConfig.alwaysShowFrameHitboxes) {
            return switch (blockState.getValue(FACING)) {
                case EAST -> EAST;
                case SOUTH -> SOUTH;
                case WEST -> WEST;
                default -> NORTH;
            };
        }
        VoxelShape shape = Shapes.empty();

        if (blockState.getValue(FACING) == Direction.NORTH) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, NORTH_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, NORTH_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, NORTH_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, NORTH_BOTTOM_AABB);
        } else if (blockState.getValue(FACING) == Direction.EAST) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, EAST_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, EAST_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, EAST_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, EAST_BOTTOM_AABB);
        } else if (blockState.getValue(FACING) == Direction.SOUTH) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, SOUTH_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, SOUTH_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, SOUTH_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, SOUTH_BOTTOM_AABB);
        } else if (blockState.getValue(FACING) == Direction.WEST) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, WEST_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, WEST_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, WEST_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, WEST_BOTTOM_AABB);
        }
        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = Shapes.empty();

        if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) {
            if (blockState.getValue(FACING) == Direction.NORTH) {
                if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) return Shapes.or(shape, NORTH_CENTER_AABB);
            } else if (blockState.getValue(FACING) == Direction.EAST) {
                if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) return Shapes.or(shape, EAST_CENTER_AABB);
            } else if (blockState.getValue(FACING) == Direction.SOUTH) {
                if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) return Shapes.or(shape, SOUTH_CENTER_AABB);
            } else if (blockState.getValue(FACING) == Direction.WEST) {
                if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) return Shapes.or(shape, WEST_CENTER_AABB);
            }
        }
        if (blockState.getValue(FACING) == Direction.NORTH) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, NORTH_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, NORTH_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, NORTH_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, NORTH_BOTTOM_AABB);
        } else if (blockState.getValue(FACING) == Direction.EAST) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, EAST_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, EAST_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, EAST_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, EAST_BOTTOM_AABB);
        } else if (blockState.getValue(FACING) == Direction.SOUTH) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, SOUTH_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, SOUTH_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, SOUTH_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, SOUTH_BOTTOM_AABB);
        } else if (blockState.getValue(FACING) == Direction.WEST) {
            if (blockState.getValue(LEFT)) shape = Shapes.or(shape, WEST_LEFT_AABB);
            if (blockState.getValue(RIGHT)) shape = Shapes.or(shape, WEST_RIGHT_AABB);
            if (blockState.getValue(TOP)) shape = Shapes.or(shape, WEST_TOP_AABB);
            if (blockState.getValue(BOTTOM)) shape = Shapes.or(shape, WEST_BOTTOM_AABB);
        }
        return shape;
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
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        var facing = state.getValue(FACING);
        return state
                .setValue(TOP, checkConnection(level, currentPos, Direction.UP))
                .setValue(BOTTOM, checkConnection(level, currentPos, Direction.DOWN))
                .setValue(LEFT, checkConnection(level, currentPos, facing.getClockWise()))
                .setValue(RIGHT, checkConnection(level, currentPos, facing.getCounterClockWise()));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, TOP, BOTTOM, LEFT, RIGHT, CORNERS, FRAME_CENTER);
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

    private static boolean checkConnection(LevelAccessor level, BlockPos pos, Direction direction) {
        var relativePos = pos.relative(direction);
        var state = level.getBlockState(relativePos);
        boolean validConnection = state.is(BBBTags.BBBBlockTags.FRAMES)
                || state.is(BBBTags.BBBBlockTags.STONE_FRAMES)
                || state.isFaceSturdy(level, relativePos, direction.getOpposite());
        return !validConnection;
    }
}
