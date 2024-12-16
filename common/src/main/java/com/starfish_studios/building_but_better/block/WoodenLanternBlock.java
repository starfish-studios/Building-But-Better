package com.starfish_studios.building_but_better.block;

import com.starfish_studios.building_but_better.registry.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodenLanternBlock extends LanternBlock {

    protected static final VoxelShape
            AABB = Shapes.or(Block.box(3, 0, 3, 13, 2, 13),
            Block.box(4, 2, 4, 12, 11, 12),
            Block.box(3, 11, 3, 13, 13, 13));
    protected static final VoxelShape
            HANGING_AABB = Shapes.or(Block.box(3, 0, 3, 13, 2, 13),
            Block.box(4, 2, 4, 12, 11, 12),
            Block.box(3, 11, 3, 13, 13, 13),
            Block.box(6, 13, 6, 10, 16, 10));

    public WoodenLanternBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(BlockStateProperties.HANGING)) {
            return HANGING_AABB;
        }
        return AABB;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(ModItemTags.HAMMERS)) return ItemInteractionResult.FAIL;

        if (!state.getValue(BlockStateProperties.HANGING)) {
            level.setBlockAndUpdate(pos, state.setValue(BlockStateProperties.HANGING, true));
            level.playSound(player, pos, state.getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
        } else if (state.getValue(BlockStateProperties.HANGING)) {
            level.setBlockAndUpdate(pos, state.setValue(BlockStateProperties.HANGING, false));
            level.playSound(player, pos, state.getSoundType().getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);

            if (!level.getBlockState(pos.below()).isSolid()) {

                level.destroyBlock(pos, true);
            }

        }
        return ItemInteractionResult.SUCCESS;
    }
}
