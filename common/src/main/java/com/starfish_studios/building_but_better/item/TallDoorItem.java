package com.starfish_studios.building_but_better.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TallDoorItem extends BlockItem {
    public TallDoorItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        BlockPos blockPos;
        Level level = blockPlaceContext.getLevel();
        BlockState blockState2 = level.isWaterAt(blockPos = blockPlaceContext.getClickedPos().above()) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
        level.setBlock(blockPos, blockState2, 27);
        BlockPos blockPos2;
        BlockState blockState3 = level.isWaterAt(blockPos2 = blockPlaceContext.getClickedPos().above(2)) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
        level.setBlock(blockPos2, blockState3, 27);
        return super.placeBlock(blockPlaceContext, blockState);
    }
}

