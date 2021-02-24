package com.rapturr.itemplus.mobs;

import com.rapturr.itemplus.ItemPlus;
import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class SeaCreature implements Listener {

    ItemPlus plugin;

    public SeaCreature(ItemPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void SeaCreatureFishup (PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (event.getCaught().getType() != null) {
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(ItemWeapons.metalrod.getItemMeta())) {
                if (event.getCaught().getType() == EntityType.DROPPED_ITEM) {
                    int random = ThreadLocalRandom.current().nextInt(100);
                    if (random < 100) {
                        event.getCaught().remove();
                    Location loc = event.getHook().getLocation();
                    Zombie seacreature = player.getWorld().spawn(loc.add(0, 1.5, 0), Zombie.class);
                    seacreature.setVelocity(player.getLocation().getDirection().multiply(-1.7));
                    seacreature.setAdult();
                    seacreature.setCustomName("§cSea Dweller");
                    seacreature.setCustomNameVisible(true);
                    seacreature.setTarget(player);
                    seacreature.setMaxHealth(100);
                    seacreature.setHealth(100);
                    seacreature.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                    seacreature.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));
                    seacreature.getEquipment().setItemInMainHand(axe);
                    seacreature.getEquipment().setChestplate(chest);
                    seacreature.getEquipment().setHelmet(helm);
                    seacreature.getEquipment().setLeggings(legs);
                    player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CURE, 10, 1);
                    player.spawnParticle(Particle.ASH, seacreature.getLocation().add(0, -1, 0), 6);
                    player.sendMessage("§c§lYou have fished up a Sea Dweller!");
                  }
                }
            }
        }
    }
    public static void init() {
        createAxe();
        createChest();
        createHelm();
        createLegs();
        createFeet();
    }

    public static ItemStack axe;
    public static ItemStack chest;
    public static ItemStack helm;
    public static ItemStack legs;
    public static ItemStack feet;

    private static void createAxe() {
        ItemStack item = new ItemStack(Material.GOLDEN_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Dwellers Axe");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        AttributeModifier axe2 = new AttributeModifier(UUID.randomUUID(), "generic_attack_damage", 4,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, axe2);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        axe = item;
    }

    private static void createChest() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setColor(Color.RED);
        item.setItemMeta(meta);
        chest = item;
    }

    private static void createHelm() {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.WHITE);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.THORNS, 10, true);
        item.setItemMeta(meta);
        helm = item; }

    private static void createLegs() {
        ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        item.setItemMeta(meta);
        legs = item;
    }

    private static void createFeet() {
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        item.setItemMeta(meta);
        feet = item;
    }
}
