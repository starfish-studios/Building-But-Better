package com.starfish_studios.bbb.mixin;

import com.starfish_studios.bbb.block.FrameBlock;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HangingEntity.class)
public class HangingEntityMixin extends Entity {
    public HangingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "survives", at = @At("HEAD"), cancellable = true)
    public void survives(CallbackInfoReturnable<Boolean> cir) {
        if (this.level().getBlockState(this.blockPosition()).getBlock() instanceof FrameBlock) {
            cir.setReturnValue(true);
        }
    }

    public void defineSynchedData() {

    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {

    }
}
