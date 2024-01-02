package com.starfish_studios.foundation.block;

import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;

public class IronFenceBlock extends FenceBlock {
    public IronFenceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = this.isSameFence(blockState);
        boolean bl3 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction);
        return !isExceptionForConnection(blockState) && bl || bl2 || bl3;
    }

    private boolean isSameFence(BlockState blockState) {
        return blockState.is(BlockTags.FENCES) && blockState.is(FoundationTags.METAL_FENCES) == this.defaultBlockState().is(FoundationTags.METAL_FENCES);
    }
}
