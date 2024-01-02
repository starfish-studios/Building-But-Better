package com.starfish_studios.foundation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SupportBlock extends HorizontalDirectionalBlock {
    protected static VoxelShape NORTH = Shapes.or(
            Block.box(4, 8, 0, 12, 16, 16),
            Block.box(4, 0, 8, 12, 8, 16)
    );
    protected static VoxelShape SOUTH = Shapes.or(
            Block.box(4, 8, 0, 12, 16, 16),
            Block.box(4, 0, 0, 12, 8, 8)
    );
    protected static VoxelShape WEST = Shapes.or(
            Block.box(0, 8, 4, 16, 16, 12),
            Block.box(8, 0, 4, 16, 8, 12)
    );
    protected static VoxelShape EAST = Shapes.or(
            Block.box(0, 8, 4, 16, 16, 12),
            Block.box(0, 0, 4, 8, 8, 12)
    );

    public SupportBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getVisualShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Block.box(0, 0, 0, 0, 0, 0);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        return switch (direction) {
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
            default -> Shapes.empty();
        };
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
