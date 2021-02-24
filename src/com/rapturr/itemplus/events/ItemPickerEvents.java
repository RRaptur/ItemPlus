package com.rapturr.itemplus.events;

import com.rapturr.itemplus.inventories.ItemPicker;
import com.rapturr.itemplus.items.ItemArmor;
import com.rapturr.itemplus.items.ItemMaterials;
import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemPickerEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof ItemPicker) {
            e.setCancelled(true);
            if (e.isLeftClick()) {
                Player player = (Player) e.getWhoClicked();
                if (e.getCurrentItem() == null) {
                    return;
                }

                //getitems from itempickerinventory here:
                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.enderwand.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.enderwand);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.wand.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.wand);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.jacksgun.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.jacksgun);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.tntwand.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.tntwand);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.burp.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.burp);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.fireball.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.fireball);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemArmor.scoutboots.getItemMeta())) {
                    player.getInventory().addItem(ItemArmor.scoutboots);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemArmor.wingsuit.getItemMeta())) {
                    player.getInventory().addItem(ItemArmor.wingsuit);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.piggun.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.piggun);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.bossegg.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.bossegg);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.test.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.test);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.hotpotato.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.hotpotato);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.legacysword.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.legacysword);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.metalrod.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.metalrod);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemWeapons.instatnt.getItemMeta())) {
                    player.getInventory().addItem(ItemWeapons.instatnt);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemMaterials.fuel.getItemMeta())) {
                    player.getInventory().addItem(ItemMaterials.fuel);
                }


                if (e.getCurrentItem().getItemMeta().equals(ItemArmor.austronauthelm.getItemMeta())) {
                    player.getInventory().addItem(ItemArmor.austronauthelm);
                }

                if (e.getCurrentItem().getItemMeta().equals(ItemArmor.jetpack.getItemMeta())) {
                    player.getInventory().addItem(ItemArmor.jetpack);
                } else if (e.getSlot() == 53) {
                    player.closeInventory();

                }

            }
        }
    }
}
