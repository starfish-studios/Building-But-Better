package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PalletBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape BOTTOM_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0);
    protected static final VoxelShape TOP_AABB = Block.box(0.0, 10.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 10.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 0.0, 6.0, 16.0, 16.0);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 6.0);
    protected static final VoxelShape WEST_AABB = Block.box(10.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    protected static final VoxelShape BOTTOM_AABB_LAYER_1 = Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
    protected static final VoxelShape BOTTOM_AABB_LAYER_2 = Block.box(0.0, 0.3, 0.0, 16.0, 6.0, 16.0);
    protected static final VoxelShape TOP_AABB_LAYER_1 = Block.box(0.0, 10.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape TOP_AABB_LAYER_2 = Block.box(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape NORTH_AABB_LAYER_1 = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape NORTH_AABB_LAYER_2 = Block.box(0.0, 0.0, 10.0, 16.0, 13.0, 16.0);

    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final BooleanProperty LAYER_1 = BBBBlockStateProperties.LAYER_1;
    public static final BooleanProperty LAYER_2 = BBBBlockStateProperties.LAYER_2;

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public PalletBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(HALF, Half.BOTTOM)
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false)
                .setValue(LAYER_1, true)
                .setValue(LAYER_2, true));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(OPEN)) {
            return switch (blockState.getValue(FACING)) {
                case NORTH -> NORTH_AABB;
                case SOUTH -> SOUTH_AABB;
                case WEST -> WEST_AABB;
                case EAST -> EAST_AABB;
                default -> BOTTOM_AABB;
            };
        } else if (blockState.getValue(HALF) == Half.TOP) {
            return TOP_AABB;
        } else return BOTTOM_AABB;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        if (blockState.getValue(OPEN)) {
            return false;
        } else {
            return super.isPathfindable(blockState, blockGetter, blockPos, pathComputationType);
        }
    }

    protected void playSound(@Nullable Player player, Level level, BlockPos blockPos, boolean bl) {
        level.playSound(player, blockPos, bl ? SoundEvents.WOODEN_TRAPDOOR_OPEN : SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (blockHitResult.getLocation().z - (double)blockPos.getZ() > 0.5 && blockState.getValue(FACING) == Direction.NORTH) {
                if (blockHitResult.getLocation().z - (double)blockPos.getZ() < 0.75) {
                    blockState = blockState.cycle(LAYER_1);
                } else {
                    blockState = blockState.cycle(LAYER_2);
                }
            } else if (blockHitResult.getLocation().z - (double)blockPos.getZ() < 0.5 && blockState.getValue(FACING) == Direction.SOUTH) {
                if (blockHitResult.getLocation().z - (double)blockPos.getZ() > 0.25) {
                    blockState = blockState.cycle(LAYER_1);
                } else {
                    blockState = blockState.cycle(LAYER_2);
                }
            } else if (blockHitResult.getLocation().x - (double)blockPos.getX() > 0.5 && blockState.getValue(FACING) == Direction.WEST) {
                if (blockHitResult.getLocation().x - (double) blockPos.getX() < 0.75) {
                    blockState = blockState.cycle(LAYER_1);
                } else {
                    blockState = blockState.cycle(LAYER_2);
                }
            } else if (blockHitResult.getLocation().x - (double)blockPos.getX() < 0.5 && blockState.getValue(FACING) == Direction.EAST) {
                if (blockHitResult.getLocation().x - (double)blockPos.getX() > 0.25) {
                    blockState = blockState.cycle(LAYER_1);
                } else {
                    blockState = blockState.cycle(LAYER_2);
                }
            } else if (blockHitResult.getLocation().y - (double)blockPos.getY() < 0.5 && blockState.getValue(HALF) == Half.BOTTOM) {
                if (blockHitResult.getLocation().y - (double)blockPos.getY() < 0.25) {
                    blockState = blockState.cycle(LAYER_1);
                } else {
                    blockState = blockState.cycle(LAYER_2);
                }
            } if (blockHitResult.getLocation().y - (double)blockPos.getY() > 0.5 && blockState.getValue(HALF) == Half.TOP) {
                if (blockHitResult.getLocation().y - (double)blockPos.getY() < 0.75) {
                    blockState = blockState.cycle(LAYER_1);
                } else {
                    blockState = blockState.cycle(LAYER_2);
                }
            }
            if (!blockState.getValue(LAYER_1) && !blockState.getValue(LAYER_2)) {
                blockState = blockState.setValue(LAYER_1, true).setValue(LAYER_2, true);
            }

            level.setBlock(blockPos, blockState, 2);
            level.playSound(player, blockPos, Blocks.SCAFFOLDING.getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
         else if (player.isShiftKeyDown()) {
            blockState = blockState.cycle(OPEN);
            level.setBlock(blockPos, blockState, 2);
            if (blockState.getValue(WATERLOGGED)) {
                level.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
            this.playSound(player, level, blockPos, blockState.getValue(OPEN));
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return false;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockState = this.defaultBlockState();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        Direction direction = blockPlaceContext.getClickedFace();
        if (!blockPlaceContext.replacingClickedOnBlock() && direction.getAxis().isHorizontal()) {
            blockState = blockState.setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(HALF, blockPlaceContext.getClickLocation().y - (double)blockPlaceContext.getClickedPos().getY() > 0.5 ? Half.TOP : Half.BOTTOM);
        } else {
            blockState = blockState.setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(HALF, direction == Direction.UP ? Half.BOTTOM : Half.TOP);
        }

        return blockState.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING, WATERLOGGED, OPEN, LAYER_1, LAYER_2);
    }
}