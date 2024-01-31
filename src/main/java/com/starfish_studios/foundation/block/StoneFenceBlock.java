package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StoneFenceBlock extends FenceBlock {
    public StoneFenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any().setValue(NORTH, false)).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = this.isSameFence(blockState);
        boolean bl3 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction);
        return !isExceptionForConnection(blockState) && bl || bl2 || bl3;
    }

    private boolean isSameFence(BlockState blockState) {
        return blockState.is(FoundationTags.FoundationBlockTags.STONE_FENCES);
    }
}
