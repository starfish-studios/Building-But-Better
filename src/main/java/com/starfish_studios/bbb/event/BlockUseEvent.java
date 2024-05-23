package com.starfish_studios.bbb.event;

import com.starfish_studios.bbb.block.FrameBlock;
import com.starfish_studios.bbb.block.MouldingBlock;
import com.starfish_studios.bbb.block.StoneFenceBlock;
import com.starfish_studios.bbb.block.properties.FrameStickDirection;
import com.starfish_studios.bbb.registry.BBBTags;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import static com.starfish_studios.bbb.block.FrameBlock.FRAME_CENTER;

public class BlockUseEvent implements UseBlockCallback {

    @Override
    public InteractionResult interact(Player player, Level level, InteractionHand hand, BlockHitResult hitResult) {
        final BlockPos blockPos = hitResult.getBlockPos();
        final boolean isHammer = player.getItemInHand(hand).is(BBBTags.BBBItemTags.HAMMERS);
        BlockState blockState = level.getBlockState(blockPos);
        BlockHitResult blockHitResult = new BlockHitResult(hitResult.getLocation(), hitResult.getDirection(), blockPos, hitResult.isInside());


        //TODO : HAMMER + MOULDINGS
        final boolean isMoulding = level.getBlockState(hitResult.getBlockPos()).is(BBBTags.BBBBlockTags.MOULDINGS);
        if (isHammer && isMoulding) {
                if (level.getBlockState(blockPos).getValue(MouldingBlock.DENTIL)) {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, false), 3);
                    level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
                } else {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, true), 3);
                    level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
                }
                return InteractionResult.SUCCESS;
        }

        //TODO : HAMMER + STONE FENCES
        final boolean isStoneFence = level.getBlockState(hitResult.getBlockPos()).is(BBBTags.BBBBlockTags.STONE_FENCES);
        if (isHammer && isStoneFence) {
            if (!level.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                    !level.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                    !level.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                    !level.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                return InteractionResult.PASS;
            } else if (player.isShiftKeyDown()) {
                if (!level.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                        !level.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                        !level.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                        !level.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                    return InteractionResult.PASS;
                } else if (level.getBlockState(blockPos).getValue(StoneFenceBlock.PILLAR)) {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.PILLAR, false), 3);
                } else {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.PILLAR, true), 3);
                }
            } else {
                if (level.getBlockState(blockPos).getValue(StoneFenceBlock.SIDE_FILL)) {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.SIDE_FILL, false), 3);
                } else {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.SIDE_FILL, true), 3);
                }
            }
            level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return InteractionResult.SUCCESS;

        }
        return InteractionResult.PASS;
    }
}
