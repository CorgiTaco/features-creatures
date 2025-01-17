package net.msrandom.featuresandcreatures.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.msrandom.featuresandcreatures.FeaturesAndCreatures;
import net.msrandom.featuresandcreatures.common.entity.BlackForestSpirit;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class BFSEyeLayer extends GeoLayerRenderer<BlackForestSpirit> {
    private static final ResourceLocation LAYER = new ResourceLocation(FeaturesAndCreatures.MOD_ID, "textures/entity/spirit/black_forest_spirit_glow.png");
    private static final ResourceLocation MODEL = new ResourceLocation(FeaturesAndCreatures.MOD_ID, "geo/black_forest_spirit.geo.json");

    public BFSEyeLayer(IGeoRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, BlackForestSpirit entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer vertexConsumer = bufferIn.getBuffer(RenderType.eyes(LAYER));
        this.getRenderer().renderEarly(entityLivingBaseIn, matrixStackIn, 15728640, bufferIn, vertexConsumer, OverlayTexture.NO_OVERLAY, packedLightIn, 1f, 1f, 1f, 0f);
    }

    @Override
    public RenderType getRenderType(ResourceLocation textureLocation) {
        return RenderType.eyes(LAYER);
    }
}