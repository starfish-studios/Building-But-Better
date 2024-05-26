package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.block.properties.ColumnType;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BalustradeBlock extends Block implements SimpleWaterloggedBlock {
    public static BooleanProperty TOP = BBBBlockStateProperties.TOP;
    public static BooleanProperty BOTTOM = BBBBlockStateProperties.BOTTOM;
    public static BooleanProperty TILTED = BooleanProperty.create("tilted");
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static VoxelShape BOTTOM_AABB = Block.box(0, 0, 0, 16, 2, 16);
    public static VoxelShape TOP_AABB = Block.box(0, 12, 0, 16, 16, 16);
    public static VoxelShape PILLAR_AABB = Block.box(4, 0, 4, 12, 16, 12);

    public static VoxelShape NORTH_TILTED_AABB = Shapes.or(
            Block.box(0, 12, 0, 16, 17, 8),
            Block.box(0, 15, 8, 16, 20, 16)
    );
    public static VoxelShape SOUTH_TILTED_AABB = Shapes.or(
            Block.box(0, 12, 8, 16, 17, 16),
            Block.box(0, 15, 0, 16, 20, 8)
    );
    public static VoxelShape EAST_TILTED_AABB = Shapes.or(
            Block.box(8, 10, 0, 16, 17, 16),
            Block.box(0, 15, 0, 8, 20, 16)
    );
    public static VoxelShape WEST_TILTED_AABB = Shapes.or(
            Block.box(0, 10, 0, 8, 17, 16),
            Block.box(8, 15, 0, 16, 20, 16)
    );

    public BalustradeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TOP, true)
                .setValue(BOTTOM, true)
                .setValue(TILTED, false)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.getItemInHand(hand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (hitResult.getLocation().y - (double)blockPos.getY() > 0.5D) {
                level.setBlockAndUpdate(blockPos, state.cycle(TOP));
            } else if (hitResult.getLocation().y - (double)blockPos.getY() < 0.5D) {
                level.setBlockAndUpdate(blockPos, state.cycle(BOTTOM));
            }
            level.playSound(player, blockPos, state.getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = PILLAR_AABB;
        if (state.getValue(TILTED) && state.getValue(TOP)) {
            shape = switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(shape, NORTH_TILTED_AABB);
                case SOUTH -> Shapes.or(shape, SOUTH_TILTED_AABB);
                case EAST -> Shapes.or(shape, EAST_TILTED_AABB);
                case WEST -> Shapes.or(shape, WEST_TILTED_AABB);
                default -> shape;
            };
        } else if (state.getValue(TOP)) shape = Shapes.or(shape, TOP_AABB);
        if (state.getValue(BOTTOM)) shape = Shapes.or(shape, BOTTOM_AABB);
        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOP, BOTTOM, WATERLOGGED, FACING, TILTED);
    }
}
