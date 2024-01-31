package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.properties.FoundationBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ColumnBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty LAYER_ONE = FoundationBlockStateProperties.LAYER_ONE;
    public static final BooleanProperty LAYER_TWO = FoundationBlockStateProperties.LAYER_TWO;
    public static final BooleanProperty LAYER_THREE = FoundationBlockStateProperties.LAYER_THREE;
    public static final BooleanProperty LAYER_FOUR = FoundationBlockStateProperties.LAYER_FOUR;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public ColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.UP)
                .setValue(LAYER_ONE, true)
                .setValue(LAYER_TWO, false)
                .setValue(LAYER_THREE, false)
                .setValue(LAYER_FOUR, true));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction[] var2 = context.getNearestLookingDirections();

        for (Direction direction : var2) {
            BlockState blockState;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockState = this.defaultBlockState().setValue(FACING, context.getNearestLookingVerticalDirection().getOpposite());
            } else {
                blockState = this.defaultBlockState().setValue(FACING, direction.getOpposite());
            }
            return blockState;
        }
        return null;
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(ItemTags.PICKAXES)) {
            if (blockState.getValue(FACING) == Direction.UP) {
                if (blockHitResult.getLocation().y - blockPos.getY() < 0.25) {
                    blockState = blockState.cycle(LAYER_ONE);
                } else if (blockHitResult.getLocation().y - blockPos.getY() < 0.5) {
                    blockState = blockState.cycle(LAYER_TWO);
                } else if (blockHitResult.getLocation().y - blockPos.getY() < 0.75) {
                    blockState = blockState.cycle(LAYER_THREE);
                } else {
                    blockState = blockState.cycle(LAYER_FOUR);
                }
            } else if (blockState.getValue(FACING) == Direction.DOWN) {
                if (blockHitResult.getLocation().y - blockPos.getY() < 0.25) {
                    blockState = blockState.cycle(LAYER_ONE);
                } else if (blockHitResult.getLocation().y - blockPos.getY() < 0.5) {
                    blockState = blockState.cycle(LAYER_TWO);
                } else if (blockHitResult.getLocation().y - blockPos.getY() < 0.75) {
                    blockState = blockState.cycle(LAYER_THREE);
                } else {
                    blockState = blockState.cycle(LAYER_FOUR);
                }
            } else if (blockState.getValue(FACING) == Direction.NORTH) {
                if (blockHitResult.getLocation().z - blockPos.getZ() < 0.25) {
                    blockState = blockState.cycle(LAYER_FOUR);
                } else if (blockHitResult.getLocation().z - blockPos.getZ() < 0.5) {
                    blockState = blockState.cycle(LAYER_THREE);
                } else if (blockHitResult.getLocation().z - blockPos.getZ() < 0.75) {
                    blockState = blockState.cycle(LAYER_TWO);
                } else {
                    blockState = blockState.cycle(LAYER_ONE);
                }
            }  else if (blockState.getValue(FACING) == Direction.EAST) {
                if (blockHitResult.getLocation().x - blockPos.getX() < 0.25) {
                    blockState = blockState.cycle(LAYER_ONE);
                } else if (blockHitResult.getLocation().x - blockPos.getX() < 0.5) {
                    blockState = blockState.cycle(LAYER_TWO);
                } else if (blockHitResult.getLocation().x - blockPos.getX() < 0.75) {
                    blockState = blockState.cycle(LAYER_THREE);
                } else {
                    blockState = blockState.cycle(LAYER_FOUR);
                }
            } else if (blockState.getValue(FACING) == Direction.SOUTH) {
                if (blockHitResult.getLocation().z - blockPos.getZ() < 0.25) {
                    blockState = blockState.cycle(LAYER_FOUR);
                } else if (blockHitResult.getLocation().z - blockPos.getZ() < 0.5) {
                    blockState = blockState.cycle(LAYER_THREE);
                } else if (blockHitResult.getLocation().z - blockPos.getZ() < 0.75) {
                    blockState = blockState.cycle(LAYER_TWO);
                } else {
                    blockState = blockState.cycle(LAYER_ONE);
                }
            } else if (blockState.getValue(FACING) == Direction.WEST) {
                if (blockHitResult.getLocation().x - blockPos.getX() < 0.25) {
                    blockState = blockState.cycle(LAYER_ONE);
                } else if (blockHitResult.getLocation().x - blockPos.getX() < 0.5) {
                    blockState = blockState.cycle(LAYER_TWO);
                } else if (blockHitResult.getLocation().x - blockPos.getX() < 0.75) {
                    blockState = blockState.cycle(LAYER_THREE);
                } else {
                    blockState = blockState.cycle(LAYER_FOUR);
                }
            }
        } else return InteractionResult.PASS;

        level.setBlock(blockPos, blockState, 3);
        level.playSound(player, blockPos, blockState.getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYER_ONE, LAYER_TWO, LAYER_THREE, LAYER_FOUR, WATERLOGGED, FACING);
    }


}
