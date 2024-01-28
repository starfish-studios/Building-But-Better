package com.starfish_studios.foundation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;

import java.util.Iterator;

public class BranchBlock extends PipeBlock {
    public BranchBlock(BlockBehaviour.Properties properties) {
        super(0.3125F, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.getStateForPlacement(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos());
    }

    public BlockState getStateForPlacement(BlockGetter blockGetter, BlockPos blockPos) {
        BlockState blockState = blockGetter.getBlockState(blockPos.below());
        BlockState blockState2 = blockGetter.getBlockState(blockPos.above());
        BlockState blockState3 = blockGetter.getBlockState(blockPos.north());
        BlockState blockState4 = blockGetter.getBlockState(blockPos.east());
        BlockState blockState5 = blockGetter.getBlockState(blockPos.south());
        BlockState blockState6 = blockGetter.getBlockState(blockPos.west());
        return this.defaultBlockState()
                .setValue(DOWN, blockState.is(this) || blockState.is(BlockTags.LOGS) || blockState.is(BlockTags.FENCES))
                .setValue(UP, blockState2.is(this) || blockState2.is(BlockTags.LOGS) || blockState2.is(BlockTags.FENCES))
                .setValue(NORTH, blockState3.is(this) || blockState3.is(BlockTags.LOGS))
                .setValue(EAST, blockState4.is(this) || blockState4.is(BlockTags.LOGS))
                .setValue(SOUTH, blockState5.is(this) || blockState5.is(BlockTags.LOGS))
                .setValue(WEST, blockState6.is(this) || blockState6.is(BlockTags.LOGS));
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (!blockState.canSurvive(levelAccessor, blockPos)) {
            levelAccessor.scheduleTick(blockPos, this, 1);
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        } else {
            boolean bl = blockState2.is(this) || blockState2.is(BlockTags.LOGS) ||
                    direction == Direction.DOWN && blockState2.is(BlockTags.FENCES) ||
                    direction == Direction.UP && blockState2.is(BlockTags.FENCES);
            return blockState.setValue(PROPERTY_BY_DIRECTION.get(direction), bl);
        }
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!blockState.canSurvive(serverLevel, blockPos)) {
            serverLevel.destroyBlock(blockPos, true);
        }

    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        /*BlockState blockState2 = levelReader.getBlockState(blockPos.below());
        boolean bl = !levelReader.getBlockState(blockPos.above()).isAir() && !blockState2.isAir();
        Iterator var6 = Direction.Plane.HORIZONTAL.iterator();

        BlockState blockState4;
        do {
            BlockPos blockPos2;
            BlockState blockState3;
            do {
                if (!var6.hasNext()) {
                    return blockState2.is(this) || blockState2.is(Blocks.END_STONE);
                }

                Direction direction = (Direction) var6.next();
                blockPos2 = blockPos.relative(direction);
                blockState3 = levelReader.getBlockState(blockPos2);
            } while (!blockState3.is(this));

            if (bl) {
                return false;
            }

            blockState4 = levelReader.getBlockState(blockPos2.below());
        } while (!blockState4.is(this) && !blockState4.is(Blocks.END_STONE));
*/
        return true;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }
}