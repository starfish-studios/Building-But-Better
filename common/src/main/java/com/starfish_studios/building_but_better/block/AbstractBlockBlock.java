/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package com.starfish_studios.building_but_better.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.starfish_studios.building_but_better.block.entity.BlockBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public abstract class AbstractBlockBlock extends BaseEntityBlock implements Equipable {
    public final BlockBlock.Types type;

    public AbstractBlockBlock(BlockBlock.Types type, Properties properties) {
        super(properties);
        this.type = type;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BlockBlockEntity(blockPos, blockState);
    }

    public BlockBlock.Types getType() {
        return this.type;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}

