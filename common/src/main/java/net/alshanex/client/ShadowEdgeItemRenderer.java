package net.alshanex.client;

import mod.azure.azurelib.rewrite.render.item.AzItemRenderer;
import mod.azure.azurelib.rewrite.render.item.AzItemRendererConfig;
import net.alshanex.ForbiddenWeaponryMod;
import net.minecraft.resources.ResourceLocation;

public class ShadowEdgeItemRenderer extends AzItemRenderer {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            ForbiddenWeaponryMod.MOD_ID,
            "geo/item/shadow_edge.geo.json"
    );

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(
            ForbiddenWeaponryMod.MOD_ID,
            "textures/item/shadow_edge.png"
    );

    public ShadowEdgeItemRenderer() {
        super(
                AzItemRendererConfig.builder(MODEL, TEXTURE)
                        .setAnimatorProvider(ShadowEdgeItemAnimator::new)
                        .build()
        );
    }
}
