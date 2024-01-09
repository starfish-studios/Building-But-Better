package com.starfish_studios.foundation.registry;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;

public class FoundationBlocks {

    public static final Block ROPE = register("rope", new ChainBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).forceSolidOn().strength(0.1F).sound(SoundType.WOOL).noOcclusion()));

    public static final Block TIKI_TORCH = register("tiki_torch", new TikiTorchBlock(FabricBlockSettings.copy((Blocks.TORCH)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(1.0F, 1.5F), ParticleTypes.FLAME));

    // region WOODEN LANTERNS
    public static final Block OAK_LANTERN = register("oak_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block SPRUCE_LANTERN = register("spruce_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block BIRCH_LANTERN = register("birch_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block JUNGLE_LANTERN = register("jungle_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block ACACIA_LANTERN = register("acacia_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block DARK_OAK_LANTERN = register("dark_oak_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block MANGROVE_LANTERN = register("mangrove_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block CHERRY_LANTERN = register("cherry_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block BAMBOO_LANTERN = register("bamboo_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block CRIMSON_LANTERN = register("crimson_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    public static final Block WARPED_LANTERN = register("warped_lantern", new WoodenLanternBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS)).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).strength(0.3F)));
    // endregion

    public static final Block OAK_TRIM = register("oak_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));
    public static final Block SPRUCE_TRIM = register("spruce_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS))));
    public static final Block BIRCH_TRIM = register("birch_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS))));
    public static final Block JUNGLE_TRIM = register("jungle_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS))));
    public static final Block ACACIA_TRIM = register("acacia_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS))));
    public static final Block DARK_OAK_TRIM = register("dark_oak_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS))));
    public static final Block MANGROVE_TRIM = register("mangrove_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS))));
    public static final Block CHERRY_TRIM = register("cherry_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS))));
    public static final Block BAMBOO_TRIM = register("bamboo_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS))));
    public static final Block CRIMSON_TRIM = register("crimson_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS))));
    public static final Block WARPED_TRIM = register("warped_trim", new ColumnBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS))));

    public static final Block COBBLESTONE_LAYER = register("cobblestone_layer", new LayerBlock(FabricBlockSettings.copy((Blocks.COBBLESTONE))));
    public static final Block IRON_FENCE = register("iron_fence", new BalustradeBlock(FabricBlockSettings.copy((Blocks.IRON_BARS))));

    public static final Block OAK_SUPPORT = register("oak_support", new SupportBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));


    public static final Block OAK_BEAM = register("oak_beam", new BeamBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion()));

    public static final Block OAK_BALUSTRADE = register("oak_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS))));
    public static final Block SPRUCE_BALUSTRADE = register("spruce_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.SPRUCE_PLANKS))));
    public static final Block BIRCH_BALUSTRADE = register("birch_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.BIRCH_PLANKS))));
    public static final Block JUNGLE_BALUSTRADE = register("jungle_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.JUNGLE_PLANKS))));
    public static final Block ACACIA_BALUSTRADE = register("acacia_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.ACACIA_PLANKS))));
    public static final Block DARK_OAK_BALUSTRADE = register("dark_oak_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.DARK_OAK_PLANKS))));
    public static final Block MANGROVE_BALUSTRADE = register("mangrove_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.MANGROVE_PLANKS))));
    public static final Block CHERRY_BALUSTRADE = register("cherry_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.CHERRY_PLANKS))));
    public static final Block BAMBOO_BALUSTRADE = register("bamboo_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.BAMBOO_PLANKS))));
    public static final Block CRIMSON_BALUSTRADE = register("crimson_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.CRIMSON_PLANKS))));
    public static final Block WARPED_BALUSTRADE = register("warped_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.WARPED_PLANKS))));


    public static final Block STONE_BALUSTRADE = register("stone_balustrade", new BalustradeBlock(FabricBlockSettings.copy((Blocks.STONE))));
    public static final Block STONE_MOULDING = register("stone_moulding", new StairBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final Block BIG_OAK_DOOR = register("big_oak_door", new BigDoorBlock(FabricBlockSettings.copy((Blocks.OAK_PLANKS)).noOcclusion(), BlockSetType.OAK));


    private static Block register(String id, Block block) {
        System.out.println(Foundation.MOD_ID + ":" + id);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Foundation.MOD_ID, id), block);
    }
}
