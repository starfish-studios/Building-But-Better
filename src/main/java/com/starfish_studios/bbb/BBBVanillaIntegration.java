package com.starfish_studios.bbb;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.starfish_studios.bbb.registry.BBBBlocks;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class BBBVanillaIntegration {
    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
            .put(BBBBlocks.CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_EXPOSED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_WEATHERED_CUT_COPPER_LAYER.get())
            .put(BBBBlocks.OXIDIZED_CUT_COPPER_LAYER.get(), BBBBlocks.WAXED_OXIDIZED_CUT_COPPER_LAYER.get())
            .build());

    public static void init() {
        ImmutableBiMap.Builder<Block, Block> biMap = ImmutableBiMap.<Block, Block>builder().putAll(HoneycombItem.WAXABLES.get());
        biMap.putAll(WAXABLES.get());
        HoneycombItem.WAXABLES = Suppliers.memoize(biMap::build);
    }

}
