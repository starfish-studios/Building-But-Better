package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class StoneFenceBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION =
            PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((entry) -> entry.getKey().getAxis().isHorizontal()).collect(Util.toMap());
    public static final BooleanProperty SIDE_FILL = BooleanProperty.create("side_fill");
    public static final BooleanProperty PILLAR = BooleanProperty.create("pillar");


    public VoxelShape PILLAR_AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    public VoxelShape NORTH_AABB = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 4.0D);
    public VoxelShape EAST_AABB = Block.box(12.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);
    public VoxelShape SOUTH_AABB = Block.box(4.0D, 0.0D, 12.0D, 12.0D, 16.0D, 16.0D);
    public VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 4.0D, 4.0D, 16.0D, 12.0D);

    public StoneFenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()
                .setValue(NORTH, false)).setValue(EAST, false)
                .setValue(SOUTH, false).setValue(WEST, false)
                .setValue(WATERLOGGED, false)
                .setValue(SIDE_FILL, false)
                .setValue(PILLAR, true));
    }

    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = PILLAR_AABB;
        if (state.getValue(NORTH)) shape = Shapes.or(shape, NORTH_AABB);
        if (state.getValue(EAST)) shape = Shapes.or(shape, EAST_AABB);
        if (state.getValue(SOUTH)) shape = Shapes.or(shape, SOUTH_AABB);
        if (state.getValue(WEST)) shape = Shapes.or(shape, WEST_AABB);
        return shape;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(NORTH) && !state.getValue(EAST) && !state.getValue(SOUTH) && !state.getValue(WEST)) {
            level.setBlock(pos, state.setValue(PILLAR, true), 3);
        }
    }

    public VoxelShape getVisualShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }

    public boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = this.isSameFence(blockState);
        boolean bl3 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction);
        return !isExceptionForConnection(blockState) && bl || bl2 || bl3;
    }

    public static boolean isExceptionForConnection(BlockState blockState) {
        return blockState.getBlock() instanceof LeavesBlock || blockState.is(Blocks.BARRIER) || blockState.is(Blocks.CARVED_PUMPKIN) || blockState.is(Blocks.JACK_O_LANTERN) || blockState.is(Blocks.MELON) || blockState.is(Blocks.PUMPKIN) || blockState.is(BlockTags.SHULKER_BOXES)
                || blockState.getBlock() instanceof ColumnBlock;
    }

    private boolean isSameFence(BlockState blockState) {
        return blockState.is(BBBTags.BBBBlockTags.STONE_FENCES) || blockState.is(BlockTags.WALLS);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockGetter blockGetter = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockState blockState = blockGetter.getBlockState(blockPos2);
        BlockState blockState2 = blockGetter.getBlockState(blockPos3);
        BlockState blockState3 = blockGetter.getBlockState(blockPos4);
        BlockState blockState4 = blockGetter.getBlockState(blockPos5);
        return super.getStateForPlacement(blockPlaceContext)
                .setValue(NORTH, this.connectsTo(blockState, blockState.isFaceSturdy(blockGetter, blockPos2, Direction.SOUTH), Direction.SOUTH))
                .setValue(EAST, this.connectsTo(blockState2, blockState2.isFaceSturdy(blockGetter, blockPos3, Direction.WEST), Direction.WEST))
                .setValue(SOUTH, this.connectsTo(blockState3, blockState3.isFaceSturdy(blockGetter, blockPos4, Direction.NORTH), Direction.NORTH))
                .setValue(WEST, this.connectsTo(blockState4, blockState4.isFaceSturdy(blockGetter, blockPos5, Direction.EAST), Direction.EAST))
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return direction.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? blockState.setValue(PROPERTY_BY_DIRECTION.get(direction),
                this.connectsTo(blockState2, blockState2.isFaceSturdy(levelAccessor, blockPos2, direction.getOpposite()), direction.getOpposite()))
                : super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 ->
                    blockState
                            .setValue(NORTH, blockState.getValue(SOUTH))
                            .setValue(EAST, blockState.getValue(WEST))
                            .setValue(SOUTH, blockState.getValue(NORTH))
                            .setValue(WEST, blockState.getValue(EAST));
            case COUNTERCLOCKWISE_90 ->
                    blockState
                            .setValue(NORTH, blockState.getValue(EAST))
                            .setValue(EAST, blockState.getValue(SOUTH))
                            .setValue(SOUTH, blockState.getValue(WEST))
                            .setValue(WEST, blockState.getValue(NORTH));
            case CLOCKWISE_90 ->
                    blockState
                            .setValue(NORTH, blockState.getValue(WEST))
                            .setValue(EAST, blockState.getValue(NORTH))
                            .setValue(SOUTH, blockState.getValue(EAST))
                            .setValue(WEST, blockState.getValue(SOUTH));
            default -> blockState;
        };
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT:
                return blockState.setValue(NORTH, blockState.getValue(SOUTH)).setValue(SOUTH, blockState.getValue(NORTH));
            case FRONT_BACK:
                return blockState.setValue(EAST, blockState.getValue(WEST)).setValue(WEST, blockState.getValue(EAST));
            default:
                return super.mirror(blockState, mirror);
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateDefinition) {
        stateDefinition.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, SIDE_FILL, PILLAR);
    }
}
