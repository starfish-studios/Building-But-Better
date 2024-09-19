package com.starfish_studios.bbb.block;

import com.google.common.collect.Maps;
import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.block.properties.FrameStickDirection;
import com.starfish_studios.bbb.block.properties.LatticePlantType;
import com.starfish_studios.bbb.block.properties.LatticeType;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class LatticeBlock extends Block implements SimpleWaterloggedBlock, BonemealableBlock, CaveVines {
    // region VARIABLES
    public static DirectionProperty FACING = BlockStateProperties.FACING;
    public static BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static EnumProperty<LatticePlantType> PLANT_TYPE = BBBBlockStateProperties.PLANT_TYPE;
    public static BooleanProperty LEFT = BBBBlockStateProperties.LEFT;
    public static BooleanProperty MIDDLE = BBBBlockStateProperties.MIDDLE;
    public static BooleanProperty RIGHT = BBBBlockStateProperties.RIGHT;

    public static VoxelShape NORTH_AABB = Block.box(0, 0, 14, 16, 16, 16);
    public static VoxelShape NORTH_PLANT_AABB = Block.box(0, 0, 13, 16, 16, 14);
    public static VoxelShape SOUTH_AABB = Block.box(0, 0, 0, 16, 16, 2);
    public static VoxelShape SOUTH_PLANT_AABB = Block.box(0, 0, 2, 16, 16, 3);
    public static VoxelShape WEST_AABB = Block.box(14, 0, 0, 16, 16, 16);
    public static VoxelShape WEST_PLANT_AABB = Block.box(13, 0, 0, 14, 16, 16);
    public static VoxelShape EAST_AABB = Block.box(0, 0, 0, 2, 16, 16);
    public static VoxelShape EAST_PLANT_AABB = Block.box(2, 0, 0, 3, 16, 16);

    private static final Map<LatticePlantType, Item> PLANT_TYPE_TO_ITEM = Util.make(Maps.newEnumMap(LatticePlantType.class), (map) -> {
        map.put(LatticePlantType.NONE, null);
        map.put(LatticePlantType.VINES, Items.VINE);
        map.put(LatticePlantType.OAK_LEAVES, Items.OAK_LEAVES);
        map.put(LatticePlantType.SPRUCE_LEAVES, Items.SPRUCE_LEAVES);
        map.put(LatticePlantType.BIRCH_LEAVES, Items.BIRCH_LEAVES);
        map.put(LatticePlantType.JUNGLE_LEAVES, Items.JUNGLE_LEAVES);
        map.put(LatticePlantType.ACACIA_LEAVES, Items.ACACIA_LEAVES);
        map.put(LatticePlantType.DARK_OAK_LEAVES, Items.DARK_OAK_LEAVES);
        map.put(LatticePlantType.AZALEA_LEAVES, Items.AZALEA_LEAVES);
        map.put(LatticePlantType.FLOWERING_AZALEA_LEAVES, Items.FLOWERING_AZALEA_LEAVES);
        map.put(LatticePlantType.MANGROVE_LEAVES, Items.MANGROVE_LEAVES);
        map.put(LatticePlantType.CHERRY_LEAVES, Items.CHERRY_LEAVES);
//        map.put(LatticePlantType.ROSE_BUSH, Items.ROSE_BUSH);
        map.put(LatticePlantType.GLOW_LICHEN, Items.GLOW_LICHEN);
        map.put(LatticePlantType.CAVE_VINES, Items.GLOW_BERRIES);
    });


    // endregion

    public LatticeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(LEFT, true)
                .setValue(MIDDLE, true)
                .setValue(RIGHT, true)
                .setValue(PLANT_TYPE, LatticePlantType.NONE)
                .setValue(BERRIES, false)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        LatticePlantType plantType = state.getValue(PLANT_TYPE);
        VoxelShape shape = Shapes.empty();

        if (direction == Direction.NORTH) {
            shape = Shapes.or(shape, NORTH_AABB);
            if (plantType != LatticePlantType.NONE) {
                shape = Shapes.or(shape, NORTH_PLANT_AABB);
            }
        } else if (direction == Direction.SOUTH) {
            shape = Shapes.or(shape, SOUTH_AABB);
            if (plantType != LatticePlantType.NONE) {
                shape = Shapes.or(shape, SOUTH_PLANT_AABB);
            }
        } else if (direction == Direction.WEST) {
            shape = Shapes.or(shape, WEST_AABB);
            if (plantType != LatticePlantType.NONE) {
                shape = Shapes.or(shape, WEST_PLANT_AABB);
            }
        } else if (direction == Direction.EAST) {
            shape = Shapes.or(shape, EAST_AABB);
            if (plantType != LatticePlantType.NONE) {
                shape = Shapes.or(shape, EAST_PLANT_AABB);
            }
        }
        return shape;

    }
    
    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        LatticePlantType plantType = state.getValue(PLANT_TYPE);
        VoxelShape shape = Shapes.empty();
        if (direction == Direction.NORTH && plantType != LatticePlantType.NONE) {
            shape = Shapes.or(shape, NORTH_PLANT_AABB);
        } else if (direction == Direction.SOUTH && plantType != LatticePlantType.NONE) {
            shape = Shapes.or(shape, SOUTH_PLANT_AABB);
        } else if (direction == Direction.EAST && plantType != LatticePlantType.NONE) {
            shape = Shapes.or(shape, EAST_PLANT_AABB);
        } else if (direction == Direction.WEST && plantType != LatticePlantType.NONE) {
            shape = Shapes.or(shape, WEST_PLANT_AABB);
        }
        return shape;
    }

    public BlockState getConnections(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean n = validConnection(level.getBlockState(pos.north()));
        boolean e = validConnection(level.getBlockState(pos.east()));
        boolean s = validConnection(level.getBlockState(pos.south()));
        boolean w = validConnection(level.getBlockState(pos.west()));
        boolean t = validConnection(level.getBlockState(pos.above()));
        boolean b = validConnection(level.getBlockState(pos.below()));

        if (state.getValue(FACING) == Direction.NORTH) {
            boolean left = !e || !validConnection(level.getBlockState(pos.east()));
            boolean right = !w || !validConnection(level.getBlockState(pos.west()));
            return state
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.SOUTH) {
            boolean left = !w || !validConnection(level.getBlockState(pos.west()));
            boolean right = !e || !validConnection(level.getBlockState(pos.east()));
            return state
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.EAST) {
            boolean left = !s || !validConnection(level.getBlockState(pos.south()));
            boolean right = !n || !validConnection(level.getBlockState(pos.north()));
            return state
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        } else if (state.getValue(FACING) == Direction.WEST) {
            boolean left = !n || !validConnection(level.getBlockState(pos.north()));
            boolean right = !s || !validConnection(level.getBlockState(pos.south()));
            return state
                    .setValue(LEFT, left)
                    .setValue(RIGHT, right);
        }
        return state;
    }

    public boolean validConnection(BlockState state) {
        return state.isFaceSturdy(null, null, Direction.UP) ||
                state.isFaceSturdy(null, null, Direction.DOWN) ||
                state.isFaceSturdy(null, null, Direction.NORTH) ||
                state.isFaceSturdy(null, null, Direction.EAST) ||
                state.isFaceSturdy(null, null, Direction.SOUTH) ||
                state.isFaceSturdy(null, null, Direction.WEST) ||
                state.is(this);
    }

    @Override
    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if (!level.isClientSide && player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.SHEARS)) {
            LatticePlantType plantType = blockState.getValue(PLANT_TYPE);
            if (PLANT_TYPE_TO_ITEM.containsKey(plantType)) {
                Item item = PLANT_TYPE_TO_ITEM.get(plantType);
                if (item != null) {
                    level.setBlock(blockPos, blockState.setValue(PLANT_TYPE, LatticePlantType.NONE), 3);
                    popResource(level, blockPos, new ItemStack(item));
                    level.playSound(null, blockPos, SoundEvents.VINE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            }
        }
    }

    public static InteractionResult use(@Nullable Entity entity, BlockState blockState, Level level, BlockPos blockPos) {

        return InteractionResult.PASS;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player.getItemInHand(hand).is(Items.SHEARS)) {
            LatticePlantType plantType = state.getValue(PLANT_TYPE);
            if (state.getValue(BERRIES)) {
                level.setBlock(pos, state.setValue(PLANT_TYPE, LatticePlantType.NONE), 3);
                return CaveVines.use(null, state, level, pos);
            } else if (PLANT_TYPE_TO_ITEM.containsKey(plantType)) {
                Item item = PLANT_TYPE_TO_ITEM.get(plantType);
                if (item != null) {
                    level.setBlock(pos, state.setValue(PLANT_TYPE, LatticePlantType.NONE), 3);
                    popResource(level, pos, new ItemStack(item));
                    level.playSound(null, pos, SoundEvents.VINE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        if (state.getValue(PLANT_TYPE) == LatticePlantType.NONE) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (PLANT_TYPE_TO_ITEM.containsValue(itemStack.getItem())) {
                for (Map.Entry<LatticePlantType, Item> entry : PLANT_TYPE_TO_ITEM.entrySet()) {
                    if (entry.getValue() == itemStack.getItem()) {
                        level.setBlock(pos, state.setValue(PLANT_TYPE, entry.getKey()), 3);
                        level.playSound(null, pos, entry.getKey() == LatticePlantType.VINES ? SoundEvents.VINE_PLACE : SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return CaveVines.use(null, state, level, pos);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        return !blockState.getValue(BERRIES) && blockState.getValue(PLANT_TYPE) == LatticePlantType.CAVE_VINES;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlock(blockPos, blockState.setValue(BERRIES, true), 2);
    }


    public boolean propagatesSkylightDown(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return getConnections(state, level, currentPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, LEFT, RIGHT, MIDDLE, PLANT_TYPE, BERRIES);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
