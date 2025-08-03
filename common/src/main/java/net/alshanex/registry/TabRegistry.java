package net.alshanex.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alshanex.ForbiddenWeaponryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ForbiddenWeaponryMod.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> FORBIDDEN_WEAPONRY_TAB = TABS.register(
            "forbidden_weaponry_tab",
            () -> CreativeTabRegistry.create(
                    Component.translatable("category.forbidden_weaponry"),
                    () -> new ItemStack(ItemRegistry.SHADOW_EDGE.get())
            )
    );
    public static void init() {
        TABS.register();
    }
}
