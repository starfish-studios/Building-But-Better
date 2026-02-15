package com.starfish_studios.bbb.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.starfish_studios.bbb.registry.BBBBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public final class WeatheringCopperLayer {
    private WeatheringCopperLayer() {}

    static final Supplier<ImmutableBiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
            .put(BBBBlocks.CUT_COPPER_LAYER.get(), BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get(), BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get(), BBBBlocks.OXIDIZED_CUT_COPPER_LAYER.get())
            .build());
    static final Supplier<ImmutableBiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    static final Supplier<ImmutableMap<Block, Block>> WAXED_BY_BLOCK = Suppliers.memoize(() -> ImmutableMap.<Block, Block>builder()
            .put(BBBBlocks.CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_EXPOSED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_WEATHERED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.OXIDIZED_CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_OXIDIZED_CUT_COPPER_LAYER.get())
            .build());

    public static Optional<BlockState> getWaxed(BlockState blockState) {
        Block waxed = WAXED_BY_BLOCK.get().get(blockState.getBlock());
        return waxed != null ? Optional.of(waxed.withPropertiesOf(blockState)) : Optional.empty();
    }

    public static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }

    public static Optional<BlockState> getPrevious(BlockState blockState) {
        return getPrevious(blockState.getBlock()).map(block -> block.withPropertiesOf(blockState));
    }

    public static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    public static Optional<BlockState> getNext(BlockState blockState) {
        return getNext(blockState.getBlock()).map(block -> block.withPropertiesOf(blockState));
    }
}

