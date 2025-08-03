package net.alshanex.fabric.client;

import net.alshanex.ForbiddenWeaponryMod;
import net.fabricmc.api.ClientModInitializer;

public final class ForbiddenWeaponryModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        ForbiddenWeaponryMod.initClient();
    }
}
