package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.block.properties.BigDoorHalf;
import com.starfish_studios.foundation.block.properties.FoundationBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class BigDoorBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<BigDoorHalf> HALVES = FoundationBlockStateProperties.HALVES;

    public BigDoorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false).setValue(HALVES, BigDoorHalf.LOWER));
    }


    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        BigDoorHalf half = blockState.getValue(HALVES);
        if (direction.getAxis() == Direction.Axis.Y && half == BigDoorHalf.LOWER == (direction == Direction.UP) && (!blockState2.is(this) || blockState2.getValue(HALVES) == half)) {
            return Blocks.AIR.defaultBlockState();
        }
        else if (direction.getAxis() == Direction.Axis.Y && half == BigDoorHalf.MIDDLE == (direction == Direction.UP) && (!blockState2.is(this) || blockState2.getValue(HALVES) == half)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            return half == BigDoorHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();
        return blockPos.getY() < level.getMaxBuildHeight() - 2 && level.getBlockState(blockPos.above()).canBeReplaced(blockPlaceContext) && level.getBlockState(blockPos.above(2)).canBeReplaced(blockPlaceContext) ? super.getStateForPlacement(blockPlaceContext) : null;
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        BlockPos blockPos2 = blockPos.above();
        BlockPos blockPos3 = blockPos2.above();
        level.setBlock(blockPos2, copyWaterloggedFrom(level, blockPos2, this.defaultBlockState().setValue(HALVES, BigDoorHalf.MIDDLE)), 3);
        level.setBlock(blockPos3, copyWaterloggedFrom(level, blockPos3, this.defaultBlockState().setValue(HALVES, BigDoorHalf.UPPER)), 3);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        if (blockState.getValue(HALVES) != BigDoorHalf.UPPER && blockState.getValue(HALVES) != BigDoorHalf.MIDDLE) {
            return super.canSurvive(blockState, levelReader, blockPos);
        } else if (blockState.getValue(HALVES) == BigDoorHalf.MIDDLE) {
            BlockState blockState2 = levelReader.getBlockState(blockPos.below());
            return blockState2.is(this) && blockState2.getValue(HALVES) == BigDoorHalf.LOWER;
        } else {
            BlockState blockState2 = levelReader.getBlockState(blockPos.below());
            return blockState2.is(this) && blockState2.getValue(HALVES) == BigDoorHalf.MIDDLE;
        }
    }

    public static BlockState copyWaterloggedFrom(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return blockState.hasProperty(BlockStateProperties.WATERLOGGED) ? blockState.setValue(BlockStateProperties.WATERLOGGED, levelReader.isWaterAt(blockPos)) : blockState;
    }

    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
            } else {
                dropResources(blockState, level, blockPos, null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BigDoorHalf halvesState = blockState.getValue(HALVES);
        if (halvesState == BigDoorHalf.UPPER) {
            BlockPos blockPosBelow = blockPos.below();
            BlockState stateBelow = level.getBlockState(blockPosBelow);
            if (stateBelow.is(blockState.getBlock()) && stateBelow.getValue(HALVES) == BigDoorHalf.MIDDLE) {
                BlockState blockState3 = stateBelow.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockPosBelow, blockState3, 35);
                level.levelEvent(player, 2001, blockPosBelow, Block.getId(stateBelow));
                BlockPos blockPosBelow2 = blockPosBelow.below();
                BlockState stateBelow2 = level.getBlockState(blockPosBelow2);
                if (stateBelow2.is(blockState.getBlock()) && stateBelow2.getValue(HALVES) == BigDoorHalf.LOWER) {
                    BlockState blockState4 = stateBelow2.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                    level.setBlock(blockPosBelow2, blockState4, 35);
                    level.levelEvent(player, 2001, blockPosBelow2, Block.getId(stateBelow2));
                }
            }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALVES, POWERED, HINGE, OPEN, FACING);
    }

    public long getSeed(BlockState blockState, BlockPos blockPos) {
        return Mth.getSeed(blockPos.getX(), blockPos.below(blockState.getValue(HALVES) == BigDoorHalf.MIDDLE ? 0 : 1).getY(), blockPos.getZ());
    }
}
