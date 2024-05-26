package com.starfish_studios.bbb.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.starfish_studios.bbb.block.UrnBlock;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BushBlock.class)
public abstract class BushBlockMixin extends Block {
    public BushBlockMixin(Properties properties) {
        super(properties);
    }

    @ModifyReturnValue(method = "mayPlaceOn", at = @At("RETURN"))
    public boolean mayPlaceOn(boolean original, BlockState state, BlockGetter level, BlockPos pos) {
        return !original || state.getBlock() instanceof UrnBlock && state.getValue(UrnBlock.SOILED);
    }
}
