package com.starfish_studios.foundation.client.renderer.blockentity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.starfish_studios.foundation.block.BlockBlock;
import com.starfish_studios.foundation.block.WallBlockBlock;
import com.starfish_studios.foundation.block.entity.BlockBlockEntity;
import com.starfish_studios.foundation.client.model.BlockModel;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class BlockBlockRenderer implements BlockEntityRenderer<BlockBlockEntity> {
    private final ImmutableMap<BlockBlock.Types, BlockModel> modelByType;
    private static final Map<BlockBlock.Type, ResourceLocation> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(BlockBlock.Types.STONE, new ResourceLocation("foundation:textures/block/block/stone.png"));
        hashMap.put(BlockBlock.Types.BLACKSTONE, new ResourceLocation("foundation:textures/block/block/blackstone.png"));
        hashMap.put(BlockBlock.Types.DEEPSLATE, new ResourceLocation("foundation:textures/block/block/deepslate.png"));
        hashMap.put(BlockBlock.Types.NETHER_BRICK, new ResourceLocation("foundation:textures/block/block/nether_brick.png"));
        hashMap.put(BlockBlock.Types.SANDSTONE, new ResourceLocation("foundation:textures/block/block/sandstone.png"));
        hashMap.put(BlockBlock.Types.RED_SANDSTONE, new ResourceLocation("foundation:textures/block/block/red_sandstone.png"));
        hashMap.put(BlockBlock.Types.QUARTZ, new ResourceLocation("foundation:textures/block/block/quartz.png"));
    });

    public static ImmutableMap<BlockBlock.Types, BlockModel> createBlockRenderers(EntityModelSet entityModelSet) {
        ImmutableMap.Builder<BlockBlock.Types, BlockModel> builder = ImmutableMap.builder();
        builder.put(BlockBlock.Types.STONE, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        builder.put(BlockBlock.Types.BLACKSTONE, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        builder.put(BlockBlock.Types.DEEPSLATE, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        builder.put(BlockBlock.Types.NETHER_BRICK, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        builder.put(BlockBlock.Types.SANDSTONE, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        builder.put(BlockBlock.Types.RED_SANDSTONE, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        builder.put(BlockBlock.Types.QUARTZ, new BlockModel(entityModelSet.bakeLayer(ModelLayers.CREEPER_HEAD)));
        return builder.build();
    }

    public BlockBlockRenderer() {
        this.modelByType = BlockBlockRenderer.createBlockRenderers(Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void render(BlockBlockEntity blockBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        float g = blockBlockEntity.getAnimation(f);
        BlockState blockState = blockBlockEntity.getBlockState();
        boolean bl = blockState.getBlock() instanceof WallBlockBlock;
        Direction direction = bl ? blockState.getValue(WallBlockBlock.FACING) : null;
        int k = bl ? RotationSegment.convertToSegment(direction.getOpposite()) : blockState.getValue(BlockBlock.ROTATION);
        float h = RotationSegment.convertToDegrees(k);
        BlockBlock.Type type = ((BlockBlock)blockState.getBlock()).getType();
        RenderType renderType = RenderType.entityCutout(this.getTextureLocation(blockBlockEntity));
        BlockBlockRenderer.renderBlock(direction, h, g, poseStack, multiBufferSource, i, this.modelByType.get(type), renderType);
    }

    private ResourceLocation getTextureLocation(BlockBlockEntity blockBlockEntity) {
        return TEXTURE_BY_TYPE.get(((BlockBlock)blockBlockEntity.getBlockState().getBlock()).getType());
    }

    public static void renderBlock(@Nullable Direction direction, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, BlockModel blockModel, RenderType renderType) {
        poseStack.pushPose();
        if (direction == null) {
            poseStack.translate(0.5f, 0.0f, 0.5f);
        } else {
            poseStack.translate(0.5f - (float)direction.getStepX() * 0.25f, 0.25f, 0.5f - (float)direction.getStepZ() * 0.25f);
        }
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
        blockModel.setupAnim(g, f, 0.0f);
        blockModel.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
    }

}