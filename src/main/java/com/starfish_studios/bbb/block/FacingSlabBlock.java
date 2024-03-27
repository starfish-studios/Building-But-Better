package com.starfish_studios.bbb.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FacingSlabBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    public static final VoxelShape SLAB_BOTTOM_UP = Block.box(0, 0, 0, 16, 8, 16);
    public static final VoxelShape SLAB_BOTTOM_DOWN = Block.box(0, 8, 0, 16, 16, 16);
    public static final VoxelShape SLAB_BOTTOM_NORTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape SLAB_BOTTOM_EAST = Block.box(0, 0, 0, 8, 16, 16);
    public static final VoxelShape SLAB_BOTTOM_SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SLAB_BOTTOM_WEST = Block.box(8, 0, 0, 16, 16, 16);

    public static final VoxelShape SLAB_TOP_UP = Block.box(0, 8, 0, 16, 16, 16);
    public static final VoxelShape SLAB_TOP_DOWN = Block.box(0, 0, 0, 16, 8, 16);
    public static final VoxelShape SLAB_TOP_NORTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape SLAB_TOP_EAST = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape SLAB_TOP_SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SLAB_TOP_WEST = Block.box(0, 0, 0, 8, 16, 16);

    public static final VoxelShape SLAB_DOUBLE = Block.box(0, 0, 0, 16, 16, 16);


    public FacingSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TYPE, SlabType.BOTTOM)
                .setValue(FACING, Direction.UP)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(TYPE)) {
            case BOTTOM -> switch (state.getValue(FACING)) {
                case NORTH -> SLAB_BOTTOM_NORTH;
                case SOUTH -> SLAB_BOTTOM_SOUTH;
                case EAST -> SLAB_BOTTOM_EAST;
                case WEST -> SLAB_BOTTOM_WEST;
                case UP -> SLAB_BOTTOM_UP;
                case DOWN -> SLAB_BOTTOM_DOWN;
            };
            case TOP -> switch (state.getValue(FACING)) {
                case NORTH -> SLAB_TOP_NORTH;
                case SOUTH -> SLAB_TOP_SOUTH;
                case EAST -> SLAB_TOP_EAST;
                case WEST -> SLAB_TOP_WEST;
                case UP -> SLAB_TOP_UP;
                case DOWN -> SLAB_TOP_DOWN;
            };
            case DOUBLE -> SLAB_DOUBLE;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, false);
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        ItemStack itemStack = blockPlaceContext.getItemInHand();
        SlabType slabType = blockState.getValue(TYPE);
        if (slabType != SlabType.DOUBLE && itemStack.is(this.asItem())) {
            if (blockPlaceContext.replacingClickedOnBlock()) {
                boolean bl = blockPlaceContext.getClickLocation().y - (double)blockPlaceContext.getClickedPos().getY() > 0.5;
                Direction direction = blockPlaceContext.getClickedFace();
                if (slabType == SlabType.BOTTOM) {
                    return direction == Direction.UP || bl && direction.getAxis().isHorizontal();
                } else {
                    return direction == Direction.DOWN || !bl && direction.getAxis().isHorizontal();
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        return blockState.getValue(TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, blockState, fluidState);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return blockState.getValue(TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(blockGetter, blockPos, blockState, fluid);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateDefinitionBuilder) {
        stateDefinitionBuilder.add(TYPE, FACING, WATERLOGGED);
    }
}
