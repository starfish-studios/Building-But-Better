package com.starfish_studios.building_but_better.block;

import com.starfish_studios.building_but_better.block.properties.BBBBlockStateProperties;
import com.starfish_studios.building_but_better.block.properties.FrameStickDirection;
import com.starfish_studios.building_but_better.registry.ModBlockTags;
import com.starfish_studios.building_but_better.registry.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!stack.is(ModItemTags.HAMMERS)) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        // TODO: This cycles through the frame center options, rotating it sort of like an Item Frame
        // region FRAME CENTER CYCLING
        FrameStickDirection frameStickDirection = state.getValue(FRAME_CENTER);
        if (frameStickDirection == FrameStickDirection.NONE) state = state.setValue(FRAME_CENTER, FrameStickDirection.VERTICAL);
        else if (frameStickDirection == FrameStickDirection.VERTICAL) state = state.setValue(FRAME_CENTER, FrameStickDirection.RIGHT);
        else if (frameStickDirection == FrameStickDirection.RIGHT) state = state.setValue(FRAME_CENTER, FrameStickDirection.HORIZONTAL);
        else if (frameStickDirection == FrameStickDirection.HORIZONTAL) state = state.setValue(FRAME_CENTER, FrameStickDirection.LEFT);
        else if (frameStickDirection == FrameStickDirection.LEFT) state = state.setValue(FRAME_CENTER, FrameStickDirection.VERTICAL);

        level.setBlock(pos, state, 3);
        level.playSound(player, pos, Blocks.SCAFFOLDING.defaultBlockState().getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
        return ItemInteractionResult.SUCCESS;
        // endregion
    }

    @Override
    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if (!level.isClientSide) {
            if (blockState.getValue(FRAME_CENTER) != FrameStickDirection.NONE) {
                level.setBlock(blockPos, blockState.setValue(FRAME_CENTER, FrameStickDirection.NONE), 3);
                level.playSound(null, blockPos, Blocks.SCAFFOLDING.defaultBlockState().getSoundType().getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
            }
        }
    }

    @Override
    // TODO: Make these use tags instead of direct items.
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext entityContext && entityContext.getEntity() instanceof Player player && player.isHolding(stack ->
        stack.is(ModItemTags.FRAMES) ||
        stack.is(ModItemTags.HAMMERS) || player.isShiftKeyDown())) { // todo && !BBBConfig.disableFrameCrouchHitbox) || BBBConfig.alwaysShowFrameHitboxes) {
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
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return getConnections(state, level, currentPos);
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
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public BlockState getConnections(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean n = validConnection(level.getBlockState(pos.north()), level, pos.north());
        boolean e = validConnection(level.getBlockState(pos.east()), level, pos.east());
        boolean s = validConnection(level.getBlockState(pos.south()), level, pos.south());
        boolean w = validConnection(level.getBlockState(pos.west()), level, pos.west());
        boolean t = validConnection(level.getBlockState(pos.above()), level, pos.above());
        boolean b = validConnection(level.getBlockState(pos.below()), level, pos.below());
        if (state.getValue(FACING) == Direction.NORTH) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()), level, pos.above());
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()), level, pos.below());
            boolean left = !e || !validConnection(level.getBlockState(pos.east()), level, pos.east());
            boolean right = !w || !validConnection(level.getBlockState(pos.west()), level, pos.west());
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.EAST) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()), level, pos.above());
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()), level, pos.below());
            boolean left = !s || !validConnection(level.getBlockState(pos.south()), level, pos.south());
            boolean right = !n || !validConnection(level.getBlockState(pos.north()), level, pos.north());
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.SOUTH) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()), level, pos.above());
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()), level, pos.below());
            boolean left = !w || !validConnection(level.getBlockState(pos.west()), level, pos.west());
            boolean right = !e || !validConnection(level.getBlockState(pos.east()), level, pos.east());
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.WEST) {
            boolean top = !t || !validConnection(level.getBlockState(pos.above()), level, pos.above());
            boolean bottom = !b || !validConnection(level.getBlockState(pos.below()), level, pos.below());
            boolean left = !n || !validConnection(level.getBlockState(pos.north()), level, pos.north());
            boolean right = !s || !validConnection(level.getBlockState(pos.south()), level, pos.south());
            return state
                    .setValue(TOP, top)
                    .setValue(BOTTOM, bottom)
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        }
        return state;
    }

    public boolean validConnection(BlockState state, BlockGetter getter, BlockPos pos) {
        if (state.isFaceSturdy(getter, pos, Direction.UP) ||
                state.isFaceSturdy(getter, pos, Direction.DOWN) ||
                state.isFaceSturdy(getter, pos, Direction.NORTH) ||
                state.isFaceSturdy(getter, pos, Direction.EAST) ||
                state.isFaceSturdy(getter, pos, Direction.SOUTH) ||
                state.isFaceSturdy(getter, pos, Direction.WEST)) {
            return true;
        }

        return state.is(ModBlockTags.FRAMES) || state.is(ModBlockTags.STONE_FRAMES);
    }
}
