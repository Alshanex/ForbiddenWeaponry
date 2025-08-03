package net.alshanex;

import mod.azure.azurelib.rewrite.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.rewrite.render.item.AzItemRendererRegistry;
import net.alshanex.client.ShadowEdgeItemRenderer;
import net.alshanex.registry.DataComponentRegistry;
import net.alshanex.registry.ItemRegistry;
import net.alshanex.registry.TabRegistry;

public final class ForbiddenWeaponryMod {
    public static final String MOD_ID = "forbidden_weaponry";

    public static void init() {
        // Write common init code here.
        ItemRegistry.init();
        TabRegistry.init();
        DataComponentRegistry.init();
    }

    public static void initClient() {
        AzItemRendererRegistry.register(ItemRegistry.SHADOW_EDGE.get(), ShadowEdgeItemRenderer::new);
    }

    public static void initAzIdentityRegistry() {
        AzIdentityRegistry.register(ItemRegistry.SHADOW_EDGE.get());
    }
}
