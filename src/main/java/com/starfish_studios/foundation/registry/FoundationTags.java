package com.starfish_studios.foundation.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.starfish_studios.foundation.Foundation.MOD_ID;

public interface FoundationTags {

    // region BLOCK TAGS
    public interface FoundationBlockTags {
        TagKey<Block> METAL_FENCES = TagKey.create(Registries.BLOCK, new ResourceLocation(MOD_ID, "metal_fences"));
        TagKey<Block> STONE_BALUSTRADES = TagKey.create(Registries.BLOCK, new ResourceLocation(MOD_ID, "stone_balustrades"));

        TagKey<Block> STONE_FENCES = TagKey.create(Registries.BLOCK, new ResourceLocation(MOD_ID, "stone_fences"));
        TagKey<Block> FRAMES = TagKey.create(Registries.BLOCK, new ResourceLocation(MOD_ID, "frames"));
        TagKey<Block> PALLETS = TagKey.create(Registries.BLOCK, new ResourceLocation(MOD_ID, "pallets"));
    }
    // endregion

    // region ITEM TAGS
    public interface FoundationItemTags {
        TagKey<Item> FRAMES = TagKey.create(Registries.ITEM, new ResourceLocation(MOD_ID, "frames"));
        TagKey<Item> PALLETS = TagKey.create(Registries.ITEM, new ResourceLocation(MOD_ID, "pallets"));
    }

}
