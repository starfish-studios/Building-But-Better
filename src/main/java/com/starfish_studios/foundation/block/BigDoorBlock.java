package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.block.properties.BigDoorHalf;
import com.starfish_studios.foundation.block.properties.FoundationBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BigDoorBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<BigDoorHalf> HALVES = FoundationBlockStateProperties.HALVES;
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
    private final BlockSetType type;

    public BigDoorBlock(Properties properties, BlockSetType blockSetType) {
        super(properties);
        this.type = blockSetType;
        this.registerDefaultState((this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false).setValue(HALVES, BigDoorHalf.LOWER));
    }

    public BlockSetType type() {
        return this.type;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        boolean bl = !(Boolean)blockState.getValue(OPEN);
        boolean bl2 = blockState.getValue(HINGE) == DoorHingeSide.RIGHT;
        switch (direction) {
            case EAST:
            default:
                return bl ? EAST_AABB : (bl2 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
                return bl ? SOUTH_AABB : (bl2 ? EAST_AABB : WEST_AABB);
            case WEST:
                return bl ? WEST_AABB : (bl2 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
                return bl ? NORTH_AABB : (bl2 ? WEST_AABB : EAST_AABB);
        }
    }


    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        BigDoorHalf half = blockState.getValue(HALVES);
        if (direction.getAxis() == Direction.Axis.Y && (half == BigDoorHalf.LOWER == (direction == Direction.UP) || half == BigDoorHalf.MIDDLE == (direction == Direction.UP))) {
            if (blockState2.is(this) && blockState2.getValue(HALVES) != half) {
                return (((blockState.setValue(FACING, blockState2.getValue(FACING))).setValue(OPEN, blockState2.getValue(OPEN))).setValue(HINGE, blockState2.getValue(HINGE))).setValue(POWERED, blockState2.getValue(POWERED));
            }
            return Blocks.AIR.defaultBlockState();
        }
        if (half == BigDoorHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return switch (pathComputationType) {
            case LAND, AIR -> blockState.getValue(OPEN);
            case WATER -> false;
        };
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {

        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();

        if (blockPos.getY() < level.getMaxBuildHeight() - 2
                && level.getBlockState(blockPos.above()).canBeReplaced(blockPlaceContext)
                && level.getBlockState(blockPos.above(2)).canBeReplaced(blockPlaceContext)) {

            boolean bl = level.hasNeighborSignal(blockPos) || level.hasNeighborSignal(blockPos.above()) || level.hasNeighborSignal(blockPos.above(2));

            return this.defaultBlockState()
                    .setValue(FACING, blockPlaceContext.getHorizontalDirection())
                    .setValue(HINGE, this.getHinge(blockPlaceContext))
                    .setValue(POWERED, bl)
                    .setValue(OPEN, bl)
                    .setValue(HALVES, BigDoorHalf.LOWER);

        } else {
            return null;
        }
    }

    private DoorHingeSide getHinge(BlockPlaceContext blockPlaceContext) {
        BlockGetter blockGetter = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Direction direction = blockPlaceContext.getHorizontalDirection();
        BlockPos blockPos2 = blockPos.above();
        Direction direction2 = direction.getCounterClockWise();
        BlockPos blockPos3 = blockPos.relative(direction2);
        BlockState blockState = blockGetter.getBlockState(blockPos3);
        BlockPos blockPos4 = blockPos2.relative(direction2);
        BlockState blockState2 = blockGetter.getBlockState(blockPos4);
        Direction direction3 = direction.getClockWise();
        BlockPos blockPos5 = blockPos.relative(direction3);
        BlockState blockState3 = blockGetter.getBlockState(blockPos5);
        BlockPos blockPos6 = blockPos2.relative(direction3);
        BlockState blockState4 = blockGetter.getBlockState(blockPos6);
        int i = (blockState.isCollisionShapeFullBlock(blockGetter, blockPos3) ? -1 : 0) + (blockState2.isCollisionShapeFullBlock(blockGetter, blockPos4) ? -1 : 0) + (blockState3.isCollisionShapeFullBlock(blockGetter, blockPos5) ? 1 : 0) + (blockState4.isCollisionShapeFullBlock(blockGetter, blockPos6) ? 1 : 0);
        boolean bl = blockState.is(this) && blockState.getValue(HALVES) == BigDoorHalf.LOWER;
        boolean bl2 = blockState3.is(this) && blockState3.getValue(HALVES) == BigDoorHalf.LOWER;
        if ((!bl || bl2) && i <= 0) {
            if ((!bl2 || bl) && i >= 0) {
                int j = direction.getStepX();
                int k = direction.getStepZ();
                Vec3 vec3 = blockPlaceContext.getClickLocation();
                double d = vec3.x - (double)blockPos.getX();
                double e = vec3.z - (double)blockPos.getZ();
                return (j >= 0 || !(e < 0.5)) && (j <= 0 || !(e > 0.5)) && (k >= 0 || !(d > 0.5)) && (k <= 0 || !(d < 0.5)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!this.type.canOpenByHand()) {
            return InteractionResult.PASS;
        } else {
            blockState = blockState.cycle(OPEN);
            level.setBlock(blockPos, blockState, 10);
            this.playSound(player, level, blockPos, blockState.getValue(OPEN));
            level.gameEvent(player, this.isOpen(blockState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    private void playSound(@Nullable Entity entity, Level level, BlockPos blockPos, boolean bl) {
        level.playSound(entity, blockPos, bl ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    public boolean isOpen(BlockState blockState) {
        return blockState.getValue(OPEN);
    }

    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        boolean bl2 = level.hasNeighborSignal(blockPos) || level.hasNeighborSignal(blockPos.relative(blockState.getValue(HALVES) == BigDoorHalf.LOWER && blockState.getValue(HALVES) != BigDoorHalf.UPPER ? Direction.UP : Direction.DOWN));
        if (!this.defaultBlockState().is(block) && bl2 != blockState.getValue(POWERED)) {
            if (bl2 != blockState.getValue(OPEN)) {
                this.playSound(null, level, blockPos, bl2);
                level.gameEvent(null, bl2 ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
            }

            level.setBlock(blockPos, blockState.setValue(POWERED, bl2).setValue(OPEN, bl2), 2);
        }

    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return mirror == Mirror.NONE ? blockState : blockState.rotate(mirror.getRotation(blockState.getValue(FACING))).cycle(HINGE);
    }

    public static boolean isWoodenDoor(Level level, BlockPos blockPos) {
        return isWoodenDoor(level.getBlockState(blockPos));
    }

    public static boolean isWoodenDoor(BlockState blockState) {
        Block var2 = blockState.getBlock();
        boolean var10000;
        if (var2 instanceof DoorBlock doorBlock) {
            if (doorBlock.type().canOpenByHand()) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }


    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        BlockPos blockPos2 = blockPos.above();
        BlockPos blockPos3 = blockPos2.above();
        level.setBlock(blockPos2, copyWaterloggedFrom(level, blockPos2, this.defaultBlockState().setValue(HALVES, BigDoorHalf.MIDDLE).setValue(FACING, blockState.getValue(FACING)).setValue(HINGE, blockState.getValue(HINGE))), 3);
        level.setBlock(blockPos3, copyWaterloggedFrom(level, blockPos3, this.defaultBlockState().setValue(HALVES, BigDoorHalf.UPPER).setValue(FACING, blockState.getValue(FACING)).setValue(HINGE, blockState.getValue(HINGE))), 3);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        if (blockState.getValue(HALVES) != BigDoorHalf.UPPER && blockState.getValue(HALVES) != BigDoorHalf.MIDDLE) {
            return super.canSurvive(blockState, levelReader, blockPos);
        } else if (blockState.getValue(HALVES) == BigDoorHalf.MIDDLE) {
            BlockState blockState2 = levelReader.getBlockState(blockPos.below());
            return blockState2.is(this) && blockState2.getValue(HALVES) == BigDoorHalf.LOWER;
        } else {
            BlockState blockState2 = levelReader.getBlockState(blockPos.below());
            return blockState2.is(this) && blockState2.getValue(HALVES) == BigDoorHalf.MIDDLE;
        }
    }

    public static BlockState copyWaterloggedFrom(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return blockState.hasProperty(BlockStateProperties.WATERLOGGED) ? blockState.setValue(BlockStateProperties.WATERLOGGED, levelReader.isWaterAt(blockPos)) : blockState;
    }

    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
            } else {
                dropResources(blockState, level, blockPos, null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BigDoorHalf halvesState = blockState.getValue(HALVES);
        if (halvesState == BigDoorHalf.UPPER) {
            BlockPos blockPosBelow = blockPos.below();
            BlockState stateBelow = level.getBlockState(blockPosBelow);
            if (stateBelow.is(blockState.getBlock()) && stateBelow.getValue(HALVES) == BigDoorHalf.MIDDLE) {
                BlockState blockState3 = stateBelow.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockPosBelow, blockState3, 35);
                level.levelEvent(player, 2001, blockPosBelow, Block.getId(stateBelow));
                BlockPos blockPosBelow2 = blockPosBelow.below();
                BlockState stateBelow2 = level.getBlockState(blockPosBelow2);
                if (stateBelow2.is(blockState.getBlock()) && stateBelow2.getValue(HALVES) == BigDoorHalf.LOWER) {
                    BlockState blockState4 = stateBelow2.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                    level.setBlock(blockPosBelow2, blockState4, 35);
                    level.levelEvent(player, 2001, blockPosBelow2, Block.getId(stateBelow2));
                }
            }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALVES, POWERED, HINGE, OPEN, FACING);
    }

    public long getSeed(BlockState blockState, BlockPos blockPos) {
        return Mth.getSeed(blockPos.getX(), blockPos.below(blockState.getValue(HALVES) == BigDoorHalf.MIDDLE ? 0 : 1).getY(), blockPos.getZ());
    }
}
