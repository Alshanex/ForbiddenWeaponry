package net.alshanex.neoforge;

import net.alshanex.ForbiddenWeaponryMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ForbiddenWeaponryMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ForbiddenWeaponryModNeoForgeClient {
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ForbiddenWeaponryMod.initClient();
    }
}
