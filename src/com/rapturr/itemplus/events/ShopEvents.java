package com.rapturr.itemplus.events;

import com.rapturr.itemplus.inventories.Shop;
import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ShopEvents implements Listener {

    @EventHandler
    public void OnClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof Shop) {
            event.setCancelled(true);
            if (event.isLeftClick()) {
                Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem() == null) {
                    return;
                }

                if (event.getSlot() == 10) {
                    player.getInventory().addItem(ItemWeapons.wand);
                }
                else if (event.getSlot() == 43) {
                    player.closeInventory();
                }
            }
        }
    }

}
