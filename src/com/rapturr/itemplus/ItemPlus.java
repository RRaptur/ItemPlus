package com.rapturr.itemplus;

import com.rapturr.itemplus.commands.ItemPlusCommands;
import com.rapturr.itemplus.events.ItemPickerEvents;
import com.rapturr.itemplus.events.ItemEvents;
import com.rapturr.itemplus.events.ShopEvents;
import com.rapturr.itemplus.items.ItemArmor;
import com.rapturr.itemplus.items.ItemMaterials;
import com.rapturr.itemplus.items.ItemWeapons;
import com.rapturr.itemplus.mobs.MetalGolem;
import com.rapturr.itemplus.mobs.RabidWolf;
import com.rapturr.itemplus.mobs.SeaCreature;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        ItemArmor.init();
        ItemWeapons.init();
        ItemMaterials.init();
        SeaCreature.init();
        getCommand("giveitems").setExecutor(new ItemPlusCommands());
        getCommand("buyitems").setExecutor(new ItemPlusCommands());
        getServer().getPluginManager().registerEvents(new ItemEvents(this), this);
        getServer().getPluginManager().registerEvents(new ItemPickerEvents(), this);
        getServer().getPluginManager().registerEvents(new ShopEvents(), this);
        getServer().getPluginManager().registerEvents(new MetalGolem(), this);
        getServer().getPluginManager().registerEvents(new RabidWolf(this), this);
        getServer().getPluginManager().registerEvents(new SeaCreature(this), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ItemPlus]: Plugin is enabled!");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ItemPlus]: Plugin is disabled!");
    }

}
