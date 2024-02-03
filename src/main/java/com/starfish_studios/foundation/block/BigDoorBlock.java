package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.registry.FoundationBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BigDoorBlock extends Block {
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;
    public static final BooleanProperty POWERED;
    public static final IntegerProperty X_POS;
    public static final IntegerProperty Y_POS;
    public static final EnumProperty<DoorHingeSide> HINGE;
    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    //protected static final VoxelShape SOUTH_AABB;
    //protected static final VoxelShape NORTH_AABB;
    //protected static final VoxelShape WEST_AABB;
    //protected static final VoxelShape EAST_AABB;
    //private final BlockSetType type;


    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public BigDoorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(X_POS,0)
                .setValue(Y_POS, 0)
                .setValue(OPEN, Boolean.FALSE).setValue(HINGE, DoorHingeSide.LEFT));
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        if (checkForAirColumn(level, blockPos.above(3).relative(blockState.getValue(FACING).getCounterClockWise()))){
            super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
            createDoor(level, blockPos, blockState);
        } else if (checkForAirColumn(level, blockPos.above(3).relative(blockState.getValue(FACING).getClockWise()))) {
            super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
            createDoor(level, blockPos.relative(blockState.getValue(FACING).getClockWise()), blockState);
        }
        else{
            level.setBlock(blockPos, Blocks.AIR.defaultBlockState(),3);
        }
    }


    public void createDoor(Level level, BlockPos pos, BlockState blockState){
        if (!level.isClientSide){
            for (int i = 0; i < 4; i ++){
                for (int j = 0; j < 2; j++) {
                    level.setBlock(pos
                                    .above(i)
                                    .relative(blockState.getValue(FACING).getCounterClockWise(), j),
                            blockState.setValue(X_POS, j).setValue(Y_POS, i).setValue(HINGE, blockState.getValue(HINGE))
                            ,3);
                }
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockState blockState = super.getStateForPlacement(blockPlaceContext).setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
        if (checkForAirColumn(level, blockPos.above(3).relative(blockState.getValue(FACING).getCounterClockWise()))){
            return super.getStateForPlacement(blockPlaceContext)
                    .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
                    .setValue(HINGE, getHingeSide(blockPlaceContext, blockPos, blockPos.relative(blockState.getValue(FACING).getCounterClockWise()), blockState));

        } else if (checkForAirColumn(level, blockPos.above(3).relative(blockState.getValue(FACING).getClockWise()))) {
            return super.getStateForPlacement(blockPlaceContext)
                    .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
                    .setValue(HINGE, getHingeSide(blockPlaceContext, blockPos.relative(blockState.getValue(FACING).getClockWise()), blockPos, blockState));
        }
        else{
            return null;
        }
    }

    public DoorHingeSide getHingeSide(BlockPlaceContext context, BlockPos leftPos, BlockPos rightPos, BlockState state){
        Level level = context.getLevel();
        BlockState leftBlockState = level.getBlockState(leftPos.relative(state.getValue(FACING).getClockWise()));
        BlockState rightBlockState = level.getBlockState(rightPos.relative(state.getValue(FACING).getCounterClockWise()));

        if (leftBlockState.is(FoundationBlocks.BIG_DOOR)){
            return leftBlockState.getValue(HINGE).equals(DoorHingeSide.LEFT) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
        }
        else{
            if (rightBlockState.is(FoundationBlocks.BIG_DOOR)){
                return rightBlockState.getValue(HINGE).equals(DoorHingeSide.LEFT) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            }
        }
        return DoorHingeSide.LEFT;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
       builder.add(new Property[]{X_POS, Y_POS, FACING, OPEN, HINGE, POWERED});
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        super.playerWillDestroy(level, blockPos, blockState, player);
        boolean open = blockState.getValue(OPEN).booleanValue();
        if (!open) {
            BlockPos startPos = getClosedStartPos(blockPos, level, blockState);
            BlockPos innerPos = blockState.getValue(HINGE).equals(DoorHingeSide.LEFT) ? startPos.relative(blockState.getValue(FACING).getCounterClockWise()) : startPos.relative(blockState.getValue(FACING).getClockWise());
            placeAirColumn(level, innerPos);
            placeAirColumn(level, startPos);
        }
        else{
            BlockPos startPos = getOpenStartPos(blockPos, level, blockState);
            BlockPos innerPos = startPos.relative(blockState.getValue(FACING).getOpposite());
            placeAirColumn(level, innerPos);
            placeAirColumn(level, startPos);
        }

    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        boolean open = blockState.getValue(OPEN).booleanValue();
        BlockPos startPos = open ? getOpenStartPos(blockPos, level, blockState) : getClosedStartPos(blockPos, level, blockState);
        if (!open) {
            if (blockState.getValue(HINGE).equals(DoorHingeSide.LEFT)) {
                boolean openFlag = checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite())) && checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()).relative(blockState.getValue(FACING).getCounterClockWise()));
                if (!openFlag) return InteractionResult.FAIL;
                placeAirColumn(level, startPos.relative(blockState.getValue(FACING).getCounterClockWise()));
                placeDoorColumn(blockState, level, startPos, 0, true);
                placeDoorColumn(blockState, level, startPos.relative(blockState.getValue(FACING).getOpposite()), 1, true);
                return InteractionResult.SUCCESS;
            }
            else{
                boolean openFlag = checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite())) && checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()).relative(blockState.getValue(FACING).getClockWise()));
                if (!openFlag) return InteractionResult.FAIL;
                placeAirColumn(level, startPos.relative(blockState.getValue(FACING).getClockWise()));
                placeDoorColumn(blockState, level, startPos, 0, true);
                placeDoorColumn(blockState, level, startPos.relative(blockState.getValue(FACING).getOpposite()), 1, true);
                return InteractionResult.SUCCESS;
            }
        }
        else{
            if (blockState.getValue(HINGE).equals(DoorHingeSide.LEFT)) {
                boolean closeFlag = checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getCounterClockWise())) && checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()).relative(blockState.getValue(FACING).getCounterClockWise()));
                if (!closeFlag) return InteractionResult.FAIL;
                placeAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()));
                placeDoorColumn(blockState, level, startPos, 0, false);
                placeDoorColumn(blockState, level, startPos.relative(blockState.getValue(FACING).getCounterClockWise()), 1, false);
                return InteractionResult.SUCCESS;
            }
            else{
                boolean closeFlag = checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getClockWise())) && checkForAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()).relative(blockState.getValue(FACING).getClockWise()));
                if (!closeFlag) return InteractionResult.FAIL;
                placeAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()));
                placeDoorColumn(blockState, level, startPos, 1, false);
                placeDoorColumn(blockState, level, startPos.relative(blockState.getValue(FACING).getClockWise()), 0, false);
                return InteractionResult.SUCCESS;
            }
        }
    }

    private void placeDoorColumn(BlockState blockState, Level level, BlockPos pos, int xPos, boolean open){
        for (int i = 0; i < 4; i ++){
            level.setBlock(pos.below(i), FoundationBlocks.BIG_DOOR.defaultBlockState()
                    .setValue(Y_POS, 3-i)
                    .setValue(X_POS, xPos)
                    .setValue(OPEN, open)
                    .setValue(FACING, blockState.getValue(FACING))
                    .setValue(HINGE, blockState.getValue(HINGE)), 3);
        }
    }

    private void placeAirColumn(Level level, BlockPos pos){
        for (int i = 0; i < 4; i ++){
            level.setBlock(pos.below(i), Blocks.AIR.defaultBlockState(), 3);
        }
    }

    private boolean checkForAirColumn(Level level, BlockPos pos){
        for (int i = 0; i < 4; i ++){
            if (!level.getBlockState(pos.below(i)).is(Blocks.AIR)){
                return false;
            }
        }
        return true;
    }

    private BlockPos getClosedStartPos(BlockPos pos, Level level, BlockState blockState){
        BlockPos startPosition = pos;
        while (level.getBlockState(startPosition).is(FoundationBlocks.BIG_DOOR) && level.getBlockState(startPosition).getValue(X_POS) != 0) {
            startPosition = startPosition.relative(blockState.getValue(FACING).getClockWise());
        }
        while (level.getBlockState(startPosition).is(FoundationBlocks.BIG_DOOR) && level.getBlockState(startPosition).getValue(Y_POS) != 3) {
            startPosition = startPosition.above();
        }
        if (blockState.getValue(HINGE).equals(DoorHingeSide.RIGHT)) startPosition = startPosition.relative(blockState.getValue(FACING).getCounterClockWise());
        return startPosition;
    }

    private BlockPos getOpenStartPos(BlockPos pos, Level level, BlockState blockState){
        BlockPos startPosition = pos;
        while (level.getBlockState(startPosition).is(FoundationBlocks.BIG_DOOR) && level.getBlockState(startPosition).getValue(Y_POS) != 3) {
            startPosition = startPosition.above();
        }
        while (level.getBlockState(startPosition).is(FoundationBlocks.BIG_DOOR) && level.getBlockState(startPosition).getValue(X_POS) != 0) {
            startPosition = startPosition.relative(blockState.getValue(FACING));
        }
        //if (blockState.getValue(HINGE).equals(DoorHingeSide.RIGHT)) startPosition = startPosition.relative(blockState.getValue(FACING).getCounterClockWise());
        return startPosition;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        OPEN = BlockStateProperties.OPEN;
        X_POS = IntegerProperty.create("x_pos",0,2);
        POWERED = BlockStateProperties.POWERED;
        Y_POS = IntegerProperty.create("y_pos",0,4);
        HINGE = BlockStateProperties.DOOR_HINGE;

        //SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        //NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        //WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        //EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
    }
}
