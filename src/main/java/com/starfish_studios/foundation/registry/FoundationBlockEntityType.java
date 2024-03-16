package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.block.entity.BlockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;

import static com.starfish_studios.foundation.Foundation.MOD_ID;

public class FoundationBlockEntityType {
    public static final BlockEntityType<BlockBlockEntity> BLOCK = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(MOD_ID, "block"),
            FabricBlockEntityTypeBuilder.create(BlockBlockEntity::new,
                    FoundationBlocks.STONE_BLOCK,
                    FoundationBlocks.WALL_STONE_BLOCK,
                    FoundationBlocks.BLACKSTONE_BLOCK,
                    FoundationBlocks.WALL_BLACKSTONE_BLOCK,
                    FoundationBlocks.DEEPSLATE_BLOCK,
                    FoundationBlocks.WALL_DEEPSLATE_BLOCK,
                    FoundationBlocks.NETHER_BRICK_BLOCK,
                    FoundationBlocks.WALL_NETHER_BRICK_BLOCK,
                    FoundationBlocks.SANDSTONE_BLOCK,
                    FoundationBlocks.WALL_SANDSTONE_BLOCK,
                    FoundationBlocks.RED_SANDSTONE_BLOCK,
                    FoundationBlocks.WALL_RED_SANDSTONE_BLOCK,
                    FoundationBlocks.QUARTZ_BLOCK,
                    FoundationBlocks.WALL_QUARTZ_BLOCK
            ).build(null)
    );


}
