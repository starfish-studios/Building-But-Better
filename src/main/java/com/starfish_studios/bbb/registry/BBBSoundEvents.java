package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BBBSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BuildingButBetter.MOD_ID);

    public static final RegistryObject<SoundEvent> LAYER_HAMMER = register("block.layer.hammer");

    private static RegistryObject<SoundEvent> register(String name) {
        ResourceLocation id = new ResourceLocation(BuildingButBetter.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
