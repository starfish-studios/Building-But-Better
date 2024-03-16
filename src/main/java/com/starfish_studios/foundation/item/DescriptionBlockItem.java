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

        if (stack.is(FoundationTags.FoundationItemTags.STONE_FENCES)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.stone_fence1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.stone_fence2").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.stone_fence3").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.stone_fence4").withStyle(ChatFormatting.GRAY));
            } else tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        if (stack.is(FoundationTags.FoundationItemTags.MOULDINGS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.moulding1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.moulding2").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        if (stack.is(FoundationTags.FoundationItemTags.SUPPORTS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.support1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.support2").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        else if (stack.is(FoundationTags.FoundationItemTags.PALLETS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.pallet1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.pallet2").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.pallet3").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.pallet4").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pallet5").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        else if (stack.is(FoundationTags.FoundationItemTags.LADDERS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.ladder1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.ladder2").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        else if (stack.is(FoundationTags.FoundationItemTags.COLUMNS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.column1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.column2").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        else if (stack.is(FoundationTags.FoundationItemTags.LAYERS)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.layer1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.layer2").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.layer3").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.layer4").withStyle(ChatFormatting.GRAY)));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        else if (stack.is(FoundationTags.FoundationItemTags.FRAMES)) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.frame1").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.frame2").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.frame3").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.foundation.frame4").withStyle(ChatFormatting.GRAY)));
                tooltip.add(Component.translatable("description.foundation.frame5").withStyle(ChatFormatting.GRAY));
            } else
                tooltip.add(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY).append(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC)).append(Component.literal("]").withStyle(ChatFormatting.DARK_GRAY)));
        }

        else {
            super.appendHoverText(stack, level, tooltip, flagIn);
        }
    }
}
