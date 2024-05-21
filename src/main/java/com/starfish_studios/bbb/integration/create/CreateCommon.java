package com.starfish_studios.bbb.integration.create;

import com.starfish_studios.bbb.block.FrameBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CreateCommon {
    public static boolean canStickToContraption(BlockState state) {
        return state.getBlock() instanceof FrameBlock;
    }
}
