package com.rapturr.itemplus.commands;

import com.rapturr.itemplus.inventories.ItemPicker;
import com.rapturr.itemplus.inventories.Shop;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemPlusCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        if (!player.isOp()) {
            player.sendMessage(ChatColor.RED + "You cant use this command!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("giveitems")) {
            if(player.isOp()) {
                ItemPicker gui = new ItemPicker();
                player.openInventory(gui.getInventory());
                player.sendMessage(ChatColor.GRAY+ "Opening GUI...");
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("buyitems")) {
                Shop gui = new Shop();
                player.openInventory(gui.getInventory());
                player.sendMessage(ChatColor.GRAY+ "Opening Shop...");
                return true;
        }
        return true;

    }
}



