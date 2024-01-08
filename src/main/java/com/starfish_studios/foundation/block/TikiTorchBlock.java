package com.starfish_studios.foundation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class TikiTorchBlock extends DoublePlantBlock {

    protected final ParticleOptions flameParticle;
    public TikiTorchBlock(Properties properties, ParticleOptions particleOptions) {
        super(properties);
        this.flameParticle = particleOptions;
    }
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            double d = (double)blockPos.getX() + 0.5;
            double e = (double)blockPos.getY() + 0.9;
            double f = (double)blockPos.getZ() + 0.5;
            level.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
            level.addParticle(this.flameParticle, d, e, f, 0.0, 0.0, 0.0);
        }

    }

}
