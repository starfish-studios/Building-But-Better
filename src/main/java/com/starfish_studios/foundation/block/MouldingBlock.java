package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class MouldingBlock extends StairBlock {


    public static final BooleanProperty DENTIL = BooleanProperty.create("dentil");

    private static final VoxelShape BOTTOM_NORTH_DENTIL_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 0, 16, 8, 13),
            Block.box(0, 8, 0, 16, 16, 4),
            Block.box(4, 8, 4, 12, 14, 10));
    private static final VoxelShape BOTTOM_EAST_DENTIL_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(3, 4, 0, 16, 8, 16),
            Block.box(12, 8, 0, 16, 16, 16),
            Block.box(6, 8, 4, 16, 14, 12));
    private static final VoxelShape BOTTOM_SOUTH_DENTIL_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 3, 16, 8, 16),
            Block.box(0, 8, 12, 16, 16, 16),
            Block.box(4, 8, 6, 12, 14, 16));
    private static final VoxelShape BOTTOM_WEST_DENTIL_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 0, 13, 8, 16),
            Block.box(0, 8, 0, 4, 16, 16),
            Block.box(4, 8, 4, 10, 14, 12));



    //region SHAPES
    private static final VoxelShape BOTTOM_NORTH_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 0, 16, 8, 13),
            Block.box(0, 8, 0, 16, 16, 4));
    private static final VoxelShape BOTTOM_EAST_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(3, 4, 0, 16, 8, 16),
            Block.box(12, 8, 0, 16, 16, 16));
    private static final VoxelShape BOTTOM_SOUTH_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 3, 16, 8, 16),
            Block.box(0, 8, 12, 16, 16, 16));
    private static final VoxelShape BOTTOM_WEST_AABB = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 0, 13, 8, 16),
            Block.box(0, 8, 0, 4, 16, 16));

    private static final VoxelShape TOP_EAST_AABB = Shapes.or(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 8, 0, 13, 12, 16),
            Block.box(0, 0, 0, 4, 8, 16),
            Block.box(4, 2, 4, 10, 8, 14));
    private static final VoxelShape TOP_NORTH_AABB = Shapes.or(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 8, 0, 16, 12, 13),
            Block.box(12, 0, 0, 16, 8, 16),
            Block.box(6, 2, 4, 16, 8, 12));
    private static final VoxelShape TOP_SOUTH_AABB = Shapes.or(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 8, 3, 16, 12, 16),
            Block.box(0, 0, 12, 16, 8, 16),
            Block.box(4, 2, 6, 16, 8, 16));
    private static final VoxelShape TOP_WEST_AABB = Shapes.or(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(3, 8, 0, 16, 12, 16),
            Block.box(12, 0, 0, 16, 8, 16),
            Block.box(6, 2, 4, 16, 8, 12));

    //endregion

    public MouldingBlock(BlockState blockState, Properties properties) {
        super(blockState, properties);
        registerDefaultState(stateDefinition.any()
                .setValue(DENTIL, true)
                .setValue(SHAPE, StairsShape.STRAIGHT)
                .setValue(HALF, Half.BOTTOM)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(SHAPE) == StairsShape.STRAIGHT && (state.getValue(HALF) == Half.BOTTOM)) return switch (state.getValue(FACING)) {
            case NORTH -> state.getValue(DENTIL) ? BOTTOM_NORTH_DENTIL_AABB : BOTTOM_NORTH_AABB;
            case EAST -> state.getValue(DENTIL) ? BOTTOM_EAST_DENTIL_AABB : BOTTOM_EAST_AABB;
            case SOUTH -> state.getValue(DENTIL) ? BOTTOM_SOUTH_DENTIL_AABB : BOTTOM_SOUTH_AABB;
            case WEST -> state.getValue(DENTIL) ? BOTTOM_WEST_DENTIL_AABB : BOTTOM_WEST_AABB;
            default -> Shapes.block();

        };
        else if (state.getValue(SHAPE) == StairsShape.STRAIGHT && (state.getValue(HALF) == Half.TOP)) return switch (state.getValue(FACING)) {
            case NORTH -> TOP_NORTH_AABB;
            case SOUTH -> TOP_SOUTH_AABB;
            case WEST -> TOP_EAST_AABB;
            case EAST -> TOP_WEST_AABB;
            default -> Shapes.block();
        };
        else return super.getShape(state, world, pos, context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DENTIL);
    }
}
