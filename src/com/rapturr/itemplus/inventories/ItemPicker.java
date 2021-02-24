package com.rapturr.itemplus.inventories;

import com.rapturr.itemplus.items.ItemArmor;
import com.rapturr.itemplus.items.ItemMaterials;
import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemPicker implements InventoryHolder {

  private Inventory inv;

  public ItemPicker() {
      inv = Bukkit.createInventory(this, 54, "ItemPlus");
      init();

  }

  private void init() {
      ItemStack item;
      List<String> lore = new ArrayList<>();
      lore.add("§7Leave the gui");
      item = createItem("§c§lRETURN", Material.REDSTONE, lore);
      inv.setItem(53, item);

      //add items here:
      item = ItemWeapons.enderwand;
          inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.wand;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.tntwand;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.jacksgun;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.burp;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.fireball;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemArmor.scoutboots;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.piggun;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.bossegg;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.test;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemArmor.wingsuit;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemMaterials.fuel;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemArmor.jetpack;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.hotpotato;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.legacysword;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.metalrod;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemWeapons.instatnt;
      inv.setItem(inv.firstEmpty(), item);

      item = ItemArmor.austronauthelm;
      inv.setItem(inv.firstEmpty(), item);



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
      return inv;

  }
}

