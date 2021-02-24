package com.rapturr.itemplus.items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fireball implements Listener {

    public static ItemStack fireball;

    public static void createFireball() {
        ItemStack item = new ItemStack(Material.FIRE_CHARGE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Fireball (2.0)");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§9§l§k1§r§9§lRARE§k1");
        lore.add("");
        lore.add("§6Item Ability: Fireball§e§l RIGHT CLICK");
        lore.add("§7Throw a fireball just like");
        lore.add("§7in Hypixel Bedwars!");
        lore.add("§c");
        lore.add("§8Cooldown: §a1s");
        meta.setLore(lore);
        item.setItemMeta(meta);
        fireball = item;

    }
    static Map<String, Long> cooldowns = new HashMap<>();

    @EventHandler
    public void FireballShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FIRE_CHARGE)) {
                if (event.getItem().getItemMeta().equals(ItemWeapons.fireball.getItemMeta())) {

                    if (cooldowns.containsKey(player.getName())) {
                        if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                            long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                            return;
                        }
                    }
                    event.setCancelled(true);
                    Fireball fireball = event.getPlayer().launchProjectile(Fireball.class);
                    fireball.setVelocity(player.getEyeLocation().getDirection().multiply(1.4));
                    player.playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                    ItemStack hand = player.getInventory().getItemInMainHand();
                    hand.setAmount(hand.getAmount() - 1);

                    cooldowns.put(player.getName(), System.currentTimeMillis() + (1 * 1000));
                }
            }
        }
    }

    @EventHandler
    public void Fireballplace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getBlockPlaced().getType().equals(Material.FIRE)) {
            if (event.getItemInHand().getItemMeta().equals(ItemWeapons.fireball.getItemMeta())) {
                event.setCancelled(true);
            }
        }
    }


}
