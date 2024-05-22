package com.starfish_studios.bbb.datagen;

import com.starfish_studios.bbb.registry.BBBBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import org.intellij.lang.annotations.Identifier;

import java.util.function.Consumer;

public class BBBRecipeProvider extends FabricRecipeProvider {
    public BBBRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        smeltingResultFromBase(exporter, Blocks.SMOOTH_STONE, BBBBlocks.POLISHED_STONE);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BBBBlocks.STONE_TILES, 4)
            .pattern("##")
            .pattern("##")
            .define('#', Blocks.STONE_BRICKS)
            .unlockedBy("has_stone", has(Blocks.STONE))
            .save(exporter);

    }


}
