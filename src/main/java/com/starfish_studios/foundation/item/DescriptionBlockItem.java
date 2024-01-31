package com.starfish_studios.foundation.item;

import com.starfish_studios.foundation.Foundation;
import com.starfish_studios.foundation.block.PalletBlock;
import com.starfish_studios.foundation.registry.FoundationItems;
import com.starfish_studios.foundation.registry.FoundationTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class DescriptionBlockItem extends BlockItem {
    public DescriptionBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {
        /*if (stack.is(FoundationTags.FoundationItemTags.FRAMES)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.frame1").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.frame2").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }
        else*/ if (stack.is(FoundationTags.FoundationItemTags.PALLETS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.pallet1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.pallet2").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.pallet3").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.pallet4").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pallet5").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }
    }
}
