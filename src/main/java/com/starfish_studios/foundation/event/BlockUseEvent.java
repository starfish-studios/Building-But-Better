package com.starfish_studios.foundation.event;

import com.starfish_studios.foundation.block.MouldingBlock;
import com.starfish_studios.foundation.block.StoneFenceBlock;
import com.starfish_studios.foundation.block.properties.FrameStickDirection;
import com.starfish_studios.foundation.registry.FoundationTags;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;

import static com.starfish_studios.foundation.block.FrameBlock.FRAME_CENTER;

public class BlockUseEvent implements UseBlockCallback {

    @Override
    public InteractionResult interact(Player player, Level world, InteractionHand hand, BlockHitResult hitResult) {
        final BlockPos blockPos = hitResult.getBlockPos();
        final boolean isHammer = player.getItemInHand(hand).is(FoundationTags.FoundationItemTags.HAMMERS);

        //TODO : HAMMER + MOULDINGS
        final boolean isMoulding = world.getBlockState(hitResult.getBlockPos()).is(FoundationTags.FoundationBlockTags.STONE_MOULDINGS);
        if (isHammer && isMoulding) {
            if (player.isShiftKeyDown()) {
                if (world.getBlockState(blockPos).getValue(MouldingBlock.DENTIL)) {
                    world.setBlock(blockPos, world.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, false), 3);
                } else {
                    world.setBlock(blockPos, world.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, true), 3);
                }
                world.playSound(player, blockPos, world.getBlockState(blockPos).getBlock().getSoundType(world.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }


        //TODO : HAMMER + STONE FENCES
        final boolean isStoneFence = world.getBlockState(hitResult.getBlockPos()).is(FoundationTags.FoundationBlockTags.STONE_FENCES);
        if (isHammer && isStoneFence) {
            if (!world.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                    !world.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                    !world.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                    !world.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                return InteractionResult.PASS;
            } else if (player.isShiftKeyDown()) {
                if (!world.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                        !world.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                        !world.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                        !world.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                    return InteractionResult.PASS;
                } else if (world.getBlockState(blockPos).getValue(StoneFenceBlock.PILLAR)) {
                    world.setBlock(blockPos, world.getBlockState(blockPos).setValue(StoneFenceBlock.PILLAR, false), 3);
                } else {
                    world.setBlock(blockPos, world.getBlockState(blockPos).setValue(StoneFenceBlock.PILLAR, true), 3);
                }
            } else {
                if (world.getBlockState(blockPos).getValue(StoneFenceBlock.SIDE_FILL)) {
                    world.setBlock(blockPos, world.getBlockState(blockPos).setValue(StoneFenceBlock.SIDE_FILL, false), 3);
                } else {
                    world.setBlock(blockPos, world.getBlockState(blockPos).setValue(StoneFenceBlock.SIDE_FILL, true), 3);
                }
            }
            world.playSound(player, blockPos, world.getBlockState(blockPos).getBlock().getSoundType(world.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return InteractionResult.SUCCESS;

        }
        return InteractionResult.PASS;
    }
}
