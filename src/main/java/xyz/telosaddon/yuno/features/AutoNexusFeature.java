package xyz.telosaddon.yuno.features;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import xyz.telosaddon.yuno.utils.ActionUtils;
import xyz.telosaddon.yuno.utils.NbtUtils;

import java.util.Optional;

public class AutoNexusFeature {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void autoNexus() {
        PlayerEntity player = mc.player;

        if (player == null) return;

        int slot = -1;
        for (int i = 0; i < 9; i++) {
            ItemStack stack = player.getInventory().getStack(i);

            if (isItemNexus(stack)) {
                slot = i;
                break;
            }
        }

        if (slot == -1) return;

        // Select the "nexus" item in the hotbar
        player.getInventory().selectedSlot = slot;

        // Simulate right-click action with the selected "nexus" item
        ActionUtils.simulateRightClick(mc);
    }

    private static boolean isItemNexus(ItemStack stack) {
        Optional<String> mythicTypeOptional = NbtUtils.getMythicType(stack);
        return mythicTypeOptional.map(s -> s.equals("nexus")).orElse(false);
    }
}
