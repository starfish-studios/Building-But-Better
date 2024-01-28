package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.entity.BrazierBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FoundationBlockEntityType {
    public static final BlockEntityType<BrazierBlockEntity> BRAZIER = Registry.register
            (BuiltInRegistries.BLOCK_ENTITY_TYPE, Foundation.MOD_ID + ":hamsters",
                    FabricBlockEntityTypeBuilder.create(BrazierBlockEntity::new, FoundationBlocks.BRAZIER)
                            .build(null)
            );

}
