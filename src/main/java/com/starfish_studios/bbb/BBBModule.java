package com.starfish_studios.bbb;

import com.starfish_studios.bbb.block.*;
import com.starfish_studios.bbb.item.DescriptionBlockItem;
import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBItems;
import io.github.fabricators_of_create.porting_lib.common.util.PlantType;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.mehvahdjukaar.every_compat.api.*;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.mehvahdjukaar.moonlight.api.set.leaves.LeavesType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

public class BBBModule extends SimpleModule {

    // Trim, Beam, Beam Stairs, Beam Slab, Pallets, Supports, Balustrades, Walls, Frames, Lanterns, Ladders, Lattices
    
    public final SimpleEntrySet<WoodType, Block> trims;
    public final SimpleEntrySet<WoodType, Block> beams;
    public final SimpleEntrySet<WoodType, Block> beamStairs;
    public final SimpleEntrySet<WoodType, Block> beamSlabs;
    public final SimpleEntrySet<WoodType, Block> pallets;
    public final SimpleEntrySet<WoodType, Block> supports;
    public final SimpleEntrySet<WoodType, Block> balustrades;
    public final SimpleEntrySet<WoodType, Block> walls;
    public final SimpleEntrySet<WoodType, Block> frames;
    public final SimpleEntrySet<WoodType, Block> lanterns;
//    public final SimpleEntrySet<WoodType, Block> ladders;
    public final SimpleEntrySet<WoodType, Block> lattices;

    public static void init(String modId) {
        new BBBModule(MOD_ID);
    }

    @Override
    public void registerBlockColors(ClientHelper.BlockColorEvent event) {
        super.registerBlockColors(event);
        ColorProviderRegistry<Block, BlockColor> blockColor = ColorProviderRegistry.BLOCK;
//        blockColor.register((state, world, pos, tintIndex) -> {
//                    if (world == null || pos == null) {
//                        return FoliageColor.getDefaultColor();
//                    }
//                    return BiomeColors.getAverageFoliageColor(world, pos);
//                }
//        );
        for (Map.Entry<WoodType, Block> entry : lattices.blocks.entrySet()) {
            blockColor.register((state, world, pos, tintIndex) -> {
                        if (world == null || pos == null) {
                            return FoliageColor.getDefaultColor();
                        }
                        return BiomeColors.getAverageFoliageColor(world, pos);
                    }, entry.getValue());
        }
    }

    public BBBModule(String modId) {
        super(modId, "bbb");

        SimpleModule bbb = new SimpleModule("bbb", "bbb");



        trims = SimpleEntrySet.builder(WoodType.class, "trim",
                        getModBlock("oak_trim"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FacingConnectingBlock(Utils.copyPropertySafe(BBBBlocks.OAK_TRIM)))
                .addTag(modRes("trims"), Registries.BLOCK)
                .addTag(modRes("trims"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/trim/oak_bottom"))
                .addTexture(modRes("block/trim/oak_middle"))
                .addTexture(modRes("block/trim/oak_none"))
                .addTexture(modRes("block/trim/oak_top"))
                .addTexture(modRes("block/trim/oak_top_face"))
                .build();
        
        this.addEntry(trims);
        
        beams = SimpleEntrySet.builder(WoodType.class, "beam",
                        getModBlock("oak_beam"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new RotatedPillarBlock(Utils.copyPropertySafe(BBBBlocks.OAK_BEAM)))
                .addTag(modRes("beams"), Registries.BLOCK)
                .addTag(modRes("beams"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();
        
        this.addEntry(beams);
        
        beamStairs = SimpleEntrySet.builder(WoodType.class, "beam_stairs",
                        getModBlock("oak_beam_stairs"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new StairBlock((Blocks.OAK_PLANKS.defaultBlockState()), Utils.copyPropertySafe(BBBBlocks.OAK_BEAM_STAIRS)))
                .addTag(modRes("beams"), Registries.BLOCK)
                .addTag(modRes("beams"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();
        
        this.addEntry(beamStairs);
        
        beamSlabs = SimpleEntrySet.builder(WoodType.class, "beam_slab",
                        getModBlock("oak_beam_slab"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FacingSlabBlock(Utils.copyPropertySafe(BBBBlocks.OAK_BEAM_SLAB)))
                .addTag(modRes("beams"), Registries.BLOCK)
                .addTag(modRes("beams"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();
        
        this.addEntry(beamSlabs);
        
        pallets = SimpleEntrySet.builder(WoodType.class, "pallet",
                        getModBlock("oak_pallet"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new PalletBlock(Utils.copyPropertySafe(BBBBlocks.OAK_PALLET)))
                .addTag(modRes("pallets"), Registries.BLOCK)
                .addTag(modRes("pallets"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/pallet/oak_pallet"))
                .build();
        
        this.addEntry(pallets);
        
        supports = SimpleEntrySet.builder(WoodType.class, "support",
                        getModBlock("oak_support"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new SupportBlock(Utils.copyPropertySafe(BBBBlocks.OAK_SUPPORT)))
                .addTag(modRes("supports"), Registries.BLOCK)
                .addTag(modRes("supports"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();

        this.addEntry(supports);

        balustrades = SimpleEntrySet.builder(WoodType.class, "balustrade",
                        getModBlock("oak_balustrade"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new BalustradeBlock(Utils.copyPropertySafe(BBBBlocks.OAK_BALUSTRADE)))
                .addTag(modRes("balustrades"), Registries.BLOCK)
                .addTag(modRes("balustrades"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/balustrade/oak_top"))
                .addTexture(modRes("block/balustrade/oak_sides"))
                .build();

        this.addEntry(balustrades);

        walls = SimpleEntrySet.builder(WoodType.class, "wall",
                        getModBlock("oak_wall"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new WoodenWallBlock(Utils.copyPropertySafe(BBBBlocks.OAK_WALL)))
                .addTag(modRes("wooden_walls"), Registries.BLOCK)
//                .addTag(modRes("wooden_walls"), Registries.ITEM)
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/beam/oak"))
                .addTexture(modRes("block/beam/oak_top"))
                .build();

        this.addEntry(walls);

        frames = SimpleEntrySet.builder(WoodType.class, "frame",
                        getModBlock("oak_frame"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FrameBlock(Utils.copyPropertySafe(BBBBlocks.OAK_FRAME)))
                .addTag(modRes("frames"), Registries.BLOCK)
                .addTag(modRes("frames"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/frame/oak"))
                .addTexture(modRes("block/frame/oak_sticks"))
                .build();

        this.addEntry(frames);

        lanterns = SimpleEntrySet.builder(WoodType.class, "lantern",
                        getModBlock("oak_lantern"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new WoodenLanternBlock(Utils.copyPropertySafe(BBBBlocks.OAK_LANTERN)))
                .addTag(modRes("lanterns"), Registries.BLOCK)
                .addTag(modRes("lanterns"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTextureM(modRes("block/lantern/oak"), modRes("block/lantern/lantern_mask"))
                .build();

        this.addEntry(lanterns);

//        ladders = SimpleEntrySet.builder(WoodType.class, "ladder",
//                        getModBlock("oak_ladder"), () -> WoodTypeRegistry.OAK_TYPE,
//                        w -> new BBBLadderBlock(1, Utils.copyPropertySafe(BBBBlocks.OAK_LADDER)))
//                .addTag(modRes("ladders"), Registries.BLOCK)
//                .addTag(modRes("ladders"), Registries.ITEM)
//                .copyParentDrop()
//                .defaultRecipe()
//                .setTab(getModTab(MOD_ID))
//                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
//                .setRenderType(() -> RenderType::cutout)
//                .useMergedPalette()
//                .addTexture(modRes("block/ladder/oak/oak"))
//                .addTexture(modRes("block/ladder/spruce/spruce"))
//                .addTexture(modRes("block/ladder/birch/birch"))
//                .addTexture(modRes("block/ladder/jungle/jungle"))
//                .addTexture(modRes("block/ladder/acacia/acacia"))
//                .addTexture(modRes("block/ladder/dark_oak/dark_oak"))
//                .addTexture(modRes("block/ladder/mangrove/mangrove"))
//                .addTexture(modRes("block/ladder/cherry/cherry"))
//                .build();
//
//        this.addEntry(ladders);

        lattices = SimpleEntrySet.builder(WoodType.class, "lattice",
                        getModBlock("oak_lattice"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new LatticeBlock(Utils.copyPropertySafe(BBBBlocks.OAK_LATTICE)))
                .addTag(modRes("lattices"), Registries.BLOCK)
                .addTag(modRes("lattices"), Registries.ITEM)
                .addCustomItem((wood, block, properties) -> new DescriptionBlockItem(block, properties))
                .copyParentDrop()
                .defaultRecipe()
                .setTab(getModTab(MOD_ID))
                .setTabMode(TabAddMode.AFTER_SAME_TYPE)
                .setRenderType(() -> RenderType::cutout)
                .useMergedPalette()
                .addTexture(modRes("block/lattice/oak"))
                .addTexture(ResourceLocation.tryParse("minecraft:block/oak_log"))
                .addTexture(ResourceLocation.tryParse("minecraft:block/oak_log_top"))
                .build();

        this.addEntry(lattices);


        EveryCompatAPI.registerModule(bbb);
    }
}
