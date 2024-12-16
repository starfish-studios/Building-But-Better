package com.starfish_studios.building_but_better.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodenWallBlock extends WallBlock {
    
    // region VARIABLES
    public static final EnumProperty<WallSide> EAST = BlockStateProperties.EAST_WALL;
    public static final EnumProperty<WallSide> NORTH = BlockStateProperties.NORTH_WALL;
    public static final EnumProperty<WallSide> SOUTH = BlockStateProperties.SOUTH_WALL;
    public static final EnumProperty<WallSide> WEST = BlockStateProperties.WEST_WALL;

    private static final VoxelShape POST_TEST = Block.box(4, 0, 4, 12, 16, 12);
    private static final VoxelShape NORTH_TEST = Block.box(4, 0, 0, 12, 16, 4);
    private static final VoxelShape WEST_TEST = Block.box(0, 0, 4, 4, 16, 12);
    private static final VoxelShape SOUTH_TEST = Block.box(4, 0, 12, 12, 16, 16);
    private static final VoxelShape EAST_TEST = Block.box(12, 0, 4, 16, 16, 12);

    private static final VoxelShape POST_COLLISION = Block.box(4, 0, 4, 12, 24, 12);
    private static final VoxelShape NORTH_COLLISION = Block.box(4, 0, 0, 12, 24, 4);
    private static final VoxelShape WEST_COLLISION = Block.box(0, 0, 4, 4, 24, 12);
    private static final VoxelShape SOUTH_COLLISION = Block.box(4, 0, 12, 12, 24, 16);
    private static final VoxelShape EAST_COLLISION = Block.box(12, 0, 4, 16, 24, 12);

    // endregion

    public WoodenWallBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = POST_TEST;

        if (state.getValue(NORTH) != WallSide.NONE && state.getValue(SOUTH) != WallSide.NONE && state.getValue(EAST) == WallSide.NONE && state.getValue(WEST) == WallSide.NONE) shape = Shapes.empty();
        if (state.getValue(NORTH) == WallSide.NONE && state.getValue(SOUTH) == WallSide.NONE && state.getValue(EAST) != WallSide.NONE && state.getValue(WEST) != WallSide.NONE) shape = Shapes.empty();
        if (state.getValue(NORTH) != WallSide.NONE && state.getValue(SOUTH) != WallSide.NONE && state.getValue(EAST) != WallSide.NONE && state.getValue(WEST) != WallSide.NONE) shape = Shapes.empty();
        if (blockGetter.getBlockState(blockPos.above()).getBlock() instanceof WallBlock && blockGetter.getBlockState(blockPos.above()).getValue(WallBlock.UP) && state.getValue(WallBlock.UP)) shape = POST_TEST;
        if (!state.getValue(WallBlock.UP)) shape = POST_TEST;
        if (state.getValue(NORTH) != WallSide.NONE) shape = Shapes.or(shape, NORTH_TEST);
        if (state.getValue(EAST) != WallSide.NONE) shape = Shapes.or(shape, EAST_TEST);
        if (state.getValue(SOUTH) != WallSide.NONE) shape = Shapes.or(shape, SOUTH_TEST);
        if (state.getValue(WEST) != WallSide.NONE) shape = Shapes.or(shape, WEST_TEST);
        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = POST_COLLISION;

        if (blockState.getValue(NORTH) != WallSide.NONE && blockState.getValue(SOUTH) != WallSide.NONE && blockState.getValue(EAST) == WallSide.NONE && blockState.getValue(WEST) == WallSide.NONE) shape = Shapes.empty();
        if (blockState.getValue(NORTH) == WallSide.NONE && blockState.getValue(SOUTH) == WallSide.NONE && blockState.getValue(EAST) != WallSide.NONE && blockState.getValue(WEST) != WallSide.NONE) shape = Shapes.empty();
        if (blockState.getValue(NORTH) != WallSide.NONE && blockState.getValue(SOUTH) != WallSide.NONE && blockState.getValue(EAST) != WallSide.NONE && blockState.getValue(WEST) != WallSide.NONE) shape = Shapes.empty();
        if (blockGetter.getBlockState(blockPos.above()).getBlock() instanceof WallBlock && blockGetter.getBlockState(blockPos.above()).getValue(WallBlock.UP) && blockState.getValue(WallBlock.UP)) shape = POST_COLLISION;
        if (!blockState.getValue(WallBlock.UP)) shape = POST_COLLISION;
        if (blockState.getValue(NORTH) != WallSide.NONE) shape = Shapes.or(shape, NORTH_COLLISION);
        if (blockState.getValue(EAST) != WallSide.NONE) shape = Shapes.or(shape, EAST_COLLISION);
        if (blockState.getValue(SOUTH) != WallSide.NONE) shape = Shapes.or(shape, SOUTH_COLLISION);
        if (blockState.getValue(WEST) != WallSide.NONE) shape = Shapes.or(shape, WEST_COLLISION);
        return shape;
    }
}
