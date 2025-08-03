package net.alshanex.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.alshanex.ForbiddenWeaponryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForbiddenWeaponryMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> SHADOW_EDGE = ITEMS.register("shadow_edge",
            () -> new AncientSageBow(new Item.Properties().durability(500).arch$tab(TabRegistry.FORBIDDEN_WEAPONRY_TAB).rarity(Rarity.EPIC)));
}
