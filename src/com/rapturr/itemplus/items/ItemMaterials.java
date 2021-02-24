package com.rapturr.itemplus.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemMaterials {

    public static ItemStack fuel;

    public static void init() {
        createFuel();
    }

    private static void createFuel() {
        ItemStack item = new ItemStack(Material.NETHER_WART, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§lFuel");
        item.setItemMeta(meta);
        fuel = item;
    }
}
