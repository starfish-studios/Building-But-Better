package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.registry.FoundationItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BeamBlock extends FaceAttachedHorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    protected static final VoxelShape CEILING_AABB_X = Block.box(0, 4, 13, 16, 12, 16);
    protected static final VoxelShape CEILING_AABB_Z = Block.box(13, 4, 0, 16, 12, 16);
    protected static final VoxelShape FLOOR_AABB_X = Block.box(4, 0, 0, 12, 3, 16);
    protected static final VoxelShape FLOOR_AABB_Z = Block.box(0, 0, 4, 16, 3, 12);
    protected static final VoxelShape NORTH_AABB = Block.box(4, 0, 13, 12, 16, 16);
    protected static final VoxelShape SOUTH_AABB = Block.box(4, 0, 0, 12, 16, 3);
    protected static final VoxelShape WEST_AABB = Block.box(13, 0, 4, 16, 16, 12);
    protected static final VoxelShape EAST_AABB = Block.box(0, 0, 4, 3, 16, 12);


    public BeamBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        return switch (blockState.getValue(FACE)) {
            case FLOOR -> {
                if (direction.getAxis() == Direction.Axis.X) {
                    yield FLOOR_AABB_X;
                }
                yield FLOOR_AABB_Z;
            }
            case WALL -> switch (direction) {
                case EAST -> EAST_AABB;
                case WEST -> WEST_AABB;
                case SOUTH -> SOUTH_AABB;
                case NORTH -> NORTH_AABB;
                default -> throw new IncompatibleClassChangeError();
            };
            case CEILING -> {
                if (direction.getAxis() == Direction.Axis.X) {
                    yield CEILING_AABB_X;
                }
                yield CEILING_AABB_Z;
            }
        };
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE, WATERLOGGED);
    }
}
