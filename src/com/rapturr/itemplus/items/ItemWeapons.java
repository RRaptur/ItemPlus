package com.rapturr.itemplus.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemWeapons {

    public static ItemStack wand;
    public static ItemStack burp;
    public static ItemStack enderwand;
    public static ItemStack fireball;
    public static ItemStack jacksgun;
    public static ItemStack tntwand;
    public static ItemStack piggun;
    public static ItemStack bossegg;
    public static ItemStack test;
    public static ItemStack hotpotato;
    public static ItemStack legacysword;
    public static ItemStack metalrod;
    public static ItemStack instatnt;

    public static void init() {
        createBossEgg();
        createBurp();
        createFireball();
        createEnderWand();
        createJacksGun();
        createPigGun();
        createTNTWand();
        createWand();
        createTest();
        createHotPotato();
        createLegacySword();
        createMetalRod();
        createinstatnt();
    }

    private static void createTest() {
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Bandage");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§9§l§k1§r§9§lRARE§k1");
        lore.add("§c");
        lore.add("§6Item Ability: Heal §e§lRIGHT CLICK");
        lore.add("§7Heal yourself and gain §cRegeneration IV§7,");
        lore.add("§8Slowness III §7and §eAbsorption §7for §a4s!");
        lore.add("§c");
        meta.setLore(lore);
        item.setItemMeta(meta);
        test = item;
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.END_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Zeus' Wand");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§6§l§k1§r§6§lLEGENDARY§k1");
        lore.add("");
        lore.add("§6Item Ability: Lightning §e§lRIGHT CLICK");
        lore.add("§7Call upon the mighty god");
        lore.add("§7Zeus and strike lightning.");
        lore.add("");
        lore.add("§7When in Main Hand:");
        lore.add("§9+50% Speed");
        lore.add("§9+8 Attack Damage");
        lore.add("");
        lore.add("§8Cooldown: §a5s");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic_movement_speed", 0.5,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "generic_attack_damage", 8,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
        item.setItemMeta(meta);
        wand = item;
    }

    private static void createBurp() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Burp");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§9§l§k1§r§9§lRARE§k1");
        lore.add("§c");
        lore.add("§7(Right Click) BURP");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        item.setItemMeta(meta);
        burp = item;
    }

    private static void createEnderWand() {
        ItemStack item = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Ender Wand");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§5§l§k1§r§5§lEPIC§k1");
        lore.add("§c");
        lore.add("§6Item Ability: Flee");
        lore.add("§7Retreat from the battle and");
        lore.add("§7gain §f+30% Speed §7for §a3s.");
        lore.add("§c");
        lore.add("§8Cooldown: §a5s");
        meta.setLore(lore);
        item.setItemMeta(meta);
        enderwand = item;
    }

    private static void createJacksGun() {
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Jack's Gun");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§6§l§k1§r§6§lLEGENDARY§k1");
        lore.add("§c");
        lore.add("§6Item Ability: §k111§r§e§l RIGHT CLICK");
        lore.add("§7Shoots something sticky and");
        lore.add("§7gain §cStrength II§7 for §a3s.");
        lore.add("§c");
        lore.add("§8Cooldown: §a2s");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        jacksgun = item;

    }

    private static void createTNTWand(){
        ItemStack item = new ItemStack(Material.WOODEN_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5TNT Wand");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§5§l§k1§r§5§lEPIC§k1");
        lore.add("§c");
        lore.add("§6Item Ability: TNT§e§l RIGHT CLICK");
        lore.add("§7Spawn a TNT and throw it");
        lore.add("§7to your enemy!");
        lore.add("§c");
        lore.add("§8Cooldown: §a5s");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK,1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        tntwand = item;


    }

    private static void createFireball(){
        ItemStack item = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Fireball");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§9§l§k1§r§9§lRARE§k1");
        lore.add("§c");
        lore.add("§6Item Ability: Fireball§e§l RIGHT CLICK");
        lore.add("§7Throw a fireball just like");
        lore.add("§7in Hypixel Bedwars!");
        lore.add("§c");
        lore.add("§8Cooldown: §a1s");
        meta.setLore(lore);
        item.setItemMeta(meta);
        fireball = item;


    }

    private static void createPigGun() {
        ItemStack item = new ItemStack(Material.PINK_DYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Pig Gun");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§5§l§k1§r§5§lEPIC§k1");
        lore.add("§c");
        lore.add("§6Item Ability: OINK§e§l RIGHT CLICK");
        lore.add("§7Shoot pigs !");
        lore.add("§c");
        meta.setLore(lore);
        item.setItemMeta(meta);
        piggun = item;
    }

    private static void createBossEgg() {
        ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Metal Golem Egg");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§5§l§k1§r§5§lEPIC§k1");
        lore.add("§c");
        lore.add("§7Summon the mighty Metal Golem!");
        lore.add("§c");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        bossegg = item;
    }

    private static void createHotPotato() {
        ItemStack item = new ItemStack(Material.BAKED_POTATO, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Hot Potato");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§5§l§k1§r§5§lEPIC§k1");
        lore.add("§c");
        lore.add("§7Dont burn your hands!");
        lore.add("§c");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        hotpotato = item;
    }

    private static void createLegacySword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Hot Potato");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§7You can hit with this sword like in 1.8!");
        lore.add("§c");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        AttributeModifier legacy1 = new AttributeModifier(UUID.randomUUID(), "generic_attack_speed", 20,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier legacy2 = new AttributeModifier(UUID.randomUUID(), "generic_attack_damage", 7,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, legacy1);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, legacy2);
        item.setItemMeta(meta);
        legacysword = item;
    }

    private static void createMetalRod() {
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Metal Rod");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§5§l§k1§r§5§lEPIC§k1");
        lore.add("§c");
        lore.add("§7Use this to fish up special sea creatures!");
        lore.add("§c");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        AttributeModifier metalrod1 = new AttributeModifier(UUID.randomUUID(), "generic_attack_damage", 5,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, metalrod1);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        metalrod = item;
    }

    private static void createinstatnt() {
        ItemStack item = new ItemStack(Material.TNT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9TNT");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§9§l§k1§r§9§lRARE§k1");
        lore.add("");
        lore.add("§7Who needs flint and steal?");
        meta.setLore(lore);
        item.setItemMeta(meta);
        instatnt = item;


    }
}
