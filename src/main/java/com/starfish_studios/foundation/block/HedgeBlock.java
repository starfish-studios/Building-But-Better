package com.starfish_studios.foundation.block;

import com.google.common.collect.ImmutableMap;
import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;
import java.util.Map;

public class HedgeBlock extends WallBlock {

    private final Map<BlockState, VoxelShape> shapeByIndex;
    private final Map<BlockState, VoxelShape> collisionShapeByIndex;

    public HedgeBlock(Properties properties) {
        super(properties);
        this.shapeByIndex = this.makeShapes(4.0F, 3.0F, 16.0F, 0.0F, 16.0F, 16.0F);
        this.collisionShapeByIndex = this.makeShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    private Map<BlockState, VoxelShape> makeShapes(float f, float g, float h, float i, float j, float k) {
        float l = 8.0F - f;
        float m = 8.0F + f;
        float n = 8.0F - g;
        float o = 8.0F + g;
        VoxelShape voxelShape = Block.box(l, 0.0, l, m, h, m);
        VoxelShape voxelShape2 = Block.box(n, i, 0.0, o, j, o);
        VoxelShape voxelShape3 = Block.box(n, i, n, o, j, 16.0);
        VoxelShape voxelShape4 = Block.box(0.0, i, n, o, j, o);
        VoxelShape voxelShape5 = Block.box(n, i, n, 16.0, j, o);
        VoxelShape voxelShape6 = Block.box(n, i, 0.0, o, k, o);
        VoxelShape voxelShape7 = Block.box(n, i, n, o, k, 16.0);
        VoxelShape voxelShape8 = Block.box(0.0, i, n, o, k, o);
        VoxelShape voxelShape9 = Block.box(n, i, n, 16.0, k, o);
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();

        for (Boolean boolean_ : UP.getPossibleValues()) {

            for (WallSide wallSide : EAST_WALL.getPossibleValues()) {

                for (WallSide wallSide2 : NORTH_WALL.getPossibleValues()) {

                    for (WallSide wallSide3 : WEST_WALL.getPossibleValues()) {

                        for (WallSide wallSide4 : SOUTH_WALL.getPossibleValues()) {
                            VoxelShape voxelShape10 = Shapes.empty();
                            voxelShape10 = applyWallShape(voxelShape10, wallSide, voxelShape5, voxelShape9);
                            voxelShape10 = applyWallShape(voxelShape10, wallSide3, voxelShape4, voxelShape8);
                            voxelShape10 = applyWallShape(voxelShape10, wallSide2, voxelShape2, voxelShape6);
                            voxelShape10 = applyWallShape(voxelShape10, wallSide4, voxelShape3, voxelShape7);
                            if (boolean_) {
                                voxelShape10 = Shapes.or(voxelShape10, voxelShape);
                            }

                            BlockState blockState = this.defaultBlockState().setValue(UP, boolean_).setValue(EAST_WALL, wallSide).setValue(WEST_WALL, wallSide3).setValue(NORTH_WALL, wallSide2).setValue(SOUTH_WALL, wallSide4);
                            builder.put(blockState.setValue(WATERLOGGED, false), voxelShape10);
                            builder.put(blockState.setValue(WATERLOGGED, true), voxelShape10);
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.shapeByIndex.get(blockState);
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.collisionShapeByIndex.get(blockState);
    }
    
    public boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction);
        return blockState.is(FoundationTags.FoundationBlockTags.HEDGES) || !isExceptionForConnection(blockState) && bl || bl2;
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
