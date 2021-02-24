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

public class ItemArmor{

    public static ItemStack scoutboots;
    public static ItemStack wingsuit;
    public static ItemStack jetpack;
    public static ItemStack austronauthelm;

    public static void init() {
        createScoutBoots();
        createWingsuit();
        createJetpack();
        createAstronautHelm();
    }

    private static void createScoutBoots(){
        ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Scout Boots");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§6§l§k1§r§6§lLEGENDARY§k1");
        lore.add("§c");
        lore.add("§6Item Ability: Double Jump§e§l ON FEET");
        lore.add("§7Agility rounded boots perfect");
        lore.add("§7to run and jump around with!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 2, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier scoutbootsspeed = new AttributeModifier(UUID.randomUUID(), "generic_movement_speed", 0.5,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
        AttributeModifier scoutbootsarmor = new AttributeModifier(UUID.randomUUID(), "generic_armor", 2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier scoutbootshealth = new AttributeModifier(UUID.randomUUID(), "generic_max_health", -4,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, scoutbootsspeed);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, scoutbootsarmor);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, scoutbootshealth);
        item.setItemMeta(meta);
        scoutboots = item;


    }

    private static void createWingsuit() {
        ItemStack item = new ItemStack(Material.ELYTRA, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c§lWingsuit");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§7Wingsuit from mc-gtm.net!");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        wingsuit = item;

    }

    private static void createJetpack() {
        ItemStack item = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§lJetpack");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§7Jetpack from mc-gtm.net!");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        jetpack = item;

    }
    private static void createAstronautHelm() {
        ItemStack item = new ItemStack(Material.GLASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Astronaut Helmet");
        List<String> lore = new ArrayList<>();
        lore.add("§c");
        lore.add("§6§l§k1§r§6§lLEGENDARY§k1");
        lore.add("§c");
        lore.add("§7Found from an old spaceship");
        lore.add("§7looks quite neat.");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        austronauthelm = item;
    }
}
