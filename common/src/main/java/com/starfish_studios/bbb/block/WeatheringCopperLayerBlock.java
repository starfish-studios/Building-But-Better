package com.starfish_studios.bbb.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class WeatheringCopperLayerBlock extends LayerBlock implements WeatheringCopper {
    private final WeatherState weatherState;

    public WeatheringCopperLayerBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull Optional<BlockState> getNext(@NotNull BlockState blockState) {
        return WeatheringCopperLayer.getNext(blockState);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(Items.HONEYCOMB)) {
            var waxedOpt = WeatheringCopperLayer.getWaxed(state);
            if (waxedOpt.isPresent()) {
                if (!level.isClientSide) {
                    level.setBlock(pos, waxedOpt.get(), 3);
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    level.levelEvent(null, 3003, pos, 0);
                    if (player instanceof ServerPlayer serverPlayer) {
                        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                    }
                }
                return level.isClientSide ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
            }
        }

        if (stack.getItem() instanceof AxeItem) {
            var previousOpt = WeatheringCopperLayer.getPrevious(state);
            if (previousOpt.isPresent()) {
                if (!level.isClientSide) {
                    level.setBlock(pos, previousOpt.get(), 3);
                    level.playSound(null, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(null, 3005, pos, 0);
                    if (!player.getAbilities().instabuild) {
                        stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                    }
                    if (player instanceof ServerPlayer serverPlayer) {
                        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                    }
                }
                return level.isClientSide ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
            }
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    @SuppressWarnings("deprecation")
    public void randomTick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        this.onRandomTick(blockState, serverLevel, blockPos, randomSource);
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopperLayer.getNext(blockState.getBlock()).isPresent();
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
