package com.starfish_studios.foundation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperLayerBlock extends LayerBlock implements WeatheringCopperLayer {
    private final WeatherState weatherState;

    public WeatheringCopperLayerBlock(WeatherState weatherState, BlockBehaviour.Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.onRandomTick(blockState, serverLevel, blockPos, randomSource);
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopperLayer.getNext(blockState.getBlock()).isPresent();
    }

    public WeatherState getAge() {
        return this.weatherState;
    }
}
