package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.item.HammerItem;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
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
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (!blockState.getValue(BlockStateProperties.HANGING)) {
                level.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.HANGING, true));
                level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            } else if (blockState.getValue(BlockStateProperties.HANGING)) {
                level.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.HANGING, false));
                level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);

                if (!level.getBlockState(blockPos.below()).isSolid()) {

                    level.destroyBlock(blockPos, true);
                }

            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
