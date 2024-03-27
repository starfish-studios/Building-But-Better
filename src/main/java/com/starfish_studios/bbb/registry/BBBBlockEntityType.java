package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.block.entity.BlockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

public class BBBBlockEntityType {
    public static final BlockEntityType<BlockBlockEntity> BLOCK = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(MOD_ID, "block"),
            FabricBlockEntityTypeBuilder.create(BlockBlockEntity::new,
                    BBBBlocks.STONE_BLOCK,
                    BBBBlocks.WALL_STONE_BLOCK,
                    BBBBlocks.BLACKSTONE_BLOCK,
                    BBBBlocks.WALL_BLACKSTONE_BLOCK,
                    BBBBlocks.DEEPSLATE_BLOCK,
                    BBBBlocks.WALL_DEEPSLATE_BLOCK,
                    BBBBlocks.NETHER_BRICK_BLOCK,
                    BBBBlocks.WALL_NETHER_BRICK_BLOCK,
                    BBBBlocks.SANDSTONE_BLOCK,
                    BBBBlocks.WALL_SANDSTONE_BLOCK,
                    BBBBlocks.RED_SANDSTONE_BLOCK,
                    BBBBlocks.WALL_RED_SANDSTONE_BLOCK,
                    BBBBlocks.QUARTZ_BLOCK,
                    BBBBlocks.WALL_QUARTZ_BLOCK
            ).build(null)
    );


}
