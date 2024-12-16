package com.starfish_studios.building_but_better.item;

import com.starfish_studios.building_but_better.BBBConfig;
import com.starfish_studios.building_but_better.registry.ModItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class DescriptionBlockItem extends BlockItem {
    public DescriptionBlockItem(Block block, Properties properties) {
        super(block, properties);
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        if (!BBBConfig.disableShiftTooltips) {

            if (stack.is(ModItemTags.BALUSTRADES)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.balustrade1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.balustrade2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.balustrade3").withStyle(ChatFormatting.GRAY));

                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.balustrade4").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.balustrade5").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }

            if (stack.is(ModItemTags.URNS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.urn1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.urn2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.urn3").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.urn4").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }

            if (stack.is(ModItemTags.LATTICES)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.lattice1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.lattice2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.lattice3").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.lattice4").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }


            if (stack.is(ModItemTags.LANTERNS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE)
                            .append(Component.translatable("description.bbb.lantern1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.lantern2").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }

            if (stack.is(ModItemTags.STONE_FENCES)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.stone_fence1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.stone_fence2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.stone_fence3").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.stone_fence4").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }

            if (stack.is(ModItemTags.MOULDINGS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.moulding1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.moulding2").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }

            if (stack.is(ModItemTags.SUPPORTS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.support1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.support2").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            } else if (stack.is(ModItemTags.PALLETS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.pallet1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.pallet2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.pallet3").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.pallet4").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pallet5").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            } else if (stack.is(ModItemTags.LADDERS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.ladder1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.ladder2").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            } else if (stack.is(ModItemTags.COLUMNS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.column1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.column2").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            } else if (stack.is(ModItemTags.LAYERS)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.layer1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.layer2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.layer3").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.layer4").withStyle(ChatFormatting.GRAY));
                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            } else if (stack.is(ModItemTags.FRAMES) || stack.is(ModItemTags.STONE_FRAMES)) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.frame1").withStyle(ChatFormatting.GRAY)));
                    tooltip.add(Component.translatable("description.bbb.frame2").withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("description.bbb.pencil").withStyle(ChatFormatting.BLUE).append(Component.translatable("description.bbb.frame3").withStyle(ChatFormatting.GRAY)));

                    if (!BBBConfig.disableFrameCrouchHitbox) {
                        if (!BBBConfig.alwaysShowFrameHitboxes) {
                            tooltip.add(Component.literal("\uE000 ").append(Component.translatable("description.bbb.frameConfig1").withStyle(ChatFormatting.GRAY)));
                            tooltip.add(Component.translatable("description.bbb.frameConfig2").withStyle(ChatFormatting.GRAY));
                        } else {
                            tooltip.add(Component.literal("\uE000 ").append(Component.translatable("description.bbb.frameConfig3").withStyle(ChatFormatting.GRAY)));
                        }
                    } else {
                        tooltip.add(Component.literal("\uE000 ").append(Component.translatable("description.bbb.frameConfig4").withStyle(ChatFormatting.GRAY)));
                        tooltip.add(Component.translatable("description.bbb.frameConfig5").withStyle(ChatFormatting.GRAY));
                    }


                } else
                    tooltip.add(Component.literal("[").append(Component.translatable("key.keyboard.left.shift")).append(Component.literal("]")).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            } else {
                super.appendHoverText(stack, context, tooltip, flagIn);
            }
        }
    }
}
