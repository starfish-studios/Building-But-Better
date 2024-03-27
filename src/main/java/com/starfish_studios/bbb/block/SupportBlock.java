package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SupportBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty SUPPORT = BooleanProperty.create("support");

    public static final VoxelShape BOTTOM_NORTH_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 0, 8, 16, 8, 16),
            Block.box(0, 0, 12, 16, 16, 16)
    );

    public static final VoxelShape BOTTOM_EAST_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 0, 0, 8, 8, 16),
            Block.box(0, 0, 0, 4, 16, 16)
    );

    public static final VoxelShape BOTTOM_SOUTH_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 0, 0, 16, 8, 8),
            Block.box(0, 0, 0, 16, 16, 4)
    );

    public static final VoxelShape BOTTOM_WEST_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(8, 0, 0, 16, 8, 16),
            Block.box(12, 0, 0, 16, 16, 16)
    );

    public static final VoxelShape TOP_NORTH_AABB = Shapes.or(
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 8, 8, 16, 16, 16),
            Block.box(0, 12, 0, 16, 16, 16)
    );

    public static final VoxelShape TOP_SOUTH_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 8, 0, 16, 16, 8),
            Block.box(0, 12, 0, 16, 16, 16)
    );

    public static final VoxelShape TOP_WEST_AABB = Shapes.or(
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(8, 8, 0, 16, 16, 16),
            Block.box(0, 12, 0, 16, 16, 16)
    );

    public static final VoxelShape TOP_EAST_AABB = Shapes.or(
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(0, 8, 0, 8, 16, 16),
            Block.box(0, 12, 0, 16, 16, 16)
    );

    public SupportBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, Half.BOTTOM)
                .setValue(WATERLOGGED, false)
                .setValue(SUPPORT, true));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> state.getValue(HALF) == Half.BOTTOM ? BOTTOM_NORTH_AABB : TOP_NORTH_AABB;
            case EAST -> state.getValue(HALF) == Half.BOTTOM ? BOTTOM_EAST_AABB : TOP_EAST_AABB;
            case SOUTH -> state.getValue(HALF) == Half.BOTTOM ? BOTTOM_SOUTH_AABB : TOP_SOUTH_AABB;
            case WEST -> state.getValue(HALF) == Half.BOTTOM ? BOTTOM_WEST_AABB : TOP_WEST_AABB;
            default -> Shapes.block();
        };
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return false;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (blockState.getValue(SUPPORT)) {
                level.setBlock(blockPos, blockState.setValue(SUPPORT, false), 3);
            } else {
                level.setBlock(blockPos, blockState.setValue(SUPPORT, true), 3);
            }
            level.playSound(player, blockPos, Blocks.SCAFFOLDING.getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateDefinition) {
        stateDefinition.add(FACING, HALF, WATERLOGGED, SUPPORT);
    }
}
