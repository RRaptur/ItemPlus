package com.rapturr.itemplus.mobs;

import com.rapturr.itemplus.ItemPlus;
import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class MetalGolem implements Listener {
    public MetalGolem() {
    }

    ItemPlus plugin;

    public MetalGolem(ItemPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnSpawnMetalGolem(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().getItemMeta().equals(ItemWeapons.bossegg.getItemMeta())) {
                player.setVelocity(new Vector(0, 2, 0));
                player.sendMessage(ChatColor.RED + "You have awakened a Metal Golem!");
                IronGolem ironGolem = event.getPlayer().getWorld().spawn(player.getLocation().add(0.5, 0, 0.5), IronGolem.class);
                ItemStack hand = player.getInventory().getItemInMainHand();
                hand.setAmount(hand.getAmount() - 1);
                ironGolem.getWorld().strikeLightningEffect(ironGolem.getLocation());
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1, 1);
                ironGolem.setCustomName("§7§lMETAL GOLEM");
                ironGolem.setCustomNameVisible(true);
                ironGolem.setMaxHealth(250);
                ironGolem.setHealth(250);
                ironGolem.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4));
                ironGolem.setTarget(player);


            }
        }
    }

    @EventHandler
    public void onDamageMetalGolem(EntityDamageByEntityEvent event) {
        //Block Attack
        if (event.getEntity() instanceof IronGolem && event.getDamager() instanceof Player) {
            if (event.getEntity().getCustomName().equals("§7§lMETAL GOLEM")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 10) {
                    event.setCancelled(true);
                    Player player = (Player) event.getDamager();
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 10);
                    player.sendMessage("§c§lYour attack was blocked!");

                }
            }
        }
        //Throw Player
        if (event.getDamager() instanceof IronGolem && event.getEntity() instanceof Player) {
            if (event.getDamager().getCustomName().equals("§7§lMETAL GOLEM")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 10) {
                    Player player = (Player) event.getEntity();
                    player.setVelocity(new Vector(0, 2, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 4));
                    player.sendMessage("§c§lYOU HAVVVE BEEN THROWN!");

                }
            }
        }
        //Truedamage
        if (event.getDamager() instanceof IronGolem && event.getEntity() instanceof Player) {
            if (event.getDamager().getCustomName().equals("§7§lMETAL GOLEM")) {
                int random = ThreadLocalRandom.current().nextInt(10);
                if (random == 1) {
                    Player player = (Player) event.getEntity();
                    player.sendMessage("§c§lMETAL GOLEM IS ENRAGED!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BIG_FALL, 1, 1);
                    player.setArrowsInBody(3);

                }
            }
        }
    }
}

