package xyz.telosaddon.yuno.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Hand;

public class ActionUtils {

    public static void simulateRightClick(MinecraftClient client) {
        if (client.player == null || client.interactionManager == null) return;

        ClientPlayerEntity player = client.player;

        // Use the main hand for interacting with the "nexus" item
        Hand activeHand = Hand.MAIN_HAND;  // You can switch to OFF_HAND if needed

        // Simulate right-click interaction with the item in the main hand
        client.interactionManager.interactItem(player, activeHand);

        // Swing the hand for visual feedback
        player.swingHand(activeHand);
    }
}
