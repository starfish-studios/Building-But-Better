package com.starfish_studios.foundation.block.entity;

import com.starfish_studios.foundation.registry.FoundationBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockBlockEntity extends BlockEntity {
    private int animationTickCount;
    private boolean isAnimating;
    public BlockBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FoundationBlockEntityType.BLOCK, blockPos, blockState);
    }

    public static void animation(Level level, BlockPos blockPos, BlockState blockState, BlockBlockEntity blockBlockEntity) {
        if (level.hasNeighborSignal(blockPos)) {
            blockBlockEntity.isAnimating = true;
            ++blockBlockEntity.animationTickCount;
        } else {
            blockBlockEntity.isAnimating = false;
        }
    }

    public float getAnimation(float f) {
        if (this.isAnimating) {
            return (float)this.animationTickCount + f;
        }
        return this.animationTickCount;
    }
}
