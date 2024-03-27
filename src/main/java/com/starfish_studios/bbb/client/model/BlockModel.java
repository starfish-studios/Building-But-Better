/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package com.starfish_studios.bbb.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@Environment(value=EnvType.CLIENT)
public class BlockModel extends SkullModelBase {
    private final ModelPart root;

    public BlockModel(ModelPart modelPart) {
        this.root = modelPart;
    }

    public static LayerDefinition createBlockModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild(
                "root",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-12.0F, -8.0F, 4.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offset(8.0F, 24.0F, -8.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(float f, float g, float h) {
        this.root.yRot = g * ((float)Math.PI / 180);
        this.root.xRot = h * ((float)Math.PI / 180);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, float f, float g, float h, float k) {
        this.root.render(poseStack, vertexConsumer, i, j, f, g, h, k);
    }
}

