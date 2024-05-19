package com.starfish_studios.bbb.mixin;

import net.minecraft.world.entity.decoration.Painting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Painting.class)
public class PaintingMixin {
    @Unique
    public boolean survives() {
        return true;
    }
}
