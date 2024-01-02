package com.starfish_studios.foundation.item;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DebugStickItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class WrenchItem extends DebugStickItem {
    public WrenchItem(Properties properties) {
        super(properties);
    }



    @Override
    public boolean isFoil(ItemStack itemStack) {
        return false;
    }

    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        Level level = useOnContext.getLevel();
        if (!level.isClientSide && player != null) {
            BlockPos blockPos = useOnContext.getClickedPos();
            if (!this.handleInteraction(player, level.getBlockState(blockPos), level, blockPos, true, useOnContext.getItemInHand())) {
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }



    private boolean handleInteraction(Player player, BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos, boolean bl, ItemStack itemStack) {
        Block block = blockState.getBlock();
        StateDefinition<Block, BlockState> stateDefinition = block.getStateDefinition();
        Collection<Property<?>> collection = stateDefinition.getProperties();
        String string = BuiltInRegistries.BLOCK.getKey(block).toString();
        CompoundTag compoundTag = itemStack.getOrCreateTagElement("DebugProperty");
        String string2 = compoundTag.getString(string);
        Property<?> property = stateDefinition.getProperty(string2);


        assert property != null;
        if (property.getName().equals("waterlogged")) {
            return false;
        }
        if (collection.isEmpty()) {
            message(player, Component.translatable(this.getDescriptionId() + ".empty", string));
            return false;
        } else {

            if (bl) {
                if (property == null) {
                    property = collection.iterator().next();
                }
            BlockState blockState2 = cycleState(blockState, property, player.isSecondaryUseActive());
            levelAccessor.setBlock(blockPos, blockState2, 18);
            } else {
                property = getRelative(collection, property, player.isSecondaryUseActive());
                String string3 = property.getName();
                compoundTag.putString(string, string3);
                message(player, Component.translatable(this.getDescriptionId() + ".select", string3, getNameHelper(blockState, property)));
            }

            return true;
        }
    }

    private static <T extends Comparable<T>> BlockState cycleState(BlockState blockState, Property<T> property, boolean bl) {
        return blockState.setValue(property, getRelative(property.getPossibleValues(), blockState.getValue(property), bl));

    }

    private static <T> T getRelative(Iterable<T> iterable, @Nullable T object, boolean bl) {
        return bl ? Util.findPreviousInIterable(iterable, object) : Util.findNextInIterable(iterable, object);
    }

    private static void message(Player player, Component component) {
        ((ServerPlayer) player).sendSystemMessage(component, true);
    }

    private static <T extends Comparable<T>> String getNameHelper(BlockState blockState, Property<T> property) {
        return property.getName(blockState.getValue(property));
    }
}