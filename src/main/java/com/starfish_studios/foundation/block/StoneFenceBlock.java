package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class StoneFenceBlock extends FenceBlock {
    public static final BooleanProperty SIDE_FILL = BooleanProperty.create("side_fill");
    public static final BooleanProperty PILLAR = BooleanProperty.create("pillar");

    public StoneFenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()
                .setValue(NORTH, false)).setValue(EAST, false)
                .setValue(SOUTH, false).setValue(WEST, false)
                .setValue(WATERLOGGED, false)
                .setValue(SIDE_FILL, false)
                .setValue(PILLAR, true));
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(NORTH) && !state.getValue(EAST) && !state.getValue(SOUTH) && !state.getValue(WEST)) {
            level.setBlock(pos, state.setValue(PILLAR, true), 3);
        }
    }

    @Override
    public boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = this.isSameFence(blockState);
        boolean bl3 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction);
        return !isExceptionForConnection(blockState) && bl || bl2 || bl3;
    }

    private boolean isSameFence(BlockState blockState) {
        return blockState.is(FoundationTags.FoundationBlockTags.STONE_FENCES) || blockState.is(BlockTags.WALLS);
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


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateDefinition) {
        stateDefinition.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, SIDE_FILL, PILLAR);
    }
}
