package com.rapturr.itemplus.events;

import com.rapturr.itemplus.ItemPlus;
import com.rapturr.itemplus.items.ItemArmor;
import com.rapturr.itemplus.items.ItemWeapons;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;


public class ItemEvents implements Listener {


    static Map<String, Long> cooldowns = new HashMap<>();

    ItemPlus plugin;
    public ItemEvents(ItemPlus plugin) {
        this.plugin = plugin;
    }


    PotionEffect AustronautEffect1 = new PotionEffect(PotionEffectType.JUMP, 20*10, 2);
    PotionEffect AustronautEffect2 = new PotionEffect(PotionEffectType.WATER_BREATHING, 20*10, 0);

    @EventHandler
    public void onRightClickBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {

                if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BLAZE_ROD)) {
                    if (event.getItem().getItemMeta().equals(ItemWeapons.burp.getItemMeta())) {

                        if (cooldowns.containsKey(player.getName())) {
                            if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                return;
                            }
                        }

                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
                        player.sendMessage("Burp");
                        WitherSkull witherSkull = event.getPlayer().launchProjectile(WitherSkull.class);
                        witherSkull.setVelocity(player.getLocation().getDirection().multiply(2));
                        witherSkull.setCharged(true);


                        cooldowns.put(player.getName(), System.currentTimeMillis() + (5 * 1000));


                    }
                }
            }
        }
    }

    @EventHandler
    public static void onWitherskullDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof WitherSkull) {
            WitherSkull witherSkull = (WitherSkull) event.getDamager();
            if (witherSkull.getShooter() instanceof Player) ;
            Player shooter = (Player) witherSkull.getShooter();
            event.setDamage(8.0);
        }
    }

    @EventHandler
    public static void onJackDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LlamaSpit) {
            LlamaSpit llamaSpit = (LlamaSpit) event.getDamager();
            if (llamaSpit.getShooter() instanceof Player) ;
            Player shooter = (Player) llamaSpit.getShooter();
            event.setDamage(8.0);
            shooter.setGlowing(true);
        }
    }

    @EventHandler
    public void onWandUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.END_ROD)) {
                    if (event.getItem().getItemMeta().equals(ItemWeapons.wand.getItemMeta())) {

                        if (cooldowns.containsKey(player.getName())) {
                            if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                return;
                            }
                        }
                        player.getWorld().strikeLightning(player.getTargetBlockExact(150).getLocation());
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                        player.spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 50);

                        cooldowns.put(player.getName(), System.currentTimeMillis() + (5 * 1000));
                    }

                }
            }
        }
    }

    @EventHandler
    public void onWandPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getItemInHand().getItemMeta().equals(ItemWeapons.wand.getItemMeta())) {
            if (event.getBlockPlaced().getType().equals(Material.END_ROD)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Vector velocity = player.getVelocity();
        if (event.getItem() != null) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FEATHER)) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                    if (event.getItem().getItemMeta().equals(ItemWeapons.enderwand.getItemMeta())) {

                        if (cooldowns.containsKey(player.getName())) {
                            if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                return;
                            }
                        }
                        player.setVelocity(player.getEyeLocation().getDirection().multiply(1.3));
                        player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
                        player.spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 10);
                        player.setWalkSpeed(player.getWalkSpeed() + 0.06F);

                        cooldowns.put(player.getName(), System.currentTimeMillis() + (5 * 1000));

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                player.setWalkSpeed(player.getWalkSpeed() - 0.06F);


                            }
                        }.runTaskLater(plugin, 20 * 3);
                    }
                }
            }
        }
    }

    @EventHandler
    public void JackShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SHOVEL)) {
                    if (event.getItem().getItemMeta().equals(ItemWeapons.jacksgun.getItemMeta())) {

                        if (cooldowns.containsKey(player.getName())) {
                            if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                return;
                            }
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1, 1);
                        LlamaSpit llamaSpit = event.getPlayer().launchProjectile(LlamaSpit.class);
                        llamaSpit.setVelocity(player.getEyeLocation().getDirection().multiply(1.2));
                        player.spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 10);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3 * 20, 1));
                        llamaSpit.setGlowing(true);

                        cooldowns.put(player.getName(), System.currentTimeMillis() + (2 * 1000));
                    }
                }
            }
        }
    }

    @EventHandler
    public void TNTWandShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SHOVEL)) {
                if (event.getItem().getItemMeta().equals(ItemWeapons.tntwand.getItemMeta())) {

                    if (cooldowns.containsKey(player.getName())) {
                        if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                            long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                            return;
                        }
                    }
                    TNTPrimed tnt = (TNTPrimed) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.PRIMED_TNT);
                    tnt.setVelocity(player.getEyeLocation().getDirection().multiply(2));
                    player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1, 1);
                    player.spawnParticle(Particle.HEART, player.getLocation(), 23);

                    cooldowns.put(player.getName(), System.currentTimeMillis() + (5 * 1000));
                }
            }
        }
    }



    @EventHandler
    public void PigGun(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().getItemMeta().equals(ItemWeapons.piggun.getItemMeta())) {

                if (cooldowns.containsKey(player.getName())) {
                    if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                        long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
                        return;
                    }
                }
                Pig pig = (Pig) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.PIG);
                pig.setVelocity(player.getEyeLocation().getDirection().multiply(2));
                player.playSound(player.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1, 1);
                pig.setCustomName(("§d§lOINK!"));
                pig.setCustomNameVisible(true);
                pig.setInvulnerable(true);

                cooldowns.put(player.getName(), System.currentTimeMillis() + (4 * 1000));

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        pig.getWorld().createExplosion(pig.getLocation(), 2.0f);
                        pig.remove();


                    }
                }.runTaskLater(plugin, 20 * 3);
            }
        }
    }

    @EventHandler
    public void Test(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.PAPER)) {
                if (event.getItem().getItemMeta().equals(ItemWeapons.test.getItemMeta())) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * 20, 2));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * 20, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 60 * 20, 1));
                    player.playSound(player.getEyeLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
                    player.spawnParticle(Particle.HEART, player.getLocation(), 2);
                    ItemStack hand = player.getInventory().getItemInMainHand();
                    hand.setAmount(hand.getAmount() - 1);

                }
            }
        }
    }

    @EventHandler
    public void Wingsuit(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (event.getPlayer().getInventory().getChestplate().getItemMeta().equals(ItemArmor.wingsuit.getItemMeta())) {
                if (event.getPlayer().isGliding()) {
                    if (event.getPlayer().isSneaking()) {
                        if (event.getPlayer().getLocation().getPitch() < 0) {
                            player.setVelocity(player.getEyeLocation().getDirection().multiply(1.2));
                            player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 10, 10);


                    }
                }
            }
        }
    }


    @EventHandler
    public void BakedPotato(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BAKED_POTATO)) {
                if (event.getItem().getItemMeta().equals(ItemWeapons.hotpotato.getItemMeta())) {
                    event.setCancelled(true);


                    Item item = location.getWorld().dropItem(location, new ItemStack(Material.BAKED_POTATO));
                    item.setVelocity(player.getEyeLocation().getDirection().multiply(1.7));
                    item.setCustomName("§5§lHot Potato");
                    item.setCustomNameVisible(true);
                    item.setInvulnerable(true);
                    item.setTicksLived(6000 - (3 * 20));
                    item.setPickupDelay(6000);
                    player.playSound(location, Sound.BLOCK_LAVA_EXTINGUISH, 10, 10);
                    ItemStack hand = player.getInventory().getItemInMainHand();
                    hand.setAmount(hand.getAmount() - 1);
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            item.getWorld().createExplosion(item.getLocation(), 2.0f);


                        }
                    }.runTaskLater(plugin, 20 * 3);
                }
            }
        }
    }

    @EventHandler
    public void AstronautHelmet(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (player.getInventory().getHelmet() == null) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.GLASS)) {
                if (event.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                if (event.getItem().getItemMeta().equals(ItemArmor.austronauthelm.getItemMeta())) {
                    player.getInventory().setHelmet(new ItemStack(ItemArmor.austronauthelm));
                    ItemStack hand = player.getInventory().getItemInMainHand();
                    hand.setAmount(0);
                    player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_TURTLE, 1, 1);
                }
                    }
                }
            }
        }
    }


    @EventHandler
    public void AstronautHelmetPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getItemInHand().getItemMeta().equals(ItemArmor.austronauthelm.getItemMeta())) {
            if (event.getBlockPlaced().getType().equals(Material.GLASS)) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void InstaTNT(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getBlockPlaced().getType().equals(Material.TNT)) {
            if (event.getItemInHand().getItemMeta().equals(ItemWeapons.instatnt.getItemMeta())) {
                event.setCancelled(true);
                event.getPlayer().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
                ItemStack hand = player.getInventory().getItemInMainHand();
                hand.setAmount(hand.getAmount() -1);

            }
        }
    }
}




//  public static void onInteract(Player
//   @EventHandlertEvent event) {
//    Player player = event.getPlayer();
//        if(event.getAction().equals(Action.LEFT_CLICK_AIR)) {
//            if(event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
//                 FallingBlock block = event.getPlayer().getWorld().spawnFallingBlock(event.getPlayer().getLocation(), Material.FIRE, (byte) 1);
//                 block.setVelocity(player.getEyeLocation().getDirection().multiply(1.5));
//             }
//      }
//   }

