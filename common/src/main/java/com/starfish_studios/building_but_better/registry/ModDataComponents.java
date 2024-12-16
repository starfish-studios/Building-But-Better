package com.starfish_studios.building_but_better.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModDataComponents {

//    public static final Supplier<DataComponentType<XenoArtifactData>> XENO_ARTIFACT = register("xeno_artifact",
//            XenoArtifactData.CODEC, XenoArtifactData.STREAM_CODEC, true);
//
//    public static final Supplier<DataComponentType<XenoArtifactDataGenerator>> XENO_ARTIFACT_GENERATOR = register("xeno_artifact_generator",
//            XenoArtifactDataGenerator.CODEC);



    public static <T> Supplier<DataComponentType<T>> register(String name, Supplier<DataComponentType<T>> factory) {
        return ModRegistry.registerDataComponent(name, factory);
    }

    public static <T> Supplier<DataComponentType<T>> register(String name, Codec<T> codec,
                                                              @Nullable StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec,
                                                              boolean cache) {
        return ModRegistry.registerDataComponent(name, () -> {
            var builder = DataComponentType.<T>builder()
                    .persistent(codec);
            if (streamCodec != null) builder.networkSynchronized(streamCodec);
            if (cache) builder.cacheEncoding();
            return builder.build();
        });
    }

    public static <T> Supplier<DataComponentType<T>> register(String name, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return register(name, codec, streamCodec, false);
    }

    public static <T> Supplier<DataComponentType<T>> register(String name, Codec<T> codec) {
        return register(name, codec, null);
    }

    public static void init() {}
}
