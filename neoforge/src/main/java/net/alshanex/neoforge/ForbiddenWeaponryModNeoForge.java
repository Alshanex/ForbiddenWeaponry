package net.alshanex.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import net.alshanex.ForbiddenWeaponryMod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ForbiddenWeaponryMod.MOD_ID)
public final class ForbiddenWeaponryModNeoForge {
    public ForbiddenWeaponryModNeoForge(IEventBus modEventBus) {
        // Run our common setup.
        ForbiddenWeaponryMod.init();
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ForbiddenWeaponryMod.initAzIdentityRegistry();
    }
}
