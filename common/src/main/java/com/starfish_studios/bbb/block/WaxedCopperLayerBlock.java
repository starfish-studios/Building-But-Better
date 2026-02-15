package com.starfish_studios.bbb.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class WaxedCopperLayerBlock extends LayerBlock {
    private final Supplier<Block> unwaxedBlock;

    public WaxedCopperLayerBlock(BlockBehaviour.Properties properties, Supplier<Block> unwaxedBlock) {
        super(properties);
        this.unwaxedBlock = unwaxedBlock;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() instanceof AxeItem) {
            if (!level.isClientSide) {
                Block unwaxed = unwaxedBlock.get();
                level.setBlock(pos, unwaxed.withPropertiesOf(state), 3);
                level.playSound(null, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(null, 3004, pos, 0);
                if (!player.getAbilities().instabuild) {
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                }
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                }
            }
            return level.isClientSide ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
        }

        return super.use(state, level, pos, player, hand, hit);
    }
}
