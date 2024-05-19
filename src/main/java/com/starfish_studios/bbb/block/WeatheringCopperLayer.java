/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package com.starfish_studios.bbb.block;


import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import com.starfish_studios.bbb.registry.BBBBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public interface WeatheringCopperLayer extends ChangeOverTimeBlock<WeatheringCopperLayer.WeatherState> {
    Supplier<ImmutableBiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BBBBlocks.CUT_COPPER_LAYER.get(), BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get())
                    .put(BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get(), BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get())
                    .put(BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get(), BBBBlocks.OXIDIZED_CUT_COPPER_LAYER.get())
                    .build()
    );

    Supplier<ImmutableBiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }

    static Block getFirst(Block block) {
        Block block2 = block;
        Block block3 = PREVIOUS_BY_BLOCK.get().get(block2);
        while (block3 != null) {
            block2 = block3;
            block3 = PREVIOUS_BY_BLOCK.get().get(block2);
        }
        return block2;
    }

    static Optional<BlockState> getPrevious(BlockState blockState) {
        return getPrevious(blockState.getBlock()).map(block -> block.withPropertiesOf(blockState));
    }

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    static BlockState getFirst(BlockState blockState) {
        return getFirst(blockState.getBlock()).withPropertiesOf(blockState);
    }

    @Override
    default Optional<BlockState> getNext(BlockState blockState) {
        return getNext(blockState.getBlock()).map(block -> block.withPropertiesOf(blockState));
    }

    @Override
    default float getChanceModifier() {
        if (this.getAge() == WeatherState.UNAFFECTED) {
            return 0.75f;
        }
        return 1.0f;
    }

    enum WeatherState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED
    }
}

