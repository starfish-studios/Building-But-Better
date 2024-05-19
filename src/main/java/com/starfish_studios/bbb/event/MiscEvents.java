package com.starfish_studios.bbb.event;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.block.MouldingBlock;
import com.starfish_studios.bbb.block.StoneFenceBlock;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscEvents {

    @SubscribeEvent
    public void onBlockUse(PlayerInteractEvent.RightClickBlock event) {
        BlockHitResult hitResult = event.getHitVec();
        BlockPos blockPos = hitResult.getBlockPos();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        Level world = event.getLevel();
        boolean isHammer = player.getItemInHand(hand).is(BBBTags.BBBItemTags.HAMMERS);
        final boolean isMoulding = world.getBlockState(hitResult.getBlockPos()).is(BBBTags.BBBBlockTags.MOULDINGS);
        if (isHammer && isMoulding) {
            if (world.getBlockState(blockPos).getValue(MouldingBlock.DENTIL)) {
                world.setBlock(blockPos, world.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, false), 3);
                world.playSound(player, blockPos, world.getBlockState(blockPos).getBlock().getSoundType(world.getBlockState(blockPos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
            } else {
                world.setBlock(blockPos, world.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, true), 3);
                world.playSound(player, blockPos, world.getBlockState(blockPos).getBlock().getSoundType(world.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            }
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
        }

        //TODO : HAMMER + STONE FENCES
        final boolean isStoneFence = world.getBlockState(hitResult.getBlockPos()).is(BBBTags.BBBBlockTags.STONE_FENCES);
        if (isHammer && isStoneFence) {
            if (!world.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                    !world.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                    !world.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                    !world.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.PASS);
            } else if (player.isShiftKeyDown()) {
                if (!world.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                        !world.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                        !world.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                        !world.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                    event.setCanceled(true);
                    event.setCancellationResult(InteractionResult.PASS);
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
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
        }
    }

}
