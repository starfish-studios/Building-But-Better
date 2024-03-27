/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.entity.BlockBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import java.util.Properties;

public abstract class AbstractBlockBlock
        extends BaseEntityBlock
        implements Equipable {
    public final BlockBlock.Type type;

    public AbstractBlockBlock(BlockBlock.Type type, Properties properties) {
        super(properties);
        this.type = type;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BlockBlockEntity(blockPos, blockState);
    }

    public BlockBlock.Type getType() {
        return this.type;
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}

