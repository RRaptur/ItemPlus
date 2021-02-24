package com.rapturr.itemplus.inventories;

import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop implements InventoryHolder {

    private Inventory shop;

    public Shop() {
        shop = Bukkit.createInventory(this, 54, "§8§lBuy Items");
        init();
    }

    private void init() {
        ItemStack item;
        for (int i = 0; i < 9; i++){
            item = createItem("", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
            shop.setItem(i, item);
        }

        for (int i = 45; i < 54; i++){
            item = createItem("§c", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
            shop.setItem(i, item);
            shop.setItem(9, item);
            shop.setItem(18, item);
            shop.setItem(27, item);
            shop.setItem(36, item);
            shop.setItem(17, item);
            shop.setItem(26, item);
            shop.setItem(35, item);
            shop.setItem(44, item);
        }
        item = createItem("§c§lReturn", Material.REDSTONE, Collections.singletonList("§7Quit the gui."));
        shop.setItem(43, item);

        ItemStack currentstack = ItemWeapons.wand;
        ItemMeta currentmeta = currentstack.getItemMeta();
        List<String> currentlore = currentmeta.getLore();
        currentlore.add("");
        currentlore.add("§7Buy item for: §e§l69 Coin");
        currentlore.add("");
        currentmeta.setLore(currentlore);
        currentstack.setItemMeta(currentmeta);
        item = currentstack;
        shop.setItem(shop.firstEmpty(), item);


    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return shop;

    }
}
