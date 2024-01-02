package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public interface FoundationSoundEvents {


    SoundEvent CHICKEN_CROW = register("entity.chicken.crow");
    SoundEvent CHICK_AMBIENT = register("entity.chick.ambient");

    SoundType STRAW = register("straw", 1, 1);

    private static SoundType register(String name, float volume, float pitch) {
        return new SoundType(volume, pitch, register("block." + name + ".break"), register("block." + name + ".step"), register("block." + name + ".place"), register("block." + name + ".hit"), register("block." + name + ".fall"));
    }

    static SoundEvent register(String name) {
        ResourceLocation id = new ResourceLocation(Foundation.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
}
