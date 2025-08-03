package net.alshanex.fabric;

import net.fabricmc.api.ModInitializer;

import net.alshanex.ForbiddenWeaponryMod;

public final class ForbiddenWeaponryModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ForbiddenWeaponryMod.init();
        ForbiddenWeaponryMod.initAzIdentityRegistry();
    }
}
