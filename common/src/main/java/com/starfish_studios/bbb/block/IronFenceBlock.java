package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class IronFenceBlock extends WallBlock {
    private static final VoxelShape POST_TEST = Block.box(7, 0, 7, 9, 16, 9);
    private static final VoxelShape NORTH_TEST = Block.box(7, 0, 0, 9, 16, 9);
    private static final VoxelShape SOUTH_TEST = Block.box(7, 0, 7, 9, 16, 16);
    private static final VoxelShape WEST_TEST = Block.box(0, 0, 7, 9, 16, 9);
    private static final VoxelShape EAST_TEST = Block.box(7, 0, 7, 16, 16, 9);
    
    public IronFenceBlock(Properties props) { super(props); }

    private static boolean isCoveredLocal(VoxelShape shape, VoxelShape test) {
        return !Shapes.joinIsNotEmpty(test, shape, BooleanOp.ONLY_FIRST);
    }

    protected boolean connectsToCustom(BlockState state, boolean sturdy, Direction direction) {
        Block block = state.getBlock();
        boolean gate = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
        return state.is(BBBTags.BBBBlockTags.METAL_FENCES) || (!isExceptionForConnection(state) && sturdy) || gate;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluid = level.getFluidState(pos);

        BlockPos north = pos.north(), east = pos.east(), south = pos.south(), west = pos.west(), up = pos.above();
        BlockState northState = level.getBlockState(north), eastState = level.getBlockState(east),
                southState = level.getBlockState(south), westState = level.getBlockState(west),
                support = level.getBlockState(up);

        boolean north2 = connectsToCustom(northState, northState.isFaceSturdy(level, north, Direction.SOUTH), Direction.SOUTH);
        boolean east2 = connectsToCustom(eastState, eastState.isFaceSturdy(level, east, Direction.WEST), Direction.WEST);
        boolean south2 = connectsToCustom(southState, southState.isFaceSturdy(level, south, Direction.NORTH), Direction.NORTH);
        boolean west2 = connectsToCustom(westState, westState.isFaceSturdy(level, west, Direction.EAST), Direction.EAST);

        BlockState base = defaultBlockState().setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        return redoConnections(level, base, up, support, north2, east2, south2, west2);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighbor, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) { level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level)); }
        if (direction == Direction.DOWN) return super.updateShape(state, direction, neighbor, level, pos, neighborPos);
        if (direction == Direction.UP) {
            return redoConnections(level, state, neighborPos, neighbor,
                    state.getValue(NORTH_WALL) != WallSide.NONE,
                    state.getValue(EAST_WALL) != WallSide.NONE,
                    state.getValue(SOUTH_WALL) != WallSide.NONE,
                    state.getValue(WEST_WALL) != WallSide.NONE);
        }

        Direction opposite = direction.getOpposite();
        boolean north = direction == Direction.NORTH ? connectsToCustom(neighbor, neighbor.isFaceSturdy(level, neighborPos, opposite), opposite) : state.getValue(NORTH_WALL) != WallSide.NONE;
        boolean east = direction == Direction.EAST ? connectsToCustom(neighbor, neighbor.isFaceSturdy(level, neighborPos, opposite), opposite) : state.getValue(EAST_WALL) != WallSide.NONE;
        boolean south = direction == Direction.SOUTH ? connectsToCustom(neighbor, neighbor.isFaceSturdy(level, neighborPos, opposite), opposite) : state.getValue(SOUTH_WALL) != WallSide.NONE;
        boolean west = direction == Direction.WEST ? connectsToCustom(neighbor, neighbor.isFaceSturdy(level, neighborPos, opposite), opposite) : state.getValue(WEST_WALL) != WallSide.NONE;

        BlockPos upPos = pos.above();
        BlockState aboveState = level.getBlockState(upPos);
        return redoConnections(level, state, upPos, aboveState, north, east, south, west);
    }

    private BlockState redoConnections(LevelReader level, BlockState state, BlockPos pos,
                                          BlockState aboveState, boolean north, boolean east, boolean south, boolean west) {
        VoxelShape shape = aboveState.getCollisionShape(level, pos).getFaceShape(Direction.DOWN);
        state = updateSides(state, north, east, south, west, shape);
        return state.setValue(UP, shouldReplacePost(state, aboveState, shape));
    }

    private boolean shouldReplacePost(BlockState state, BlockState aboveState, VoxelShape aboveShape) {
        if (aboveState.getBlock() instanceof WallBlock && aboveState.getValue(UP)) return true;

        WallSide north = state.getValue(NORTH_WALL);
        WallSide east = state.getValue(EAST_WALL);
        WallSide south = state.getValue(SOUTH_WALL);
        WallSide west = state.getValue(WEST_WALL);

        boolean northEmpty = north == WallSide.NONE;
        boolean eastEmpty = east == WallSide.NONE;
        boolean southEmpty = south == WallSide.NONE;
        boolean westEmpty = west == WallSide.NONE;

        if ((northEmpty && southEmpty && eastEmpty && westEmpty) || (northEmpty != southEmpty) || (eastEmpty  != westEmpty)) {
            return true;
        }

        if ((north == WallSide.TALL && south == WallSide.TALL) || (east  == WallSide.TALL && west  == WallSide.TALL)) {
            return false;
        }

        return aboveState.is(BlockTags.WALL_POST_OVERRIDE) || isCoveredLocal(aboveShape, POST_TEST);
    }

    private BlockState updateSides(BlockState state, boolean north, boolean east, boolean south, boolean west, VoxelShape shape) {
        return state.setValue(NORTH_WALL, forceWallState(north, shape, NORTH_TEST))
            .setValue(EAST_WALL, forceWallState(east, shape, EAST_TEST))
            .setValue(SOUTH_WALL, forceWallState(south,shape, SOUTH_TEST))
            .setValue(WEST_WALL, forceWallState(west, shape, WEST_TEST));
    }

    private WallSide forceWallState(boolean connect, VoxelShape shape, VoxelShape test) {
        if (!connect) return WallSide.NONE;
        return isCoveredLocal(shape, test) ? WallSide.TALL : WallSide.LOW;
    }
}
