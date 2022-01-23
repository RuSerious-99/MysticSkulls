package me.ruserious99.mysticskulls.listeners;

import me.ruserious99.mysticskulls.skulls.SkullsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GeneralListeners implements Listener


{
        @EventHandler(ignoreCancelled = true)
        public void onPlayerItemBreak(final PlayerItemBreakEvent event) {
            final Player player = event.getPlayer();
            final ItemStack type = event.getBrokenItem();
            if (type.getType().toString().endsWith("_HELMET")) {
                unEquipSkull(type, player);
            }
        }

        @EventHandler
        public void onArmorClicked(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            ItemStack itemCursor = event.getWhoClicked().getItemOnCursor();
            ItemStack clickedItem = event.getCurrentItem();
            int slot = event.getSlot();

            if (event.isShiftClick() && event.isRightClick() && event.getCurrentItem().getType().name().endsWith("_HELMET")){
                event.setCancelled(true);
                return;
            }

            if (event.isShiftClick() && event.getCurrentItem().getType().name().endsWith("_HELMET")) {
                if (slot == 39) {
                    unEquipSkull(clickedItem, player);
                } else {
                    equipSkull(clickedItem, player);
                }
            }

            if (event.getSlotType() == InventoryType.SlotType.ARMOR && !event.isShiftClick()) {
                unEquipSkull(clickedItem, player);
                equipSkull(itemCursor, player);
            }

        }

        private void unEquipSkull(ItemStack clickedItem, Player player) {
            String maskEquipped = SkullsManager.getPersistentData().getCustomDataTag(clickedItem, "equippedSkull");
            String multiMaskEquipped = SkullsManager.getPersistentData().getCustomDataTag(clickedItem, "equippedMultiSkull");

            if (maskEquipped != null) {
                if (maskEquipped.contains("Skull")) {
                    SkullsManager.getRunInstalledSkulls().unEquipSkull(maskEquipped, player);
                }
            }
            if (multiMaskEquipped != null) {
                if (multiMaskEquipped.contains("Skull")) {
                    String[] splitted = multiMaskEquipped.split(",");
                    SkullsManager.getRunInstalledSkulls().unEquipSkull(splitted[0], player);
                    SkullsManager.getRunInstalledSkulls().unEquipSkull(splitted[1], player);
                }
            }
        }

        private void equipSkull(ItemStack itemCursor, Player player) {
            String maskEquipped = SkullsManager.getPersistentData().getCustomDataTag(itemCursor, "equippedSkull");
            String multiMaskEquipped = SkullsManager.getPersistentData().getCustomDataTag(itemCursor, "equippedMultiSkull");

            if (maskEquipped != null) {
                if (maskEquipped.contains("Skull")) {
                    SkullsManager.getRunInstalledSkulls().equipSkull(maskEquipped, player);
                }
            }
            if (multiMaskEquipped != null) {
                if (multiMaskEquipped.contains("Skull")) {
                    String[] splitted = multiMaskEquipped.split(",");
                    SkullsManager.getRunInstalledSkulls().equipSkull(splitted[0], player);
                    SkullsManager.getRunInstalledSkulls().equipSkull(splitted[1], player);
                }
            }
        }
    }

