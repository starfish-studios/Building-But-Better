package com.starfish_studios.building_but_better.block;

import com.starfish_studios.building_but_better.block.properties.BBBBlockStateProperties;
import com.starfish_studios.building_but_better.block.properties.ColumnType;
import com.starfish_studios.building_but_better.registry.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ColumnBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty LAYER_1 = BBBBlockStateProperties.LAYER_1;
    public static final BooleanProperty LAYER_2 = BBBBlockStateProperties.LAYER_2;
    public static final BooleanProperty LAYER_3 = BBBBlockStateProperties.LAYER_3;
    public static final BooleanProperty LAYER_4 = BBBBlockStateProperties.LAYER_4;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<ColumnType> TYPE = BBBBlockStateProperties.COLUMN_TYPE;

    public static VoxelShape LAYER_1_AABB = Block.box(0, 0, 0, 16, 4, 16);
    public static VoxelShape LAYER_2_AABB = Block.box(0, 4, 0, 16, 8, 16);
    public static VoxelShape LAYER_3_AABB = Block.box(0, 8, 0, 16, 12, 16);
    public static VoxelShape LAYER_4_AABB = Block.box(0, 12, 0, 16, 16, 16);
    public static VoxelShape CORE_AABB = Block.box(2, 0, 2, 14, 16, 14);

    public static VoxelShape LAYER_1_AABB_Z = Block.box(0, 0, 12, 16, 16, 16);
    public static VoxelShape LAYER_2_AABB_Z = Block.box(0, 0, 8, 16, 16, 12);
    public static VoxelShape LAYER_3_AABB_Z = Block.box(0, 0, 4, 16, 16, 8);
    public static VoxelShape LAYER_4_AABB_Z = Block.box(0, 0, 0, 16, 16, 4);
    public static VoxelShape CORE_AABB_Z = Block.box(2, 2, 0, 14, 14, 16);

    public static VoxelShape LAYER_1_AABB_X = Block.box(0, 0, 0, 4, 16, 16);
    public static VoxelShape LAYER_2_AABB_X = Block.box(4, 0, 0, 8, 16, 16);
    public static VoxelShape LAYER_3_AABB_X = Block.box(8, 0, 0, 12, 16, 16);
    public static VoxelShape LAYER_4_AABB_X = Block.box(12, 0, 0, 16, 16, 16);
    public static VoxelShape CORE_AABB_X = Block.box(0, 2, 2, 16, 14, 14);

    public ColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(AXIS, Direction.Axis.Y)
                .setValue(TYPE, ColumnType.NONE)
                .setValue(LAYER_1, true)
                .setValue(LAYER_2, true)
                .setValue(LAYER_3, true)
                .setValue(LAYER_4, true));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape shape = blockState.getValue(AXIS) == Direction.Axis.X ? CORE_AABB_X : blockState.getValue(AXIS) == Direction.Axis.Z ? CORE_AABB_Z : CORE_AABB;
        if (blockState.getValue(LAYER_1)) shape = blockState.getValue(AXIS) == Direction.Axis.X ? Shapes.or(shape, LAYER_1_AABB_X) : blockState.getValue(AXIS) == Direction.Axis.Z ? Shapes.or(shape, LAYER_1_AABB_Z) : Shapes.or(shape, LAYER_1_AABB);
        if (blockState.getValue(LAYER_2)) shape = blockState.getValue(AXIS) == Direction.Axis.X ? Shapes.or(shape, LAYER_2_AABB_X) : blockState.getValue(AXIS) == Direction.Axis.Z ? Shapes.or(shape, LAYER_2_AABB_Z) : Shapes.or(shape, LAYER_2_AABB);
        if (blockState.getValue(LAYER_3)) shape = blockState.getValue(AXIS) == Direction.Axis.X ? Shapes.or(shape, LAYER_3_AABB_X) : blockState.getValue(AXIS) == Direction.Axis.Z ? Shapes.or(shape, LAYER_3_AABB_Z) : Shapes.or(shape, LAYER_3_AABB);
        if (blockState.getValue(LAYER_4)) shape = blockState.getValue(AXIS) == Direction.Axis.X ? Shapes.or(shape, LAYER_4_AABB_X) : blockState.getValue(AXIS) == Direction.Axis.Z ? Shapes.or(shape, LAYER_4_AABB_Z) : Shapes.or(shape, LAYER_4_AABB);
        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(AXIS, context.getClickedFace().getAxis())
                .setValue(TYPE, ColumnType.NONE)
                .setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighbourState, LevelAccessor level, BlockPos pos, BlockPos neighbourPos) {
        Direction.Axis axis = state.getValue(AXIS);
        if (direction.getAxis() != axis) return state;
        Direction.AxisDirection towards = Direction.AxisDirection.POSITIVE;
        if (axis == Direction.Axis.Z) towards = towards.opposite();

        ColumnType type = getType(state, getRelativeState(level, pos, axis, towards), getRelativeState(level, pos, axis, towards.opposite()));
        state = state.setValue(TYPE, type);
        return state;
    }

    public BlockState getRelativeState(LevelAccessor level, BlockPos pos, Direction.Axis axis, Direction.AxisDirection towards) {
        return level.getBlockState(pos.relative(Direction.fromAxisAndDirection(axis, towards)));
    }

    public ColumnType getType(BlockState state, BlockState above, BlockState below) {
        boolean aboveConnects = false;
        boolean belowConnects = false;
        boolean layer1 = state.getValue(LAYER_1);
        boolean layer4 = state.getValue(LAYER_4);

        boolean stateFull = (layer1 == state.getValue(LAYER_2)) && (layer1 == state.getValue(LAYER_3)) && (layer1 == layer4);
        if (above.is(state.getBlock()) && state.getValue(AXIS) == above.getValue(AXIS)) {
            boolean layerAbove1 = above.getValue(LAYER_1);
            boolean layerAbove4 = above.getValue(LAYER_4);
            boolean aboveFull = (layerAbove1 == above.getValue(LAYER_2)) && (layerAbove1 == above.getValue(LAYER_3)) && (layerAbove1 == layerAbove4);
            if ((stateFull && aboveFull) || (!layer4 && !layerAbove1)) aboveConnects = true;
        }

        if (below.is(state.getBlock()) && state.getValue(AXIS) == below.getValue(AXIS)) {
            boolean layerBelow1 = below.getValue(LAYER_1);
            boolean layerBelow4 = below.getValue(LAYER_4);
            boolean belowFull = (layerBelow1 == below.getValue(LAYER_2)) && (layerBelow1 == below.getValue(LAYER_3)) && (layerBelow1 == layerBelow4);
            if ((stateFull && belowFull) || (!layer1 && !layerBelow4)) belowConnects = true;
        }

        if (aboveConnects && !belowConnects) return ColumnType.BOTTOM;
        else if (!aboveConnects && belowConnects) return ColumnType.TOP;
        else if (aboveConnects) return ColumnType.MIDDLE;
        return ColumnType.NONE;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!stack.is(ModItemTags.HAMMERS)) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        Direction.Axis interactAxis = state.getValue(AXIS);

        double interactPosAxis = hitResult.getLocation().get(interactAxis);
        int blockPosAxis = pos.get(interactAxis);
        double finalHitLoc = interactPosAxis - blockPosAxis;
        if (interactAxis == Direction.Axis.Z) finalHitLoc = 1 - finalHitLoc;

        if (finalHitLoc < 0.25) state = state.cycle(LAYER_1);
        else if (finalHitLoc < 0.5) state = state.cycle(LAYER_2);
        else if (finalHitLoc < 0.75) state = state.cycle(LAYER_3);
        else state = state.cycle(LAYER_4);

        if (state.getValue(WATERLOGGED) && state.isCollisionShapeFullBlock(level, pos)) state = state.setValue(WATERLOGGED, false);
        level.setBlock(pos, state, 3);
        level.playSound(player, pos, state.getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
        return ItemInteractionResult.SUCCESS;
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYER_1, LAYER_2, LAYER_3, LAYER_4, WATERLOGGED, AXIS, TYPE);
    }


}
