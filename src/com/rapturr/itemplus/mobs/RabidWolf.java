package com.rapturr.itemplus.mobs;

import com.rapturr.itemplus.ItemPlus;
import org.bukkit.DyeColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RabidWolf implements Listener {

    ItemPlus plugin;

    public RabidWolf(ItemPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void SpawnRabidWolf(EntityDeathEvent event) {

        if (event.getEntity() instanceof Wolf && event.getEntity().getKiller() != null) {
            int random = ThreadLocalRandom.current().nextInt(100);
            if (random < 10) {
                Player player = event.getEntity().getKiller();
                Wolf wolf = player.getWorld().spawn(event.getEntity().getLocation(), Wolf.class);
                wolf.setCollarColor(DyeColor.RED);
                wolf.setAngry(true);
                wolf.setCustomName("§c§lRABID WOLF");
                wolf.setCustomNameVisible(true);
                wolf.setAdult();
                wolf.setAgeLock(true);
                wolf.setMaxHealth(200);
                wolf.setHealth(200);
                wolf.setTarget(player);
                wolf.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4));
                wolf.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3));
                player.playSound(player.getLocation(), Sound.ENTITY_WOLF_HOWL, 1, 1);
                player.sendMessage("§cA RABID WOLF SHOWED UP!");
            }
        }
    }
    @EventHandler
    public void Attacks(EntityDamageByEntityEvent event) {

        //Spawn pups at half health
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Wolf) {
            if (event.getEntity().getCustomName().equals("§c§lRABID WOLF")) {
                Wolf rabidwolf = (Wolf) event.getEntity();
                if (rabidwolf.getHealth() <= 100) {
                    Player player = (Player) event.getDamager();
                    player.sendMessage("§c§lIm calling the pups!");
                    rabidwolf.setCustomName("§c§lENRAGED");
                    for (int i = 0; i < 4; i++) {
                        Wolf puppies = rabidwolf.getWorld().spawn(rabidwolf.getLocation(), Wolf.class);
                        puppies.setBaby();
                        puppies.setAgeLock(true);
                        puppies.setTarget(player);
                        puppies.setAngry(true);
                        puppies.setCustomName("§cPups");
                        puppies.setCustomNameVisible(true);
                        puppies.setMaxHealth(50);
                        puppies.setHealth(50);
                        puppies.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4));
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_WOLF_HOWL, 1, 1);
                }
            }
        }
        //Block Attack
        if (event.getEntity() instanceof Wolf && event.getDamager() instanceof Player) {
            if (event.getEntity().getCustomName().equals("§c§lRABID WOLF") || event.getEntity().getCustomName().equals("§c§lENRAGED")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 10) {
                    Player player = (Player) event.getDamager();
                    event.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 10);
                    player.sendMessage("§c§lYour attack was dodged!");

                }
            }
        }
        //bitten
        if (event.getDamager() instanceof Wolf && event.getEntity() instanceof Player) {
            if (event.getDamager().getCustomName().equals("§c§lRABID WOLF") || event.getDamager().getCustomName().equals("§c§lRABID WOLF")) {
                int random = ThreadLocalRandom.current().nextInt(100);
                if (random < 10) {
                    Player playerbitten = (Player) event.getEntity();
                    playerbitten.sendMessage("§c§lYou have been bitten!");
                    playerbitten.playSound(playerbitten.getLocation(), Sound.ENTITY_ZOMBIE_INFECT, 1, 1);
                    playerbitten.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 3));
                    playerbitten.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 6));
                    playerbitten.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 5));
                }
            }
        }
    }
}