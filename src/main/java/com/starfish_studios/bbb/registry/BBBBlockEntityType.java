package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.block.entity.BlockBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BuildingButBetter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BBBBlockEntityType {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BuildingButBetter.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockBlockEntity>> BLOCK = BLOCK_ENTITIES.register(
            "block",
            () -> BlockEntityType.Builder.of(BlockBlockEntity::new,
                    BBBBlocks.STONE_BLOCK.get(),
                    BBBBlocks.WALL_STONE_BLOCK.get(),
                    BBBBlocks.BLACKSTONE_BLOCK.get(),
                    BBBBlocks.WALL_BLACKSTONE_BLOCK.get(),
                    BBBBlocks.DEEPSLATE_BLOCK.get(),
                    BBBBlocks.WALL_DEEPSLATE_BLOCK.get(),
                    BBBBlocks.NETHER_BRICK_BLOCK.get(),
                    BBBBlocks.WALL_NETHER_BRICK_BLOCK.get(),
                    BBBBlocks.SANDSTONE_BLOCK.get(),
                    BBBBlocks.WALL_SANDSTONE_BLOCK.get(),
                    BBBBlocks.RED_SANDSTONE_BLOCK.get(),
                    BBBBlocks.WALL_RED_SANDSTONE_BLOCK.get(),
                    BBBBlocks.QUARTZ_BLOCK.get(),
                    BBBBlocks.WALL_QUARTZ_BLOCK.get()
            ).build(null)
    );


}
