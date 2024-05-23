package com.starfish_studios.bbb.item;

import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

import java.util.Optional;
import java.util.Random;

import static com.starfish_studios.bbb.registry.BBBTags.*;
import static com.starfish_studios.bbb.registry.BBBTags.BBBBlockTags.CHISEL_STONE;

public class ChiselItem extends Item {
    private final TagKey<Block> outputBlockTag;

    public ChiselItem(Properties properties, TagKey<Block> outputBlockTag) {
        super(properties);
        this.outputBlockTag = outputBlockTag;
    }

    @Override
    public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return !player.isCreative();
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);


        return InteractionResult.FAIL;
    }
}