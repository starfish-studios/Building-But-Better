package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.block.properties.FrameStickDirection;
import com.starfish_studios.bbb.block.properties.LayerNumber;
import com.starfish_studios.bbb.registry.BBBSoundEvents;
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
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LayerBlock extends Block implements SimpleWaterloggedBlock {
    // region PROPERTIES
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 4);
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape LAYER_1_UP = Block.box(0, 0, 0, 16, 4, 16);
    public static final VoxelShape LAYER_2_UP = Block.box(0, 0, 0, 16, 8, 16);
    public static final VoxelShape LAYER_3_UP = Block.box(0, 0, 0, 16, 12, 16);
    public static final VoxelShape LAYER_4_UP = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_DOWN = Block.box(0, 12, 0, 16, 16, 16);
    public static final VoxelShape LAYER_2_DOWN = Block.box(0, 8, 0, 16, 16, 16);
    public static final VoxelShape LAYER_3_DOWN = Block.box(0, 4, 0, 16, 16, 16);
    public static final VoxelShape LAYER_4_DOWN = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_NORTH = Block.box(0, 0, 12, 16, 16, 16);
    public static final VoxelShape LAYER_2_NORTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape LAYER_3_NORTH = Block.box(0, 0, 4, 16, 16, 16);
    public static final VoxelShape LAYER_4_NORTH = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_SOUTH = Block.box(0, 0, 0, 16, 16, 4);
    public static final VoxelShape LAYER_2_SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape LAYER_3_SOUTH = Block.box(0, 0, 0, 16, 16, 12);
    public static final VoxelShape LAYER_4_SOUTH = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_EAST = Block.box(0, 0, 0, 4, 16, 16);
    public static final VoxelShape LAYER_2_EAST = Block.box(0, 0, 0, 8, 16, 16);
    public static final VoxelShape LAYER_3_EAST = Block.box(0, 0, 0, 12, 16, 16);
    public static final VoxelShape LAYER_4_EAST = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_WEST = Block.box(12, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_2_WEST = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_3_WEST = Block.box(4, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_4_WEST = Block.box(0, 0, 0, 16, 16, 16);
    // endregion


    public LayerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
            this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.UP)
                .setValue(LAYERS, 1)
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (blockState.getValue(LAYERS) > 1) {
                level.setBlock(blockPos, blockState.setValue(LAYERS, blockState.getValue(LAYERS) - 1), 3);
                Block.popResource(level, blockPos, this.asItem().getDefaultInstance());
                player.getItemInHand(interactionHand).hurtAndBreak(1, player, (playerEntity) -> {
                    playerEntity.broadcastBreakEvent(interactionHand);
                });
                level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else if (blockState.getValue(LAYERS) == 1) {
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(LAYERS)) {
            case 1 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_1_NORTH;
                case SOUTH -> LAYER_1_SOUTH;
                case EAST -> LAYER_1_EAST;
                case WEST -> LAYER_1_WEST;
                case UP -> LAYER_1_UP;
                case DOWN -> LAYER_1_DOWN;
            };
            case 2 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_2_NORTH;
                case SOUTH -> LAYER_2_SOUTH;
                case EAST -> LAYER_2_EAST;
                case WEST -> LAYER_2_WEST;
                case UP -> LAYER_2_UP;
                case DOWN -> LAYER_2_DOWN;
            };
            case 3 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_3_NORTH;
                case SOUTH -> LAYER_3_SOUTH;
                case EAST -> LAYER_3_EAST;
                case WEST -> LAYER_3_WEST;
                case UP -> LAYER_3_UP;
                case DOWN -> LAYER_3_DOWN;
            };
            case 4 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_4_NORTH;
                case SOUTH -> LAYER_4_SOUTH;
                case EAST -> LAYER_4_EAST;
                case WEST -> LAYER_4_WEST;
                case UP -> LAYER_4_UP;
                case DOWN -> LAYER_4_DOWN;
            };
            default -> throw new IllegalStateException("Unexpected value: " + state.getValue(LAYERS));
        };
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return !blockPlaceContext.isSecondaryUseActive() && blockPlaceContext.getItemInHand().is(this.asItem()) && blockState.getValue(LAYERS) < 4 ||
                super.canBeReplaced(blockState, blockPlaceContext);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // If the player is sneaking, place the block as if it were a full block
        if (context.getPlayer() != null && context.getPlayer().isCrouching()) {
            BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
            Direction[] var2 = context.getNearestLookingDirections();
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());

            if (blockState.getBlock() == this) {
                return blockState.setValue(LAYERS, Math.min(4, blockState.getValue(LAYERS) + 1));
            }

            for (Direction direction : var2) {
                if (direction.getAxis() == Direction.Axis.Y) {
                    blockState = this.defaultBlockState().setValue(FACING, context.getNearestLookingVerticalDirection().getOpposite());
                } else {
                    blockState = this.defaultBlockState().setValue(FACING, direction.getOpposite());
                }
                return blockState;
            }
            if (blockState.is(this)) {
                return blockState.setValue(WATERLOGGED, false).setValue(LAYERS, 4);
            } else {
                return blockState.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
            }
        } else {
            BlockPos blockPos = context.getClickedPos();
            BlockState blockState = context.getLevel().getBlockState(blockPos);
            if (blockState.is(this)) {
                return blockState.setValue(LAYERS, Math.min(4, blockState.getValue(LAYERS) + 1));
            }
            FluidState fluidState = context.getLevel().getFluidState(blockPos);
            BlockState blockState2 = this.defaultBlockState().setValue(FACING, Direction.UP).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
            Direction direction = context.getClickedFace();
            if (direction == Direction.DOWN || direction != Direction.UP && context.getClickLocation().y - (double) blockPos.getY() > 0.5) {
                return blockState2.setValue(FACING, Direction.DOWN);
            }
            return blockState2;
        }
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        return blockState.getValue(LAYERS) != 4 && SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, blockState, fluidState);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return blockState.getValue(LAYERS) != 4 && SimpleWaterloggedBlock.super.canPlaceLiquid(blockGetter, blockPos, blockState, fluid);
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
        builder.add(WATERLOGGED, FACING, LAYERS);
    }



}
