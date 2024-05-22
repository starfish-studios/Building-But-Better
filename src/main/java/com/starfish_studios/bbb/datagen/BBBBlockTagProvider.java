package com.starfish_studios.bbb.datagen;

import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BBBBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BBBBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BBBTags.BBBBlockTags.FRAMES)
            .add(BBBBlocks.OAK_FRAME)
        ;

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(BBBBlocks.STONE_BLOCK)
        ;
    }
}
