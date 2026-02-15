package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.block.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.ToIntFunction;

import static net.minecraft.world.level.material.PushReaction.DESTROY;

public class BBBBlocks {
    // Stone, Blackstone, Deepslate, Nether Brick, Sandstone, Red Sandstone, Quartz

    // Write a list of every wood block.
    // Trim, Beam, Beam Stairs, Beam Slab, Pallets, Supports, Balustrades, Walls, Frames, Lanterns, Ladders, Lattices
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuildingButBetter.MOD_ID, Registries.BLOCK);


    public static final RegistrySupplier<Block> OAK_BALUSTRADE = BLOCKS.register("oak_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> SPRUCE_BALUSTRADE = BLOCKS.register("spruce_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> BIRCH_BALUSTRADE = BLOCKS.register("birch_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> JUNGLE_BALUSTRADE = BLOCKS.register("jungle_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> ACACIA_BALUSTRADE = BLOCKS.register("acacia_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> DARK_OAK_BALUSTRADE = BLOCKS.register("dark_oak_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> CRIMSON_BALUSTRADE = BLOCKS.register("crimson_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> WARPED_BALUSTRADE = BLOCKS.register("warped_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> MANGROVE_BALUSTRADE = BLOCKS.register("mangrove_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> BAMBOO_BALUSTRADE = BLOCKS.register("bamboo_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> CHERRY_BALUSTRADE = BLOCKS.register("cherry_balustrade", () -> new BalustradeBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));

    public static final RegistrySupplier<Block> OAK_LATTICE = BLOCKS.register("oak_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> SPRUCE_LATTICE = BLOCKS.register("spruce_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BIRCH_LATTICE = BLOCKS.register("birch_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> JUNGLE_LATTICE = BLOCKS.register("jungle_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> ACACIA_LATTICE = BLOCKS.register("acacia_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> DARK_OAK_LATTICE = BLOCKS.register("dark_oak_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> CRIMSON_LATTICE = BLOCKS.register("crimson_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WARPED_LATTICE = BLOCKS.register("warped_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> MANGROVE_LATTICE = BLOCKS.register("mangrove_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BAMBOO_LATTICE = BLOCKS.register("bamboo_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> CHERRY_LATTICE = BLOCKS.register("cherry_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion().pushReaction(DESTROY)));

    public static final RegistrySupplier<Block> OAK_WALL = BLOCKS.register("oak_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> SPRUCE_WALL = BLOCKS.register("spruce_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistrySupplier<Block> BIRCH_WALL = BLOCKS.register("birch_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistrySupplier<Block> JUNGLE_WALL = BLOCKS.register("jungle_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistrySupplier<Block> ACACIA_WALL = BLOCKS.register("acacia_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistrySupplier<Block> DARK_OAK_WALL = BLOCKS.register("dark_oak_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistrySupplier<Block> CRIMSON_WALL = BLOCKS.register("crimson_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistrySupplier<Block> WARPED_WALL = BLOCKS.register("warped_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistrySupplier<Block> MANGROVE_WALL = BLOCKS.register("mangrove_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistrySupplier<Block> BAMBOO_WALL = BLOCKS.register("bamboo_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistrySupplier<Block> CHERRY_WALL = BLOCKS.register("cherry_wall", () -> new WoodenWallBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));


    public static final RegistrySupplier<Block> OAK_BEAM = BLOCKS.register("oak_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> SPRUCE_BEAM = BLOCKS.register("spruce_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> BIRCH_BEAM = BLOCKS.register("birch_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> JUNGLE_BEAM = BLOCKS.register("jungle_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> ACACIA_BEAM = BLOCKS.register("acacia_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> DARK_OAK_BEAM = BLOCKS.register("dark_oak_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> CRIMSON_BEAM = BLOCKS.register("crimson_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> WARPED_BEAM = BLOCKS.register("warped_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> MANGROVE_BEAM = BLOCKS.register("mangrove_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> BAMBOO_BEAM = BLOCKS.register("bamboo_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistrySupplier<Block> CHERRY_BEAM = BLOCKS.register("cherry_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));


    public static final RegistrySupplier<Block> OAK_BEAM_STAIRS = BLOCKS.register("oak_beam_stairs", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> SPRUCE_BEAM_STAIRS = BLOCKS.register("spruce_beam_stairs", () -> new StairBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistrySupplier<Block> BIRCH_BEAM_STAIRS = BLOCKS.register("birch_beam_stairs", () -> new StairBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistrySupplier<Block> JUNGLE_BEAM_STAIRS = BLOCKS.register("jungle_beam_stairs", () -> new StairBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistrySupplier<Block> ACACIA_BEAM_STAIRS = BLOCKS.register("acacia_beam_stairs", () -> new StairBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistrySupplier<Block> DARK_OAK_BEAM_STAIRS = BLOCKS.register("dark_oak_beam_stairs", () -> new StairBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistrySupplier<Block> CRIMSON_BEAM_STAIRS = BLOCKS.register("crimson_beam_stairs", () -> new StairBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistrySupplier<Block> WARPED_BEAM_STAIRS = BLOCKS.register("warped_beam_stairs", () -> new StairBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistrySupplier<Block> MANGROVE_BEAM_STAIRS = BLOCKS.register("mangrove_beam_stairs", () -> new StairBlock(Blocks.MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistrySupplier<Block> BAMBOO_BEAM_STAIRS = BLOCKS.register("bamboo_beam_stairs", () -> new StairBlock(Blocks.BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistrySupplier<Block> CHERRY_BEAM_STAIRS = BLOCKS.register("cherry_beam_stairs", () -> new StairBlock(Blocks.CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));

    public static final RegistrySupplier<Block> OAK_BEAM_SLAB = BLOCKS.register("oak_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> SPRUCE_BEAM_SLAB = BLOCKS.register("spruce_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistrySupplier<Block> BIRCH_BEAM_SLAB = BLOCKS.register("birch_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistrySupplier<Block> JUNGLE_BEAM_SLAB = BLOCKS.register("jungle_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistrySupplier<Block> ACACIA_BEAM_SLAB = BLOCKS.register("acacia_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistrySupplier<Block> DARK_OAK_BEAM_SLAB = BLOCKS.register("dark_oak_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistrySupplier<Block> CRIMSON_BEAM_SLAB = BLOCKS.register("crimson_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistrySupplier<Block> WARPED_BEAM_SLAB = BLOCKS.register("warped_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistrySupplier<Block> MANGROVE_BEAM_SLAB = BLOCKS.register("mangrove_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistrySupplier<Block> BAMBOO_BEAM_SLAB = BLOCKS.register("bamboo_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistrySupplier<Block> CHERRY_BEAM_SLAB = BLOCKS.register("cherry_beam_slab", () -> new FacingSlabBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));

    public static final RegistrySupplier<Block> OAK_SUPPORT = BLOCKS.register("oak_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> SPRUCE_SUPPORT = BLOCKS.register("spruce_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> BIRCH_SUPPORT = BLOCKS.register("birch_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> JUNGLE_SUPPORT = BLOCKS.register("jungle_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> ACACIA_SUPPORT = BLOCKS.register("acacia_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> DARK_OAK_SUPPORT = BLOCKS.register("dark_oak_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> CRIMSON_SUPPORT = BLOCKS.register("crimson_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> WARPED_SUPPORT = BLOCKS.register("warped_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> MANGROVE_SUPPORT = BLOCKS.register("mangrove_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> BAMBOO_SUPPORT = BLOCKS.register("bamboo_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> CHERRY_SUPPORT = BLOCKS.register("cherry_support", () -> new SupportBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));

    public static final RegistrySupplier<Block> OAK_PALLET = BLOCKS.register("oak_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> SPRUCE_PALLET = BLOCKS.register("spruce_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> BIRCH_PALLET = BLOCKS.register("birch_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> JUNGLE_PALLET = BLOCKS.register("jungle_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> ACACIA_PALLET = BLOCKS.register("acacia_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> DARK_OAK_PALLET = BLOCKS.register("dark_oak_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> CRIMSON_PALLET = BLOCKS.register("crimson_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> WARPED_PALLET = BLOCKS.register("warped_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> MANGROVE_PALLET = BLOCKS.register("mangrove_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> BAMBOO_PALLET = BLOCKS.register("bamboo_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> CHERRY_PALLET = BLOCKS.register("cherry_pallet", () -> new PalletBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));

    public static final RegistrySupplier<Block> OAK_FRAME = BLOCKS.register("oak_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> SPRUCE_FRAME = BLOCKS.register("spruce_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BIRCH_FRAME = BLOCKS.register("birch_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> JUNGLE_FRAME = BLOCKS.register("jungle_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> ACACIA_FRAME = BLOCKS.register("acacia_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> DARK_OAK_FRAME = BLOCKS.register("dark_oak_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> CRIMSON_FRAME = BLOCKS.register("crimson_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WARPED_FRAME = BLOCKS.register("warped_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> MANGROVE_FRAME = BLOCKS.register("mangrove_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BAMBOO_FRAME = BLOCKS.register("bamboo_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> CHERRY_FRAME = BLOCKS.register("cherry_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion().noCollission().pushReaction(DESTROY)));


    public static final RegistrySupplier<Block> OAK_LANTERN = BLOCKS.register("oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> SPRUCE_LANTERN = BLOCKS.register("spruce_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> BIRCH_LANTERN = BLOCKS.register("birch_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> JUNGLE_LANTERN = BLOCKS.register("jungle_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> ACACIA_LANTERN = BLOCKS.register("acacia_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> DARK_OAK_LANTERN = BLOCKS.register("dark_oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> CRIMSON_LANTERN = BLOCKS.register("crimson_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> WARPED_LANTERN = BLOCKS.register("warped_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> MANGROVE_LANTERN = BLOCKS.register("mangrove_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> BAMBOO_LANTERN = BLOCKS.register("bamboo_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));
    public static final RegistrySupplier<Block> CHERRY_LANTERN = BLOCKS.register("cherry_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F)));

    public static final RegistrySupplier<Block> OAK_TRIM = BLOCKS.register("oak_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> SPRUCE_TRIM = BLOCKS.register("spruce_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistrySupplier<Block> BIRCH_TRIM = BLOCKS.register("birch_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistrySupplier<Block> JUNGLE_TRIM = BLOCKS.register("jungle_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistrySupplier<Block> ACACIA_TRIM = BLOCKS.register("acacia_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistrySupplier<Block> DARK_OAK_TRIM = BLOCKS.register("dark_oak_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistrySupplier<Block> CRIMSON_TRIM = BLOCKS.register("crimson_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistrySupplier<Block> WARPED_TRIM = BLOCKS.register("warped_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistrySupplier<Block> MANGROVE_TRIM = BLOCKS.register("mangrove_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistrySupplier<Block> BAMBOO_TRIM = BLOCKS.register("bamboo_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistrySupplier<Block> CHERRY_TRIM = BLOCKS.register("cherry_trim", () -> new FacingConnectingBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));

    public static final RegistrySupplier<Block> OAK_LAYER = BLOCKS.register("oak_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> SPRUCE_LAYER = BLOCKS.register("spruce_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistrySupplier<Block> BIRCH_LAYER = BLOCKS.register("birch_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistrySupplier<Block> JUNGLE_LAYER = BLOCKS.register("jungle_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistrySupplier<Block> ACACIA_LAYER = BLOCKS.register("acacia_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistrySupplier<Block> DARK_OAK_LAYER = BLOCKS.register("dark_oak_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistrySupplier<Block> CRIMSON_LAYER = BLOCKS.register("crimson_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistrySupplier<Block> WARPED_LAYER = BLOCKS.register("warped_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistrySupplier<Block> MANGROVE_LAYER = BLOCKS.register("mangrove_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistrySupplier<Block> BAMBOO_LAYER = BLOCKS.register("bamboo_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistrySupplier<Block> BAMBOO_MOSAIC_LAYER = BLOCKS.register("bamboo_mosaic_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_MOSAIC)));
    public static final RegistrySupplier<Block> CHERRY_LAYER = BLOCKS.register("cherry_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));

    public static final RegistrySupplier<Block> OAK_LADDER = BLOCKS.register("oak_ladder", () -> new BBBLadderBlock(1, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> SPRUCE_LADDER = BLOCKS.register("spruce_ladder", () -> new BBBLadderBlock(2, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> BIRCH_LADDER = BLOCKS.register("birch_ladder", () -> new BBBLadderBlock(3,BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> JUNGLE_LADDER = BLOCKS.register("jungle_ladder", () -> new BBBLadderBlock(4, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> ACACIA_LADDER = BLOCKS.register("acacia_ladder", () -> new BBBLadderBlock(5, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> DARK_OAK_LADDER = BLOCKS.register("dark_oak_ladder", () -> new BBBLadderBlock(6, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> CRIMSON_LADDER = BLOCKS.register("crimson_ladder", () -> new BBBLadderBlock(7, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> WARPED_LADDER = BLOCKS.register("warped_ladder", () -> new BBBLadderBlock(8, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> MANGROVE_LADDER = BLOCKS.register("mangrove_ladder", () -> new BBBLadderBlock(9, BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> BAMBOO_LADDER = BLOCKS.register("bamboo_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistrySupplier<Block> CHERRY_LADDER = BLOCKS.register("cherry_ladder", () -> new BBBLadderBlock(10, BlockBehaviour.Properties.copy(Blocks.LADDER)));


    // region BLOCKS
    public static final RegistrySupplier<Block> STONE_BLOCK = BLOCKS.register("stone_block", () -> new BlockBlock(BlockBlock.Types.STONE, BlockBehaviour.Properties.copy((Blocks.STONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_STONE_BLOCK = BLOCKS.register("wall_stone_block", () -> new WallBlockBlock(BlockBlock.Types.STONE, BlockBehaviour.Properties.copy((Blocks.STONE)).pushReaction(DESTROY).dropsLike(STONE_BLOCK.get())));
    public static final RegistrySupplier<Block> BLACKSTONE_BLOCK = BLOCKS.register("blackstone_block", () -> new BlockBlock(BlockBlock.Types.BLACKSTONE, BlockBehaviour.Properties.copy((Blocks.BLACKSTONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_BLACKSTONE_BLOCK = BLOCKS.register("wall_blackstone_block", () -> new WallBlockBlock(BlockBlock.Types.BLACKSTONE, BlockBehaviour.Properties.copy((Blocks.BLACKSTONE)).pushReaction(DESTROY).dropsLike(BLACKSTONE_BLOCK.get())));
    public static final RegistrySupplier<Block> DEEPSLATE_BLOCK = BLOCKS.register("deepslate_block", () -> new BlockBlock(BlockBlock.Types.DEEPSLATE, BlockBehaviour.Properties.copy((Blocks.DEEPSLATE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_DEEPSLATE_BLOCK = BLOCKS.register("wall_deepslate_block", () -> new WallBlockBlock(BlockBlock.Types.DEEPSLATE, BlockBehaviour.Properties.copy((Blocks.DEEPSLATE)).pushReaction(DESTROY).dropsLike(DEEPSLATE_BLOCK.get())));
    public static final RegistrySupplier<Block> NETHER_BRICK_BLOCK = BLOCKS.register("nether_brick_block", () -> new BlockBlock(BlockBlock.Types.NETHER_BRICK, BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_NETHER_BRICK_BLOCK = BLOCKS.register("wall_nether_brick_block", () -> new WallBlockBlock(BlockBlock.Types.NETHER_BRICK, BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS)).pushReaction(DESTROY).dropsLike(NETHER_BRICK_BLOCK.get())));
    public static final RegistrySupplier<Block> SANDSTONE_BLOCK = BLOCKS.register("sandstone_block", () -> new BlockBlock(BlockBlock.Types.SANDSTONE, BlockBehaviour.Properties.copy((Blocks.SANDSTONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_SANDSTONE_BLOCK = BLOCKS.register("wall_sandstone_block", () -> new WallBlockBlock(BlockBlock.Types.SANDSTONE, BlockBehaviour.Properties.copy((Blocks.SANDSTONE)).pushReaction(DESTROY).dropsLike(SANDSTONE_BLOCK.get())));
    public static final RegistrySupplier<Block> RED_SANDSTONE_BLOCK = BLOCKS.register("red_sandstone_block", () -> new BlockBlock(BlockBlock.Types.RED_SANDSTONE, BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_RED_SANDSTONE_BLOCK = BLOCKS.register("wall_red_sandstone_block", () -> new WallBlockBlock(BlockBlock.Types.RED_SANDSTONE, BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE)).pushReaction(DESTROY).dropsLike(RED_SANDSTONE_BLOCK.get())));
    public static final RegistrySupplier<Block> QUARTZ_BLOCK = BLOCKS.register("quartz_block", () -> new BlockBlock(BlockBlock.Types.QUARTZ, BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_QUARTZ_BLOCK = BLOCKS.register("wall_quartz_block", () -> new WallBlockBlock(BlockBlock.Types.QUARTZ, BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK)).pushReaction(DESTROY).dropsLike(QUARTZ_BLOCK.get())));
    // endregion

    // region COLUMNS
    public static final RegistrySupplier<Block> STONE_COLUMN = BLOCKS.register("stone_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.STONE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> BLACKSTONE_COLUMN = BLOCKS.register("blackstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.BLACKSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> DEEPSLATE_COLUMN = BLOCKS.register("deepslate_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> NETHER_BRICK_COLUMN = BLOCKS.register("nether_brick_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> SANDSTONE_COLUMN = BLOCKS.register("sandstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> RED_SANDSTONE_COLUMN = BLOCKS.register("red_sandstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> QUARTZ_COLUMN = BLOCKS.register("quartz_column", () -> new ColumnBlock(BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK)).noOcclusion()));
    // endregion

    // region URNS
    public static final RegistrySupplier<Block> STONE_URN = BLOCKS.register("stone_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.STONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BLACKSTONE_URN = BLOCKS.register("blackstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.BLACKSTONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> DEEPSLATE_URN = BLOCKS.register("deepslate_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> NETHER_BRICK_URN = BLOCKS.register("nether_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> SANDSTONE_URN = BLOCKS.register("sandstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.SANDSTONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> RED_SANDSTONE_URN = BLOCKS.register("red_sandstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> QUARTZ_URN = BLOCKS.register("quartz_urn", () -> new UrnBlock(BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK)).noOcclusion().pushReaction(DESTROY)));
    // endregion

    // region MOULDINGS
    public static final RegistrySupplier<Block> STONE_MOULDING = BLOCKS.register("stone_moulding", () -> new MouldingBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> BLACKSTONE_MOULDING = BLOCKS.register("blackstone_moulding", () -> new MouldingBlock((Blocks.BLACKSTONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> DEEPSLATE_MOULDING = BLOCKS.register("deepslate_moulding", () -> new MouldingBlock((Blocks.DEEPSLATE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> NETHER_BRICK_MOULDING = BLOCKS.register("nether_brick_moulding", () -> new MouldingBlock((Blocks.NETHER_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> SANDSTONE_MOULDING = BLOCKS.register("sandstone_moulding", () -> new MouldingBlock((Blocks.SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> RED_SANDSTONE_MOULDING = BLOCKS.register("red_sandstone_moulding", () -> new MouldingBlock((Blocks.RED_SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.RED_SANDSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> QUARTZ_MOULDING = BLOCKS.register("quartz_moulding", () -> new MouldingBlock((Blocks.QUARTZ_BLOCK.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    // endregion

    // region STONE FENCES
    public static final RegistrySupplier<Block> STONE_FENCE = BLOCKS.register("stone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.STONE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> BLACKSTONE_FENCE = BLOCKS.register("blackstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.BLACKSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> DEEPSLATE_FENCE = BLOCKS.register("deepslate_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> NETHER_BRICK_FENCE = BLOCKS.register("nether_brick_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> SANDSTONE_FENCE = BLOCKS.register("sandstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> RED_SANDSTONE_FENCE = BLOCKS.register("red_sandstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> QUARTZ_FENCE = BLOCKS.register("quartz_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK)).noOcclusion()));
    // endregion

    // region LAYERS
    public static final RegistrySupplier<Block> MOSS_LAYER = BLOCKS.register("moss_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.MOSS_BLOCK))));
    public static final RegistrySupplier<Block> STONE_LAYER = BLOCKS.register("stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.STONE))));
    public static final RegistrySupplier<Block> COBBLESTONE_LAYER = BLOCKS.register("cobblestone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.COBBLESTONE))));
    public static final RegistrySupplier<Block> MOSSY_COBBLESTONE_LAYER = BLOCKS.register("mossy_cobblestone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.MOSSY_COBBLESTONE))));
    public static final RegistrySupplier<Block> SMOOTH_STONE_LAYER = BLOCKS.register("smooth_stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.SMOOTH_STONE))));
    public static final RegistrySupplier<Block> POLISHED_STONE_LAYER = BLOCKS.register("polished_stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.SMOOTH_STONE))));
    public static final RegistrySupplier<Block> STONE_TILE_LAYER = BLOCKS.register("stone_tile_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.STONE_BRICKS))));
    public static final RegistrySupplier<Block> STONE_BRICK_LAYER = BLOCKS.register("stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.STONE_BRICKS))));
    public static final RegistrySupplier<Block> MOSSY_STONE_BRICK_LAYER = BLOCKS.register("mossy_stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.MOSSY_STONE_BRICKS))));
    public static final RegistrySupplier<Block> GRANITE_LAYER = BLOCKS.register("granite_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.GRANITE))));
    public static final RegistrySupplier<Block> POLISHED_GRANITE_LAYER = BLOCKS.register("polished_granite_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.POLISHED_GRANITE))));
    public static final RegistrySupplier<Block> DIORITE_LAYER = BLOCKS.register("diorite_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.DIORITE))));
    public static final RegistrySupplier<Block> POLISHED_DIORITE_LAYER = BLOCKS.register("polished_diorite_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.POLISHED_DIORITE))));
    public static final RegistrySupplier<Block> ANDESITE_LAYER = BLOCKS.register("andesite_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.ANDESITE))));
    public static final RegistrySupplier<Block> POLISHED_ANDESITE_LAYER = BLOCKS.register("polished_andesite_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.POLISHED_ANDESITE))));
    public static final RegistrySupplier<Block> COBBLED_DEEPSLATE_LAYER = BLOCKS.register("cobbled_deepslate_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.COBBLED_DEEPSLATE))));
    public static final RegistrySupplier<Block> POLISHED_DEEPSLATE_LAYER = BLOCKS.register("polished_deepslate_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.POLISHED_DEEPSLATE))));
    public static final RegistrySupplier<Block> DEEPSLATE_BRICK_LAYER = BLOCKS.register("deepslate_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE_BRICKS))));
    public static final RegistrySupplier<Block> DEEPSLATE_TILE_LAYER = BLOCKS.register("deepslate_tile_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE_TILES))));
    public static final RegistrySupplier<Block> BRICK_LAYER = BLOCKS.register("brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.BRICKS))));
    public static final RegistrySupplier<Block> MUD_BRICK_LAYER = BLOCKS.register("mud_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.MUD_BRICKS))));
    public static final RegistrySupplier<Block> SANDSTONE_LAYER = BLOCKS.register("sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.SANDSTONE))));
    public static final RegistrySupplier<Block> SMOOTH_SANDSTONE_LAYER = BLOCKS.register("smooth_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.SMOOTH_SANDSTONE))));
    public static final RegistrySupplier<Block> RED_SANDSTONE_LAYER = BLOCKS.register("red_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE))));
    public static final RegistrySupplier<Block> SMOOTH_RED_SANDSTONE_LAYER = BLOCKS.register("smooth_red_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.SMOOTH_RED_SANDSTONE))));
    public static final RegistrySupplier<Block> PRISMARINE_LAYER = BLOCKS.register("prismarine_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.PRISMARINE))));
    public static final RegistrySupplier<Block> PRISMARINE_BRICK_LAYER = BLOCKS.register("prismarine_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.PRISMARINE_BRICKS))));
    public static final RegistrySupplier<Block> DARK_PRISMARINE_LAYER = BLOCKS.register("dark_prismarine_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.DARK_PRISMARINE))));
    public static final RegistrySupplier<Block> NETHER_BRICK_LAYER = BLOCKS.register("nether_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS))));
    public static final RegistrySupplier<Block> RED_NETHER_BRICK_LAYER = BLOCKS.register("red_nether_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.RED_NETHER_BRICKS))));
    public static final RegistrySupplier<Block> BLACKSTONE_LAYER = BLOCKS.register("blackstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.BLACKSTONE))));
    public static final RegistrySupplier<Block> POLISHED_BLACKSTONE_LAYER = BLOCKS.register("polished_blackstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.POLISHED_BLACKSTONE))));
    public static final RegistrySupplier<Block> POLISHED_BLACKSTONE_BRICK_LAYER = BLOCKS.register("polished_blackstone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.POLISHED_BLACKSTONE_BRICKS))));
    public static final RegistrySupplier<Block> END_STONE_BRICK_LAYER = BLOCKS.register("end_stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.END_STONE_BRICKS))));
    public static final RegistrySupplier<Block> PURPUR_LAYER = BLOCKS.register("purpur_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.PURPUR_BLOCK))));
    public static final RegistrySupplier<Block> QUARTZ_LAYER = BLOCKS.register("quartz_layer", () -> new LayerBlock(BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK))));
    public static final RegistrySupplier<Block> CUT_COPPER_LAYER = BLOCKS.register("cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy((Blocks.CUT_COPPER))));
    public static final RegistrySupplier<Block> EXPOSED_CUT_COPPER_LAYER = BLOCKS.register("exposed_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatherState.EXPOSED, BlockBehaviour.Properties.copy((Blocks.EXPOSED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WEATHERED_CUT_COPPER_LAYER = BLOCKS.register("weathered_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatherState.WEATHERED, BlockBehaviour.Properties.copy((Blocks.WEATHERED_CUT_COPPER))));
    public static final RegistrySupplier<Block> OXIDIZED_CUT_COPPER_LAYER = BLOCKS.register("oxidized_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatherState.OXIDIZED, BlockBehaviour.Properties.copy((Blocks.OXIDIZED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WAXED_CUT_COPPER_LAYER = BLOCKS.register("waxed_cut_copper_layer", () -> new WaxedCopperLayerBlock(BlockBehaviour.Properties.copy((Blocks.WAXED_CUT_COPPER)), CUT_COPPER_LAYER));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_CUT_COPPER_LAYER = BLOCKS.register("waxed_exposed_cut_copper_layer", () -> new WaxedCopperLayerBlock(BlockBehaviour.Properties.copy((Blocks.WAXED_EXPOSED_CUT_COPPER)), EXPOSED_CUT_COPPER_LAYER));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_CUT_COPPER_LAYER = BLOCKS.register("waxed_weathered_cut_copper_layer", () -> new WaxedCopperLayerBlock(BlockBehaviour.Properties.copy((Blocks.WAXED_WEATHERED_CUT_COPPER)), WEATHERED_CUT_COPPER_LAYER));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_CUT_COPPER_LAYER = BLOCKS.register("waxed_oxidized_cut_copper_layer", () -> new WaxedCopperLayerBlock(BlockBehaviour.Properties.copy((Blocks.WAXED_OXIDIZED_CUT_COPPER)), OXIDIZED_CUT_COPPER_LAYER));
    // endregion

    // region FRAMES
    public static final RegistrySupplier<Block> STONE_FRAME = BLOCKS.register("stone_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.STONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BLACKSTONE_FRAME = BLOCKS.register("blackstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.BLACKSTONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> DEEPSLATE_FRAME = BLOCKS.register("deepslate_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE_BRICKS)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> NETHER_BRICK_FRAME = BLOCKS.register("nether_brick_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.NETHER_BRICKS)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> SANDSTONE_FRAME = BLOCKS.register("sandstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.SANDSTONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> RED_SANDSTONE_FRAME = BLOCKS.register("red_sandstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.RED_SANDSTONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> QUARTZ_FRAME = BLOCKS.register("quartz_frame", () -> new FrameBlock(BlockBehaviour.Properties.copy((Blocks.QUARTZ_BLOCK)).noOcclusion().noCollission().pushReaction(DESTROY)));
    // endregion

    public static final RegistrySupplier<Block> POLISHED_STONE = BLOCKS.register("polished_stone", () -> new TwoFacingConnectingBlock(BlockBehaviour.Properties.copy((Blocks.SMOOTH_STONE))));
    public static final RegistrySupplier<Block> POLISHED_STONE_STAIRS = BLOCKS.register("polished_stone_stairs", () -> new StairBlock((Blocks.SMOOTH_STONE.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistrySupplier<Block> POLISHED_STONE_SLAB = BLOCKS.register("polished_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistrySupplier<Block> STONE_TILES = BLOCKS.register("stone_tiles", () -> new Block(BlockBehaviour.Properties.copy((Blocks.STONE_BRICKS))));
    public static final RegistrySupplier<Block> STONE_TILE_STAIRS = BLOCKS.register("stone_tile_stairs", () -> new StairBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistrySupplier<Block> STONE_TILE_SLAB = BLOCKS.register("stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    private static ToIntFunction<BlockState> litLevel(int lit) {
        return s -> s.getValue(BrazierBlock.LIT) ? lit : 0;
    }

    public static final RegistrySupplier<Block> BRAZIER = BLOCKS.register("brazier", () -> new BrazierBlock(BlockBehaviour.Properties.copy((Blocks.IRON_BLOCK)).lightLevel(litLevel(15)).noOcclusion().pushReaction(DESTROY).strength(1.0F, 1.5F)));
    public static final RegistrySupplier<Block> SOUL_BRAZIER = BLOCKS.register("soul_brazier", () -> new BrazierBlock(BlockBehaviour.Properties.copy((Blocks.IRON_BLOCK)).lightLevel(litLevel(10)).noOcclusion().pushReaction(DESTROY).strength(1.0F, 1.5F)));

    public static final RegistrySupplier<Block> ROPE = BLOCKS.register("rope", () -> new ChainBlock(BlockBehaviour.Properties.copy((Blocks.OAK_PLANKS)).forceSolidOn().strength(0.1F).sound(SoundType.WOOL).noOcclusion()));

    public static final RegistrySupplier<Block> IRON_FENCE = BLOCKS.register("iron_fence", () -> new IronFenceBlock(BlockBehaviour.Properties.copy((Blocks.IRON_BARS)).noOcclusion()));

    //public static final Block TALL_OAK_DOOR = BLOCKS.register("tall_oak_door", () -> new TallDoorBlock(BlockBehaviour.Properties.copy((Blocks.OAK_PLANKS)).noOcclusion(), BlockSetType.OAK));

    // public static final Block COPPER_GATEWAY = BLOCKS.register("copper_gateway", () -> new GatewayBlock(BlockBehaviour.Properties.copy((Blocks.OAK_DOOR)).noOcclusion()));

}
