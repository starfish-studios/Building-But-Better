package com.starfish_studios.building_but_better.registry;

import com.starfish_studios.building_but_better.block.entity.BlockBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static final Supplier<BlockEntityType<BlockBlockEntity>> BLOCK = ModRegistry.registerBlockEntityType("block",
            () -> ModRegistry.createBlockEntityType(BlockBlockEntity::new,
                    ModBlocks.STONE_BLOCK.get(),
                    ModBlocks.WALL_STONE_BLOCK.get(),
                    ModBlocks.BLACKSTONE_BLOCK.get(),
                    ModBlocks.WALL_BLACKSTONE_BLOCK.get(),
                    ModBlocks.DEEPSLATE_BLOCK.get(),
                    ModBlocks.WALL_DEEPSLATE_BLOCK.get(),
                    ModBlocks.NETHER_BRICK_BLOCK.get(),
                    ModBlocks.WALL_NETHER_BRICK_BLOCK.get(),
                    ModBlocks.SANDSTONE_BLOCK.get(),
                    ModBlocks.WALL_SANDSTONE_BLOCK.get(),
                    ModBlocks.RED_SANDSTONE_BLOCK.get(),
                    ModBlocks.WALL_RED_SANDSTONE_BLOCK.get(),
                    ModBlocks.QUARTZ_BLOCK.get(),
                    ModBlocks.WALL_QUARTZ_BLOCK.get()
            )
    );
    
    public static void init() {}
}
