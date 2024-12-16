package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.BuildingButBetter;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSoundEvents {
    public static final Supplier<SoundEvent> LAYER_HAMMER = register("block.layer.hammer");

    public static Supplier<SoundEvent> register(String name) {
        return ModRegistry.registerSoundEvent(name, () -> SoundEvent.createVariableRangeEvent(BuildingButBetter.res(name)));
    }

    public static void init() {}
}
