package com.starfish_studios.foundation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodenLanternBlock extends LanternBlock {

    protected static final VoxelShape
            AABB = Shapes.or(Block.box(3, 0, 3, 13, 2, 13),
            Block.box(4, 2, 4, 12, 11, 12),
            Block.box(3, 11, 3, 13, 13, 13),
            Block.box(6, 13, 6, 10, 16, 10));

    public WoodenLanternBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return AABB;
    }
}
