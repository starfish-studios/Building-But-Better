package com.starfish_studios.bbb.mixin.create;

import com.simibubi.create.content.contraptions.BlockMovementChecks;
import com.starfish_studios.bbb.integration.create.CreateCommon;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockMovementChecks.class, remap = false)
public abstract class BlockMovementChecksMixin {
    @Inject(method = "isBlockAttachedTowardsFallback", at = @At(value = "HEAD"), cancellable = true)
    private static void bbb$allowStickyConnections(BlockState state, Level world, BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (CreateCommon.canStickToContraption(state)) cir.setReturnValue(true);
    }
}
