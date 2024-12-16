package com.starfish_studios.building_but_better.block;

import com.mojang.serialization.MapCodec;
import com.starfish_studios.building_but_better.block.properties.BBBBlockStateProperties;
import com.starfish_studios.building_but_better.registry.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PalletBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<PalletBlock> CODEC = simpleCodec(PalletBlock::new);
    public MapCodec<PalletBlock> codec() {
        return CODEC;
    }

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
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        if (state.getValue(OPEN)) return false;
        return super.isPathfindable(state, pathComputationType);
    }

    protected void playSound(@Nullable Player player, Level level, BlockPos blockPos, boolean bl) {
        level.playSound(player, blockPos, bl ? SoundEvents.WOODEN_TRAPDOOR_OPEN : SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(ModItemTags.HAMMERS)) {
            if (hitResult.getLocation().z - (double)pos.getZ() > 0.5 && state.getValue(FACING) == Direction.NORTH) {
                if (hitResult.getLocation().z - (double)pos.getZ() < 0.75) {
                    state = state.cycle(LAYER_1);
                } else {
                    state = state.cycle(LAYER_2);
                }
            } else if (hitResult.getLocation().z - (double)pos.getZ() < 0.5 && state.getValue(FACING) == Direction.SOUTH) {
                if (hitResult.getLocation().z - (double)pos.getZ() > 0.25) {
                    state = state.cycle(LAYER_1);
                } else {
                    state = state.cycle(LAYER_2);
                }
            } else if (hitResult.getLocation().x - (double)pos.getX() > 0.5 && state.getValue(FACING) == Direction.WEST) {
                if (hitResult.getLocation().x - (double) pos.getX() < 0.75) {
                    state = state.cycle(LAYER_1);
                } else {
                    state = state.cycle(LAYER_2);
                }
            } else if (hitResult.getLocation().x - (double)pos.getX() < 0.5 && state.getValue(FACING) == Direction.EAST) {
                if (hitResult.getLocation().x - (double)pos.getX() > 0.25) {
                    state = state.cycle(LAYER_1);
                } else {
                    state = state.cycle(LAYER_2);
                }
            } else if (hitResult.getLocation().y - (double)pos.getY() < 0.5 && state.getValue(HALF) == Half.BOTTOM) {
                if (hitResult.getLocation().y - (double)pos.getY() < 0.25) {
                    state = state.cycle(LAYER_1);
                } else {
                    state = state.cycle(LAYER_2);
                }
            } if (hitResult.getLocation().y - (double)pos.getY() > 0.5 && state.getValue(HALF) == Half.TOP) {
                if (hitResult.getLocation().y - (double)pos.getY() < 0.75) {
                    state = state.cycle(LAYER_1);
                } else {
                    state = state.cycle(LAYER_2);
                }
            }
            if (!state.getValue(LAYER_1) && !state.getValue(LAYER_2)) {
                state = state.setValue(LAYER_1, true).setValue(LAYER_2, true);
            }

            level.setBlock(pos, state, 2);
            level.playSound(player, pos, Blocks.SCAFFOLDING.defaultBlockState().getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return ItemInteractionResult.SUCCESS;
        }
        else if (player.isShiftKeyDown()) {
            state = state.cycle(OPEN);
            level.setBlock(pos, state, 2);
            if (state.getValue(WATERLOGGED)) {
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
            this.playSound(player, level, pos, state.getValue(OPEN));
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
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