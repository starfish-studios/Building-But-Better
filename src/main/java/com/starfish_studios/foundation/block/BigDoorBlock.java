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
        this.registerDefaultState(this.stateDefinition.any().setValue(X_POS,0).setValue(Y_POS, 0).setValue(OPEN, Boolean.FALSE));
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        if (!level.isClientSide){
            for (int i = 0; i < 4; i ++){
                for (int j = 0; j < 2; j++) {
                    level.setBlock(blockPos
                            .above(i)
                            .relative(blockState.getValue(FACING).getCounterClockWise(), j),
                            blockState.setValue(X_POS, j).setValue(Y_POS, i)
                            ,3);
                }
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
       builder.add(FACING,OPEN,X_POS, Y_POS);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        super.playerWillDestroy(level, blockPos, blockState, player);
        boolean open = blockState.getValue(OPEN).booleanValue();
        if (!open) {
            BlockPos startPos = getClosedStartPos(blockPos, level, blockState);
            BlockPos innerPos = startPos.relative(blockState.getValue(FACING).getCounterClockWise());
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
            placeAirColumn(level, startPos.relative(blockState.getValue(FACING).getCounterClockWise()));
            placeDoorColumn(blockState, level, startPos, 0, true);
            placeDoorColumn(blockState, level, startPos.relative(blockState.getValue(FACING).getOpposite()), 1, true);
            System.out.println("opening");
            return InteractionResult.SUCCESS;

        }
        else{
            placeAirColumn(level, startPos.relative(blockState.getValue(FACING).getOpposite()));
            placeDoorColumn(blockState, level, startPos, 0, false);
            placeDoorColumn(blockState, level, startPos.relative(blockState.getValue(FACING).getCounterClockWise()), 1, false);

            System.out.println("closing");
            return InteractionResult.SUCCESS;
        }

        //return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    private void placeDoorColumn(BlockState blockState, Level level, BlockPos pos, int xPos, boolean open){
        for (int i = 0; i < 4; i ++){
            level.setBlock(pos.below(i), FoundationBlocks.BIG_DOOR.defaultBlockState()
                    .setValue(Y_POS, 3-i)
                    .setValue(X_POS, xPos)
                    .setValue(OPEN, open)
                    .setValue(FACING, blockState.getValue(FACING)), 3);
        }
    }

    private void placeAirColumn(Level level, BlockPos pos){
        for (int i = 0; i < 4; i ++){
            level.setBlock(pos.below(i), Blocks.AIR.defaultBlockState(), 3);
        }
    }

    private BlockPos getClosedStartPos(BlockPos pos, Level level, BlockState blockState){
        BlockPos startPosition = pos;
        while (level.getBlockState(startPosition).is(FoundationBlocks.BIG_DOOR) && level.getBlockState(startPosition).getValue(X_POS) != 0) {
            startPosition = startPosition.relative(blockState.getValue(FACING).getClockWise());
        }
        while (level.getBlockState(startPosition).is(FoundationBlocks.BIG_DOOR) && level.getBlockState(startPosition).getValue(Y_POS) != 3) {
            startPosition = startPosition.above();
        }
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
        return startPosition;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        OPEN = BlockStateProperties.OPEN;
        X_POS = IntegerProperty.create("x_pos",0,2);
        POWERED = BlockStateProperties.POWERED;
        Y_POS = IntegerProperty.create("y_pos",0,4);
        //SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        //NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        //WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        //EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
    }
}
