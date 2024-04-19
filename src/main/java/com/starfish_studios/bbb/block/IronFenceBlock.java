package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IronFenceBlock extends WallBlock {
    public static final EnumProperty<WallSide> EAST = BlockStateProperties.EAST_WALL;
    public static final EnumProperty<WallSide> NORTH = BlockStateProperties.NORTH_WALL;
    public static final EnumProperty<WallSide> SOUTH = BlockStateProperties.SOUTH_WALL;
    public static final EnumProperty<WallSide> WEST = BlockStateProperties.WEST_WALL;
    private static final VoxelShape POST_TEST = Block.box(6, 0, 6, 10, 16, 10);
    private static final VoxelShape NORTH_TEST = Block.box(7, 0, 0, 9, 16, 8);
    private static final VoxelShape SOUTH_TEST = Block.box(7, 0, 8, 9, 16, 16);
    private static final VoxelShape WEST_TEST = Block.box(0, 0, 7, 8, 16, 9);
    private static final VoxelShape EAST_TEST = Block.box(8, 0, 7, 16, 16, 9);

    public IronFenceBlock(Properties properties) {
        super(properties);
    }

    public boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction);
        return blockState.is(BBBTags.BBBBlockTags.METAL_FENCES) || !isExceptionForConnection(blockState) && bl || bl2;
    }

    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = POST_TEST;

        if (state.getValue(NORTH) != WallSide.NONE && state.getValue(SOUTH) != WallSide.NONE && state.getValue(EAST) == WallSide.NONE && state.getValue(WEST) == WallSide.NONE) shape = Shapes.empty();
        if (state.getValue(NORTH) == WallSide.NONE && state.getValue(SOUTH) == WallSide.NONE && state.getValue(EAST) != WallSide.NONE && state.getValue(WEST) != WallSide.NONE) shape = Shapes.empty();
        if (state.getValue(NORTH) != WallSide.NONE && state.getValue(SOUTH) != WallSide.NONE && state.getValue(EAST) != WallSide.NONE && state.getValue(WEST) != WallSide.NONE) shape = Shapes.empty();
        if (blockGetter.getBlockState(blockPos.above()).getBlock() instanceof WallBlock && blockGetter.getBlockState(blockPos.above()).getValue(WallBlock.UP) && state.getValue(WallBlock.UP)) shape = POST_TEST;

        if (state.getValue(NORTH) != WallSide.NONE) shape = Shapes.or(shape, NORTH_TEST);
        if (state.getValue(EAST) != WallSide.NONE) shape = Shapes.or(shape, EAST_TEST);
        if (state.getValue(SOUTH) != WallSide.NONE) shape = Shapes.or(shape, SOUTH_TEST);
        if (state.getValue(WEST) != WallSide.NONE) shape = Shapes.or(shape, WEST_TEST);
        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        LevelReader levelReader = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockPos blockPos6 = blockPos.above();
        BlockState blockState = levelReader.getBlockState(blockPos2);
        BlockState blockState2 = levelReader.getBlockState(blockPos3);
        BlockState blockState3 = levelReader.getBlockState(blockPos4);
        BlockState blockState4 = levelReader.getBlockState(blockPos5);
        BlockState blockState5 = levelReader.getBlockState(blockPos6);
        boolean bl = this.connectsTo(blockState, blockState.isFaceSturdy(levelReader, blockPos2, Direction.SOUTH), Direction.SOUTH);
        boolean bl2 = this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos3, Direction.WEST), Direction.WEST);
        boolean bl3 = this.connectsTo(blockState3, blockState3.isFaceSturdy(levelReader, blockPos4, Direction.NORTH), Direction.NORTH);
        boolean bl4 = this.connectsTo(blockState4, blockState4.isFaceSturdy(levelReader, blockPos5, Direction.EAST), Direction.EAST);
        BlockState blockState6 = this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return this.updateShape(levelReader, blockState6, blockPos6, blockState5, bl, bl2, bl3, bl4);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        if (direction == Direction.DOWN) {
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        } else {
            return direction == Direction.UP ? this.topUpdate(levelAccessor, blockState, blockPos2, blockState2) : this.sideUpdate(levelAccessor, blockPos, blockState, blockPos2, blockState2, direction);
        }
    }

    private BlockState sideUpdate(LevelReader levelReader, BlockPos blockPos, BlockState blockState, BlockPos blockPos2, BlockState blockState2, Direction direction) {
        Direction direction2 = direction.getOpposite();
        boolean bl = direction == Direction.NORTH ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, NORTH_WALL);
        boolean bl2 = direction == Direction.EAST ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, EAST_WALL);
        boolean bl3 = direction == Direction.SOUTH ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, SOUTH_WALL);
        boolean bl4 = direction == Direction.WEST ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, WEST_WALL);
        BlockPos blockPos3 = blockPos.above();
        BlockState blockState3 = levelReader.getBlockState(blockPos3);
        return this.updateShape(levelReader, blockState, blockPos3, blockState3, bl, bl2, bl3, bl4);
    }
}
