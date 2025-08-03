package net.alshanex.item;

import net.alshanex.registry.DataComponentRegistry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ShadowEdge extends SwordItem {
    private final ShadowEdgeDispatcher dispatcher;

    public enum AnimationState {
        INACTIVE,
        ACTIVE
    }

    private static final Tier SHADOW_TIER = new Tier() {
        @Override
        public int getUses() {
            return 500;
        }

        @Override
        public float getSpeed() {
            return 8.0f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 11.0f;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return null;
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return null;
        }
    };

    public ShadowEdge(Properties properties) {
        super(SHADOW_TIER, properties);
        this.dispatcher = new ShadowEdgeDispatcher();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            boolean isInShadowMode = isInShadowMode(itemStack);

            if (!isInShadowMode) {
                setShadowMode(itemStack, true);
                setAnimationState(itemStack, AnimationState.ACTIVE);
                dispatcher.activation(player, itemStack);

                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0f, 1.2f);
            } else {
                setShadowMode(itemStack, false);
                setAnimationState(itemStack, AnimationState.INACTIVE);
                dispatcher.deactivation(player, itemStack);

                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 1.0f, 0.8f);
            }
        }

        return InteractionResultHolder.success(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public static boolean isInShadowMode(ItemStack stack) {
        return stack.getOrDefault(DataComponentRegistry.SHADOW_MODE.get(), false);
    }

    public static void setShadowMode(ItemStack stack, boolean shadowMode) {
        stack.set(DataComponentRegistry.SHADOW_MODE.get(), shadowMode);
    }

    public static AnimationState getAnimationState(ItemStack stack) {
        String stateName = stack.getOrDefault(DataComponentRegistry.ANIMATION_STATE.get(), "INACTIVE");
        try {
            return AnimationState.valueOf(stateName);
        } catch (IllegalArgumentException e) {
            return AnimationState.INACTIVE;
        }
    }

    public static void setAnimationState(ItemStack stack, AnimationState state) {
        stack.set(DataComponentRegistry.ANIMATION_STATE.get(), state.name());
    }
}
