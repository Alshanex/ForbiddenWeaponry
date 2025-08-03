package net.alshanex.item;

import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class ShadowEdgeDispatcher {

    private static final AzCommand ACTIVATION_COMMAND = AzCommand.create(
            "base_controller",
            "activation",
            AzPlayBehaviors.HOLD_ON_LAST_FRAME);

    private static final AzCommand ACTIVE_COMMAND = AzCommand.create(
            "base_controller",
            "active",
            AzPlayBehaviors.LOOP);

    private static final AzCommand DEACTIVATION_COMMAND = AzCommand.create(
            "base_controller",
            "deactivation",
            AzPlayBehaviors.HOLD_ON_LAST_FRAME);

    private static final AzCommand INACTIVE_COMMAND = AzCommand.create(
            "base_controller",
            "inactive",
            AzPlayBehaviors.LOOP);

    public void activation(Entity entity, ItemStack itemStack) {
        ACTIVATION_COMMAND.sendForItem(entity, itemStack);
    }

    public void active(Entity entity, ItemStack itemStack) {
        ACTIVE_COMMAND.sendForItem(entity, itemStack);
    }

    public void deactivation(Entity entity, ItemStack itemStack) {
        DEACTIVATION_COMMAND.sendForItem(entity, itemStack);
    }

    public void inactive(Entity entity, ItemStack itemStack) {
        INACTIVE_COMMAND.sendForItem(entity, itemStack);
    }
}
